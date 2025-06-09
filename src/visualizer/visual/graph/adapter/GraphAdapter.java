package visualizer.visual.graph.adapter;

import visualizer.StateAdapter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public interface GraphAdapter extends StateAdapter {
    boolean checkField(Field field, Object instance);
    ArrayList<Integer>[] getValue(Object object);
}
