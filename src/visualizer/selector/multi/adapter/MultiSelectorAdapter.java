package visualizer.selector.multi.adapter;

import visualizer.StateAdapter;

import javax.swing.plaf.nimbus.State;
import java.lang.reflect.Field;
import java.util.List;

public interface MultiSelectorAdapter extends StateAdapter {
    boolean checkField(Field field, Object instance);
    List<Integer> getValue(Object object);
}
