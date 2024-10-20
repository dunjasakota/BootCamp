import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class kojivec2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

        driver.navigate().to("https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2");
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        WebElement goToCart = driver.findElement(By.cssSelector("a[href='/cart?ref_=sw_gtc']"));
        goToCart.click();


        WebElement ourBook = driver.findElement(By.className("a-truncate-cut"));
        String expectedBook = "Selenium Framework Design in Data-Driven Testing: Build data-driven test frameworks using Selenium WebDriver, AppiumDriver, Java, and TestNG";
        Assert.assertEquals(ourBook.getText(), expectedBook);

        WebElement expectedBook2Check=driver.findElement(By.cssSelector("img[alt='Selenium Framework Design in Data-Driven Testing: Build data-driven test frameworks using Selenium WebDriver, AppiumDriver, Java, and TestNG, Opens in a new tab']"));
        Assert.assertTrue(expectedBook2Check.isDisplayed());

        WebElement checkOutButton=driver.findElement(By.cssSelector("input[name='proceedToRetailCheckout']"));
        Assert.assertTrue(checkOutButton.isDisplayed());

        WebElement correctAuthorName=driver.findElement(By.cssSelector(".a-size-base.sc-product-creator"));
        String correctAuTThorName=correctAuthorName.getText();
        Assert.assertTrue(correctAuTThorName.contains("David Kopec"));

        WebElement checkIf1Item$40=driver.findElement(By.cssSelector("div[data-name='Subtotals']"));
        String actualNumberOfItemsAndPrice=checkIf1Item$40.getText();
        String expectedNumberOfItemsAndPrice="Subtotal (1 item): $46.00";
        Assert.assertEquals(actualNumberOfItemsAndPrice,expectedNumberOfItemsAndPrice);


        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        WebElement emptyCartMessage = driver.findElement(By.cssSelector(".a-size-large.a-spacing-top-base.sc-your-amazon-cart-is-empty"));
        wait.until(ExpectedConditions.visibilityOf(emptyCartMessage));


        boolean isPresent=false;
        try{
            isPresent=driver.findElement(By.cssSelector("img[alt='Selenium Framework Design in Data-Driven Testing: Build data-driven test frameworks using Selenium WebDriver, AppiumDriver, Java, and TestNG, Opens in a new tab']")).isDisplayed();
        } catch (Exception e){

        }
        Assert.assertFalse(isPresent);





    }
}
