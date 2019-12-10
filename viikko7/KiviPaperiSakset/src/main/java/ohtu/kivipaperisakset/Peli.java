
package ohtu.kivipaperisakset;


public abstract class Peli {
    
    public void pelaa() {
        Tuomari tuomari = new Tuomari();
        IO io = new IO();

        io.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = io.next();
        String tokanSiirto = teeToinenSiirto();
        
        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            io.println(tuomari.toString());
            io.println("");

            io.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = io.next();
            
            tokanSiirto = teeToinenSiirto();
        }

        io.println("");
        io.println("Kiitos!");
        io.println(tuomari.toString());
    }
    
    private boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
    
    protected abstract String teeToinenSiirto();
}
