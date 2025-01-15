
/**
 * This class provides implementations of various sorting algorithms, including Bubble Sort, Insertion Sort,
 * Selection Sort, Merge Sort, and Quick Sort.
 */
public class SortingAlgorithms {
	
	/**
     * Sorts an integer array using the Bubble Sort algorithm.
     *
     * @param arr The array to be sorted.
     */
    public static void BubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Sorts an integer array using the Insertion Sort algorithm.
     *
     * @param arr The array to be sorted.
     */
    public static void InsertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    /**
     * Sorts an integer array using the Selection Sort algorithm.
     *
     * @param arr The array to be sorted.
     */
    public static void SelectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    /**
     * Sorts an integer array using the Merge Sort algorithm.
     *
     * @param arr The array to be sorted.
     */
    public static void MergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * Helper method for Merge Sort that recursively sorts a subarray.
     *
     * @param arr   The array to be sorted.
     * @param left  The left index of the subarray.
     * @param right The right index of the subarray.
     */
    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    /**
     * Merges two subarrays during the Merge Sort algorithm.
     *
     * @param arr   The array to be sorted.
     * @param left  The left index of the first subarray.
     * @param mid   The middle index.
     * @param right The right index of the second subarray.
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    /**
     * Sorts an integer array using the Quick Sort algorithm.
     *
     * @param arr The array to be sorted.
     */
    public static void QuickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * Helper method for Quick Sort that recursively sorts a subarray.
     *
     * @param arr  The array to be sorted.
     * @param low  The low index of the subarray.
     * @param high The high index of the subarray.
     */
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    
    /**
     * Partitions the array during Quick Sort and returns the pivot index.
     *
     * @param arr  The array to be sorted.
     * @param low  The low index of the subarray.
     * @param high The high index of the subarray.
     * @return The pivot index.
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
