/**
 * Definition of the binary search tree class, BSTree
 */

import java.io.*;

public class BSTree<E extends Comparable<E>> implements Cloneable {
	/** Representation of a binary tree node */
	private class BTreeNode {
		E item;
		BTreeNode left;
		BTreeNode right;

		/**
		 * Construct a new binary tree node
		 *
		 * @param left
		 *            the left child of this tree node
		 * @param right
		 *            the right child of this tree node
		 * @param item
		 *            the object in this tree node
		 */
		public BTreeNode(BTreeNode left, BTreeNode right, E item) {
			this.item = item;
			this.left = left;
			this.right = right;
		}
	}

	// Root of the tree
	private BTreeNode root;

	// All public methods are complete
	// -------------------------------

	/**
	 * Gets the number of nodes of this tree
	 *
	 * @return the number of nodes in this tree
	 */
	public int size() {
		return this.countNodes(this.root);
	}

	/**
	 * Gets the height of this tree. An empty tree has a height of 0.
	 *
	 * @return the height of this tree
	 */
	public int height() {
		// The height of a tree is the maximum level of its leaves
		// For an empty tree the height is 0
		return this.subTreeHeight(this.root);
	}

	/**
	 * Is the given object in this tree?
	 *
	 * @param item
	 *            the object to find in the tree
	 * @return true if the given object is in this tree, false otherwise
	 * @throws ClassCastException
	 *             if the given object can't be compared to the objects already
	 *             in the tree
	 */
	public boolean contains(E item) {
		return this.subtreeContains(item, this.root);
	}

	/**
	 * adds a given object to this tree
	 *
	 * @param item
	 *            the object to add to this tree
	 * @return true if the given object has been added to this tree, false
	 *         otherwise
	 * @throws ClassCastException
	 *             if the given object can't be compared to the objects already
	 *             in this tree
	 */
	public boolean add(E item) {
		if (!this.contains(item)) {
			this.root = this.addToSubtree(item, this.root);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * removes a given object from this tree
	 *
	 * @param item
	 *            the object to remove
	 * @return true if the given object has been removed, false otherwise
	 * @throws ClassCastException
	 *             if the given object can't be compared to the objects already
	 *             in this tree
	 */
	public boolean remove(E item) {
		if (this.contains(item)) {
			this.root = this.removeFromSubtree(item, this.root);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Prints in pre order the nodes of this tree
	 *
	 * @param out
	 *            the PrintStream to print to
	 */
	public void printPreOrder(PrintStream out) {
		this.printSubtreePreOrder(out, this.root);
	}

	/**
	 * Prints in order the nodes of this tree
	 *
	 * @param out
	 *            the PrintStream to print to
	 */
	public void printInOrder(PrintStream out) {
		this.printSubtreeInOrder(out, this.root);
	}

	/**
	 * Prints in post order the nodes of this tree
	 *
	 * @param out
	 *            the PrintStream to print to
	 */
	public void printPostOrder(PrintStream out) {
		this.printSubtreePostOrder(out, this.root);
	}

	/**
	 * Makes a copy of this tree
	 *
	 * @return a copy of this tree
	 */
	public Object clone() {
		BSTree copyTree = null;
		try {
			copyTree = (BSTree) super.clone();
			copyTree.root = this.cloneSubtree(this.root);
		} catch (CloneNotSupportedException cnse) {
			// Never happens since this tree is cloneable
		}
		return copyTree;
	}

	// Private methods
	// ---------------

	/**
	 * Gets the number of nodes of a subtree
	 *
	 * @param root
	 *            the root of the subtree
	 * @return the number of nodes in the subtree rooted at root
	 */
	private int countNodes(BTreeNode root) {
		if (root == null) {
			return 0;
		} else {
			return 1 + countNodes(root.left) + countNodes(root.right);
		}
	}

	/**
	 * Gets the height of a subtree rooted at a given root. An empty tree has a
	 * height equal to 0.
	 *
	 * @param root
	 *            the root of the subtree
	 * @return the height of the subtree rooted at root
	 */
	private int subTreeHeight(BTreeNode root) {
		if (root == null) {
			return 0;
		} else {
			return 1 + Math.max(subTreeHeight(root.left),
					subTreeHeight(root.right));
		}
	}

	/**
	 * Is the given object in a subtree rooted at a given root?
	 *
	 * @param item
	 *            the object to find in the tree
	 * @param root
	 *            the root of the subtree
	 * @return true if the given object is in this tree, false otherwise
	 * @throws ClassCastException
	 *             if the given object can't be compared to the objects already
	 *             in the subtree
	 */
	private boolean subtreeContains(E item, BTreeNode root) {
		if (root == null) { // empty
			return false;
		} else {
			int cmp = item.compareTo(root.item);
			if (cmp == 0) { // found it
				return true;
			} else if (cmp < 0) { // less than -> go left
				return subtreeContains(item, root.left);
			} else { // greater than -> go right
				return subtreeContains(item, root.right);
			}
		}
	}

	/**
	 * adds a given object to a subtree rooted at a given root
	 *
	 * @param item
	 *            the object to add to the subtree
	 * @return the new root of the subtree
	 * @throws ClassCastException
	 *             if the given object can't be compared to the objects already
	 *             in the subtree
	 */
	private BTreeNode addToSubtree(Object item, BTreeNode root) {
		if (root == null) {
			// create a new node
		} else {
			int cmp = ((Comparable) root.item).compareTo(item);
			if (cmp < 0) {
				// Insert in the right subtree
			} else if (cmp > 0) {
				// Insert in the left subTree
			}
		}

		return root;
	}

	/**
	 * Prints in pre order the nodes of a subtree rooted at a given root
	 *
	 * @param out
	 *            the PrintStream to print to
	 * @param root
	 *            the root of the subtree
	 */
	private void printSubtreePreOrder(PrintStream out, BTreeNode root) {
		// Anything to print?

		// print the node first

		// print the children
	}

	/**
	 * Prints in order the nodes of a subtree rooted at a given root
	 *
	 * @param out
	 *            the PrintStream to print to
	 * @param root
	 *            the root of the subtree
	 */
	private void printSubtreeInOrder(PrintStream out, BTreeNode root) {
		// Anything to print?

		// print the left child

		// print the node

		// print the right child

	}

	/**
	 * Prints in post order the nodes of a subtree rooted at a given root
	 *
	 * @param out
	 *            the PrintStream to print to
	 * @param root
	 *            the root of the subtree
	 */
	private void printSubtreePostOrder(PrintStream out, BTreeNode root) {
		// Anything to print?

		// print the left and right children

		// print the node

	}

	/**
	 * removes a given object from a subtree at a given root
	 *
	 * @param item
	 *            the object to remove
	 * @param root
	 *            the root of the subtree
	 * @return the new root of the subtree
	 * @throws ClassCastException
	 *             if the given object can't be compared to the objects already
	 *             in the subtree
	 * @throws NullPointerException
	 *             if the root is null (empty subtree)
	 */
	private BTreeNode removeFromSubtree(Object item, BTreeNode root) {
		int cmp = ((Comparable) root.item).compareTo(item);
		if (cmp == 0) {
			// This is the node to delete, delete it
			// by calling deleteRootInSubtree
		}
		// Is the node to delete be among the right descendants?
		else if (cmp < 0) {
		}
		// Or among the left descendants?
		else if (cmp > 0) {
		}

		return root;
	}

	/**
	 * Deletes the given root of a subtree and returns the new root of modified
	 * subtree
	 *
	 * @param root
	 *            the given root of the subtree
	 * @return the new root of the subtree
	 * @throws NullPointerException
	 *             if the root of the subtree is null
	 */
	private BTreeNode deleteRootInSubtree(BTreeNode root) {
		// How many children does root have?
		if (root.left != null && root.right != null) {
			// 2 children
			// find the min right descendant: This is the new item
			// for root (use findMin)

			// Delete among the right descendants the node that contains
			// root.item (call removeFromSubtree)

			return root;
		} else {
			// 0 or 1 child: bypass the node and return
			// as the new root the child node
			BTreeNode newRoot = null;
			if (root.left != null) {
				// left child only
			} else if (root.right != null) {
				// right child only
			}

			// return the new root
			return newRoot;
		}
	}

	/**
	 * Finds the leftmost descendant in a given subtree and returns its item
	 * (the leftmost descendant is the node with the smallest item)
	 *
	 * @param root
	 *            the root of the subtree
	 * @returns the item in the leftmost descendant of the subtree
	 */
	private Object findMin(BTreeNode root) {
		return null; // change this
	}

	/**
	 * Makes a copy of the subtree rooted at root
	 *
	 * @param root
	 *            the root of the subtree
	 * @returns the root of the copy
	 */
	private BTreeNode cloneSubtree(BTreeNode root) {
		// root of the copy tree
		BTreeNode rootCopy = null;

		// Make a copy of the tree node if there is anything to copy
		if (root != null) {

			// proceed with the left and right children

		}

		return rootCopy;
	}
}