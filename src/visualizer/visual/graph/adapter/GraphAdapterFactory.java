package visualizer.visual.graph.adapter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class GraphAdapterFactory {
    private static List<GraphAdapter> adapters = new ArrayList<>();

    static {
        adapters.add(new GraphValueAdapter());
    }

    public static GraphAdapter getAdapter(Field field, Object instance) {
        for(GraphAdapter adapter : adapters) {
            if(adapter.checkField(field, instance)) return adapter;
        }

        return null;
    }
}
