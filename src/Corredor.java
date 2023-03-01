
public class Corredor extends Thread {

    private int dorsal;
    private Testigo testigo;

    public Corredor(int dorsal, Testigo testigo) {
        this.dorsal = dorsal;
        this.testigo = testigo;
    }

    @Override
    public void run() {
    try {
        testigo.comprobarTurno(dorsal);

        System.out.println("Soy el corredor "+dorsal+" y empiezo a correr.");
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (dorsal!=4){
            int receptor= dorsal+1;
            System.out.println("Terminé, paso el testigo al corredor "+receptor);
            testigo.pasarTurno(receptor);
        } else {
            System.out.println("Terminé! Soy el último");
        }

    } catch(Exception ex) {

        }



    }
}
