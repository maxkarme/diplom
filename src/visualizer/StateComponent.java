package visualizer;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class StateComponent {
    private static int iter = 0;
    private List<Object> values = new ArrayList<>();
    private Field field;
    private Object instance;

    protected StateAdapter adapter;

    protected StateComponent(Field _field, Object _instance, StateAdapter stateAdapter) {
        field = _field;
        instance = _instance;
        adapter = stateAdapter;
        screenValue();
    }

    protected Object getValue() {
        if(iter >= values.size()) iter = values.size() - 1;
        if(iter < 0) iter = 0;
        return values.get(iter);
    }

    public static void changeIter(int delta) {
        iter += delta;
    }

    public static void clearIter() {
        iter = 0;
    }

    public void screenValue() {
        values.add(adapter.screenValue(field, instance));
    }
}
