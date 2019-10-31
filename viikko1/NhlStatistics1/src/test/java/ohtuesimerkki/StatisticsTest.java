/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author f
 */
public class StatisticsTest {
    
    public StatisticsTest() {
    }
    
    Statistics stats;
    
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            
            ArrayList<Player> players = new ArrayList<>();
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    
    @Before
    public void setUp(){    
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void konstruktorissaOikeaLista() {
        boolean works = true;
        if (stats.search("Semenko") == null) {
           works = false;
        }
        if (stats.search("Lemieux") == null) {
           works = false;
        }
        if (stats.search("Kurri") == null) {
           works = false;
        }
        if (stats.search("Yzerman") == null) {
           works = false;
        }
        if (stats.search("Gretzky") == null) {
           works = false;
        }
        
        assertTrue(works);
       
    }
    
    @Test
    public void hakuPalauttaaNullJosEiLoydy() {
        Player player = stats.search("Lowery");
        assertTrue(player == null);
    }
    
    @Test
    public void hakuLoytaaOlemassaOlevanPelaajan() {
        Player gretzky = stats.search("Gretzky");
        assertTrue(!(gretzky == null) && (gretzky.getName().equals("Gretzky")) && (gretzky.getTeam().equals("EDM")) && (gretzky.getGoals() == 35) && gretzky.getAssists() == 89);
    }

    @Test
    public void tiimiMetodiPalauttaaOikeatHenkilot() {
        List<Player> players = stats.team("EDM");
        ArrayList<String> names = new ArrayList<>();
        
        for (Player player: players) {
            names.add(player.getName());
        }
        boolean works = names.contains("Gretzky") && names.contains("Kurri") && names.contains("Semenko");
    
        assertTrue(works);
    }
    
    @Test
    public void palautetaanOikeatParhaatPelaajat() {
        List<Player> players = stats.topScorers(2);
        ArrayList<String> names = new ArrayList<>();
        
        for (Player player: players) {
            names.add(player.getName());
        }
        boolean works = names.get(0).equals("Gretzky") && names.get(1).equals("Lemieux");
    
        assertTrue(works);
    }
    
}
