package visualizer.visual;

import visualizer.visual.array.ArrayVisualFactory;
import visualizer.selector.Selector;
import visualizer.visual.description.DescriptionVisualFactory;
import visualizer.visual.graph.GraphVisualFactory;

import javax.swing.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

public class VisualCommonFactory {
    private static HashMap<String, VisualFactory> factoriesMap = new HashMap<>();

    static {
        factoriesMap.put("visualizer.visual.array.Array", new ArrayVisualFactory());
        factoriesMap.put("visualizer.visual.graph.Graph", new GraphVisualFactory());
        factoriesMap.put("visualizer.visual.description.DescriptionAlgorithm", new DescriptionVisualFactory());
    }

    public static VisualComponent buildComponent(Object instance, Annotation annotation, Field field, ArrayList<Selector> selectors) {
        if(!factoriesMap.containsKey(annotation.annotationType().getName())) return null;

        return factoriesMap.get(annotation.annotationType().getName()).buildComponent(instance, field, selectors, annotation);
    }

}
