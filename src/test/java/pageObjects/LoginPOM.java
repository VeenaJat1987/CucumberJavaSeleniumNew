package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {

    WebDriver driver;
    //Constructors
    public LoginPOM(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    //Locators

    @FindBy(id="Email")
    WebElement txt_email;

    @FindBy(id="Password")
    WebElement txt_password;

    @FindBy(xpath="//button[normalize-space()='Log in']")
    WebElement btn_login;

    @FindBy(linkText = "Logout")
    WebElement link_logout;


    //Action Methods

    public void setEmail(String user) {
        txt_email.clear();
        txt_email.sendKeys(user);
    }

    public void setPassword(String pwd) {
        txt_password.clear();
        txt_password.sendKeys(pwd);
    }

    public void clickLogin() {
        btn_login.click();
    }

    public void clickLogout() {
        link_logout.click();
    }

}
