package visualizer.visual;

import visualizer.StateAdapter;
import visualizer.StateComponent;

import javax.swing.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public abstract class VisualComponent extends StateComponent {
    public VisualComponent(Field _field, Object _instance, StateAdapter _adapter) {
        super(_field, _instance, _adapter);
    }

    public abstract JComponent getComponent();
}
