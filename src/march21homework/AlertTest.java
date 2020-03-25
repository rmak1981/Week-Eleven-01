package march21homework;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class AlertTest {
    private WebDriver driver;
    private JavascriptExecutor jse;


    @Before
    public void openBrowser (){
        String baseURL= "https://learn.letskodeit.com/";
        System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        jse = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseURL);
    }
    @Test
    public void alertClick() throws InterruptedException {
        driver.findElement(By.linkText("Practice")).click();
        Thread.sleep(2000);

        jse.executeScript("window.scrollBy(0,-1900)");
        WebElement alertBtn = driver.findElement(By.id("alertbtn"));
        alertBtn.click();
        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }
    @After
    public void closeBrowser () throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }


}
