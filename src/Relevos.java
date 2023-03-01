
public class Relevos {
    /**
            *
     *  Escribe una clase llamada Relevos que simule una carrera de relevos de la siguiente forma:
     * * Cree 4 threads, que se quedarán a la espera de recibir alguna señal para comenzar a correr. Una vez creados los threads,
     * se indicará que comience la carrera, con lo que uno de los threads deberá empezar a correr.
     * * Cuando un thread termina de correr, pone algún mensaje en pantalla y espera un par de segundos, pasando el testigo a
     * otro de los hilos para que comience a correr, y terminando su ejecución (la suya propia).
     * * Cuando el último thread termine de correr, el padre mostrará un mensaje indicando que todos los hijos han terminado.
            *
    El relevo se transfiere a través del objeto compartido. Existirá un atributo entero con el número del hilo que se ejecuta.
    Hilo termina ejecución, incrementa turno y notifica el cambio.
    Antes de ejecutarse cada hilo, comprueba si es su turno. Si no lo es, espera.
            **/

    public static void main(String[] args) {

        Testigo t = new Testigo();
        Corredor c1 = new Corredor(1,t);
        Corredor c2 = new Corredor(2,t);
        Corredor c3 = new Corredor(3,t);
        Corredor c4 = new Corredor(4,t);

        c1.start();
        c2.start();
        c3.start();
        c4.start();

        System.out.println("todos los hilos creados");
        t.pasarTurno(1);
        System.out.println("Comienza la carrera!");



        try {
            c1.join();
            c2.join();
            c3.join();
            c4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Todos han terminado, que gran carrera!");
    }
}