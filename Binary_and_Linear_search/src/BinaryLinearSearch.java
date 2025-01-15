import java.security.SecureRandom;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BinaryLinearSearch {
    public static long binaryRecursiveTime;
    public static long linearRecursiveTime;
    public static int[] randomArr;

    public BinaryLinearSearch() {
        randomArr = new int[32];
    }

    // Method to generate random integers between 10 and 100
    public void generateRandomInts() {
        SecureRandom random = new SecureRandom();
        System.out.println("Unsorted Random Array:");
        System.out.print("[");
        for (int i = 0; i < randomArr.length; i++) {
            randomArr[i] = random.nextInt(91) + 10; // Generates numbers between 10 and 100
            System.out.print(randomArr[i] + " ");
        }
        System.out.print("]");
        System.out.println("\nSorted Random Array:");
        Arrays.sort(randomArr);
        System.out.print("[");
        for (int num : randomArr) {
            System.out.print(num + " ");
        }
        System.out.print("]");
        System.out.println();
    }

    /**
     * Iterative Binary Search method.
     *
     * @param key The element to search for.
     * @return The index of the element if found, otherwise -1.
     */
    public int iterativeBinarySearch(int key) {
        int start = 0;
        int end = randomArr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (randomArr[mid] == key) {
                return mid;
            } else if (randomArr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    /**
     * Recursive Binary Search method.
     *
     * @param key   The element to search for.
     * @param start The start index of the search range.
     * @param end   The end index of the search range.
     * @return The index of the element if found, otherwise -1.
     */
    public int recursiveBinarySearch(int key, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (randomArr[mid] == key) {
                return mid;
            } else if (randomArr[mid] < key) {
                return recursiveBinarySearch(key, mid + 1, end);
            } else {
                return recursiveBinarySearch(key, start, mid - 1);
            }
        }

        return -1;
    }

    /**
     * Iterative Linear Search method.
     *
     * @param key The element to search for.
     * @return The index of the element if found, otherwise -1.
     */
    public int iterativeLinearSearch(int key) {
        for (int i = 0; i < randomArr.length; i++) {
            if (randomArr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Recursive Linear Search method.
     *
     * @param key   The element to search for.
     * @param index The current index in the search.
     * @return The index of the element if found, otherwise -1.
     */
    public int recursiveLinearSearch(int key, int index) {
        if (index < randomArr.length) {
            if (randomArr[index] == key) {
                return index;
            } else {
                return recursiveLinearSearch(key, index + 1);
            }
        }
        return -1;
    }

    /**
     * Measures the execution time of binary search and returns it in nanoseconds.
     *
     * @param key        The element to search for.
     * @param isRecursive Flag indicating whether to use the recursive or iterative version of binary search.
     * @return The execution time in nanoseconds.
     */
    public long timeBinarySearch(int key, boolean isRecursive) {
        long startTime = System.nanoTime();

        if (isRecursive) {
            recursiveBinarySearch(key, 0, randomArr.length - 1);
        } else {
            iterativeBinarySearch(key);
        }

        long endTime = System.nanoTime();
        binaryRecursiveTime = endTime - startTime;
        return binaryRecursiveTime;
    }

    /**
     * Measures the execution time of linear search and returns it in nanoseconds.
     *
     * @param key        The element to search for.
     * @param isRecursive Flag indicating whether to use the recursive or iterative version of linear search.
     * @return The execution time in nanoseconds.
     */
    public long timeLinearSearch(int key, boolean isRecursive) {
        long startTime = System.nanoTime();

        if (isRecursive) {
            recursiveLinearSearch(key, 0);
        } else {
            iterativeLinearSearch(key);
        }

        long endTime = System.nanoTime();
        linearRecursiveTime = endTime - startTime;
        return linearRecursiveTime;
    }

    /**
     * Converts nanoseconds to milliseconds.
     *
     * @param nanos The time in nanoseconds.
     * @return The time in milliseconds.
     */
    public double nanosToMillis(long nanos) {
        return nanos / 1000000.0;
    }
}