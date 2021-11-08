package LinkedListImplementation;

public class BinaryTree {

    public BinaryTree() {
        System.out.println("Tree planted.");
    }

    public void preOrder(TNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root);

        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    public void inOrder(TNode root) {
        if(root == null) {
            return;
        }

        inOrder(root.getLeft());
        System.out.print(root);
        inOrder(root.getRight());
    }

    private void postOrder(TNode root) {
        System.out.println("postOrder");
    }
}
