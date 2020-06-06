package classes.others;

import classes.data_structures.AVLTree;
import classes.data_structures.Queue;

public class TestTree {
    public static void main(String[] args) {
        AVLTree<Integer> testTree = new AVLTree<>();

        for (int i=0; i<101; i ++){
            testTree.Insert(i);
        }

        for (int i= 0; i<51; i++){
            int comprobar = testTree.getKey(testTree.Find(i, testTree.getRoot()));

            if (comprobar == i){
                int result = testTree.Delete(testTree.Find(i, testTree.getRoot()));

                System.out.println(result);
            }
            else System.out.println("no se borro "+ i);
        }

        Queue<Integer> testResult = new Queue<>();

        testTree.PreOrder(testTree.getRoot(), testResult);

        while (!testResult.IsEmpty()){
            System.out.println(testResult.Dequeue());
        }
    }
}