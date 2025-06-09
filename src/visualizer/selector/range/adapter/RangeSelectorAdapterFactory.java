package visualizer.selector.range.adapter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class RangeSelectorAdapterFactory {
    private static List<RangeSelectorAdapter> adapters = new ArrayList<>();

    static {
        adapters.add(new RangeSelectorValueAdapter());
    }

    public static RangeSelectorAdapter getAdapter(Field field, Object instance) {
        for(RangeSelectorAdapter adapter : adapters) {
            if(adapter.checkField(field, instance)) return adapter;
        }

        return null;
    }
}
