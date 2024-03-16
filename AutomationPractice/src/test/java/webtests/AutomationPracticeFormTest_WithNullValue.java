package webtests;


import org.testng.annotations.Test;
import pages.BasePage;
import pages.RegistrationPage;
import utilities.DriverSetup;


public class AutomationPracticeFormTest_WithNullValue extends DriverSetup {
    RegistrationPage registrationPage = new RegistrationPage();
    @Test

    public void blanktest() throws InterruptedException{
        BasePage basePage = new BasePage();
        getDriver().get("https://demoqa.com/automation-practice-form");
        basePage.scrollToBottom();
        registrationPage.ClickSubmit();
        boolean successMessage = registrationPage.getSuccessmessagePresent();
        System.out.println(successMessage);
        assert !successMessage : "Success message is not as expected.";
        basePage.takeScreenshot("src\\test\\java\\images\\Test2.jpg");
    }
}
