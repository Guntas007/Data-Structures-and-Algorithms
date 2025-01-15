import java.util.Arrays;

/**
 * This class provides implementations of various searching algorithms, including Binary Search and Linear Search.
 */
public class Searching {
    /**
	 * 
	 * @author gunta
	 * A class representing the result of a search operation, including the index where the target was found
     * and the time it took in nanoseconds.
	 */
    public static class SearchResult {
        private int index;
        private long nanoseconds;

        /**
         * Creates a new SearchResult object.
         *
         * @param index       The index where the target was found.
         * @param nanoseconds The time it took in nanoseconds to perform the search.
         */
        public SearchResult(int index, long nanoseconds) {
            this.index = index;
            this.nanoseconds = nanoseconds;
        }

        /**
         * Gets the index where the target was found.
         *
         * @return The index.
         */
        public int getIndex() {
            return index;
        }

        /**
         * Gets the time it took in nanoseconds to perform the search.
         *
         * @return The time in nanoseconds.
         */
        public long getNanoseconds() {
            return nanoseconds;
        }
    }

    /**
     * Performs a binary search on a sorted array to find a target element.
     *
     * @param randomArr The sorted array to search in.
     * @param target    The element to search for.
     * @return A SearchResult object containing the index of the target element and the time taken in nanoseconds.
     */
    public static SearchResult binarySearch(int[] randomArr, int target) {
        Arrays.sort(randomArr); // Sort the array first

        long startTime = System.nanoTime();
        int result = binarySearch(randomArr, target, 0, randomArr.length - 1);
        long endTime = System.nanoTime();

        long durationNanoseconds = endTime - startTime;

        SearchResult searchResult = new SearchResult(result, durationNanoseconds);
        return searchResult;
    }

    /**
     * Performs a binary search on a sorted array to find a target element.
     *
     * @param randomArr The sorted array to search in.
     * @param target    The element to search for.
     * @param left      The left index of the current search range.
     * @param right     The right index of the current search range.
     * @return The index of the target element or -1 if it's not found.
     */
    public static int binarySearch(int[] randomArr, int target, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;

            if (randomArr[mid] == target) {
                return mid;
            }

            if (randomArr[mid] < target) {
                return binarySearch(randomArr, target, mid + 1, right);
            } else {
                return binarySearch(randomArr, target, left, mid - 1);
            }
        }

        return -1;
    }

    /**
     * Performs a linear search to find a target element in an array.
     *
     * @param arr    The array to search in.
     * @param target The element to search for.
     * @return A SearchResult object containing the index of the target element and the time taken in nanoseconds.
     */
    public static SearchResult linearSearch(int[] arr, int target) {
        long startTime = System.nanoTime();
        int result = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                result = i;
                break;
            }
        }

        long endTime = System.nanoTime();

        SearchResult searchResult = new SearchResult(result, endTime - startTime);
        return searchResult;
    }
}
