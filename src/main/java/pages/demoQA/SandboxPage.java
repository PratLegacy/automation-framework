package pages.demoQA;

import enums.SubCategory;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pojo.Element;
import pojo.UserDetails;

public class SandboxPage extends BasePage {

    @FindBy(how = How.ID, using = "submit")
    WebElement submit;

    @FindBy(how = How.ID, using = "userName")
    WebElement textBox_fullName;

    @FindBy(how = How.ID, using = "userEmail")
    WebElement textBox_email;

    @FindBy(how = How.ID, using = "name")
    WebElement textBoxOutput_fullName;

    @FindBy(how = How.ID, using = "email")
    WebElement textBoxOutput_email;

    @FindBy(how = How.XPATH, using = "//p[@id=\"currentAddress\"]")
    WebElement textBoxOutput_currAdd;

    @FindBy(how = How.XPATH, using = "//p[@id=\"permanentAddress\"]")
    WebElement textBoxOutput_perAdd;

    @FindBy(how = How.ID, using = "currentAddress")
    WebElement textBox_currentAddress;

    @FindBy(how = How.ID, using = "permanentAddress")
    WebElement textBox_permanentAddress;

    @FindBy(how = How.XPATH, using = "//div[@class=\"container playgound-body\"]")
    WebElement sandbox;

    public SandboxPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitUntilVisible() throws TimeoutException {
        wait.until(isTrue -> sandbox.isDisplayed());
    }

    @Override
    public boolean isVisible() {
        return sandbox.isDisplayed();
    }

    public SandboxPage selectSubCategory(Element element) {
        WebElement subCategory = driver
                .findElement(By.xpath("//li/span[text()='"+element.getSubCategory()+"']"));
        scrollToElementWithWait(subCategory);
        subCategory.click();
        return new SandboxPage(driver);
    }

    public SandboxPage setTextboxDetails(UserDetails user) {
        wait.until(isTrue -> textBox_fullName.isDisplayed());
        textBox_fullName.sendKeys(user.getFullName());
        textBox_email.sendKeys(user.getEmail());
        textBox_currentAddress.sendKeys(user.getCurrentAddress());
        textBox_permanentAddress.sendKeys(user.getPermanentAddress());

        scrollToElement(submit);
        submit.click();
        return new SandboxPage(driver);
    }

    public UserDetails getTextboxDetails() {
        scrollToElementWithWait(textBoxOutput_fullName);
        String name = textBoxOutput_fullName.getText();
        String email = textBoxOutput_email.getText();
        String currAdd = textBoxOutput_currAdd.getText();
        String permAdd = textBoxOutput_perAdd.getText();

        return new UserDetails(name.split(":")[1],
                email.split(":")[1],
                currAdd.split(":")[1],
                permAdd.split(":")[1]);
    }
}
