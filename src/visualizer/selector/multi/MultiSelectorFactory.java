package visualizer.selector.multi;

import visualizer.selector.Selector;
import visualizer.selector.SelectorFactory;
import visualizer.selector.multi.adapter.MultiSelectorAdapter;
import visualizer.selector.multi.adapter.MultiSelectorAdapterFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

public class MultiSelectorFactory implements SelectorFactory {
    @Override
    public Selector buildSelector(Object instance, Field field, Annotation annotation) {
        field.setAccessible(true);
        MultiSelectorAnnotation multiAnnotation = (MultiSelectorAnnotation) annotation;

        try {
            List<Object> value = (List<Object>) field.get(instance);
            MultiSelectorAdapter adapter = MultiSelectorAdapterFactory.getAdapter(field, instance);
            return new MultiSelector(instance, field, multiAnnotation.name(), multiAnnotation.priority(), adapter);
        } catch (Exception ex) {
            System.out.println("Error in MultiSelectorFactory");
        }

        return null;
    }
}
