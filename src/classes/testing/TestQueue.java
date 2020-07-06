package classes.testing;

import classes.data_structures.Queue;

public class TestQueue{
    public static void main(String[] args) {
        Queue<Integer> testQueue = new Queue<>();
        long result = 0, numberOfProofs = 10000000;

        long startTime = System.nanoTime();

        for (long i=0; i<numberOfProofs; i++){
            testQueue.Enqueue((int) Math.random() * 1000000);
        }

        long finishTime = System.nanoTime();
        result = finishTime-startTime;

        System.out.println("Se genero la prueba de Queue-Enqueue para un total de: " + numberOfProofs
                + " operaciones con un resultado de: " + result / numberOfProofs + " milisegundos por operacion y: "
                + result + " milisegundos en total");

        startTime = System.nanoTime();

        for (long i=0; i<numberOfProofs; i++){
            testQueue.Dequeue();
        }

        finishTime = System.nanoTime();
        result = finishTime-startTime;

        System.out.println("Se genero la prueba de Queue-Dequeue para un total de: " + numberOfProofs
                + " operaciones con un resultado de: " + result / numberOfProofs + " milisegundos por operacion y: "
                + result + " milisegundos en total");
    }
}