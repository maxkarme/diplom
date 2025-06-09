package visualizer.selector.multi.adapter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MultiSelectorAdapterFactory {
    private static List<MultiSelectorAdapter> adapters = new ArrayList<>();

    static {
        adapters.add(new MultiSelectorIntegerAdapter());
        adapters.add(new MultiSelectorBooleanAdapter());
    }

    public static MultiSelectorAdapter getAdapter(Field field, Object instance) {
        for(MultiSelectorAdapter adapter : adapters) {
            if(adapter.checkField(field, instance)) return adapter;
        }

        return null;
    }
}
