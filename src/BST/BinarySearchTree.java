package BST;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    public BinarySearchTree() {
        System.out.println("Tree operations ready");
    }

    public AVLNode searchData(AVLNode root, int data) {

        if(root == null) {
            return null;
        }

        else if(root.getData() == data) {
            //Data found
            return root;

            //Note: If recursive function calls this method again, the root found
            //will be returned to that function, and so, the correct way to return
            //the root found is returning the value between all the iterations

        }

        else if(data < root.getData()) {
            //If data is less than node.data we go left
            System.out.print(" <- ");
            return searchData(root.getLeft(), data);
        }

        else if(data > root.getData()) {
            //If data is more than node.data we go right
            System.out.print(" -> ");
            return searchData(root.getRight(), data);
        }

        return null;
    }

    public void preOrder(AVLNode root) {
        if(root == null) {
            return;
        }

        System.out.print(root);
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    public void inOrder(AVLNode root) {
        if(root == null) {
            return;
        }

        inOrder(root.getLeft());
        System.out.print(root);
        inOrder(root.getRight());
    }

    public void postOrder(AVLNode root){
        if(root == null) {
            return;
        }

        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root);
    }

    public void levelOrder(AVLNode root) {
        if(root == null) {
            return;
        }

        Queue<AVLNode> queue = new LinkedList<>();
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

    public AVLNode insertData(AVLNode currentNode, int data) {

        //current node starts from the root
        //if the current node is empty then we found the space where data needs to be inserted

        //insertData will look for an empty space to insert the new node
        //currentNode setLeft and setRight are going to fill the node pointers from previous and next
        //when an empty space is found, and therefore, there is no more recursive calls, the previous node
        //setLeft/setRight will now point to the empty space to prevent the new node gets deleted from garbage collector
        //nodes previous to find an empty space will not be updated.

        if(currentNode == null) {
            currentNode = new AVLNode(data);
            return currentNode;
        }

        if(data <= currentNode.getData()) {
            currentNode.setLeft(insertData(currentNode.getLeft(), data));

        } else if(data > currentNode.getData()) {
            currentNode.setRight(insertData(currentNode.getRight(), data));
        }

        return currentNode;

    }

    public AVLNode deleteData(AVLNode root, int data) {
        if(root == null) {
            return null;
        }

        if(data < root.getData()) {
            root.setLeft(deleteData(root.getLeft(), data));
        }

        else if(data > root.getData()) {
            root.setRight(deleteData(root.getRight(), data));
        }

        else if(data == root.getData()){

            System.out.println("Deleting [" + data + "]");

            //If root has two childs, we find the min node in right subtree, and update root with the min node,
            //and lastly we delete the min node
            if(root.getLeft() != null && root.getRight() != null) {
                AVLNode node = minLeftInRight(root.getRight());
                System.out.println("Replacement " + node);
                System.out.println(root + "updated to " + node);
                deleteMinNode(root, root, node);
                return null;
            }

            //If node has one child, we remove him and return his child, so it can
            //be adopted by his grandfather
            if(root.getLeft() != null) {
                System.out.println(root + "replaced by " + root.getLeft());
                return root.getLeft();
            }
            else if(root.getRight() != null) {
                System.out.println(root + "replaced by " + root.getRight());
                return root.getRight();
            }


            //If node don't have any leafs/childs, we remove it
            if(root.getLeft() == null & root.getRight() == null) {
                System.out.println("Leaf [" + data + "] deleted");
                return null;
            }

        }

        return root;
    }

    private AVLNode minLeftInRight(AVLNode root) {
        if(root == null) {
            return null;
        }

        if(root.getRight() != null) {
            return minLeftInRight(root.getLeft());
        } else {
            return root;
        }
    }

    private void deleteMinNode(AVLNode root, AVLNode toDelete, AVLNode lastNode) {
        if(root == null) {
            return;
        }

        Queue<AVLNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            if(queue.peek().getLeft() != null) {
                queue.add(queue.peek().getLeft());
            }

            if(queue.peek().getRight() != null) {
                queue.add(queue.peek().getRight());
            }

            if(queue.peek() == toDelete) {
                queue.peek().setData(lastNode.getData());
            }

            if(queue.peek().getLeft() == lastNode) {
                System.out.println(lastNode + "deleted");
                queue.peek().setLeft(null);
            }

            if(queue.peek().getRight() == lastNode) {
                System.out.println(lastNode + "deleted");
                queue.peek().setRight(null);
            }

            queue.remove(queue.peek());
        }
    }

    public void deleteTree(AVLNode root) {
        root = null;
        System.out.println("Felled Tree");
    }
}
