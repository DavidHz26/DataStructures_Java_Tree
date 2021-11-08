package LinkedListImplementation;

import java.util.LinkedList;
import java.util.Queue;

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

    public void postOrder(TNode root) {
        if(root == null) {
            return;
        }

        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root);
    }

    public void levelOrder(TNode root) {
        if(root == null) {
            return;
        }

        Queue<TNode> list = new LinkedList<TNode>();
        list.add(root);

        while(!list.isEmpty()) {

            if(list.peek().getLeft() != null) {
                list.add(list.peek().getLeft());
            }

            if(list.peek().getRight() != null) {
                list.add(list.peek().getRight());
            }

            System.out.print(list.peek());
            list.remove(list.peek());
        }
    }
}
