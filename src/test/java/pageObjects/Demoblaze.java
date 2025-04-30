package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Demoblaze {

    WebDriver driver;
    //Constructors
    public Demoblaze(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    //Locators

    @FindBy(id="username")
    WebElement txt_username;

    @FindBy(id="password")
    WebElement txt_password;

    @FindBy(xpath="//button[@id='submit']")
    WebElement btn_login;

    @FindBy(xpath = "//a[normalize-space()='Log out']")
    WebElement link_logout;


    //Action Methods

    public void setUsername(String user) {
        txt_username.clear();
        txt_username.sendKeys(user);
    }

    public void setPassword(String pwd) {
        txt_password.clear();
        txt_password.sendKeys(pwd);
    }

    public void clickLoginbtn() {

        btn_login.click();
    }

    public void clickLogout() {

        link_logout.click();
    }

    public void setUsername_SetPassword(String user, String pwd) {
        txt_username.clear();
        txt_username.sendKeys(user);
        txt_password.clear();
        txt_password.sendKeys(pwd);
    }

}
