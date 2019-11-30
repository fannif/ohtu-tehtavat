
package ohtu;

import java.awt.Button;
import java.awt.TextField;
import javax.swing.JButton;
import javax.swing.JTextField;


public class Nollaus extends Komento {
    
    public Nollaus(JTextField tuloskentta, JTextField syotekentta, JButton nollaa, JButton undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }
    
    @Override
    public void suorita() {
        int arvo = 0;

        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
    
        sovellus.nollaa();
        
        int laskunTulos = sovellus.tulos();
    
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
    }
    
    @Override
    public void peru() {
        
    }
    
}
