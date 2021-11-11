package AVL;

public class Main {
    public static void main(String[] args){

        AVLTree avl = new AVLTree();

        System.out.println("Insert");
        avl.insertData(30);
        avl.insertData(20);
        avl.insertData(40);
        avl.insertData(10);
        avl.insertData(5);
        avl.insertData(3);
        avl.insertData(4);
        avl.insertData(50);
        avl.insertData(60);
        avl.insertData(70);
        avl.insertData(65);

        System.out.println("Search");
        avl.searchData(20);

        System.out.println("TraverseInOrder");
        avl.traverseInOrder();
        System.out.println();

        System.out.println("TraversePreOrder");
        avl.traversePreOrder();
        System.out.println();

        System.out.println("TraversePostOrder");
        avl.traversePostOrder();
        System.out.println();

        System.out.println("TraverseLevelOrder");
        avl.traverseLevelOrder();
        System.out.println();




//
    }
}
