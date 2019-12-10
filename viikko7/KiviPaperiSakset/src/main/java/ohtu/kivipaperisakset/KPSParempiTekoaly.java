package ohtu.kivipaperisakset;


// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends Peli {

    private static IO io = new IO();
    private TekoalyParannettu tekoaly = new TekoalyParannettu(20);
    
    @Override
    public String teeToinenSiirto() {
        
        String tokanSiirto;

        tokanSiirto = tekoaly.annaSiirto();
        io.println("Tietokone valitsi: " + tokanSiirto);

        return tokanSiirto;
    }

}
