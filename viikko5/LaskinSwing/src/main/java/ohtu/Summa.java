
package ohtu;

import java.awt.Button;
import java.awt.TextField;
import javax.swing.JButton;
import javax.swing.JTextField;


public class Summa extends Komento {

    public Summa(JTextField tuloskentta, JTextField syotekentta, JButton nollaa, JButton undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }
    
    
    
    @Override
    public void suorita() {
        int arvo = 0;
        
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        
        sovellus.plus(arvo);
        
        int laskunTulos = sovellus.tulos();
    
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
    }
    
    @Override
    public void peru() {
        
    }
    
}
