package BST;

public class Main {
    public static void main(String[] args) {

        BSTNode root = new BSTNode(100);

        //1th gen
        root.setLeft(new BSTNode(80));
        root.setRight(new BSTNode(200));

        //2nd gen
        root.getLeft().setLeft(new BSTNode(70));
        root.getLeft().setRight(new BSTNode(90));

        root.getRight().setLeft(new BSTNode(150));
        root.getRight().setRight(new BSTNode(300));

        //3rd gen
        root.getLeft().getLeft().setLeft(new BSTNode(50));

        root.getRight().getLeft().setLeft(new BSTNode(140));
        root.getRight().getLeft().setRight(new BSTNode(160));

        root.getRight().getRight().setRight(new BSTNode(400));

        //4th gen
        root.getLeft().getLeft().getLeft().setLeft(new BSTNode(40));
        root.getLeft().getLeft().getLeft().setRight(new BSTNode(60));

        root.getRight().getRight().getRight().setLeft(new BSTNode(350));
        root.getRight().getRight().getRight().setRight(new BSTNode(410));


        BinarySearchTree bst = new BinarySearchTree();

        System.out.println(bst.searchData(root, 90));
        System.out.println(bst.searchData(root, 60));

        System.out.println("Pre-Order");
        bst.preOrder(root);
        System.out.println();

        System.out.println("In-Order");
        bst.inOrder(root);
        System.out.println();

        System.out.println("Post-Order");
        bst.postOrder(root);
        System.out.println();

        System.out.println("Level-Order");
        bst.levelOrder(root);
        System.out.println();

//        System.out.println("Insert");
//        bst.insertData(root, 85);
//        System.out.println();

        System.out.println("Pre-Order");
        bst.preOrder(root);
        System.out.println();

        System.out.println("Delete");
        bst.deleteData(root, 100);
//        bst.deleteData(root, 40);
//        bst.deleteData(root, 50);

        System.out.println("Pre-Order");
        bst.preOrder(root);
        System.out.println();

        //root should be inside BST Class
        // TODO: 10/11/2021 Move the tree of Main to BST Class 
        System.out.println("DeleteTree");
        bst.deleteTree(root);


    }
}
