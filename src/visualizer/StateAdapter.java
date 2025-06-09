package visualizer;

import java.lang.reflect.Field;

public interface StateAdapter {
    Object screenValue(Field field, Object instance);
}
