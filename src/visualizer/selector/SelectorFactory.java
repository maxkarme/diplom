package visualizer.selector;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public interface SelectorFactory {
    Selector buildSelector(Object instance, Field field, Annotation annotation);
}
