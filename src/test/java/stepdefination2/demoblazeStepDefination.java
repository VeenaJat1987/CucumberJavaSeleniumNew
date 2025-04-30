package stepdefination2;

import BaseClass.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import pageObjects.Demoblaze;
import utilities.ExcelReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class demoblazeStepDefination extends BaseClass {

    @Before
    public void setup() throws IOException
    {
        //Logging
        logger= Logger.getLogger("nopCommerceSDET");
        PropertyConfigurator.configure(".//src/test/java/resource/log4j.properties");
        logger.setLevel(Level.DEBUG);

        //Load properties file
        prop = new Properties();
        FileReader file = new FileReader(".//src/test/java/resource/config.properties");
        prop.load(file);

        String br=prop.getProperty("browser"); //getting the browser name from config.properties file

        //Launching browser
        if (br.equals("firefox")) {
             driver = new FirefoxDriver();
        }

        else if (br.equals("chrome")) {
            driver = new ChromeDriver();
        }

        else if (br.equals("ie")) {
            driver = new InternetExplorerDriver();
        }



    }

    @Given("User launch chrome browser")
    public void user_launch_chrome_browser() {
        logger.info("************* Launching Browser *****************");
        demoblaze= new Demoblaze(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @When("user opens URL {string}")
    public void user_opens_url(String url) {
        logger.info("************* Launching Demoblaze *****************");
        driver.get(url);
    }

    @When("User enter Username as {string} and Password as {string}")
    public void user_enter_username_as_and_password_as(String username, String password) {
        logger.info("************* entering username and password *****************");
        demoblaze.setUsername(username);
        demoblaze.setPassword(password);
    }
    @When("click on login btn")
    public void click_on_login_btn() {
        demoblaze.clickLoginbtn();
    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String value2) {
        logger.info("************* verifying the login page *****************");
        String value = driver.findElement(By.xpath("//h1[normalize-space()='Logged In Successfully']")).getText();
        if(value.equals(value2)){
            Assert.assertTrue(true);
        }
        else{
            Assert.fail();
        }
    }

    @When("User click on Logout link")
    public void user_click_on_logout_link() {
        logger.info("*************logging out *****************");
        demoblaze.clickLogout();
    }

    @After
    @Then("close browser")
    public void close_browser() {
        logger.info("************* quitting browser *****************");
        driver.quit();
    }

    @When("user opens URL")
    public void userOpensURL() throws IOException {
        logger.info("************* Launching Demoblaze *****************");
        driver.get(prop.getProperty("url"));
    }

    @And("User enter Username  and Password as")
    public void userEnterUsernameAndPasswordAs() {
        logger.info("************* entering username and password *****************");
        demoblaze.setUsername(prop.getProperty("username"));
        demoblaze.setPassword(prop.getProperty("password"));
    }


    @And("The user enter sheet {string} and {string} to get username and password")
    public void theUserEnterSheetAndToGetUsernameAndPassword(String Sheetname, String rownum) throws IOException, InvalidFormatException {
        ExcelReader reader=new ExcelReader();
        List<Map<String,String>> listLogin= reader.getData(excelpath, Sheetname);
        String uname=listLogin.get(Integer.parseInt(rownum)).get("Username");
        String pwd=listLogin.get(Integer.parseInt(rownum)).get("Password");
        System.out.println("username :"+uname+" "+pwd);
        demoblaze.setUsername_SetPassword(uname, pwd);
    }
}
