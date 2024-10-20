import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class IspravanLogIn {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.navigate().to("https://www.saucedemo.com");
        String validUsername="standard_user";
        String validPassword="secret_sauce";

        WebElement usernameTextBox=driver.findElement(By.id("user-name"));
        WebElement passwordTextBox= driver.findElement(By.id("password"));

        usernameTextBox.clear();
        usernameTextBox.sendKeys(validUsername);

        passwordTextBox.clear();
        passwordTextBox.sendKeys(validPassword);

        WebElement logInButton=driver.findElement(By.id("login-button"));
        logInButton.click();

        String expectedURL="https://www.saucedemo.com/inventory.html";
        String actualURL=driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);

        WebElement menuButton=driver.findElement(By.id("react-burger-menu-btn"));
        menuButton.click();
        WebElement logOutButton=driver.findElement(By.id("logout_sidebar_link"));
        wait.until(ExpectedConditions.visibilityOf(logOutButton));








    }
}
