package visualizer.visual.array.adapter;

import visualizer.StateAdapter;

import java.lang.reflect.Field;
import java.util.List;

public interface ArrayAdapter extends StateAdapter {
    boolean checkField(Field field, Object instance);
    List<Object> getValue(Object object);
}
