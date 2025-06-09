package visualizer.visual.graph;

import visualizer.StateAdapter;
import visualizer.selector.Selector;
import visualizer.visual.VisualComponent;
import visualizer.visual.VisualFactory;
import visualizer.visual.graph.adapter.GraphAdapterFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class GraphVisualFactory implements VisualFactory {
    @Override
    public VisualComponent buildComponent(Object instance, Field field, ArrayList<Selector> selectors, Annotation annotation) {
        field.setAccessible(true);
        Graph graph = (Graph) annotation;

        StateAdapter adapter = GraphAdapterFactory.getAdapter(field, instance);

        return new GraphVisual(graph, field, instance, selectors, adapter);
    }
}
