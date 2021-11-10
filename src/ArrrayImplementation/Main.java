package ArrrayImplementation;

public class Main {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree(10);

        tree.insertData(20);
        tree.insertData(100);
        tree.insertData(3);
        tree.insertData(50);
        tree.insertData(15);
        tree.insertData(250);
        tree.insertData(35);
        tree.insertData(222);
//        tree.insertData(300);

        //tree.insertData(400); -> return Array is full

//        System.out.println("Traverse");
//        tree.traverse();

        System.out.println("Search");
        tree.searchData(250);

        System.out.println("InOrder");
        tree.inOrder(1);
        System.out.println();

        System.out.println("PreOrder");
        tree.preOrder(1);
        System.out.println();

        System.out.println("PostOrder");
        tree.postOrder(1);
        System.out.println();

        System.out.println("LevelOrder");
        tree.levelOrder();
        System.out.println();

        System.out.println("Delete");
        tree.deleteValue(3);
        System.out.println();

        System.out.println("LevelOrder");
        tree.levelOrder();
        System.out.println();

        System.out.println("Delete Tree");
        tree.delete();

        tree.levelOrder();


    }
}
