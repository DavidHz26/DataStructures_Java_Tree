package BST;

public class BSTNode {

    private int data;
    private BSTNode left;
    private BSTNode right;

    public BSTNode(int data) {

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

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public BSTNode getLeft() {
        return left;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }

    public BSTNode getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "[" + data + "] ";
    }
}
