package BST;

public class AVLNode {

    private int data;
    private AVLNode left;
    private AVLNode right;

    public AVLNode(int data) {

        this.data = data;
        left = null;
        right = null;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setLeft(AVLNode left) {
        this.left = left;
    }

    public AVLNode getLeft() {
        return left;
    }

    public void setRight(AVLNode right) {
        this.right = right;
    }

    public AVLNode getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "[" + data + "] ";
    }
}
