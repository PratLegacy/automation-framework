package tests;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.demoQA.HomePage;
import pojo.Element;
import pojo.UserDetails;
import utils.loggers.Log;

import java.lang.reflect.Method;

import static utils.extentReports.ExtentTestManager.startTest;

public class VerifyTextBox extends BaseTest {

   // private static final Logger LOG = Logger.getLogger(VerifyTextBox.class);

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        driverSetup();
    }

    @Parameters({"category", "subCategory"})
    @Test(description = "Verify the functionality of text box element")
    public void verifyTextBoxOutputData(@Optional("Elements") String category, @Optional("Text Box") String subCategory, Method method) {
        SoftAssert softAssert = new SoftAssert();
        startTest(method.getName(), "Verify the functionality of text box element");

        Element element = new Element(category, subCategory);
        UserDetails user = new UserDetails("Prathik", "prat@gmail.com", "b-007", "perm");
        HomePage homePage = new HomePage(driver);

        Log.info("Validating Text box operations");
        UserDetails userToVerify = homePage.selectCategory(element)
                .selectSubCategory(element)
                .setTextboxDetails(user)
                .getTextboxDetails();

        Log.info("Validating Text box data");
        softAssert.assertEquals(userToVerify.getFullName(),
                user.getFullName(),
                "Name mismatch");

        softAssert.assertEquals(userToVerify.getEmail(),
                user.getEmail(),
                "Email mismatch");

        softAssert.assertEquals(userToVerify.getCurrentAddress(),
                user.getCurrentAddress(),
                "Current Address mismatch");

        softAssert.assertEquals(userToVerify.getPermanentAddress(),
                user.getPermanentAddress(),
                "Permanent Address mismatch");

        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driverTearDown();
    }
}
