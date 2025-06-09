package visualizer.selector.multi.adapter;

import java.lang.reflect.Field;
import java.util.List;

public class MultiSelectorBooleanAdapter implements MultiSelectorAdapter {
    @Override
    public boolean checkField(Field field, Object instance) {
        try {
            List<?> value = (List<?>)field.get(instance);
            boolean allIntegers = value.stream().allMatch(e -> e instanceof Boolean);
            return allIntegers;
        } catch(Exception err) {
            return false;
        }
    }

    @Override
    public List<Integer> getValue(Object object) {
        try {
            List<Boolean> value = (List<Boolean>)object;
            return value.stream().map(elem -> elem ? 1 : 0).toList();
        } catch(Exception err) {
            System.out.println("Error in MultiSelectorBooleanAdapter");
            return null;
        }
    }

    @Override
    public Object screenValue(Field field, Object instance) {
        try {
            List<Boolean> value = (List<Boolean>)field.get(instance);
            return List.copyOf(value);
        } catch(Exception err) {
            System.out.println("Error in MultiSelectorBooleanAdapter");
            return null;
        }
    }
}
