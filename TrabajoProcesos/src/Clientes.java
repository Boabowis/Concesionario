
import java.util.concurrent.Semaphore;

public class Clientes extends Thread {
    private String nombre;
    private Semaphore semaforo;

    public Clientes(String nombre, Semaphore semaforo) {
        this.nombre = nombre;
        this.semaforo = semaforo;
    }

    public void run() {
        try {
            semaforo.acquire();
            int coche = (int) (Math.random() * 4) + 1;
            System.out.println(nombre + " ... probando vehículo ... " + coche);
            Thread.sleep((int) (Math.random() * 3000 + 1000));
            System.out.println(nombre + " ... terminó de probar el vehículo ... " + coche);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforo.release();
        }
    }
}
