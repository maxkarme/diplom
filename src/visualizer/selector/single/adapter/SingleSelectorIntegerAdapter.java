package visualizer.selector.single.adapter;

import visualizer.selector.range.RangeSelectorValue;

import java.lang.reflect.Field;

public class SingleSelectorIntegerAdapter implements SingleSelectorAdapter {
    @Override
    public boolean checkField(Field field, Object instance) {
        try {
            Integer value = (Integer)field.get(instance);
            return true;
        } catch(Exception err) {
            return false;
        }
    }

    @Override
    public Integer getValue(Object object) {
        try {
            Integer value = (Integer)object;
            return value;
        } catch(Exception err) {
            System.out.println("Error in MultiSelectorIntegerAdapter");
            return null;
        }
    }

    @Override
    public Object screenValue(Field field, Object instance) {
        try {
            Integer value = (Integer) field.get(instance);
            return Integer.valueOf(value.intValue());
        } catch(Exception err) {
            System.out.println("Error in MultiSelectorIntegerAdapter");
            return null;
        }
    }
}
