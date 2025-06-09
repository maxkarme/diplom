package visualizer.selector.single.adapter;

import visualizer.StateAdapter;

import java.lang.reflect.Field;

public interface SingleSelectorAdapter extends StateAdapter {
    boolean checkField(Field field, Object instance);
    Integer getValue(Object object);
}
