package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();

        sleep(3);
        
        // Kirjaudutaan ulos seuraavaa testiä varten
        element = driver.findElement(By.linkText("logout"));
        element.click();
        
        sleep(2);
        
        // Testataan, ettei voi kirjautua väärällä salasanalla
        element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);
        
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();
        
        sleep(2);
        element = driver.findElement(By.linkText("back to home"));
        element.click();

        sleep(3);      
        
        // Tilanne, jossa luodaan uusi käyttäjätunnus
        element = driver.findElement(By.linkText("register new user"));
        element.click();
        
        sleep(2);
        
        Random r = new Random();
        
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka" + r.nextInt(100000));
        element = driver.findElement(By.name("password"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("pekka");
        
        sleep(2);
        element.submit();

        sleep(2);
        
        //Tilanne, jossa kirjaudutaan ulos uuden käyttäjän luomisen jälkeen.
        //Äsken juuri luotiin käyttäjä, joten jatketaan siitä suoraan.
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        
        sleep(2);
        
        element = driver.findElement(By.linkText("logout"));
        element.click();        
        
        sleep(3);
        
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
