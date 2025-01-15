import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab3BinLinSearchTest {
    public static void main(String[] args) {
        BinaryLinearSearch search = new BinaryLinearSearch();
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);

        while (!exit) {
            System.out.println("Select your option in the menu below");
            System.out.println("1. Initialize and populate an array of 32 random integers.");
            System.out.println("2. Perform a recursive binary and linear search.");
            System.out.println("3. Perform iterative binary and linear search.");
            System.out.println("4. Exit.");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    search.generateRandomInts();
                    break;
                case 2:
                    try {
                        System.out.println("Please enter an integer value to search");
                        int key2 = scanner.nextInt();
                        int recursiveBinaryResult = search.recursiveBinarySearch(key2, 0, search.randomArr.length - 1);
                        int recursiveLinearResult = search.recursiveLinearSearch(key2, 0);
                        
                        long binaryTime = search.timeBinarySearch(key2, true);
                        long linearTime = search.timeLinearSearch(key2, true);
                        displaySearchResult(key2, recursiveBinaryResult, recursiveLinearResult, binaryTime, linearTime);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Input. Enter an integer.");
                    }
                    break;
                case 3:
                    System.out.println("Please enter an integer value to search:");
                    int key3 = scanner.nextInt();
                    int iterativeBinaryResult = search.iterativeBinarySearch(key3);
                    int iterativeLinearResult = search.iterativeLinearSearch(key3);
                    long binaryTime = search.timeBinarySearch(key3, false);
                    long linearTime = search.timeLinearSearch(key3, false);
                    displaySearchResult(key3, iterativeBinaryResult, iterativeLinearResult, binaryTime, linearTime);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Please choose an option 1 to 4");
                    break;
            }

            // Clear the newline character from the input buffer
            scanner.nextLine();
        }
    }
    
    /**
     * Displays search results including array details, search results, and execution times.
     *
     * @param key          The integer value being searched for.
     * @param binaryResult The result of the binary search.
     * @param linearResult The result of the linear search.
     * @param binaryTime   The execution time of binary search in nanoseconds.
     * @param linearTime   The execution time of linear search in nanoseconds.
     */
    private static void displaySearchResult(int key, int binaryResult, int linearResult, long binaryTime, long linearTime) {
        System.out.println("\nArray of randomly generated integers:");
        System.out.print("Unsorted array: ");
        for (int num : BinaryLinearSearch.randomArr) {
            System.out.print(num + ",");
        }
        System.out.println();

        System.out.print("Sorted array: ");
        for (int num : BinaryLinearSearch.randomArr) {
            System.out.print(num + ",");
        }
        System.out.println();

        System.out.println("Searching for " + key + "...");
        System.out.println("Recursive Binary Search:");
        if (binaryResult != -1) {
            System.out.println(key + " was found at index position " + binaryResult);
        } else {
            System.out.println(key + " was not found");
        }
        System.out.println("Recursive Binary Search Time (nanoseconds): " + binaryTime + " nanoseconds");
        System.out.println("Recursive Binary Search Time (milliseconds): " + binaryTime / 1000000 + " milliseconds");

        System.out.println("\nRecursive Linear Search:");
        if (linearResult != -1) {
            System.out.println(key + " was found at index position " + linearResult);
        } else {
            System.out.println(key + " was not found");
        }
        System.out.println("Recursive Linear Search Time (nanoseconds): " + linearTime + " nanoseconds");
        System.out.println("Recursive Linear Search Time (milliseconds): " + linearTime / 1000000 + " milliseconds");
    }

    
}