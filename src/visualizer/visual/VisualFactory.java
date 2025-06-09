package visualizer.visual;

import visualizer.selector.Selector;

import javax.swing.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;

public interface VisualFactory {
    VisualComponent buildComponent(Object instance, Field field, ArrayList<Selector> selectors, Annotation annotation);
}
