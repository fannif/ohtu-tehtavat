package ohtu;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Stepdefs {
    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567";
    
    @Given("login is selected")
    public void loginIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();   
    }    

    @Given("command new user is selected")
    public void newUserIsSelected() {
	driver.get(baseUrl);
	WebElement element = driver.findElement(By.linkText("register new user"));
	element.click();
    }

    @Given("user with username {string} with password {string} is successfully created")
    public void userIsCreatedSuccessfully(String username, String password) {
	driver.get(baseUrl);
	WebElement element = driver.findElement(By.linkText("register new user"));
	element.click();
	registerWith(username, password, password);
    }

    @Given("user with username {string} and password {string} is tried to be created")
    public void userWithBadPasswordOrNameIsTriedToBeCreated(String username, String password) {
	driver.get(baseUrl);
	WebElement element = driver.findElement(By.linkText("register new user"));
	element.click();
	registerWith(username, password, password);
    }
    
    @When("correct username {string} and password {string} are given")
    public void correctUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is logged in")
    public void userIsLoggedIn() {
        pageHasContent("Ohtu Application main page");
    }    
 
    @When("correct username {string} and incorrect password {string} are given")
    public void correctUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is not logged in and error message is given")
    public void userIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }    
    
    @When("incorrect username {string} and password {string} are given")
    public void usernameAndPasswordAreGiven(String username, String password) throws Throwable {
        logInWith(username, password);
    }   

    @When("a valid username {string} and password {string} and matching password confirmation {string} are entered")
    public void validUsernameAndPasswordAndMatchingConfirmationAreGiven(String username, String password, String confirmation) throws Throwable {
	registerWith(username, password, confirmation);
    }

    @When("an invalid username {string} and password {string} and matching password confirmation {string} are entered")
    public void invalidUsernameAndPasswordAndMatchingConfirmationAreGiven(String username, String password, String confirmation) throws Throwable {
	registerWith(username, password, confirmation);
    }

    @When("a valid username {string} and invalid password {string} and matching password confirmation {string} are entered")
    public void validUsernameAndInvalidPasswordAndMatchingConfirmationAreGiven(String username, String password, String confirmation) throws Throwable {
	registerWith(username, password, confirmation);
    }

    @When("a valid username {string} and password {string} and not matching password confirmation {string} are entered")
    public void validUsernameAndPasswordAndNotMatchingConfirmationAreGiven(String username, String password, String confirmation) throws Throwable {
	registerWith(username, password, confirmation);
    }

    @Then("a new user is created")
    public void userIsCreated() {
	pageHasContent("Welcome to Ohtu Application!");
    }

    @Then("user is not created and error {string} is reported")
    public void usernameIsTooShort(String e) {
	pageHasContent(e);
    }
    
    @After
    public void tearDown(){
        driver.quit();
    }
        
    /* helper methods */
 
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
        
    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    } 

    private void registerWith(String username, String password, String confirmation) {
	assertTrue(driver.getPageSource().contains("Create username and give password"));
	WebElement element = driver.findElement(By.name("username"));
	element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
	element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(confirmation);
        element = driver.findElement(By.name("signup"));
        element.submit();  
    }
}
