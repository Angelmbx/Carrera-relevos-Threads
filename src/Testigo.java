public class Testigo {

    private int turno;

    Testigo(){
        this.turno=0;
    }
    public synchronized void pasarTurno(int dorsal){

        this.turno=dorsal;
        notifyAll();

    }
    public synchronized void comprobarTurno(int dorsal){
        while (turno!=dorsal){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
      }
        }




}
