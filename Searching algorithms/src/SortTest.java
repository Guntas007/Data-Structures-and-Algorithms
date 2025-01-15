import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class SortTest {
    private static int[] randomArr;

    @BeforeAll
    public static void initializeArray() {
        // Initialize the randomArr with 1000 random integers
        randomArr = new int[999999];
        Random random = new Random();
        for (int i = 0; i < randomArr.length; i++) {
            randomArr[i] = random.nextInt(1000);
        }
    }

    @Test
    public void testBubbleSort() {
        int[] arrCopy = Arrays.copyOf(randomArr, randomArr.length);
        SortingAlgorithms.BubbleSort(arrCopy);
        int[] sortedArr = Arrays.copyOf(randomArr, randomArr.length);
        Arrays.sort(sortedArr);
        Assertions.assertArrayEquals(sortedArr, arrCopy);
    }

    @Test
    public void testInsertionSort() {
        int[] arrCopy = Arrays.copyOf(randomArr, randomArr.length);
        SortingAlgorithms.InsertionSort(arrCopy);
        int[] sortedArr = Arrays.copyOf(randomArr, randomArr.length);
        Arrays.sort(sortedArr);
        Assertions.assertArrayEquals(sortedArr, arrCopy);
    }

    @Test
    public void testSelectionSort() {
        int[] arrCopy = Arrays.copyOf(randomArr, randomArr.length);
        SortingAlgorithms.SelectionSort(arrCopy);
        int[] sortedArr = Arrays.copyOf(randomArr, randomArr.length);
        Arrays.sort(sortedArr);
        Assertions.assertArrayEquals(sortedArr, arrCopy);
    }

    @Test
    public void testMergeSort() {
        int[] arrCopy = Arrays.copyOf(randomArr, randomArr.length);
        SortingAlgorithms.MergeSort(arrCopy);
        int[] sortedArr = Arrays.copyOf(randomArr, randomArr.length);
        Arrays.sort(sortedArr);
        Assertions.assertArrayEquals(sortedArr, arrCopy);
    }

    @Test
    public void testQuickSort() {
        int[] arrCopy = Arrays.copyOf(randomArr, randomArr.length);
        SortingAlgorithms.QuickSort(arrCopy);
        int[] sortedArr = Arrays.copyOf(randomArr, randomArr.length);
        Arrays.sort(sortedArr);
        Assertions.assertArrayEquals(sortedArr, arrCopy);
    }
}
