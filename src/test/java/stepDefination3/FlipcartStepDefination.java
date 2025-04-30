package stepDefination3;

import BaseClass.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.FlipkartWebsite;
import utilities.WindowHandling;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class FlipcartStepDefination extends BaseClass {
    String OriginalcartNumber;
    String currentCartNumber;
    int countOfproducts;

    @Before
    public void setup() throws IOException
    {
      driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Load properties file
        prop = new Properties();
        FileReader file = new FileReader(".//src/test/java/resource/config.properties");
        prop.load(file);
        windowhandling = new WindowHandling();
        flipkart = new FlipkartWebsite(driver);

    }

    @Given("User launch chromebrowser")
    public void user_launch_chromebrowser() {
        System.out.println("URL launched");
    }

    @When("User opens URL of flipkart website")
    public void user_opens_url_of_flipkart_website() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(prop.getProperty("url2"));
        driver.manage().window().maximize();
    }

    @When("User go to particular product section")
    public void user_go_to_particular_product_section() throws InterruptedException {
        flipkart.clickMobileLink();
       // flipkart.clickAppleMobileLink();
        flipkart.clickSamsungMobileLink();
    }

    @When("User add products to cart")
    public void user_add_products_to_cart() throws InterruptedException {
        flipkart.clickiPhone13MobileLink();
        windowhandling.windowHandlingThroughIndex(driver);
        driver.close();
        System.out.println("Child window closed");
        driver.switchTo().window(windowhandling.parent);
        flipkart.clickiPhone16MobileLink();
        windowhandling.windowHandlingThroughIterator(driver);
    }

    @Then("Verify the qunatity of products in cart")
    public void verify_the_qunatity_of_products_in_cart() {
        OriginalcartNumber = flipkart.getCartQunatity();
        System.out.println(OriginalcartNumber);

        String s = OriginalcartNumber.substring(OriginalcartNumber.indexOf("(")+1, OriginalcartNumber.indexOf("items)")-1);
        countOfproducts = Integer.parseInt(s);
        System.out.println("count: " + countOfproducts);

    }

    @When("User delete the products")
    public void user_delete_the_products() throws InterruptedException {
        flipkart.removeElement();

        Thread.sleep(2000);
       // driver.close();
       // System.out.println("Child window closed");
    driver.navigate().back();
        Thread.sleep(2000);
    }

    @When("User add the products to the cart")
    public void user_add_the_products_to_the_cart() throws InterruptedException {
        driver.switchTo().window(windowhandling.parent);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement colors = flipkart.getiPhone15MobileLink();
        js.executeScript("arguments[0].click()", colors);
        windowhandling.windowHandlingThroughIterator(driver);

        driver.close();
        System.out.println("Child window closed");
        driver.switchTo().window(windowhandling.parent);

        WebElement colors1 = flipkart.getgooglePixel813MobileLink();
        js.executeScript("arguments[0].click()", colors1);//
        windowhandling.windowHandlingThroughIterator(driver);// click operation
    }

    @Then("verify the current products quantity with original product quantity before deleting")
    public void verify_the_current_products_quantity_with_original_product_quantity_before_deleting() {
        currentCartNumber = flipkart.getCartQunatity();
        System.out.println(currentCartNumber);
        Assert.assertEquals(OriginalcartNumber, currentCartNumber);
    }

    @After
    @Then("User quit the browser")
    public void user_quit_the_browser() {
        driver.quit();
    }

    @And("User add products to cart using common xpath of products")
    public void userAddProductsToCartUsingCommonXpathOfProducts() throws InterruptedException {

    List<WebElement> products = flipkart.clickOnCommonXpath();
        for(int i=1;i<=5;i++) {
            products.get(i).click();
            windowhandling.windowHandlingThroughIterator(driver);
            driver.close();
            System.out.println("Child window closed");
            driver.switchTo().window(windowhandling.parent);
        }
        flipkart.clickOnCartLink();

    }

    @And("User add products as per count considering the previous added cart quantity")
    public void userAddProductsAsPerCountConsideringThePreviousAddedCartQuantity() throws InterruptedException {
/*        driver.get(prop.getProperty("url2"));
        flipkart.clickMobileLink();
        // flipkart.clickAppleMobileLink();
        flipkart.clickSamsungMobileLink();*/

        List<WebElement> products = flipkart.clickOnCommonXpath();
        for(int i=1;i<=countOfproducts;i++) {
            products.get(i).click();
            Thread.sleep(3000);
            windowhandling.windowHandlingThroughIterator(driver);
            driver.close();
            System.out.println("Child window closed");
            driver.switchTo().window(windowhandling.parent);
        }
        flipkart.clickOnCartLink();


    }
}
