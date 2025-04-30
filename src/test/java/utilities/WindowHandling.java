package utilities;

import BaseClass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WindowHandling extends BaseClass {
   public  String parent;

    public String parentWindowHandling(WebDriver driver){
        parent = driver.getWindowHandle();
        return parent;
    }

    public void windowHandlingThroughIndex(WebDriver driver) throws InterruptedException {
        this.driver=driver;
        Set windowHandles = driver.getWindowHandles();
        List<String> windowList = new ArrayList(windowHandles);
        String parentID = windowList.get(0);
        String childID = windowList.get(1);

        driver.switchTo().window(childID);

        for (int repeat = 0; repeat < 2; repeat++) {
            try {
                driver.navigate().refresh();
               // driver.findElement(By.xpath("//button[contains(@class,'QqFHMw vslbG+ In9uk2')]")).click();

                mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement element = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                        "//button[contains(@class,'QqFHMw vslbG+ In9uk2')]")));
                element.click();

            } catch (StaleElementReferenceException exc) {
                System.out.println(exc.getMessage());
                exc.printStackTrace();
            }

        }
        Thread.sleep(1000);
    }


    public void windowHandlingThroughIterator(WebDriver driver) throws InterruptedException {
        this.driver=driver;
        parent = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        String ChildWindow;
        while (i1.hasNext()) {
            ChildWindow = i1.next();
            if (!parent.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);

                for (int repeat = 0; repeat < 2; repeat++) {
                    try {
                        driver.navigate().refresh();
                        driver.findElement(By.xpath("//button[contains(@class,'QqFHMw vslbG+ In9uk2')]")).click();

                    } catch (StaleElementReferenceException exc) {
                        System.out.println(exc.getMessage());
                        exc.printStackTrace();
                    }

                }
    }
}Thread.sleep(1000);
    }


}
