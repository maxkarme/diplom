package visualizer.visual.array.adapter;

import java.lang.reflect.Field;
import java.util.List;

public class ArrayValueAdapter implements ArrayAdapter {
    @Override
    public boolean checkField(Field field, Object instance) {
        try {
            Object[] value = (Object[])field.get(instance);

            if(value.length > 10000) {
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
            Object[] value = (Object[])object;
            return List.of(value);
        } catch(Exception err) {
            System.out.println("Error in ArrayValueAdapter");
            return null;
        }
    }

    @Override
    public Object screenValue(Field field, Object instance) {
        try {
            Object[] value = (Object[])field.get(instance);
            return List.of(value);
        } catch(Exception err) {
            System.out.println("Error in ArrayValueAdapter");
            return null;
        }
    }
}
