package visualizer.visual.description.adapter;

import visualizer.StateAdapter;

import java.lang.reflect.Field;
import java.util.List;

public interface DescriptionAdapter extends StateAdapter {
    boolean checkField(Field field, Object instance);
    String getValue(Object object);
}
