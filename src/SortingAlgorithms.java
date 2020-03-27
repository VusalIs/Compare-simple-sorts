import java.util.Arrays;

public class SortingAlgorithms<T extends Comparable>{

    public static Integer[] selectionSort(Integer[] array) {
        int N = array.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if(array[j].compareTo(array[min]) < 0){
                    min = j;
                }
            }
            exch(array, i, min);

        }
        return array;
    }

    public static Integer[] insertionSort(Integer[] array){
        int N = array.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if(array[j].compareTo(array[j-1]) < 0)
                    exch(array, j, j-1);
                else break;
            }
        }
        return array;
    }

    public static Integer[] mergeSort(Integer[] array){
        mergeSortMain(array, array.length);
        return array;
    }

    private static void mergeSortMain(Integer[] array, int N) {
        if (N < 2) {
            return;
        }
        int mid = N / 2;
        Integer[] l = Arrays.copyOfRange(array, 0, mid);
        Integer[] r = Arrays.copyOfRange(array, mid, N);

        mergeSortMain(l, mid);
        mergeSortMain(r, N - mid);

        merge(array, l, r, mid, N - mid);
    }

    private static void merge(
            Integer[] array, Integer[] leftArray, Integer[] rightArray, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            }
            else {
                array[k++] = rightArray[j++];
            }
        }
        while (i < left) {
            array[k++] = leftArray[i++];
        }
        while (j < right) {
            array[k++] = rightArray[j++];
        }
    }

    private static void exch(Integer[] array, int i, int j){
        Integer swap = array[i];
        array[i] = array[j];
        array[j] = swap;
    }
}
