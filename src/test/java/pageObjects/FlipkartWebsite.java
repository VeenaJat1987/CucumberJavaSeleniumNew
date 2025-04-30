package pageObjects;


import BaseClass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static pageObjects.XpathValues.*;
import static pageObjects.XpathValues.mobileLink;

public class FlipkartWebsite extends BaseClass {


    //Constructors
    public FlipkartWebsite(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }

    //Locators

    @FindBy(xpath= XpathValues.mobileLink)
    WebElement mobileLink;

    @FindBy(xpath=XpathValues.appleMobileLink)
    WebElement appleMobileLink;

    @FindBy(xpath=XpathValues.iPhone13MobileLink)
    WebElement iPhone13MobileLink;

    @FindBy(xpath=XpathValues.iPhone16MobileLink)
    WebElement iPhone16MobileLink;

    @FindBy(xpath=XpathValues.iPhone15MobileLink)
    WebElement iPhone15MobileLink;

    @FindBy(xpath=XpathValues.googlePixel8MobileLink)
    WebElement googlePixel8MobileLink;

    @FindBy(xpath=XpathValues.goclickOnCartButton)
    WebElement goclickOnCartButton;

    @FindBy(xpath=XpathValues.cartQunatity)
    WebElement cartQunatity;

    @FindBy(xpath=XpathValues.removeElement_list)
    List<WebElement> removeElement_list;

    @FindBy(xpath= commonXapthOfProducts)
    List<WebElement> commonxpathOfProducts;

    @FindBy(xpath= cart_Link)
    WebElement cartLink;

    @FindBy(xpath= samsungMobile_Link)
    WebElement samsungMobileLink;


    //Action Methods

    public void clickMobileLink() {
        mobileLink.click();
    }

    public void clickAppleMobileLink() {
        appleMobileLink.click();
    }

    public void clickiPhone13MobileLink() {
        iPhone13MobileLink.click();
    }

    public void clickiPhone16MobileLink() {
        iPhone16MobileLink.click();
    }

    public WebElement  getiPhone15MobileLink() {
        return iPhone15MobileLink;
    }

    public WebElement getgooglePixel813MobileLink() {
        return googlePixel8MobileLink;
    }

    public String  getCartQunatity() {
        return cartQunatity.getText();
    }

    public void removeElement() {
        List<WebElement> removeElements = removeElement_list;
        for (WebElement remove : removeElements) {
            driver.navigate().refresh();
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.refreshed(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Remove')]"))));
            driver.findElement(By.xpath("//div[contains(text(),'Remove')]")).click();

            mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                    "//div[contains(text(),'Remove Item')]/following-sibling::div//div[contains(text(),'Remove')]")));
            element.click();

        }

    }

    public List<WebElement> clickOnCommonXpath(){
        return commonxpathOfProducts;
    }

    public void clickOnCartLink() {
        cartLink.click();
    }

    public void clickSamsungMobileLink() {
        samsungMobileLink.click();
    }


}
