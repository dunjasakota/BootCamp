import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class NeispravnaLogInLozinka {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.navigate().to("https://www.saucedemo.com");
        String validUsername="standard_users";
        String invalidPassword="secret_sauce123";

        WebElement usernameTextBox=driver.findElement(By.id("user-name"));
        WebElement passwordTextBox= driver.findElement(By.id("password"));

        usernameTextBox.clear();
        usernameTextBox.sendKeys(validUsername);

        passwordTextBox.clear();
        passwordTextBox.sendKeys(invalidPassword);

        WebElement logInButton=driver.findElement(By.id("login-button"));
        logInButton.click();

        String expectedURL="https://www.saucedemo.com/";
        String actualURL=driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);

        WebElement errorMessage=driver.findElement(By.cssSelector("h3[data-test='error']"));
        String expectedMessage="Epic sadface: Username and password do not match any user in this service";
        String actualMessage=errorMessage.getText();
        Assert.assertEquals(actualMessage,expectedMessage);






    }
}