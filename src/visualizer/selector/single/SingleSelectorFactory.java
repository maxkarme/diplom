package visualizer.selector.single;

import visualizer.selector.Selector;
import visualizer.selector.SelectorFactory;
import visualizer.selector.single.adapter.SingleSelectorAdapter;
import visualizer.selector.single.adapter.SingleSelectorAdapterFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class SingleSelectorFactory implements SelectorFactory {
    @Override
    public Selector buildSelector(Object instance, Field field, Annotation annotation) {
        field.setAccessible(true);
        SingleSelectorAnnotation singleAnnotation = (SingleSelectorAnnotation) annotation;

        try {
            SingleSelectorAdapter adapter = SingleSelectorAdapterFactory.getAdapter(field, instance);
            return new SingleSelector(instance, field, singleAnnotation.name(), singleAnnotation.priority(), adapter);
        } catch (Exception ex) {
            System.out.println("Error in SingleSelectorFactory");
        }

        return null;
    }
}
