import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Consumer extends Thread{
    private Buffer buffer;
    //private byte[] rezultat =null;
    public Consumer ( Buffer b) {
        buffer = b;
    }
    public void run () {
        //se face citiea pe sferturi si se pune in rezultat
        long start = System.currentTimeMillis();
        try {
        File file2 = new File("D://facultate/Java/pozeee/poza3.bmp");
        file2.createNewFile();
        int n = (int) file2.length();
        //System.out.println(" "+ n);
        byte[] value = new byte[n/4+1];
        byte[] rezultat = new byte[n];
        for (int i = 1; i <= 4; i++) {
            value = buffer.get();
            if (i == 1) {
                for (int j = 0; j < (n/4+1); j++) {
                    rezultat[j] = value[j];
                }
            }
            if (i == 2) {
                for (int j = 0; j < (n/4+1); j++) {
                    rezultat[j + (n/4+1)] = value[j];
                }
            }
            if (i == 3) {
                for (int j = 0; j < (n/4+1); j++) {
                    rezultat[j + (n/4+1)*2] = value[j];
                }
            }
            if (i == 4) {
                for (int j = 0; j < (n-(n/4+1)*3); j++) {
                    rezultat[j + (n/4+1)*3] = value[j];
                }
            }
            System.out.println("Consumatorul a primit 1/4");
            if (i == 4) {
                //se face conversia de la un vector de bytes la bufferedimage
                ByteArrayInputStream bais = new ByteArrayInputStream(rezultat);

                // Calcularea si afisarea timpului de citire
                long stopTime = System.currentTimeMillis();
                long readTime = stopTime - start;





                try {
                    BufferedImage image = ImageIO.read(bais);
                    //System.out.println(image.getWidth(null));

                    long startTime = System.currentTimeMillis();

                    // Setarea parametrilor procesarii de catre utilizator de la tastatura
                    Scanner keyboard = new Scanner(System.in);
                    System.out.println("Introduceti raza pentru convolutie pe orizontala: ");
                    int hRad = keyboard.nextInt();
                    System.out.println("Introduceti raza pentru convolutie pe verticala: ");
                    int vRad = keyboard.nextInt();
                    System.out.println("Introduceti numărul de iterații: ");
                    int iter = keyboard.nextInt();

                    // Aplicarea functiei de convolutie
                    Smoothing smoothing = new Smoothing(hRad,vRad,iter);
                    smoothing.filter(image,image);

                    System.out.println("Timpul de citire: " + readTime);

                    // Calcularea si afisarea timpului de procesare
                    long stopTime1 = System.currentTimeMillis();
                    long processTime = stopTime1 - startTime;
                    System.out.println("Timpul de procesare: " + processTime);

                    // Scrierea noului fisier imagine
                    File f=null;
                    try{
                        f = new File("D://facultate/Java/pozeee/output3.jpg");
                        ImageIO.write(image, "jpg", f);
                    }catch(IOException e){
                        System.out.println("Error: "+e);
                    }

                    // Calculare si afisare timp de scriere
                    long stopTime2 = System.currentTimeMillis();
                    long writeTime = stopTime2 - stopTime1;
                    System.out.println("Timpul de scriere: " + writeTime);


                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

        }
        }catch (Exception e) {
                e.printStackTrace();}
    }

}
