import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class healthCareServiceTest {

    @Test
    public void TestLogIn(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hothaifa\\Desktop\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        WebElement makeAppBtn = driver.findElement(By.id("btn-make-appointment"));
        makeAppBtn.click();
        String expectedUrl = "https://katalon-demo-cura.herokuapp.com/profile.php#login";
        String acctualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,acctualUrl);

        //login section
        String email = "John Doe";
        String password="ThisIsNotAPassword";
        WebElement emailTB= driver.findElement(By.id("txt-username"));
        WebElement passwordTB= driver.findElement(By.id("txt-password"));

        emailTB.sendKeys(email);
        passwordTB.sendKeys(password);
        WebElement loginBtn = driver.findElement(By.id("btn-login"));
        loginBtn.click();

        String actualText = driver.findElement(By.cssSelector("#appointment > div > div > div > h2")).getText();
        String expectedText = "Make Appointment";

        Assert.assertEquals(expectedText,actualText);

    }
    @Test
    public void TestmakeApp(){
        
    }
}
