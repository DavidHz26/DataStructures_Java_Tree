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

        //If left subtree is overloaded
        if(b > 1) {
            if (height(root.getRight().getRight()) <= height(root.getRight().getLeft())) {
                System.out.println("Right-Left");
                root.setRight(rightRotate(root.getRight()));
            }

            System.out.println("Right-Right");
            root = leftRotate(root);
        }

        //If right subtree is overloaded
        else if(b > -1) {
            //Here we need to check to which side is going to rotate by checking the height of the trees

            //if height of left-left is greater than height of left-right then we simply rotate to right the root
            //but if height of left-left is less than height of left-right
            //then we need to rotate to left the root.left, but the tree still is going to be disbalanced
            if (height(root.getLeft().getLeft()) <= height(root.getLeft().getRight())) {
                System.out.println("Left-Right");
                root.setLeft(leftRotate(root.getLeft()));
            }

            //So we rotate root now to right to organize the tree in a balanced way
            System.out.println("Left-Left");
            root = rightRotate(root);

            //Example:
            //      40                            40                                   40       still disbalanced so              40
            //  30      50    [add 25]        30      50     [leftRotation]         30    50      [rightRotation]             25       50
            //20                           20                                    25                                        20    30
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

        //formula to get or update of a current node is:
        //height(node) = max(height(node.left), height(node.right)) + 1

        //For example:        [40]
        //              [20]        [50]
        //         [10]      [30]


        //If node is null (height = -1) <height class>
        //So if we want the height of 10, 10.left and 10.right are null
        //So height(10) = max(-1, -1) + 1
        //both childs height are the same, so we took any plus 1
        //h[10] = -1 + 1 = 0;  so height of 10 is 0
        //now, height of 20; h(20) = max(20.left <10>, 20.right <30>) + 1
        //if node doesn't have any childs then his height is 0, as we prove with 10
        //so h[20] = max(0,0) + 1 and the result is 1
        //h[40] = max(1 <height of 20>, 0 <no childs in 50>) + 1
        //so h[40] = 2


        //So following the formula h(n) = max(h(n.left), h(n.right)) + 1
        int h = Math.max(height(root.getLeft()), height(root.getRight())) + 1;

        //And lastly we update the height
        root.setHeight(h);
    }

    private int balance(AVLNode node) {

        //Formula for balance is balance(node) = height(node.left) - height(node.right);

        //Balance checks if the difference in height is too much
        //the acceptable difference is 1 in height, more than that the tree is disbalanced

        //So using the example from updateHeight class

        //If we try to add a node 5, it will go to the left of 10
        //then we calculate his balance

        //balance[5] = height(node.left) <-1 because null>, height(node.right)  <again null so -1>
        //then balance[5] = (-1) - (-1) = 0;  0 is greater that -2 and less than 2? Yes; so tree is balanced

        //since balance is in a recursive function, then we go to his parent [10] and again
        //b[10] = height(10.left) <5, doesn't have childs so his length is 0> - height(10.right) <null so -1>
        //b[10] = 0 - (-1) = 1;  1 is greater than -2 and less than 2? Yes; so tree is balanced

        //Now we go to 10 parent, 20
        //b[20] = h(10) - h(30) = 1 - 0 = 1 so its balanced

        //Now 20 parent, 40
        //b[40] = h(20) - h(50) = 2 - 0 = 2, and here 2 is greater that -2 and less than 2? NO, so tree is unbalanced
        //And we need to rotate the tree

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
