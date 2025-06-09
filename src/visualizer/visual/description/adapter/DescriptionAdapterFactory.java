package visualizer.visual.description.adapter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class DescriptionAdapterFactory {
    private static List<DescriptionAdapter> adapters = new ArrayList<>();

    static {
        adapters.add(new DescriptionValueAdapter());
    }

    public static DescriptionAdapter getAdapter(Field field, Object instance) {
        for(DescriptionAdapter adapter : adapters) {
            if(adapter.checkField(field, instance)) return adapter;
        }

        return null;
    }
}
