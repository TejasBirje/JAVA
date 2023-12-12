package DataStructures.BST;

public class BSTNode {

    BSTNode left, right;
    int data;

    /* Constructor */

    public BSTNode() {
        left = null;
        right = null;
        data = 0;
    }

    /* Constructor */

    public BSTNode(int n) {
        left = null;
        right = null;
        data = n;
    }

    /* Function to set left node */

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    /* Function to set right node */

    public void setRight(BSTNode right) {
        this.right = right;
    }

    /* Function to get left node */

    public BSTNode getLeft() {
        return left;
    }

    /* Function to get right node */

    public BSTNode getRight() {
        return right;
    }

    /* Function to set data to node */

    public void setData(int data) {
        this.data = data;
    }

    /* Function to get data from node */

    public int getData() {
        return data;
    }
}
