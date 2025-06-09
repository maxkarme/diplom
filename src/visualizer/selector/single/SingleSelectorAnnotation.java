package visualizer.selector.single;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SingleSelectorAnnotation  {
    String name();
    int priority() default 3;
}
