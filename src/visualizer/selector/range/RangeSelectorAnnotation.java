package visualizer.selector.range;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RangeSelectorAnnotation {
    String name();
    int priority() default 2;
}
