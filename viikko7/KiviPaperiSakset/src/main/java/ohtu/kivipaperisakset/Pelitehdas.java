
package ohtu.kivipaperisakset;

import java.util.Scanner;


public class Pelitehdas {
    
    private Tuomari tuomari;
    private Tekoaly tekoaly;
    private static Scanner scanner = new Scanner(System.in);
    
    public static Peli luoKaksinpeli() {
        return new KPSPelaajaVsPelaaja();
    }
    
    public static Peli luoHelppoPeli() {
        return new KPSTekoaly();
    }
    
    public static Peli luoVaikeaPeli() {
        return new KPSParempiTekoaly();
    }
    
}
