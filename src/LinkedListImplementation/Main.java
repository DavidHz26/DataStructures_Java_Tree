package LinkedListImplementation;

public class Main {

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();

        TNode root = new TNode(20);

        //LEFT SUBTREE
        //1th gen
        root.setLeft(new TNode(100));

        //2nd gen
        root.getLeft().setLeft(new TNode(50));
        root.getLeft().setRight(new TNode(15));

        //3th gen
        root.getLeft().getLeft().setLeft(new TNode(222));

        //RIGHT SUBTREE
        //1th gen
        root.setRight(new TNode(3));

        //2nd gen
        root.getRight().setLeft(new TNode(250));
        root.getRight().setRight(new TNode(35));

        System.out.println("Pre-Order");
        tree.preOrder(root);
        System.out.println();

        System.out.println("In-Order");
        tree.inOrder(root);
        System.out.println();

        System.out.println("Post-Order");
        tree.postOrder(root);
        System.out.println();

        System.out.println("Level_Order");
        tree.levelOrder(root);
        System.out.println();


    }

}
