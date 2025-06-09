package visualizer.visual.array.adapter;

import java.lang.reflect.Field;
import java.util.List;

public class ArrayListAdapter implements ArrayAdapter {
    @Override
    public boolean checkField(Field field, Object instance) {
        try {
            List<Object> value = (List<Object>)field.get(instance);
            if(value.size() > 10000) {
                System.out.println("Very big array data");
                return false;
            }
            return true;
        } catch(Exception err) {
            return false;
        }
    }

    @Override
    public List<Object> getValue(Object object) {
        try {
            List<Object> value = (List<Object>)object;
            return value;
        } catch(Exception err) {
            System.out.println("Error in ArrayValueAdapter");
            return null;
        }
    }

    @Override
    public Object screenValue(Field field, Object instance) {
        try {
            List<Object> value = (List<Object>)field.get(instance);
            return List.copyOf(value);
        } catch(Exception err) {
            System.out.println("Error in ArrayValueAdapter");
            return null;
        }
    }
}
