package visualizer.visual.array;

import visualizer.common.TextManager;
import visualizer.selector.Selector;
import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class ArrayJComponent extends JComponent {
    private final Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 16);
    private final ArrayList<Selector> selectors;
    private final String name;
    private final Object value;

    public ArrayJComponent(String _name, ArrayList<Selector> _selectors, Object _value) {
        selectors = _selectors;
        value = _value;
        name = _name;
    }

    private List<Object> getArr() {
        try {
            List<Object> arr = (List<Object>) value;
            return arr;
        }
        catch (Error err) {
            System.out.println("Error in ArrayJComponent");
        }

        return null;
    }


    @Override
    public void paintComponent(Graphics g) {
        List<Object> arr = getArr();
        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(font);
        g2.setStroke(new BasicStroke(2));

        g2.setColor(Color.BLACK);
        g2.drawString(name, 20, 25);

        int x = 20;
        int y = 40;

        for(int k = 0; k < 2; ++k) {
            x = 20;
            for (int i = 0; i < arr.size(); ++i) {
                boolean isSelected = false;

                for (Selector s : selectors) {
                    if (s.isSelected(i) != 0) isSelected = true;
                }

                if (isSelected) {
                    g2.setColor(Color.RED);
                } else {
                    g2.setColor(Color.BLACK);
                }


                String text = arr.get(i).toString();
                Rectangle2D textBounds = TextManager.getTextBounds(g2, text);


                int width = (int) textBounds.getWidth() + 20;
                int height = (int) textBounds.getHeight() * 2;

                boolean isDraw = (k == 0 && !isSelected) || (k == 1 && isSelected);

                if (isDraw) {
                    TextManager.drawCenter(g2, text, x, y, width, height);
                    g2.drawRect(x, y, width, height);

                    g2.setColor(Color.BLACK);
                }

                x += width;
            }
        }
    }
}
