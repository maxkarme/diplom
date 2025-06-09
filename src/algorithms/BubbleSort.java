package algorithms;

import visualizer.Visualizer;
import visualizer.selector.single.SingleSelectorAnnotation;
import visualizer.visual.array.Array;
import visualizer.visual.description.DescriptionAlgorithm;

public class BubbleSort implements Runnable {
    @DescriptionAlgorithm
    private String description = "Пузырьковая сортировка";

    @Array(name="Array")
    private Integer[] arr = {5, 4, 3, 2, 1};

    @SingleSelectorAnnotation(name="arr")
    private Integer j = 0;

    public void run() {
        for(int i = 0; i < arr.length; ++i) {
            for(j = 0; j < arr.length - 1 - i; ++j) {
                Visualizer.yield();
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
