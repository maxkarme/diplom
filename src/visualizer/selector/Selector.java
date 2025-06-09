package visualizer.selector;

import visualizer.StateAdapter;
import visualizer.StateComponent;

import java.lang.reflect.Field;

public abstract class Selector extends StateComponent {
    protected Selector(Field _field, Object _instance, StateAdapter stateAdapter) {
        super(_field, _instance, stateAdapter);
    }

    public abstract int getPriority();
    public abstract int isSelected(int element);

    public abstract String getName();
}
