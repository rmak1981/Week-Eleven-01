package march21homework;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class ComputerTab {

    private WebDriver driver;
    private JavascriptExecutor jse;

    @Before
    public void openBrowser() {
        String baseURL1 = "https://demo.nopcommerce.com/"; // set the property
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");//declare driver
        driver = new ChromeDriver();
        jse = (JavascriptExecutor) driver; // driver to scroll
        driver.manage().window().maximize();//maximize window
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(baseURL1);//open url
    }

    @Test
    public void userShudNavigateToComputerPage() {
        //click on computers
        driver.findElement(By.linkText("Computers")).click();
        WebElement assertText = driver.findElement((By.xpath("//div[@class='page-title']/h1")));
        String expectedText = "Computers";
        String actualText = assertText.getText();
        Assert.assertEquals(actualText, expectedText);
    }
    @Test
    public void Computer() throws InterruptedException {
        Actions actions = new Actions(driver);
        // actions to mouse over movement and to perform
        actions.moveToElement(driver.findElement((By.xpath("//body/div[@class='master-wrapper-page']/div[@class='header-menu']/ul[@class='top-menu notmobile']/li[1]")))
        ).perform();
        // to select desktop dropdown
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Desktops')]")).click();
        // scroll down
        jse.executeScript("window.scrollBy(0,-2000);");
        driver.findElement(By.linkText("Build your own computer")).click();
        Thread.sleep(2000);
        //select 400 gb hd and scroll down
        jse.executeScript("window.scrollBy(0,-3000);");
        Thread.sleep(2000);
        WebElement radioBtn = driver.findElement(By.xpath("//input[@id='product_attribute_3_7']"));
        radioBtn.click();
        Thread.sleep(2000);

        driver.findElement(By.id("product_attribute_3_7"));
        Thread.sleep(2000);
        //add to cart
        jse.executeScript("window.scrollBy(0,1500)");
        driver.findElement(By.id("add-to-cart-button-1")).click();
        Thread.sleep(2000);
        // verify add to cart text
        WebElement assertText = driver.findElement(By.xpath("//p[@class='content']"));
        String expectedText = "The product has been added to your shopping cart";
        String actualText = assertText.getText();
        Assert.assertEquals(expectedText,actualText);
    }
    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }

}
