package AVL;

public class Main {
    public static void main(String[] args){

        AVLTree avl = new AVLTree();

        // TODO: If want a specific insert order remember that it needs to be in level order
        //  if you start from a subtree "insert" will balance your tree and result can be different

        System.out.println("Insert");
        avl.insertData(400);
        avl.insertData(100);
        avl.insertData(1000);
        avl.insertData(80);
        avl.insertData(200);
        avl.insertData(500);
        avl.insertData(2000);
        avl.insertData(70);
        avl.insertData(90);
        avl.insertData(300);
        avl.insertData(3000);
        avl.insertData(50);

        System.out.println("Delete");
        avl.deleteData(90);
        avl.deleteData(50);
        avl.deleteData(300);
        avl.deleteData(200);
        avl.deleteData(500);

        avl.insertData(2500);

        avl.deleteData(1000);

        System.out.println("Search");
        avl.searchData(100);

        System.out.println("TraversePreOrder");
        avl.traversePreOrder();
        System.out.println();

        System.out.println("TraverseInOrder");
        avl.traverseInOrder();
        System.out.println();

        System.out.println("TraversePostOrder");
        avl.traversePostOrder();
        System.out.println();

        System.out.println("TraverseLevelOrder");
        avl.traverseLevelOrder();
        System.out.println();

        System.out.println("Delete");
        avl.deleteTree();

        avl.traverseLevelOrder();


//
    }
}
