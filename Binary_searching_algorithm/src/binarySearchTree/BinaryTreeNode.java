package binarySearchTree;

import java.util.Comparator;

/**
 * CET - CS Academic Level 3
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD. 
 * @author Algonquin College
 * @author George Kriger
 *
 */

class BinaryTreeNode <T> {			//pkg visibility is minimum required. But use of public is acceptable - GJK
    private T data;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;
    private Comparator<T> comparator;
    
	/**
	 * Construct new tree node using these contents
	 * @param data contents of node
	 * @param comparator generic method which determines < >  and =
	 */
    public BinaryTreeNode(T data, Comparator<T> comparator) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.comparator = comparator;
    }

	/**
	 * retrieve the contents of the node
	 * @return contents of node
	 */
	public T getData() {
		return data;
	}

	/**
	 * retrieve the reference to the left hand subtree
	 * @return reference to left subtree
	 */
	public BinaryTreeNode getLeft() {
		return left;
	}

	/**
	 * retrieve the reference to the right hand subtree
	 * @return reference to right subtree
	 */
	public BinaryTreeNode getRight() {
		return right;
	}

    // Compare method using the comparator
    public int compareData(T data2) {
        return comparator.compare(data, data2);
    }

	/**
	 * create new node and insert it in the proper location 
	 * using BST logic
	 * @param newData contents of node which will be inserted
	 */
	public void insert(T newData) {
		if (comparator.compare(newData, data)< 0) {
			if (left == null)
				left = new BinaryTreeNode<T>(newData, comparator);
			else
				left.insert(newData);
		} else if (comparator.compare(newData, data)> 0) {
			if (right == null)
				right = new BinaryTreeNode<T>(newData, comparator);
			else
				right.insert(newData);
		} else
			System.out.println("Duplicate not adding " + newData);
	}//insert


}// class
