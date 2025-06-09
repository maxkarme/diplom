package visualizer.visual.graph.adapter;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class GraphValueAdapter implements GraphAdapter {
    @Override
    public boolean checkField(Field field, Object instance) {
        try {
            ArrayList<Integer>[] value = (ArrayList<Integer>[])field.get(instance);
            int maxLength = value.length;
            for (ArrayList<Integer> integers : value) {
                maxLength = Math.max(maxLength, integers.size());
            }

            if(maxLength > 10000) {
                System.out.println("Very big data in graph");
                return false;
            }
            return true;
        } catch(Exception err) {
            return false;
        }
    }

    @Override
    public ArrayList<Integer>[] getValue(Object object) {
        try {
            ArrayList<Integer>[] value = (ArrayList<Integer>[])object;

            return value;
        } catch(Exception err) {
            System.out.println("Error in GraphValueAdapter");
            return null;
        }
    }

    @Override
    public Object screenValue(Field field, Object instance) {
        try {
            ArrayList<Integer>[] value = (ArrayList<Integer>[])field.get(instance);
            ArrayList<Integer>[] copy = new ArrayList[value.length];

            for(int i = 0; i < value.length; ++i) {
                copy[i] = new ArrayList<>(value[i]);;
            }

            return copy;
        } catch(Exception err) {
            System.out.println("Error in GraphValueAdapter");
            return null;
        }
    }
}
