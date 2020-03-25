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
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BookTab {
    private WebDriver driver;
    private JavascriptExecutor jse;

    @Before
    public void openBrowser() {
        String baseUrl = "https://demo.nopcommerce.com/";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        jse = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateBookPage() throws InterruptedException {
        //Mouse hover to Books Tab perform
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//li[5]"))).perform();
        Thread.sleep(2000);
        // click on Books Tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Books')]")).click();
        Thread.sleep(2000);
        //verify User on Books page with text shown above
        WebElement assertText = driver.findElement(By.className("page-title"));
        String expectedText = "Books";
        String actualText = assertText.getText();
        Assert.assertEquals(expectedText, actualText);
    }
    //    @Test
//    public void sortByBooksAtoZPosition() throws InterruptedException {
//
//        driver.findElement(By.id("products-orderby")).click();
//        WebElement dropDownAtoZ = driver.findElement(By.xpath("//*[@id=\\\"products-orderby\\\"]"));
//        Thread.sleep(2000);
//        Select select = new Select(dropDownAtoZ);
//        select.selectByVisibleText("Name: A to Z");
//
////        jse.executeScript("window.scrollBy(0,-2000)");
////        //driver.findElement(By.xpath("//select[@id='products-orderby']")).click();
////        Thread.sleep(2000);
//        //WebElement element = driver.findElement(By.xpath("//option[contains(text(),'Name: A to Z')]"));
////        Thread.sleep(2000);
////        Select select = new Select(element);
////        select.selectByIndex(1);
////        Select dropdownAtoZ = new Select(driver.findElement(By.linkText("products-orderby")));
////        dropdownAtoZ.selectByVisibleText("Name: A to Z");
//        driver.findElement(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//input[3]")).click();
//        Thread.sleep(2000);

    @Test
    public void USerShouldVerifyBookByATZ() throws InterruptedException {
        driver.findElement(By.linkText("Books")).click();
        // WebElement assertText = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Books')]"));
        driver.findElement(By.xpath("//select[@id='products-orderby']"));

        //Web element position
        WebElement positionDropDown = driver.findElement(By.cssSelector("select#products-orderby"));

        Select select = new Select(positionDropDown);
        select.selectByIndex(1);
        Thread.sleep(2000);
        //scroll down page
        jse.executeScript("window.scrollBy(0,500);");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//input[1]")).click();
        WebElement assertTex = driver.findElement(By.xpath("//p[@class='content']"));
        String expectedText = "The product has been added to your shopping cart";
        String actualTex = assertTex.getText();
        Assert.assertEquals(expectedText, actualTex);

//        WebElement aToZ = driver.findElement(By.xpath("//select[@id='products-orderby']"));
//        aToZ.getText();
//        ArrayList<String> getList = new ArrayList<>(); // array list to get elements form web page
//        List<WebElement>elementList = driver.findElements(By.className("product-title"));
//        System.out.println("Product List"+getList);
//        ArrayList<String> sortedList = new ArrayList<>();
//        sortedList.addAll(getList);
//        Collections.sort(sortedList);
//        Assert.assertTrue(getList.equals(sortedList));
//        System.out.println("Sorted Product List"+ sortedList);
    }
//    @Test
//    public void bookAddedToWishlistSuccessfully() throws InterruptedException {
//        //WebElement Books Link
//        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//li[5]/a")).click();
//        //WebElement Position dropdown box
//        WebElement positionDropDown = driver.findElement(By.cssSelector("select#products-orderby"));
//        Select select = new Select(positionDropDown);
//        Thread.sleep(2000);
//        select.selectByIndex(1);
//        //Scroll down page
//        jse.executeScript("window.scrollBy(0, 500);");
//        Thread.sleep(2000);
//        //WebElement for wishlist button
//        driver.findElement(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//input[3]")).click();
//        WebElement itemAddedToWishlist = driver.findElement(By.xpath("//p[@class='content']"));
//        String expectedTxt = "The product has been added to your wishlist";
//        String actualTxt = itemAddedToWishlist.getText();
//        Assert.assertEquals(expectedTxt, actualTxt);
//    }


    @After
    public void closeBrowser() {
        driver.quit();
    }
}

