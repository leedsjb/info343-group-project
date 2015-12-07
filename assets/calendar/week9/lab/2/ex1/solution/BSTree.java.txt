import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * Definition of the binary search tree class, BSTree
 * Integers are stored in the nodes of the tree
 */

public class BSTree implements Cloneable
{
    /** Representation of a binary tree node (via an inner class)*/
    private class BTreeNode
    {
        int data;
        BTreeNode left;
        BTreeNode right;
        // Position of the node in the tree
        // (0,0) is the root of the tree
        // (the left child of the root is at (w=-1,h=1))
        // useful for the graphics representation
        int w;
        int h;
    }

    /** Root of the tree */
    private BTreeNode root;

    /** current height and width of the tree */
    private int treeHeight;
    private int treeWidth;

    /** Is the tree window open? */
    private boolean treeWindowVisible;


    /** Graphics elements for the display of the tree */
    private class TreeWindow extends JPanel
    {
        // The frame that contains the display of the tree
        JFrame f = new JFrame("Binary tree");

        // Units along x and y for the display
        int unitWidth;
        int unitHeight;

        /**
        * Construct a TreeWindow
        */
        public TreeWindow()
        {
            setBackground(Color.white);
            f.setContentPane(this);
            f.addWindowListener(new WindowAdapter()
            {
                public void windowClosing(WindowEvent we)
                {
                    treeWindowVisible=false;
                }
            });
        }

        /**
        * Show the window
        */
        public void makeVisible()
        {
            f.setSize(400,300);
            f.setLocation(100,100);
            f.show();
        }

        /**
        * Draw the tree
        */
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            // Set the coordinate system
            int width = getWidth();
            int height = getHeight();
            unitWidth = width/(treeWidth+2); //one extra space on the left and right sides
            unitHeight = height/(treeHeight+2); //one extra space at the top and bottom
            if (unitWidth==0) unitWidth=1;
            if (unitHeight==0) unitHeight=1;

            Graphics2D g2D = (Graphics2D)g;
            // Work in the tree coordinate system: (0,0) is at the root
            g2D.translate((-minW(root)+1)*unitWidth,unitHeight);
            g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);

            // Start drawing the tree
            if (root!=null) drawTree(root,g2D);
        }

        // draw the tree rooted at root
        public void drawTree(BTreeNode root, Graphics2D g2D)
        {
            // Display this node
            g2D.fillOval(root.w*unitWidth-2,root.h*unitHeight-2,4,4);
            g2D.setColor(Color.red);
            g2D.drawString(""+root.data,root.w*unitWidth,root.h*unitHeight);
            g2D.setColor(Color.black);

            // draw the links to the children
            if (root.left!=null)
            {
                g2D.drawLine(root.w*unitWidth,root.h*unitHeight,
                              root.left.w*unitWidth,root.left.h*unitHeight);
                // draw the left part of the tree
                drawTree(root.left,g2D);
            }
            if (root.right!=null)
            {
                g2D.drawLine(root.w*unitWidth,root.h*unitHeight,
                             root.right.w*unitWidth,root.right.h*unitHeight);
                // draw the right part of the tree
                drawTree(root.right,g2D);
            }
        }
    }

    // A MouseListener class to allow the user to delete a node in the tree
    // with a mouse click.
    private class TreeMouseListener extends MouseAdapter
    {
        public void mousePressed(MouseEvent e)
        {
            // Click coordinates
            int x=e.getX();
            int y=e.getY();
            // Are we next to a node?
            int w=(int)((double)x/treeWindow.unitWidth+0.5);
            int h=(int)((double)y/treeWindow.unitHeight+0.5);
            // Work with the coordinate system of the tree
            w-=-minW(root)+1;
            h--;
            // Any node to remove at this location
            removeNodeAt(root,w,h);
        }

        public void removeNodeAt(BTreeNode root,int w,int h)
        {
            if (root==null) return;
            if (root.w==w && root.h==h)
                remove(root.data);
            else
            {
                removeNodeAt(root.left,w,h);
                removeNodeAt(root.right,w,h);
            }
        }
    }

    private TreeWindow treeWindow;
    private TreeMouseListener mouseListener;

    // Constructor
    public BSTree()
    {
        // Create the graphics window
        treeWindow = new TreeWindow();
        // A mouseListener to allow the user to delete nodes in the tree
        mouseListener = new TreeMouseListener();
        treeWindow.addMouseListener(mouseListener);
        // Show the tree
        display();
    }

    // Number of nodes in this Tree
    public int size()
    {
        return countNodes(root);
    }

    // Height of this Tree
    public int height()
    {
        // The height of a tree is the maximum depth of its leaves
        // For an empty tree the height is -1
        return computeHeight(root);
    }

    public boolean find(int data)
    {
        // Is data an element of the tree?
        return findData(data,root);
    }

    // insert an item in the tree
    public void insert(int data)
    {
        // Nothing to do if data is already in the tree
        // (this call is done so that w and h can be updated as
        // the tree is traversed when inserting the data item)
        if (find(data)) return;

        // Add data to the tree (root is located at (0,0))
        root = insertData(data,root,0,0);

        // Display the new tree
        display();
    }

    // remove an item from the tree
    public void remove(int data)
    {
        // Nothing to do if data is not in the tree
        // (this call is done so that w and h can be updated as
        // the tree is traversed when inserting the data item)
        if (!find(data)) return;

        // Delete the node containing data
        root = delItem(data,root);

        // Display the new tree
        display();
    }

    // Printing
    //
    // pre order
    public void printPreOrder(PrintStream out)
    {
        printPrO(out,root);
    }
    //
    // in order
    public void printInOrder(PrintStream out)
    {
        printIO(out,root);
    }

    // post order
    public void printPostOrder(PrintStream out)
    {
        printPoO(out,root);
    }

    // breadth first
    public void printBreadthFirst(PrintStream out)
    {
        // A linked list works well for a queue
        LinkedList queue = new LinkedList();
        // Start at the root: enqueue the root node
        if (root!=null) queue.add(root);
        while(!queue.isEmpty()){
            // dequeue the node at the front of the queue
            // and print it
            BTreeNode n = (BTreeNode)queue.remove(0);
            out.print(n.data+" ");
            // enqueue the children of that node (if any)
            if (n.left!=null) queue.add(n.left);
            if (n.right!=null) queue.add(n.right);
        }
    }

    // Make a copy of this tree
    public Object clone()
    {
        BSTree t = new BSTree();
        t.root = copy(root);
        t.display();
        return t;
    }


    // Private methods

    // Display the tree in a graphics window
    private void display()
    {
        // the commented code copies the tree. Then, it computes w and h for
        // the copy and checks that the two trees have the same w and h for
        // all of the nodes (kept just for reference)
//      // copy the current tree
//      BTreeNode rootCopy = new BTreeNode();
//      rootCopy = copy(root);
//
//      // recompute w and h in the copy
//      if (rootCopy!=null)
//      {
//          rootCopy.h=rootCopy.w=0;
//          setHeightAndWidth(rootCopy);
//      }
//
//      // compare the two trees
//      if (!sameTree(root,rootCopy))
//          System.out.println("No error");

        // current height and width of the tree
        treeHeight = computeHeight(root);
        treeWidth = maxW(root)-minW(root);

        // Display the window (if not already shown)
        if (!treeWindowVisible)
        {
            treeWindow.makeVisible();
            treeWindowVisible=true;
        }

        // draw the tree
        treeWindow.repaint();
    }

    // check that the two trees rooted at root and rootCopy are the same
    // (i.e., same w, h and data for each node)
    private boolean sameTree(BTreeNode root, BTreeNode rootCopy)
    {
        boolean isEqual=false;
        if (root==null && rootCopy==null)
            isEqual=true;
        else if(root.w!=rootCopy.w || root.h!=rootCopy.h || root.data!=rootCopy.data)
            isEqual=false;
        else
            isEqual=sameTree(root.right,rootCopy.right)&&sameTree(root.left,rootCopy.left);

        return isEqual;
    }

    // Count the number of nodes in the tree (use recursion)
    private int countNodes(BTreeNode root)
    {
        if (root==null)
            return 0;
        else
            return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // Compute the height of the tree starting at root (use recursion)
    private int computeHeight(BTreeNode root)
    {
        // The height of a tree is the
        // maximum depth of its leaves
        // An empty tree has a height of -1
        if (root==null)
            return -1;
        else
        {
            int leftH = computeHeight(root.left);
            int rightH = computeHeight(root.right);
            if (leftH>rightH)
                return 1 + leftH;
            else
                return 1 + rightH;
        }
    }

    // Is data in the tree started at root? (use recursion)
    private boolean findData(int data,BTreeNode root)
    {
        // Is data in the tree?
        if (root==null)
            return false;
        else if (root.data==data)
            return true;
        else if (root.data>data)
            return findData(data,root.left);
        else
            return findData(data,root.right);
    }

    // Insert data in the tree rooted at root (root is at location (w,h))
    // Precondition: data is not in the tree
    private BTreeNode insertData(int data, BTreeNode root, int w, int h)
    {
        if (root==null)
        {
            // create a new node
            root = new BTreeNode();
            root.data = data;
            root.w = w;
            root.h = h;
        }
        else if (data>root.data)
        {
            // data goes in the right subtree
            // If data goes in the left subtree of root.right,
            // make room for it on the display (update root.right.w and all the descendants))
            if (root.right!=null && data<root.right.data) wPlusOne(root.right);
            // Insert in the right subtree
            root.right = insertData(data,root.right,root.w+1,root.h+1);
        }
        else if (data<root.data)
        {
            // data goes in the right subtree
            // If data goes in the right subtree of root.left,
            // make room for it on the display (update root.left.w and all the descendants)
            if (root.left!=null && data>root.left.data) wMinusOne(root.left);
            // Insert in the left subTree
            root.left = insertData(data,root.left,root.w-1,root.h+1);
        }

        return root;
    }

    // Add one to w for all of the nodes in the tree rooted at root
    private void wPlusOne(BTreeNode root)
    {
        if (root==null) return;
        root.w++;
        wPlusOne(root.right);
        wPlusOne(root.left);
    }

    // Subtract one from w for all of the nodes in the tree rooted at root
    private void wMinusOne(BTreeNode root)
    {
        if (root==null) return;
        root.w--;
        wMinusOne(root.right);
        wMinusOne(root.left);
    }

    // Subtract one from h for all of the nodes in the tree rooted at root
    private void hMinusOne(BTreeNode root)
    {
        if (root==null) return;
        root.h--;
        hMinusOne(root.right);
        hMinusOne(root.left);
    }

    // print in pre order (use recursion)
    private void printPrO(PrintStream out, BTreeNode root)
    {
        // Anything to print?
        if (root==null) return;

        // print the node first
        out.print(root.data+" ");

        // print the children
        printPrO(out,root.left);
        printPrO(out,root.right);
    }

    // print in order (use recursion)
    private void printIO(PrintStream out, BTreeNode root)
    {
        // Anything to print?
        if (root==null) return;

        // print the left child
        printIO(out,root.left);

        // print the node
        out.print(root.data+" ");

        // print the right child
        printIO(out,root.right);
    }

    // print in post order (use recursion)
    private void printPoO(PrintStream out, BTreeNode root)
    {
        // Anything to print?
        if (root==null) return;

        // print the left and right children
        printPoO(out,root.left);
        printPoO(out,root.right);

        // print the node
        out.print(root.data+" ");
    }

    // remove the node containing data (if it is part of the tree)
    // return the new root of the tree
    // (use recursion and the other methods delNode and findMin)
    // Precondition: data is in the tree
    private BTreeNode delItem(int data, BTreeNode root)
    {
        // If the tree is not empty
        if (root != null)
        {
            // If this is the node to delete, delete it
            // by calling delNode
            if (data == root.data)
            {
                // If this is the absolute root of the tree, we need a special treatment
                if (root.w==0 && root.h==0)
                {
                    if (root.right!=null && root.left!=null)
                        wMinusOne(root.right);
                    else if (root.left!=null)
                        while(root.left.w!=0) wPlusOne(root.left);
                    else if (root.right!=null)
                    while(root.right.w!=0) wMinusOne(root.right);
                }
                root = delNode(root);
            }
            // Could the node to delete be among the right descendants?
            else if (data > root.data)
            {
                // if data is in the left subtree of root.right, update w for the
                // display (one less node to display)
                if (root.right!=null && root.right.data>data) wMinusOne(root.right);

                // if data is equal to root.right.data
                if (root.right!=null && root.right.data==data && root.right.right!=null)
                    wMinusOne(root.right.right);

                root.right=delItem(data,root.right);
            }
            // Or among the left descendants?
            else
            {
                // if data is in the right subtree of root.left, update w for the
                // display (one less node to display)
                if (root.left!=null && root.left.data<data) wPlusOne(root.left);

                // if data is equal to root.left.data
                if (root.left!=null && root.left.data==data && root.left.left!=null)
                {
                    wPlusOne(root.left.left);
                    if (root.left.right!=null) root.left.w++;
                }
                root.left = delItem(data,root.left);
            }
        }
        return root;
    }

    // Delete the node in root and return the root
    // of the modified tree
    private BTreeNode delNode(BTreeNode root)
    {
        // How many children does root have?
        if (root.left!=null && root.right!=null)
        {	// 2 children
            // find the min right descendant: This is the new data
            // for root (use findMin)
            root.data = findMin(root.right);
            // Delete among the right descendants the node that contains
            // root->data (call delItem)
            root.right = delItem(root.data, root.right);
            return root;
        }
        else
        {
            // 0 or 1 child: bypass the node and return
            // as the new root the child node
            BTreeNode newRoot = null;
            if (root.left!=null)
                // left child only
                newRoot = root.left;
            else if (root.right!=null)
                // right child only
                newRoot = root.right;

            // move up the new root and all of its descendants
            hMinusOne(newRoot);

            // return the new root
            return newRoot;
        }
    }

    // Find the leftmost descendant (smallest value in the tree)
    // and return its data value
    private int findMin(BTreeNode root)
    {
        while (root.left != null)
            root = root.left;

        return root.data;
    }

    // Make a copy of this tree starting at root (use recursion)
    private BTreeNode copy(BTreeNode root)
    {
        // root of the copy tree
        BTreeNode rootCopy=null;

        if (root!=null)
        {
            rootCopy = new BTreeNode();
            rootCopy.data = root.data;
            rootCopy.h = root.h;
            rootCopy.w = root.w;
            rootCopy.left = copy(root.left);
            rootCopy.right = copy(root.right);
        }

        return rootCopy;
    }

    // max w in the tree rooted at root
    private int maxW(BTreeNode root)
    {
        if (root==null) return 0;
        BTreeNode p = root;
        while(p.right!=null) p=p.right;
        return p.w;
    }

    // min w in the tree rooted at root
    private int minW(BTreeNode root)
    {
        if (root==null) return 0;
        BTreeNode p = root;
        while(p.left!=null) p=p.left;
        return p.w;
    }

    // Set the height and width of every node in the tree
    // (not used in this program. More expensive than the method used
    // but easier to implement. Just call setHeightAndWidth whenever
    // the tree changes (after an insert or a remove))
    private void setHeightAndWidth(BTreeNode root)
    {
        // Nothing to do if there is no tree
        if (root==null) return;

        // left child
        if (root.left!=null)
        {
            root.left.w = root.w-1-countNodes(root.left.right);
            root.left.h = root.h+1;
            setHeightAndWidth(root.left);
        }
        // right child
        if (root.right!=null)
        {
            root.right.w = root.w+1+countNodes(root.right.left);
            root.right.h = root.h+1;
            setHeightAndWidth(root.right);
        }
    }
}