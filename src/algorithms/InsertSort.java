package algorithms;

import visualizer.Visualizer;
import visualizer.selector.single.SingleSelectorAnnotation;
import visualizer.visual.array.Array;

public class InsertSort implements Runnable {

    @Array
    private Integer[] array = {10, 2, 10, 3, 1, 2, 5};

    @SingleSelectorAnnotation(name= "array")
    private Integer j = 0;

    public void run() {
        for(int i = 0; i < array.length; ++i) {
            for(j = i; j > 0; --j) {
                Visualizer.yield();
                if(array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;

                } else break;
            }
        }
    }
}
