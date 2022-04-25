package sorting.choise;

import java.util.Random;

public class MySorts {

    public static void genRandomData(int arr[]) {
        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(100000);
        }
    }
    //(N^2-N)/2
    public static void selectionSort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exchange(a, i, min);
        }
    }

    public static void gnomeSort(Integer[] a) {
        int index = 0;
        while (index < a.length) {
            if (index == 0)
                index++;
            if (a[index] >= a[index - 1])
                index++;
            else {
                int temp = 0;
                temp = a[index];
                a[index] = a[index - 1];
                a[index - 1] = temp;
                index--;
            }
        }
    }

    public static void insertionSort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exchange(a, j, j - 1);
            }

        }
    }

    public static void shellSort(Integer[] a) {
        //выделяем сегмент массива
        for (int half = a.length / 2; half > 0; half /= 2) {

            for (int i = half; i < a.length; i++) {
                int temp = a[i];
                int j;
                for (j = i; j >= half && a[j-half]>temp; j--) {
                    a[j] = a[j-half];
                }
                a[j] = temp;
            }
        }
    }

    public static void bubbleSort(Integer[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }

        }
    }

    public static void shakerSort(Integer arr[]) {
        int buff;
        int left = 0;
        int right = arr.length - 1;
        do {
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    buff = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buff;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (arr[i] < arr[i - 1]) {
                    buff = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = buff;
                }
            }
            left++;
        } while (left < right);
    }

    private static void exchange(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static boolean isSorted(int[] a) {
        for (int i = 0; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    public static void show(int[] a) {
        for (Comparable comparable : a) {
            System.out.print(comparable + " ");
            //System.out.println();
        }
    }
}
