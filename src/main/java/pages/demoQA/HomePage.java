package pages.demoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pojo.Element;

public class HomePage extends BasePage {

    @FindBy(how = How.XPATH, using = "//h5[contains(text(),'Elements')]")
    WebElement elementsCategory;

    @FindBy(how = How.XPATH, using = "//div[@class=\"home-content\"]")
    WebElement homeBanner;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitUntilVisible() throws TimeoutException {
        wait.until(isTrue -> homeBanner.isDisplayed());
    }

    @Override
    public boolean isVisible() {
        return homeBanner.isDisplayed();
    }

    public SandboxPage selectCategory(Element element) {
        WebElement category = driver
                .findElement(By.xpath("//h5[contains(text(),'" + element.getCategory() + "')]"));
        scrollToElementWithWait(category);
        category.click();

        return new SandboxPage(driver);
    }
}
