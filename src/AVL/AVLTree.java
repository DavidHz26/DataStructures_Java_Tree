package AVL;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {

    //AVL Tree is a BST but the tree should be balanced
    //difference of 1 is permitted between right and left subtree height
    //if isn't 1, then we balance the tree by a rotation

    private AVLNode root;

    public AVLTree() {
        root = null;
    }

    public void insertData(int data) {
        root = insert(root, data);
    }

    private AVLNode insert(AVLNode root, int data) {

        if(root == null) {
            root = new AVLNode(data);
            System.out.println(root + "added");
            return root;
        }

        if(data < root.getData()) {
            System.out.print("<-");
            root.setLeft(insert(root.getLeft(), data));
        }
        else if(data > root.getData()) {
            System.out.print("->");
            root.setRight(insert(root.getRight(), data));
        }

        updateHeight(root);

        int b = balance(root);

        //Left-Left Cond -> rightRotate(root)
        //Left-Right Cond -> rightRotate(root.left)
        //Right-Right Cond -> leftRotate(root)
        //Right-Left Cond -> leftRotate(root.right)

        if(b > 1) {
            if (height(root.getRight().getRight()) <= height(root.getRight().getLeft())) {
                root.setRight(rightRotate(root.getRight()));
            }
            root = leftRotate(root);
        }
        else if(b < -1) {
            //if height of left-left is less than height of left-right
            //then we rotate to left the root.left, but the tree still is going to be disbalanced
            if (height(root.getLeft().getLeft()) <= height(root.getLeft().getRight())) {
                root.setLeft(leftRotate(root.getLeft()));
            }

            //So we rotate root now to right to organize the tree in a balanced way
            root = rightRotate(root);

            //Example:
            //      40                            40                                   40                                40
            //  30      50    [add 25]        30      50     [leftRotation]         30    50    [rightRotation]      25       50
            //20                           20                                    25                               20    30
            //                                25                              20
        }

        return root;

    }

    private int height(AVLNode node) {
        //We checked if the node exists
        //If exists. then we return his height
        //If not, we return -1

        if(node == null) {
            return -1;
        }

        return node.getHeight();
    }

    private void updateHeight(AVLNode root) {

        //Set the node height to the maximum height of children + 1

        //Height of root.getLeft
        int leftHeight = height(root.getLeft());

        //Height of root.getRight
        int rightHeight = height(root.getRight());

        //We compare and get the child with more height
        int max = Math.max(leftHeight, rightHeight);

        root.setHeight(1 + max);
    }

    private int balance(AVLNode node) {
        //We calculate the difference between left and right subtree
        //If the difference in heights is 1 is acceptable
        //If is equal or greater than 2 the tree is unbalanced

        //If node = null, then we stop and return 0
        if(node == null) {
            return 0;
        }

        return height(node.getRight()) - height(node.getLeft());
    }

    public AVLNode rightRotate(AVLNode disbalancedNode) {
        System.out.println("Rotating to right...");

        //To rotate root to right,we need to make root.left into the new root
        // left (new root) <- root -> right
        AVLNode newRoot = disbalancedNode.getLeft();

        //when root.left is rotated his right needs to be disconnected
        //So we connect it to the previous root.left which is going to be empty
        disbalancedNode.setLeft(disbalancedNode.getLeft().getRight());

        //now we point the new root.right to the previous root
        newRoot.setRight(disbalancedNode);

        //And lastly we updated their new heights
        updateHeight(disbalancedNode);
        updateHeight(newRoot);
        return newRoot;
    }

    public AVLNode leftRotate(AVLNode disbalancedNode) {
        System.out.println("Rotating to left...");
        AVLNode newRoot = disbalancedNode.getRight();
        disbalancedNode.setRight(disbalancedNode.getRight().getLeft());
        newRoot.setLeft(disbalancedNode);
        updateHeight(disbalancedNode);
        updateHeight(newRoot);
        return newRoot;
    }

    public void searchData(int data) {
        root = search(root, data);
    }

    private AVLNode search(AVLNode root, int data) {

        if(root == null) {
            return null;
        }

        if(root.getData() == data) {
            System.out.println(root + "found");
            return root;
        }

        if(data <= root.getData()) {
            System.out.print("<-");
            search(root.getLeft(), data);
        } else if (data > root.getData()) {
            System.out.print("->");
            search(root.getRight(), data);
        }

        return root;
    }

    public void traverseInOrder() {
        inOrder(root);
    }

    private void inOrder(AVLNode root) {
        if(root == null) {
            return;
        }

        inOrder(root.getLeft());
        System.out.print(root);
        inOrder(root.getRight());
    }

    public void traversePreOrder() {
        preOrder(root);
    }

    private void preOrder(AVLNode root) {
        if(root == null) {
            return;
        }

        System.out.print(root);
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    public void traversePostOrder() {
        postOrder(root);
    }

    private void postOrder(AVLNode root) {
        if(root == null) {
            return;
        }

        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root);
    }

    public void traverseLevelOrder() {
        levelOrder(root);
    }

    private void levelOrder(AVLNode root) {
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


}
