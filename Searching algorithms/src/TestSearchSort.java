import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * This class provides a menu-driven interface for testing search and sort algorithms.
 */
public class TestSearchSort {
    /**
     * The main method that runs the program.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        int[] randomArr = new int[1000];
        Searching.SearchResult result;

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        while (!quit) {
            try {
                System.out.println("Select your option in the menu below:");
                System.out.println("1: Initialize and populate an array of 1000 random integers.");
                System.out.println("2: Perform recursive binary search.");
                System.out.println("3: Perform recursive linear search.");
                System.out.println("4: Sort the array");
                System.out.println("5: Quit");

                System.out.print("> ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        // Initialize and populate the array
                        randomArr = genRandomInts(1000, 120, 999);
                        System.out.println("Array of randomly generated integers:");
                        System.out.println(Arrays.toString(randomArr));
                        break;

                    case 2:
                        // Perform binary search
                        System.out.print("Please enter an integer value to search: ");
                        int target = scanner.nextInt();
                        // Sort the array before performing binary search
                        Arrays.sort(randomArr);
                        Searching.SearchResult result1 = Searching.binarySearch(randomArr, target);
                        if (result1.getIndex() != -1) {
                            System.out.println(target + " was found at index " + result1.getIndex());
                            System.out.println("Time taken in nanoseconds: " + result1.getNanoseconds());
                            System.out.println("Time taken in milliseconds: " + (result1.getNanoseconds() / 1000000.0));
                        } else {
                            System.out.println(target + " was not found in the array.");
                        }
                        break;

                    case 3:
                        System.out.println("Please enter an integer value to search:");
                        target = scanner.nextInt();
                        result = Searching.linearSearch(randomArr, target);
                        System.out.println(Arrays.toString(randomArr));
                        if (result.getIndex() != -1) {
                            System.out.println(target + " was found at index position " + result.getIndex() + " : Recursive Linear Search.");
                            System.out.println("Time taken in nanoseconds: " + result.getNanoseconds());
                            System.out.println("Time taken in milliseconds: " + (result.getNanoseconds() / 1000000.0));
                        } else {
                            System.out.println(target + " was not found in the array.");
                        }
                        break;

                    case 4:
                        boolean sortSubMenu = true;
                        while (sortSubMenu) {
                            System.out.println("Select a sorting algorithm to sort the data array");
                            System.out.println("B. Bubble Sort");
                            System.out.println("I. Insertion Sort");
                            System.out.println("S. Selection Sort");
                            System.out.println("M. Merge Sort");
                            System.out.println("Q. Quick Sort");
                            System.out.println("R. Return to Main Menu");
                            System.out.print("> ");

                            char sortChoice = Character.toUpperCase(scanner.next().charAt(0));

                            switch (sortChoice) {
                                case 'B':
                                    int[] bubbleSortArr = Arrays.copyOf(randomArr, randomArr.length);
                                    long bubbleSortStart = System.nanoTime();
                                    SortingAlgorithms.BubbleSort(bubbleSortArr);
                                    long bubbleSortEnd = System.nanoTime();
                                    System.out.println("Bubble Sort: Simple sorting algorithm - O(n^2) Complexity");
                                    System.out.println("Sorted: " + Arrays.toString(bubbleSortArr));
                                    System.out.println("Time taken in nanoseconds: " + (bubbleSortEnd - bubbleSortStart));
                                    System.out.println("Time taken in milliseconds: " + ((bubbleSortEnd - bubbleSortStart) / 1000000.0));
                                    break;

                                case 'I':
                                    int[] insertionSortArr = Arrays.copyOf(randomArr, randomArr.length);
                                    long insertionSortStart = System.nanoTime();
                                    SortingAlgorithms.InsertionSort(insertionSortArr);
                                    long insertionSortEnd = System.nanoTime();
                                    System.out.println("Insertion Sort: Simple sorting algorithm - O(n^2) Complexity");
                                    System.out.println("Sorted: " + Arrays.toString(insertionSortArr));
                                    System.out.println("Time taken in nanoseconds: " + (insertionSortEnd - insertionSortStart));
                                    System.out.println("Time taken in milliseconds: " + ((insertionSortEnd - insertionSortStart) / 1000000.0));
                                    break;

                                case 'S':
                                    int[] selectionSortArr = Arrays.copyOf(randomArr, randomArr.length);
                                    long selectionSortStart = System.nanoTime();
                                    SortingAlgorithms.SelectionSort(selectionSortArr);
                                    long selectionSortEnd = System.nanoTime();
                                    System.out.println("Selection Sort: Simple sorting algorithm - O(n^2) Complexity");
                                    System.out.println("Sorted: " + Arrays.toString(selectionSortArr));
                                    System.out.println("Time taken in nanoseconds: " + (selectionSortEnd - selectionSortStart));
                                    System.out.println("Time taken in milliseconds: " + ((selectionSortEnd - selectionSortStart) / 1000000.0));
                                    break;

                                case 'M':
                                    int[] mergeSortArr = Arrays.copyOf(randomArr, randomArr.length);
                                    long mergeSortStart = System.nanoTime();
                                    SortingAlgorithms.MergeSort(mergeSortArr);
                                    long mergeSortEnd = System.nanoTime();
                                    System.out.println("Merge Sort: Recursive Divide-And-Conquer - O(n log n) Complexity");
                                    System.out.println("Sorted: " + Arrays.toString(mergeSortArr));
                                    System.out.println("Time taken in nanoseconds: " + (mergeSortEnd - mergeSortStart));
                                    System.out.println("Time taken in milliseconds: " + ((mergeSortEnd - mergeSortStart) / 1000000.0));
                                    break;

                                case 'Q':
                                    int[] quickSortArr = Arrays.copyOf(randomArr, randomArr.length);
                                    long quickSortStart = System.nanoTime();
                                    SortingAlgorithms.QuickSort(quickSortArr);
                                    long quickSortEnd = System.nanoTime();
                                    System.out.println("Quick Sort: Recursive Divide-And-Conquer - O(n log n) Complexity");
                                    System.out.println("Sorted: " + Arrays.toString(quickSortArr));
                                    System.out.println("Time taken in nanoseconds: " + (quickSortEnd - quickSortStart));
                                    System.out.println("Time taken in milliseconds: " + ((quickSortEnd - quickSortStart) / 1000000.0));
                                    break;

                                case 'R':
                                    sortSubMenu = false;
                                    break;

                                default:
                                    System.out.println("Invalid entry, please try again...");
                            }
                        }
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        quit = true;
                        break;

                    default:
                        System.out.println("Invalid entry, please try again...");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid option.");
                scanner.next(); 
            }
        }
    }

    /**
     * Generates an array of random integers within a specified range.
     *
     * @param size The size of the array.
     * @param min  The minimum value for the random integers.
     * @param max  The maximum value for the random integers.
     * @return An array of random integers.
     */
    public static int[] genRandomInts(int size, int min, int max) {
        int[] randomArr = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            randomArr[i] = random.nextInt(max - min + 1) + min;
        }

        return randomArr;
    }
}
