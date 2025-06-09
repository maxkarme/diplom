package visualizer.visual.graph;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Graph {
    String name() default "";
    boolean isOriented() default false;
}
