package webtests;

import org.testng.annotations.Test;
import pages.BasePage;
import pages.RegistrationPage;
import utilities.DriverSetup;

public class AutomationPracticeFormTest_CheckFailureScreenshort extends DriverSetup {

    /*
    If my testcase fails the system will take a Screenshot automatically
    You will find all the Screenshots in location: "AutomationPractice\src\test\java\images"
    */
    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    public void testcasefaildCheck() throws InterruptedException{
        BasePage basePage = new BasePage();
        getDriver().get("https://demoqa.com/automation-practice-form");
        basePage.scrollToBottom();
        registrationPage.ClickSubmit();
        boolean successMessage = registrationPage.getSuccessmessagePresent();
        System.out.println(successMessage);
        assert successMessage : "Success message is not as expected.";
        basePage.takeScreenshot("src\\test\\java\\images\\image.jpg");
    }
}
