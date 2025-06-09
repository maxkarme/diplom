package visualizer.visual.array.adapter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ArrayAdapterFactory {
    private static List<ArrayAdapter> adapters = new ArrayList<>();

    static {
        adapters.add(new ArrayListAdapter());
        adapters.add(new ArrayValueAdapter());
    }

    public static ArrayAdapter getAdapter(Field field, Object instance) {
        for(ArrayAdapter adapter : adapters) {
            if(adapter.checkField(field, instance)) return adapter;
        }

        return null;
    }
}
