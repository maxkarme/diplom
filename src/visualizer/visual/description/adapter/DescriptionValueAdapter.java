package visualizer.visual.description.adapter;

import java.lang.reflect.Field;
import java.util.List;

public class DescriptionValueAdapter implements DescriptionAdapter {
    @Override
    public boolean checkField(Field field, Object instance) {
        try {
            String value = (String)field.get(instance);
            return true;
        } catch(Exception err) {
            return false;
        }
    }

    @Override
    public String getValue(Object object) {
        try {
            String value = (String)object;
            return value;
        } catch(Exception err) {
            System.out.println("Error in DescriptionValueAdapter");
            return null;
        }
    }

    @Override
    public Object screenValue(Field field, Object instance) {
        try {
            String value = (String)field.get(instance);
            return new String(value);
        } catch(Exception err) {
            System.out.println("Error in DescriptionValueAdapter");
            return null;
        }
    }
}
