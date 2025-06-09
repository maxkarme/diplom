package visualizer.selector.range;

import visualizer.StateAdapter;
import visualizer.selector.Selector;
import visualizer.selector.SelectorFactory;
import visualizer.selector.range.adapter.RangeSelectorAdapterFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class RangeSelectorFactory implements SelectorFactory {
    @Override
    public Selector buildSelector(Object instance, Field field, Annotation annotation) {
        field.setAccessible(true);
        RangeSelectorAnnotation rangeAnnotation = (RangeSelectorAnnotation) annotation;

        StateAdapter adapter = RangeSelectorAdapterFactory.getAdapter(field, instance);

        try {
            RangeSelectorValue value = (RangeSelectorValue) field.get(instance);
            return new RangeSelector(instance, field, rangeAnnotation.name(), rangeAnnotation.priority(), adapter);
        } catch (Exception ex) {
            System.out.println("Error in RangeSelectorFactory");
        }

        return null;
    }
}
