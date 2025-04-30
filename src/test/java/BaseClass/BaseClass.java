package BaseClass;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.yaml.snakeyaml.Yaml;
import pageObjects.Demoblaze;
import pageObjects.FlipkartWebsite;
import pageObjects.TestAutomationWebsite;
import pageObjects.XpathValues;
import utilities.DatabaseConnection;
import utilities.ExcelDataProvider;
import utilities.SelectFutureAndPastDates;
import utilities.WindowHandling;

import java.util.Map;
import java.util.Properties;

public class BaseClass {

    public WebDriver driver;
    public Demoblaze demoblaze;
    public Properties prop;
    public static Logger logger;
    ////excel data
    public String excelpath =".//src/test/java/resource/Demoblaze.xlsx";
   public  Yaml yaml;
    public Map<String, Object> data;
    public TestAutomationWebsite testAutomation;
    public SelectFutureAndPastDates dateSelection;

    public static String file1 ="D://Selenium/IntelliIDEWorkspace/CucumberJavaSelenium/src/test/java/resource/samplefile.png";
    public static String file2 ="D://Selenium/IntelliIDEWorkspace/CucumberJavaSelenium/src/test/java/resource/bhuvan_project_computer.png";
    public String excelpath2 =".//src/test/java/resource/TestAutomationsampleExcel.xlsx";
    public ExcelDataProvider excelDataProvider;
    public DatabaseConnection dataBaseConnection = new DatabaseConnection();

   public  FlipkartWebsite flipkart ;
    public WindowHandling windowhandling;
    public WebDriverWait mywait;
    public XpathValues xpath;
}
