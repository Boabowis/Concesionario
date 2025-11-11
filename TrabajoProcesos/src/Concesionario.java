import java.util.concurrent.Semaphore;

public class Concesionario {
    public static void main(String[] args) {
        Semaphore semaforo = new Semaphore(4);

        for (int i = 1; i <= 9; i++) {
            new Clientes("Cliente" + i, semaforo).start();
        }
    }
}

