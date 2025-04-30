package stepdefination;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.LoginPOM;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class LoginStepDefination {

   WebDriver driver;
    LoginPOM loginpage;

    @Given("User launch chrome browser")
    public void user_launch_chrome_browser() {
        ChromeOptions options = new ChromeOptions();
        File file =  new File("D://Selenium//SelectorsHub-Chrome-Web-Store.crx");
        options.addExtensions(file);
        options.addArguments("--start-maximized");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        driver= new ChromeDriver(options);
        loginpage= new LoginPOM(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @When("user opens URL {string}")
    public void user_opens_url(String url) {
        driver.get(url);
    }
    @When("User enter emailid as {string} and password as {string}")
    public void user_enter_emailid_as_and_password_as(String email, String password) {
        loginpage.setEmail(email);
        loginpage.setPassword(password);
    }
    @When("click on login")
    public void click_on_login() {
        loginpage.clickLogin();
       // new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@src, 'https://challenges.cloudflare.com')]")));
       // new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.recaptcha-checkbox-checkmark"))).click();
        // In Selenium/WebDriver (JavaScript with WebDriverIO, for example)


/*        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

// Switch to iframe
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@title='Widget containing a Cloudflare security challenge']")));

// Click the checkbox (will only work if it's not a real CAPTCHA)
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='checkbox']")));
        checkbox.click();

// Return to default content
        driver.switchTo().defaultContent();*/
    }
    @Then("Page title should be {string}")
    public void page_title_should_be(String title) {
        if(driver.getPageSource().contains("Login was unsuccessful")){
            driver.close();
            Assert.fail();
        }
        else{
            Assert.assertEquals(title, driver.getTitle());
        }
    }
    @When("User click on Logout link")
    public void user_click_on_logout_link() {
        loginpage.clickLogout();
    }
    @Then("close browser")
    public void close_browser() {
        driver.quit();
    }

}
