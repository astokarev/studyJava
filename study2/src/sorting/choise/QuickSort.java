package sorting.choise;

public class QuickSort {

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int low, int high)
    {
        int base = arr[high];
        // правильный индекс базового элемента(стена)
        int i = (low - 1);

        for(int j = low; j <= high - 1; j++)
        {
            if (arr[j] < base)
            {
                //сдвигаем "стену"
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high)
        {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }
}
