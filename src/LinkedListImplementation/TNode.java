package LinkedListImplementation;

public class TNode {

    private int data;
    private TNode right;
    private TNode left;

    public TNode(int data) {
        this.data = data;
        right = null;
        left = null;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setRight(TNode node) {
        right = node;
    }

    public void setLeft(TNode node) {
        left = node;
    }

    public TNode getRight() {
        return right;
    }

    public TNode getLeft() {
        return left;
    }

    @Override
    public String toString() {
        return "[" + data + "] ";
    }
}
