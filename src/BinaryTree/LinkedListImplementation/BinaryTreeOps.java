package BinaryTree.LinkedListImplementation;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeOps {

    public BinaryTreeOps() {
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

        Queue<TNode> queue = new LinkedList<TNode>();
        queue.add(root);

        while(!queue.isEmpty()) {

            if(queue.peek().getLeft() != null) {
                queue.add(queue.peek().getLeft());
            }

            if(queue.peek().getRight() != null) {
                queue.add(queue.peek().getRight());
            }

            System.out.print(queue.peek());
            queue.remove(queue.peek());
        }
    }

    public void searchData(TNode root, int data) {
        System.out.println("Searching for " + data + "...");

        if(root == null) {
            return;
        }

        Queue<TNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {

            if(queue.peek().getLeft() != null) {
                queue.add(queue.peek().getLeft());
            }

            if(queue.peek().getRight() != null) {
                queue.add(queue.peek().getRight());
            }

            if(queue.peek().getData() == data) {
                System.out.println("\n" + data + " found!");
                return;
            }

            System.out.print(queue.peek());
            queue.remove(queue.peek());
        }

        System.out.println(data + " not found!");

    }

    public void insertData(TNode root, int data){
        System.out.println("Inserting new node " + data + "...");
        if(root == null) {
            return;
        }

        Queue<TNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {

            if(queue.peek().getLeft() != null) {
                queue.add(queue.peek().getLeft());
            } else {
                queue.peek().setLeft(new TNode(data));
                System.out.println(data + " added as left child of " + queue.peek());
                return;
            }

            if(queue.peek().getRight() != null) {
                queue.add(queue.peek().getRight());
            } else {
                queue.peek().setRight(new TNode(data));
                System.out.println("\n" + data + " added as right child of " + queue.peek());
                return;
            }

            System.out.print(queue.peek());
            queue.remove(queue.peek());
        }
    }

    public void deleteData(TNode root, int data){
        System.out.println("Deleting node " + data + "...");

        if(root == null) {
            return;
        }

        Queue<TNode> queue = new LinkedList<>();
        queue.add(root);
        TNode nodeToDelete = null;
        TNode lastNode = null;

        while(!queue.isEmpty()) {
            if(queue.peek().getLeft() != null) {
                queue.add(queue.peek().getLeft());
            }

            if(queue.peek().getRight() != null) {
                queue.add(queue.peek().getRight());
            }

            if(queue.peek().getData() == data) {
               nodeToDelete = queue.peek();
            }

            System.out.print(queue.peek());
            lastNode = queue.peek();
            queue.remove(queue.peek());

            if(queue.isEmpty()) {
                System.out.println("\nNode to Delete: " + nodeToDelete + ", replacement: " + lastNode);
                updateLastNode(root, nodeToDelete, lastNode);
                System.out.println(data + " deleted");
            }
        }

    }

    private void updateLastNode(TNode root, TNode toDelete, TNode lastNode) {
        Queue<TNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            if(queue.peek().getLeft() != null) {
                queue.add(queue.peek().getLeft());
            }

            if(queue.peek().getLeft() == lastNode) {
                queue.peek().setLeft(null);
            }

            if(queue.peek().getRight() != null) {
                queue.add(queue.peek().getRight());
            }

            if(queue.peek().getRight() == lastNode) {
                queue.peek().setRight(null);
            }

            if(queue.peek() == toDelete) {
                queue.peek().setData(lastNode.getData());
            }

            queue.remove(queue.peek());
        }
    }

    public void deleteTree(TNode root) {
       root = null;
       System.out.println("Felled Tree.");
    }
}
