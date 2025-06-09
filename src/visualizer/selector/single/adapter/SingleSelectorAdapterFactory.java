package visualizer.selector.single.adapter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class SingleSelectorAdapterFactory {
    private static List<SingleSelectorAdapter> adapters = new ArrayList<>();

    static {
        adapters.add(new SingleSelectorIntegerAdapter());
    }

    public static SingleSelectorAdapter getAdapter(Field field, Object instance) {
        for(SingleSelectorAdapter adapter : adapters) {
            if(adapter.checkField(field, instance)) return adapter;
        }

        return null;
    }
}
