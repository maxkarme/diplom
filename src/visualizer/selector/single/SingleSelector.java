package visualizer.selector.single;

import visualizer.selector.Selector;
import visualizer.selector.single.adapter.SingleSelectorAdapter;

import java.lang.reflect.Field;

public class SingleSelector extends Selector {
    private final String name;
    private final int priority;

    public SingleSelector(Object _instance, Field _field, String _name, int _priority, SingleSelectorAdapter _adapter) {
        super(_field, _instance, _adapter);
        name = _name;
        priority = _priority;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public int isSelected(int element) {
        try {
            Integer value = ((SingleSelectorAdapter) adapter).getValue(getValue());
            return element == value ? 6 : 0;
        } catch (Exception ex) {
            System.out.println("Error in SingleSelector " + getName());
        }

        return 0;
    }
}
