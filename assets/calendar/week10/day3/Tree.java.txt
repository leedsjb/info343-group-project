import java.io.*;
/**
 * A class that represents a tree structure where each node
 * has a pointer to its parent, a pointer to its first child and
 * a pointer to its right sibling.
 */

public class Tree {

    // Node in the tree
    public class Node {
        private Node parent;
        private Node firstChild;
        private Node rightSibling;
        private Object item;

        /**
         * Constructs a tree node that contains the given item and that has
         * the given parent
         *
         * @param item the object to store in the tree node
         * @param parent the tree node which is the parent of this tree node
         */
        public Node (Object item, Node parent) {
            this.item = item;
            this.parent = parent;
        }

        /**
         * Returns the content of this tree node as a string
         *
         * @return the content of this tree node as a string
         */
        public String toString() {
            return "" + this.item;
        }
    }

    private Node root;

    /**
     * Constructs an empty tree
     */
    public Tree() {
    }

    /**
     * Add an item to the tree. The tree node which is created for the item
     * is a child of the given tree node
     *
     * @param item the object to store in the tree
     * @param parent the parent of the tree node that is created to contain
     * the item. parent is null if the item is added at the root level.
     * @returns the tree node that contains the item
     */
    public Node add(Object item, Node parent) {
        if (parent == null) {
            this.root = new Node(item, null);
            return this.root;
        }
        else {
            Node n = new Node(item, parent);
            // Add this node to the right of the existing siblings
            Node leftSibling = parent.firstChild;
            if (leftSibling == null) {
                parent.firstChild = n;
            }
            else {
                while (leftSibling.rightSibling != null) {
                    leftSibling = leftSibling.rightSibling;
                }
                leftSibling.rightSibling = n;
            }
            return n;
        }
    }

    /**
     * Counts the number of nodes in this tree
     *
     * @return the number of nodes in this tree
     */
    public int countNodes() {
        return this.countNodes(this.root);
    }

    /**
     * Counts the number of nodes in the tree rooted at the given tree node
     *
     * @param root the root of the tree whose nodes are counted
     * @returns the number of nodes in the tree rooted at the given tree node
     */
    private int countNodes(Node root) {
        // Base case
        if (root == null) {
            return 0;
        }
        else {
            int count = 1;
            Node child = root.firstChild;
            while(child != null) {
                count += countNodes(child);
                child = child.rightSibling;
            }
            return count;
        }
    }

    /**
     * Returns the sibling on the right of and at the same level as the given
     * tree node
     * The complexity of the method is O(n)
     *
     * @param n the given tree node
     * @returns the sibling on the right of and at the same level as the given
     * tree node
     */
    private Node getNextLevelSibling(Node n) {
        // Base cases
        if (n == null) {
            return null;
        }
        else if (n.rightSibling != null) {
            return n.rightSibling;
        }
        else { // the next right sibling is a cousin
            Node parentRightSibling = n.parent;
            do {
                parentRightSibling = this.
                                        getNextLevelSibling(parentRightSibling);
            }
            while (parentRightSibling != null &&
                   parentRightSibling.firstChild == null);

            if (parentRightSibling == null) {
                return null;
            }
            else {
                return parentRightSibling.firstChild;
            }
        }
    }

    /**
     * Returns the node in this tree
     * that contains the given item, or null if the item is not in this tree
     *
     * @param item the object to look for
     * @returns the tree node that contains item, or null if item is not
     * in the tree
     */
    public Node findNode(Object item) {
        return this.findNode(item, this.root);
    }

    /**
     * Returns the node in the tree rooted at the given node and
     * that contains the given item, or null if the item is not in the tree
     *
     * @param root the root of the tree
     * @param item the object to look for
     * @returns the tree node that contains item, or null if item is not
     * in the tree
     */
    private Node findNode(Object item, Node root) {
        // Base cases
        if (root == null) { // no tree at the root
            return null;
        }
        else if (root.item.equals(item)) { // found the item
            return root;
        }
        else { // check the subtrees rooted at the children
            Node n = null;
            Node child = root.firstChild;

            while (child != null && n == null) {
                n = this.findNode(item, child);
                child = child.rightSibling;
            }

            return n;
        }
    }

    /**
     * Test the class
     */
    public static void main(String[] args) {
        // An example of a tree
        Tree t = new Tree();
        Node a = t.add("a", null);
        Node b = t.add("b", a);
        Node c = t.add("c", a);
        Node d = t.add("d", a);
        Node e = t.add("e", b);
        Node f = t.add("f", b);
        Node g = t.add("g", c);
        Node h = t.add("h", d);
        Node i = t.add("i", d);
        Node j = t.add("j", d);
        Node k = t.add("k", f);
        Node l = t.add("l", i);

        System.out.println(t.countNodes());

        // Test getNextLevelSibling
        BufferedReader reader =
                           new BufferedReader(new InputStreamReader(System.in));
        String inputMessage = "Enter a letter (just type enter to stop): ";
        String s;
        System.out.print(inputMessage);
        try {
            while ( !(s = reader.readLine().trim()).equals("") ) {
                Node n = t.findNode(s);
                if (n == null) {
                    System.out.println(s + " is not in the tree");
                }
                else {
                    Node rs = t.getNextLevelSibling(n);
                    if (rs == null) {
                        System.out.println("No node to the right of " + n);
                    }
                    else {
                        System.out.println(
                                        "To the right of " + n + " is " + rs);
                    }
                }
                System.out.print(inputMessage);
            }
        }
        catch(IOException ioe) {
            throw new RuntimeException();
        }
    }
}






