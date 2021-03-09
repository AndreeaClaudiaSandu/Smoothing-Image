import java.io.File;
import java.io.FileInputStream;

public class Producer extends Thread{
    private Buffer buffer;

    public Producer ( Buffer b) {

        buffer = b;
    }

    public void run () {

        int readBytes;
        try {
            //se citeste poza pe biti (pe sferturi, grupuri de n/4+1)
            File file = new File("D://facultate/Java/pozeee/poza3.bmp");
            file.createNewFile();
            int n= (int) file.length();
            byte[] data = new byte[n/4+1];
            FileInputStream in = new FileInputStream(file);

            while ((readBytes = in.read(data)) != -1) {
                buffer.put(data);
                System.out.println("Producatorul a pus 1/4\t");
                try {
                    sleep (( int )(Math.random () * 100) );
                } catch (InterruptedException e) { }
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
