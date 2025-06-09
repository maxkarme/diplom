package visualizer.selector.multi;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MultiSelectorAnnotation {
    String name();
    int priority() default 2;
}
