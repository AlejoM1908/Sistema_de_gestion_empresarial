package classes.testing;

import classes.data_structures.HashTable;
import classes.data_structures.Queue;
import classes.others.User;

public class TestHashTable {
    public static void main(String[] args) {
        HashTable<String, User> hash = new HashTable<>();
        Queue<User> queue = new Queue<>();
        User current;

        for (int i = 0; i < 4; i++) {
            current = new User("root", "Root");
            hash.Add(current.getPassword(), current);
            queue.Enqueue(current);

            current = new User("master", "1234");
            hash.Add(current.getPassword(), current);
            queue.Enqueue(current);

            current = new User("Pablito", "pablo_fernan");
            hash.Add(current.getPassword(), current);
            queue.Enqueue(current);

            current = new User("daniel", "1414");
            hash.Add(current.getPassword(), current);
            queue.Enqueue(current);

            while (!queue.IsEmpty()) {
                current = queue.Dequeue();

                if (current.compareTo(hash.getValue(hash.Get(current.getPassword(), current))) == 0) {
                    System.out.println("Se encontro el usuario: " + current.getNickname() + " en la estructura");
                    System.out.println("Procediendo a eliminar el usuario encontrado!");

                    if (current.compareTo(hash.getValue(hash.Remove(current.getPassword(), current))) == 0) {
                        System.out.println("El usuario: " + current.getNickname() + " fue eliminado con exito\n");
                    } else
                        System.out.println("El usuario no pudo ser eliminado con exito!\n");
                } else
                    System.out.println("El usuario: " + current.getNickname() + " no pudo ser encontrado!\n");
            }

            if (hash.IsEmpty())
                System.out.println("La estructura funciona correctamente!!\n");

            else System.out.println("La estructura no esta vacia!\n");
        }
    }
}