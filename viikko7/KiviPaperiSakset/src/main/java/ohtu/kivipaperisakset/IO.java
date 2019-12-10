
package ohtu.kivipaperisakset;

import java.util.Scanner;


public class IO {
    
    private Scanner scanner = new Scanner(System.in);
    
    public String next() {
        return scanner.nextLine();
    }
    
    public void print(String line) {
        System.out.print(line);
    }
    
    public void println(String line) {
        System.out.println(line);
    }   
}
