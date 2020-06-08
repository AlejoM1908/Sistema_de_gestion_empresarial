package classes.testing;

import classes.data_structures.AVLTree;

public class TestTree {
    public static void main(String[] args) {
        AVLTree<Integer> testTree = new AVLTree<>();
        long result = 0, numberOfProofs = 5000000;

        long startTime = System.nanoTime();

        for (long j = 0; j < numberOfProofs; j++) {
            testTree.Insert((int) Math.random() * (10000000));
        }

        long finishTime = System.nanoTime();

        result = finishTime - startTime;

        System.out.println("Se genero la prueba de AVLTree-Insert para un total de: " + numberOfProofs
                + " operaciones con un resultado de: " + result / numberOfProofs + " milisegundos por operacion y: "
                + result + " milisegundos en total");

        startTime = System.nanoTime();

        for (long j = 0; j < numberOfProofs; j++) {
            testTree.Find((int) Math.random() * (10000000), testTree.getRoot());
        }

        finishTime = System.nanoTime();

        result = finishTime - startTime;

        System.out.println("Se genero la prueba AVLTree-Find para un total de: " + numberOfProofs
                + " operaciones con un resultado de: " + result / numberOfProofs + " milisegundos por operacion y: "
                + result + " milisegundos en total");

        startTime = System.nanoTime();

        for (long j = 0; j < numberOfProofs; j++) {
            testTree.Delete(testTree.Find((int) Math.random() * (10000000), testTree.getRoot()));
        }

        finishTime = System.nanoTime();

        result = finishTime - startTime;

        System.out.println("Se genero la prueba AVLTree-Delete para un total de: " + numberOfProofs
                + " operaciones con un resultado de: " + result / numberOfProofs + " milisegundos por operacion y: "
                + result + " milisegundos en total");
    }
}