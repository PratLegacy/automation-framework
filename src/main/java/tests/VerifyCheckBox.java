package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.demoQA.HomePage;
import pojo.Element;
import pojo.UserDetails;
import utils.loggers.Log;

import java.lang.reflect.Method;

import static utils.extentReports.ExtentTestManager.startTest;

public class VerifyCheckBox extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        driverSetup();
    }

    @Parameters({"category", "subCategory"})
    @Test(description = "Verify the functionality of check box element")
    public void verifyCheckBoxOutputData(String category, String subCategory, Method method) throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        startTest(method.getName(), "Verify the functionality of check box element");

        Element element = new Element(category, subCategory);
        UserDetails user = new UserDetails("Prathik", "prat@gmail.com", "b-007", "perm");
        HomePage homePage = new HomePage(driver);

        Log.info("Validating Check box operations");
        homePage.selectCategory(element)
                .selectSubCategory(element);
        Thread.sleep(1000);
        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driverTearDown();
    }
}
