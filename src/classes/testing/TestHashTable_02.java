package classes.testing;

import classes.data_structures.HashTable;

public class TestHashTable_02 {
    public static void main(String[] args) {
        HashTable<Integer, Integer> testHash = new HashTable<>();
        long result = 0, numberOfProofs = 10000000;

        long startTime = System.nanoTime();

        for (long j = 0; j < numberOfProofs; j++) {
            int number = (int) Math.random() * (10000000);
            testHash.Add(number, number);
        }

        long finishTime = System.nanoTime();

        result = finishTime - startTime;

        System.out.println("Se genero la prueba de HashTable-Add para un total de: " + numberOfProofs
                + " operaciones con un resultado de: " + result / numberOfProofs + " milisegundos por operacion y: "
                + result + " milisegundos en total");

        startTime = System.nanoTime();

        for (long j = 0; j < numberOfProofs; j++) {
            int number = (int) Math.random() * (10000000);
            testHash.getValue(testHash.Get(number, number));
        }

        finishTime = System.nanoTime();

        result = finishTime - startTime;

        System.out.println("Se genero la prueba HashTable-Get para un total de: " + numberOfProofs
                + " operaciones con un resultado de: " + result / numberOfProofs + " milisegundos por operacion y: "
                + result + " milisegundos en total");

        startTime = System.nanoTime();

        for (long j = 0; j < numberOfProofs; j++) {
            int number = (int) Math.random() * (10000000);
            testHash.Remove(number, number);
        }

        finishTime = System.nanoTime();

        result = finishTime - startTime;

        System.out.println("Se genero la prueba HashTable-Remove para un total de: " + numberOfProofs
                + " operaciones con un resultado de: " + result / numberOfProofs + " milisegundos por operacion y: "
                + result + " milisegundos en total");
    }
}