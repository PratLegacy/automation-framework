package pages.demoQA;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    protected Wait wait;

    public BasePage(WebDriver driver) {
        this(driver, true);
    }

    public BasePage(WebDriver driver, boolean waitUntilVisible) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new FluentWait<WebDriver>(driver)
                .pollingEvery(Duration.ofMillis(100))
                .withTimeout(Duration.ofSeconds(4))
                .ignoring(NoSuchElementException.class);
        if (waitUntilVisible) {
            waitUntilVisible();
        }
    }

    public abstract void waitUntilVisible() throws TimeoutException;

    public abstract boolean isVisible();

    /**
     * Scrolls to element and waits
     *
     * @param element
     * @return element
     */
    public void scrollToElementWithWait(WebElement element) {
        scrollToElement(element);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
