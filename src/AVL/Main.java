package AVL;

public class Main {
    public static void main(String[] args){

        AVLTree avl = new AVLTree();

        System.out.println("Insert");
        avl.insertData(40);
        avl.insertData(30);
        avl.insertData(50);
        avl.insertData(60);

        System.out.println("LevelOrder");
        avl.traverseLevelOrder();
        System.out.println();

        avl.insertData(55);

        avl.traverseLevelOrder();

//        System.out.println("Search");
//        avl.searchData(20);
//
//        System.out.println("TraverseInOrder");
//        avl.traverseInOrder();
//        System.out.println();
//
//        System.out.println("TraversePreOrder");
//        avl.traversePreOrder();
//        System.out.println();
//
//        System.out.println("TraversePostOrder");
//        avl.traversePostOrder();
//        System.out.println();
//
//        System.out.println("TraverseLevelOrder");
//        avl.traverseLevelOrder();
//        System.out.println();




//
    }
}
