package pageObjects;


import BaseClass.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestAutomationWebsite extends BaseClass {

    WebDriver driver;
    //Constructors
    public TestAutomationWebsite(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    //Locators

    @FindBy(id="name")
    WebElement txt_username;

    @FindBy(id="email")
    WebElement txt_email;

    @FindBy(id="phone")
    WebElement txt_phone;

    @FindBy(id="datepicker")
    WebElement click_date;

    @FindBy(xpath="//span[@class='ui-datepicker-month']")
    WebElement currentmonth;

    @FindBy(xpath="//span[@class='ui-datepicker-year']")
    WebElement currentyear;

    @FindBy(xpath="//input[@id='singleFileInput']")
    WebElement singleFile;

    @FindBy(xpath="//button[text()='Upload Single File']")
    WebElement singleFileBtn;

    @FindBy(id="singleFileStatus")
    WebElement singleFileText;

    @FindBy(id="multipleFilesInput")
    WebElement multipleFile;

    @FindBy(xpath="//button[text()='Upload Multiple Files']")
    WebElement multipleFileBtn;

    @FindBy(id="multipleFilesStatus")
    WebElement multipleFileText;

    @FindBy(id="textarea")
    WebElement txt_address;


    //Action Methods

    public void setName(String user) {
        txt_username.clear();
        txt_username.sendKeys(user);
    }

    public void setEmail(String email) {
        txt_email.clear();
        txt_email.sendKeys(email);
    }

    public void setPhone(String phone) {
        txt_phone.clear();
        txt_phone.sendKeys(phone);
    }

    public void setDate() {
        click_date.clear();
        click_date.click();
    }

    public String getMonth() {
       return( currentmonth.getText());
    }

    public String getYear() {
       return( currentyear.getText());
    }

    public void setFilename() {
        singleFile.clear();
        singleFile.sendKeys(BaseClass.file1);
    }

    public void clickSingleFilenameBtn() {
        singleFileBtn.click();
    }

    public String getSingleFileName() {
        return( singleFileText.getText());
    }

    public void setMultipleFilename() {
        multipleFile.clear();
        multipleFile.sendKeys(BaseClass.file1);
        multipleFile.sendKeys(BaseClass.file2);
    }

    public void clickMultipleFilenameBtn() {
        multipleFileBtn.click();
    }

    public String getMultipleFileName() {
        return( multipleFileText.getText());
    }
    public void setAddress(String address) {
        txt_address.clear();
        txt_address.sendKeys(address);
    }

}
