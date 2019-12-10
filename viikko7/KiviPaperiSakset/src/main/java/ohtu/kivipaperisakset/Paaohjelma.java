package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static IO io = new IO();
    private static Pelitehdas pelit = new Pelitehdas();

    public static void main(String[] args) {

        while (true) {
            io.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = io.next();
            if (vastaus.endsWith("a")) {
                io.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                Peli kaksinpeli = pelit.luoKaksinpeli();
                kaksinpeli.pelaa();
            } else if (vastaus.endsWith("b")) {
                io.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                Peli yksinpeli = pelit.luoHelppoPeli();
                yksinpeli.pelaa();
            } else if (vastaus.endsWith("c")) {
                io.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                Peli pahaYksinpeli = pelit.luoVaikeaPeli();
                pahaYksinpeli.pelaa();
            } else {
                break;
            }

        }

    }
}
