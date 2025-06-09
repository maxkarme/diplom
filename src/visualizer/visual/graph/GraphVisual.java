package visualizer.visual.graph;

import visualizer.StateAdapter;
import visualizer.selector.Selector;
import visualizer.visual.VisualComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.lang.reflect.Field;
import java.util.*;
import java.util.List;

public class GraphVisual extends VisualComponent {
    private final GraphJComponent component;
    private JPanel pane = new JPanel();

    public GraphVisual(Graph graph, Field _field, Object _instance, ArrayList<Selector> _selectors, StateAdapter _adapter) {
        super(_field, _instance, _adapter);
        component = new GraphJComponent(graph, _selectors, getValue());
        pane.add(component);
    }


    @Override
    public JComponent getComponent() {
        return component;
    }
}
