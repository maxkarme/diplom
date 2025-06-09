package visualizer.selector.range.adapter;

import visualizer.StateAdapter;
import visualizer.selector.range.RangeSelectorValue;

import java.lang.reflect.Field;
import java.util.List;

public interface RangeSelectorAdapter extends StateAdapter {
    boolean checkField(Field field, Object instance);
    RangeSelectorValue getValue(Object object);
}
