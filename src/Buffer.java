public class Buffer {
    private byte[] number = new byte[273955];
    private boolean available = false ;

    public synchronized byte[] get () {
        while (!available ) {
            try {
                wait ();
                // Asteapta producatorul sa puna o valoare
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }
        available = false ;
        notifyAll ();
        return number;
    }

    public synchronized void put (byte [] number ) {
        while ( available ) {
            try {
                wait ();
                // Asteapta consumatorul sa preia valoarea
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }
        this.number = number ;
        available = true;
        notifyAll ();
    }
}
