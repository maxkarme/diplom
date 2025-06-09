package visualizer.selector.range.adapter;

import visualizer.selector.range.RangeSelectorValue;

import java.lang.reflect.Field;
import java.util.List;

public class RangeSelectorValueAdapter implements RangeSelectorAdapter {
    @Override
    public boolean checkField(Field field, Object instance) {
        try {
            RangeSelectorValue value = (RangeSelectorValue)field.get(instance);
            return true;
        } catch(Exception err) {
            return false;
        }
    }

    @Override
    public RangeSelectorValue getValue(Object object) {
        try {
            RangeSelectorValue value = (RangeSelectorValue)object;
            return value;
        } catch(Exception err) {
            System.out.println("Error in MultiSelectorIntegerAdapter");
            return null;
        }
    }

    @Override
    public Object screenValue(Field field, Object instance) {
        try {
            RangeSelectorValue value = (RangeSelectorValue)field.get(instance);
            return new RangeSelectorValue(value.getFrom(), value.getTo());
        } catch(Exception err) {
            System.out.println("Error in MultiSelectorIntegerAdapter");
            return null;
        }
    }
}
