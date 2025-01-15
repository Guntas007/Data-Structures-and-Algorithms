package binarySearchTree;

import java.util.Comparator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BinaryTree<T> {
    private BinaryTreeNode<T> root;
    private Comparator<T> comparator;

    public BinaryTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void insertInTree(T data) {
        if (root == null) {
            root = new BinaryTreeNode<>(data, comparator);
        } else {
            root.insert(data);
        }
    }

    public void displayInOrder() {
        displayInOrder(root);
    }

    private void displayInOrder(BinaryTreeNode<T> node) {
        if (node != null) {
            displayInOrder(node.getLeft());
            System.out.print(node.getData() + " ");
            displayInOrder(node.getRight());
        }
    }

    public void displayPreOrder() {
        displayPreOrder(root);
    }

    private void displayPreOrder(BinaryTreeNode<T> node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            displayPreOrder(node.getLeft());
            displayPreOrder(node.getRight());
        }
    }

    public void displayPostOrder() {
        displayPostOrder(root);
    }

    private void displayPostOrder(BinaryTreeNode<T> node) {
        if (node != null) {
            displayPostOrder(node.getLeft());
            displayPostOrder(node.getRight());
            System.out.print(node.getData() + " ");
        }
    }

    public boolean search(T data) {
        return search(root, data);
    }

    private boolean search(BinaryTreeNode<T> node, T data) {
        if (node == null) {
            return false;
        }

        int compare = node.compareData(data);
        if (compare == 0) {
            return true;
        } else if (compare > 0) {
            return search(node.getLeft(), data);
        } else {
            return search(node.getRight(), data);
        }
    }

    public void readValuesFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                T value = parseValue(line);
                insertInTree(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Adjust the parsing logic based on the specific generic type
    @SuppressWarnings("unchecked")
    private T parseValue(String line) {
        if (line.matches("-?\\d+")) { // For integers
            return (T) (Integer.valueOf(line));
        } else { // For strings or other types
            return (T) line;
        }
    }
}
