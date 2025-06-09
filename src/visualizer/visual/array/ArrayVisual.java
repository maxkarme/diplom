package visualizer.visual.array;

import visualizer.StateAdapter;
import visualizer.common.TextManager;
import visualizer.selector.Selector;
import visualizer.visual.VisualComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ArrayVisual extends VisualComponent {
    private final ArrayJComponent component;
    private JPanel pane = new JPanel();
    private static Map<Integer, Color> colors = new HashMap();

    static {
        colors.put(0, new Color(0, 0, 0));
        colors.put(1, new Color(200, 0, 0));
        colors.put(2, new Color(0, 0, 200));
        colors.put(6, new Color(0, 200, 0));
    }
    public ArrayVisual(String _name, Field _field, Object _instance, ArrayList<Selector> _selectors, StateAdapter _adapter) {
        super(_field, _instance, _adapter);
        component = new ArrayJComponent(_name, _selectors, getValue());
        pane.add(component);
    }

    @Override
    public JComponent getComponent() {
        return component;
    }
}
