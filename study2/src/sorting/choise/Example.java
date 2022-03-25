package sorting.choise;

import static sorting.choise.MySorts.*;
import static sorting.choise.QuickSort.quickSort;

public class Example {

    public static void main(String[] args) {
        int[] a = new int[10000];
        genRandomData(a);
        long time = System.currentTimeMillis();
        //insertionSort(a);
        //shellSort(a);
        quickSort(a, 0, a.length-1);
        assert isSorted(a);
        System.out.println(System.currentTimeMillis() - time);
        show(a);
    }

}
