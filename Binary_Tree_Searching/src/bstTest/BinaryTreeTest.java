package bstTest;

import binarySearchTree.BinaryTree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree<Integer> bst = new BinaryTree<>(new IntegerComparator());

        // Read values from SampleValues.txt and insert into the BST
        bst.readValuesFromFile("SampleValues.txt");

        // Display tree using pre-order, in-order, and post-order traversal
        System.out.println("Tree display using pre-order traversal:");
        bst.displayPreOrder();

        System.out.println("\nTree display using in-order traversal:");
        bst.displayInOrder();

        System.out.println("\nTree display using post-order traversal:");
        bst.displayPostOrder();
        
        System.out.println();

        // Search for specific values
        searchAndDisplay(bst, 200);
        searchAndDisplay(bst, 11);
        searchAndDisplay(bst, 38);
        searchAndDisplay(bst, 95);
    }

    private static void searchAndDisplay(BinaryTree<Integer> bst, Integer value) {
        boolean found = bst.search(value);
        System.out.println("Searching for " + value + ": " + (found ? "found" : "NOT found"));
    }
}
