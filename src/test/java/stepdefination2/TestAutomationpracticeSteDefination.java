package stepdefination2;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.DatabaseConnection;
import utilities.ExcelDataProvider;
import utilities.SelectFutureAndPastDates;
import BaseClass.BaseClass;
import BaseClass.Elements;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.yaml.snakeyaml.Yaml;
import pageObjects.TestAutomationWebsite;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.*;

import static utilities.DatabaseConnection.*;

public class TestAutomationpracticeSteDefination  extends BaseClass {
    @Before
    public void setup() throws IOException
    {
        //yaml file
        yaml = new Yaml();
        InputStream inputStream = new FileInputStream(".//src/test/java/resource/Elements.yml");
        data = yaml.load(inputStream);

      driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        testAutomation = new TestAutomationWebsite(driver);
        excelDataProvider = new ExcelDataProvider();
        dataBaseConnection = new DatabaseConnection();
    }

    @Given("User launch browser")
    public void user_launch_browser() {
    System.out.println("URL launched");
    driver.manage().window().maximize();
    }

    @When("user opens URL of testautomationpractice website")
    public void user_opens_url_of_testautomationpractice_website() {
        driver.get((String) data.get("url"));
    }

    @When("^User enter Name, Email and Phone$")
    public void user_enter_name_email_and_phone(DataTable elements) throws InterruptedException {

        for (Map<String, String> data : elements.asMaps(String.class, String.class)) {
            testAutomation.setName(data.get("Name"));
            testAutomation.setEmail(data.get("Email"));
            testAutomation.setPhone(data.get("Phone"));

            Thread.sleep(5000);
        }

    }
    @When("quit the browser")
    public void quit_the_browser() {
        driver.quit();
    }

    @And("Enter value to date field")
    public void enterValueToDateField() throws InterruptedException {
        testAutomation.setDate();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        // Get the date using calendar object
       // Date today = Calendar.getInstance()                .getTime();

        // Convert the date into a
        // string using format() method
        String dateToString = df.format(data.get("date"));

        SelectFutureAndPastDates.compare_convertToDateFormat(dateToString, driver);
        Thread.sleep(5000);
    }

    @And("display the value of the table with names and their CPU value")
    public void displayTheValueOfTheTableWithNamesAndTheirCPUValue() {

        List<WebElement> columnnames = driver.findElements(By.xpath("//table[@id='taskTable']/thead/tr[@id='headers']/th"));
        for(int i=0;i<=4;i++) {
            String nameofcolumns = columnnames.get(i).getText();

            if(nameofcolumns.equalsIgnoreCase("CPU (%)")) {
                System.out.println("I value: " + i);
                System.out.println(nameofcolumns);
                int c= ++i;

                for(int j=1;j<=4;j++) {
                    WebElement CPUvalue = driver.findElement(By.xpath("//table[@id='taskTable']/tbody[@id='rows']/tr["+j+"]/td["+ c +"]"));
                    WebElement rowName = driver.findElement(By.xpath("//table[@id='taskTable']/tbody[@id='rows']/tr["+j+"]/td[1]"));
                    System.out.println(CPUvalue.getText() + ":" + rowName.getText());
                }
                break;
            }
        }
    }

    @And("capture all the values in each page of the table and select the check boc.")
    public void captureAllTheValuesInEachPageOfTheTableAndSelectTheCheckBoc() {

        List<WebElement> pageNumbers = driver.findElements(By.xpath("//ul[@id='pagination']/li/a"));
        for(WebElement pageNum : pageNumbers) {
            String num = pageNum.getText();
            pageNum.click();

            for(int j=1;j<=5;j++) {
                String productname = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+ j +"]/td[2]")).getText();
                String productPrice = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+ j +"]/td[3]")).getText();
                WebElement CheckBox = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+ j +"]/td[4]/input"));

                System.out.println(productname +" :" + productPrice);
                CheckBox.click();
            }
        }
    }

    @And("Upload Single file")
    public void uploadSingleFile() {
        testAutomation.setFilename();
        testAutomation.clickSingleFilenameBtn();
        
    }

    @Then("Verify the File Name {string}in browser")
    public void verifyTheFileNameInBrowser(String filename) {
        String value = testAutomation.getSingleFileName();
        Assert.assertTrue(value.contains(filename));
    }

    @Then("Verify the File Names {string} and {string} in browser")
    public void verifyTheFileNamesAndInBrowser(String file1, String file2) {
        String value = testAutomation.getMultipleFileName();
        Assert.assertTrue(value.contains(file1));
        Assert.assertTrue(value.contains(file2));
    }

    @And("Upload Multiple file")
    public void uploadMultipleFile() {
        testAutomation.setMultipleFilename();
        testAutomation.clickMultipleFilenameBtn();
    }

    @DataProvider(name="users")
    public Object[][] getTheTestdataUsingDataproviderOfTestng() throws IOException {
        Object[][] data = excelDataProvider.getTestData("Sheet1");
        return data;

    }

    @Test(dataProvider = "users")
    @Then("Verify the exceldata in specific fields.")
    public void verifyTheExceldataInSpecificFields(String name, String email, String phone, String address) throws InterruptedException {
        testAutomation.setName(name);
        testAutomation.setPhone(phone);
        testAutomation.setEmail(email);
        testAutomation.setAddress(address);
        Thread.sleep(2000);
    }

    @And("provide data to fields from database")
    public void provideDataToFieldsFromDatabase() throws SQLException, ClassNotFoundException {
        dataBaseConnection.createDataBaseConnection();
        try {
            // SQL query to retrieve worker from the database
            String query = "Select * from Datas";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            // Iterate through the result set and print worker details
            while (resultSet.next()) {
                testAutomation.setName(resultSet.getString("Name"));
                testAutomation.setPhone(resultSet.getString("Phone"));
                testAutomation.setEmail(resultSet.getString("Email"));
                testAutomation.setAddress(resultSet.getString("Address"));
                Thread.sleep(5000);
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    @And("quit the browser and database connection")
    public void quitTheBrowserAndDatabaseConnection() {
        if (connection != null) {
            try {
                System.out.println("Closing Database Connection...");
                connection.close();
            } catch (Exception error) {
                error.printStackTrace();
            }
        }

        driver.quit();
    }
}
