package visualizer.visual.description;

import javax.swing.*;
import java.awt.*;

public class DescriptionJComponent extends JComponent{
    private final Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 14);
    private Object value;

    public DescriptionJComponent(Object _value) {
        value = _value;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(font);

        try {
            String text = (String) value;

            StringBuilder textWithNewLines = new StringBuilder();
            int cnt = 0;

            textWithNewLines.append("<html>");

            JLabel test = new JLabel("test");

            test.paintComponents(g);

            for(int i = 0; i < text.length(); ++i) {
                if(cnt > 30 && text.charAt(i) == ' ') {
                    textWithNewLines.append("<br>");
                    continue;
                }

                textWithNewLines.append(text.charAt(i));
                cnt++;
            }

            g2.drawString(text.toString(), 10, 40);
        } catch(Exception ex) {
            System.out.println("Error in DescriptionVisualFactory");
        }
    }
}
