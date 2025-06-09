package visualizer.visual.description;

import visualizer.StateAdapter;
import visualizer.visual.VisualComponent;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Field;

public class DescriptionVisual extends VisualComponent {
    private final DescriptionJComponent component;
    public DescriptionVisual(Object _instance, Field _field, StateAdapter _adapter) {
        super(_field, _instance, _adapter);
        component = new DescriptionJComponent(getValue());
    }

    @Override
    public JComponent getComponent() {
        return component;
    }
}
