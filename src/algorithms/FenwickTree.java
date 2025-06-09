package algorithms;

import visualizer.Visualizer;
import visualizer.selector.range.RangeSelectorAnnotation;
import visualizer.selector.range.RangeSelectorValue;
import visualizer.selector.single.SingleSelectorAnnotation;
import visualizer.visual.array.Array;
import visualizer.visual.description.DescriptionAlgorithm;

public class FenwickTree implements Runnable {
    @DescriptionAlgorithm
    String description =
            "Дерево фенвика: алгоритм, для эффективного подсчета суммы элементов " +
            "в массиве. Для этого он разбивает исходный массив на отрезки и поддерживает " +
            "сумму элементов на этих отрезках. По индексу в дереве фенвика хранится сумма, на " +
            "некотором отрезке в исходном массиве. Данная визуализация для каждого элемента в дереве " +
            "фенвика демострирует, какому отрезку он соответствует в исходном массиве ";

    @Array(name="Исходный массив")
    private Integer[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};

    @Array(name="Дерево фенвика")
    private Integer[] fenwickTree = new Integer[9];

    @SingleSelectorAnnotation(name="fenwickTree")
    private Integer arrInd = 0;

    @RangeSelectorAnnotation(name="arr")
    private RangeSelectorValue rangeValue = new RangeSelectorValue(-1, -1);

    private void add(Integer val, Integer ind) {
        while(ind < fenwickTree.length) {
            fenwickTree[ind] += val;
            ind += (ind & -ind);
        }
    }

    public FenwickTree() {
        for(Integer i = 0; i < fenwickTree.length; ++i) {
            fenwickTree[i] = 0;
        }

        for(Integer i = 1; i < arr.length; ++i) {
            add(arr[i], i);
        }
    }


    @Override
    public void run() {
        while(arrInd < arr.length - 1) {
            arrInd++;
            int size = (arrInd & -arrInd);
            rangeValue = new RangeSelectorValue(arrInd - size + 1, arrInd);
            Visualizer.yield();
        }
    }
}
