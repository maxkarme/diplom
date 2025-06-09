package visualizer.visual.array;

import visualizer.StateAdapter;
import visualizer.visual.VisualComponent;
import visualizer.visual.VisualFactory;
import visualizer.selector.Selector;
import visualizer.visual.array.adapter.ArrayAdapterFactory;

import javax.swing.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class ArrayVisualFactory implements VisualFactory {
    @Override
    public VisualComponent buildComponent(Object instance, Field field, ArrayList<Selector> selectors, Annotation annotation) {
        field.setAccessible(true);
        Array array = (Array) annotation;

        StateAdapter adapter = ArrayAdapterFactory.getAdapter(field, instance);

        return new ArrayVisual(array.name(), field, instance, selectors, adapter);
    }
}
