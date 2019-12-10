package ohtu.kivipaperisakset;

public class KPSPelaajaVsPelaaja extends Peli {

    private static IO io = new IO();
    
    @Override
    public String teeToinenSiirto() {
        
        io.print("Toisen pelaajan siirto: ");
        String tokanSiirto = io.next();
   
        return tokanSiirto;
    }

}