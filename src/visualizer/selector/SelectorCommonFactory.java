package visualizer.selector;

import visualizer.selector.multi.MultiSelectorFactory;
import visualizer.selector.range.RangeSelectorFactory;
import visualizer.selector.single.SingleSelectorFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;

public class SelectorCommonFactory {
    private static HashMap<String, SelectorFactory> factoriesMap = new HashMap<>();

    static {
        factoriesMap.put("visualizer.selector.single.SingleSelectorAnnotation", new SingleSelectorFactory());
        factoriesMap.put("visualizer.selector.range.RangeSelectorAnnotation", new RangeSelectorFactory());
        factoriesMap.put("visualizer.selector.multi.MultiSelectorAnnotation", new MultiSelectorFactory());
    }

    public static Selector buildSelector(Object instance, Annotation annotation, Field field) {
        if(!factoriesMap.containsKey(annotation.annotationType().getName())) return null;

        return factoriesMap.get(annotation.annotationType().getName()).buildSelector(instance, field, annotation);
    }


}
