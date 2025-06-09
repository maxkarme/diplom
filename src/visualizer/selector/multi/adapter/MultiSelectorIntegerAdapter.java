package visualizer.selector.multi.adapter;

import java.lang.reflect.Field;
import java.util.List;

public class MultiSelectorIntegerAdapter implements MultiSelectorAdapter {
    @Override
    public boolean checkField(Field field, Object instance) {
        try {
            List<?> value = (List<?>)field.get(instance);
            boolean allIntegers = value.stream().allMatch(e -> e instanceof Integer);
            return allIntegers;
        } catch(Exception err) {
            return false;
        }
    }

    @Override
    public List<Integer> getValue(Object object) {
        try {
            List<Integer> value = (List<Integer>)object;
            return value;
        } catch(Exception err) {
            System.out.println("Error in MultiSelectorIntegerAdapter");
            return null;
        }
    }

    @Override
    public Object screenValue(Field field, Object instance) {
        try {
            List<Integer> value = (List<Integer>)field.get(instance);
            return List.copyOf(value);
        } catch(Exception err) {
            System.out.println("Error in MultiSelectorBooleanAdapter");
            return null;
        }
    }
}
