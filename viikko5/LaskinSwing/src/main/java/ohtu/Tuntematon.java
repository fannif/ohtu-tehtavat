
package ohtu;

import javax.swing.JButton;
import javax.swing.JTextField;


public class Tuntematon extends Komento {
    
    public Tuntematon(JTextField tuloskentta, JTextField syotekentta, JButton nollaa, JButton undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }
    
    @Override
    public void suorita() {
        
    }
    
    @Override
    public void peru() {
        
    }
    
}
