import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        //se pornesc threadurile
        Buffer b = new Buffer();
        Producer p1 = new Producer(b);
        Consumer c1 = new Consumer(b);
        long startt = System.currentTimeMillis();
        p1.start();
        c1.start();
        while(c1.isAlive()==true) {

        }

        //calcularea timpului total
        long stopp = System.currentTimeMillis();
        long total = stopp - startt;
        System.out.println("Timpul : " + total);

        //varargs
        System.out.println();
        fun(100);
        fun(1,2,3,4);
        fun();
    }

    static void fun(int ...a){
        System.out.println("Numarul de argumente: "+ a.length);
        for(int i:a)
            System.out.print(i+ " ");
        System.out.println();
    }

}
