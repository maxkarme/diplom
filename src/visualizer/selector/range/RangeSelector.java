package visualizer.selector.range;

import visualizer.StateAdapter;
import visualizer.StateComponent;
import visualizer.selector.Selector;
import visualizer.selector.range.adapter.RangeSelectorAdapter;

import java.lang.reflect.Field;

public class RangeSelector extends Selector {
    private final String name;
    private final int priority;

    public RangeSelector(Object _instance, Field _field, String _name, int _priority, StateAdapter _adapter) {
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
            RangeSelectorValue value = (RangeSelectorValue) ((RangeSelectorAdapter) adapter).getValue(getValue());
            boolean res = value.getFrom() <= element && element <= value.getTo();
            return res ? 1 : 0;
        } catch (Exception ex) {
            System.out.println("Error in RangeSelectorFactory");
        }

        return 0;
    }
}
