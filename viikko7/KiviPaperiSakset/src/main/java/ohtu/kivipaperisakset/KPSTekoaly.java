package ohtu.kivipaperisakset;


public class KPSTekoaly extends Peli {

    private static IO io = new IO();
    private Tekoaly tekoaly = new Tekoaly();
    
    @Override
    public String teeToinenSiirto() {

        String tokanSiirto;

        tokanSiirto = tekoaly.annaSiirto();
        io.println("Tietokone valitsi: " + tokanSiirto);

        return tokanSiirto;
    }


}