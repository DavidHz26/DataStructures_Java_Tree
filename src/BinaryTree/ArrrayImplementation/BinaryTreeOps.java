package BinaryTree.ArrrayImplementation;

import java.util.Arrays;

public class BinaryTreeOps {
    private int[] array;
    private int x;
    private int xCount;
    private int lastUsedIndex;
    private int capacity;

    //IMPORTANT: array[0] is not used

    public BinaryTreeOps(int size) {
        array = new int[size];
        Arrays.fill(array, -1);
        x = 0;
        xCount = 0;
        lastUsedIndex = 0;
        capacity = 0;
    }

    public void insertData(int data) {

        try {
            if (isFull()) {
                System.out.println("Array is full");
                return;
            }

            //Data needs to be entered at the first available space (left or right)
            //array should be represented in level-order

            //The formula I reached for left subtree is 2(x)+2 where x is index
            //and formula for right subtree is 2(x)+1, where index gets incremented when
            //we pass from left child to right child

            // if index = 0 then it is the root node -> 0 doesn't count, so root should be array[1]
            // 2(0)+1 = 1, then the node is the root

            //We check if that space is available, and add the new node
            if (array[2 * x + 1] == -1) {
                array[2 * x + 1] = data;
                lastUsedIndex++;
                capacity++;
                xCount = 1;
                return;
            }

            //If not, then next space should be open, and we add the new node, and since the last one was root, then
            //left child should be open, and we increment index

            if (array[2 * x + 2] == -1) {
                array[2 * x + 2] = data;
                x++;
                xCount = 2;
                lastUsedIndex++;
                capacity++;
            }

            //                                                       2(0)+1 = 1 <root>
            //                                    2(0)+2 = 2 <left>  ->  [index=1]   ->  2(1)+1 = 3 <right>
            //2(1)+2 = 4 <left> ->  [index=2]   ->  2(2)+1 = 5 <right>                2(2)+2 = 6 <left> ->  [index=3]   ->  2(3)+1 = 7 <right>

            //So even index and odd result = right leaf/child and odd index and even result = left leaf/child
        } catch (NullPointerException e) {
            System.out.println("Array does not exist.");
        }
    }

    public void searchData(int data) {
        try {
            for (int i = 1; i <= lastUsedIndex; i++) {
                if (array[i] == data) {
                    System.out.println(data + " found at position: " + i);
                    return;
                }
            }

            System.out.println(data + " not found!");

        } catch (NullPointerException e) {
            System.out.println("Array does not exist.");
        }
    }

    public void inOrder(int index) {
        try {
            if (index > lastUsedIndex) {
                return;
            }

            inOrder(index * 2);
            System.out.print("[" + array[index] + "] ");
            inOrder(index * 2 + 1);
        } catch (NullPointerException e) {
            System.out.println("Array does not exist.");
        }
    }

    public void preOrder(int index) {
        try {
            if (index > lastUsedIndex) {
                return;
            }

            System.out.print("[" + array[index] + "] ");
            preOrder(index * 2);
            preOrder(index * 2 + 1);
        } catch (NullPointerException e) {
            System.out.println("Array does not exist.");
        }
    }

    public void postOrder(int index) {
        try {
            if (index > lastUsedIndex) {
                return;
            }

            postOrder(index * 2);
            postOrder(index * 2 + 1);
            System.out.print("[" + array[index] + "] ");
        } catch (NullPointerException e) {
            System.out.println("Array does not exist.");
        }
    }

    public void levelOrder(){
        try {
            for (int i = 1; i <= lastUsedIndex; i++) {
                System.out.print("[" + array[i] + "] ");
            }

            System.out.println("\n");
        } catch (NullPointerException e) {
            System.out.println("Array does not exist.");
        }
    }

    public void deleteValue(int data) {
        try {
            for (int i = 1; i <= lastUsedIndex; i++) {
                if (array[i] == data) {
                    array[i] = array[lastUsedIndex];
                    array[lastUsedIndex] = -1;
                    lastUsedIndex--;
                    capacity--;

                    if (xCount == 2) {
                        xCount = 1;
                    } else if (xCount == 1) {
                        x--;
                        xCount = 2;
                    }


                    System.out.println(data + " deleted");
                    return;
                }
            }

            System.out.println(data + " not in array");
        } catch (NullPointerException e) {
            System.out.println("Array does not exist.");
        }
    }

    public void delete() {
        try {
            array = null;
            System.out.println("Felled Tree");
        } catch (NullPointerException e) {
        System.out.println("Array does not exist.");
    }
    }

    public boolean isFull() {
        return capacity == array.length - 1;
    }

}
