package visualizer.selector.multi;

import visualizer.StateComponent;
import visualizer.selector.Selector;
import visualizer.selector.multi.adapter.MultiSelectorAdapter;

import java.lang.reflect.Field;
import java.util.List;

public class MultiSelector extends Selector {
    private final String name;
    private final int priority;

    private final MultiSelectorAdapter adapter;

    public MultiSelector(Object _instance, Field _field, String _name, int _priority, MultiSelectorAdapter _adapter) {
        super(_field, _instance, _adapter);
        name = _name;
        priority = _priority;
        adapter = _adapter;
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
            List<Integer> value = adapter.getValue(getValue());
            return value.get(element);
        } catch (Exception ex) {
            System.out.println("Error in MultiSelectorCheck");
        }

        return 0;
    }
}
