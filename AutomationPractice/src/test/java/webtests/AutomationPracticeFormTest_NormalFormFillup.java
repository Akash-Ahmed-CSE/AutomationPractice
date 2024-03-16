package webtests;

import org.testng.annotations.Test;
import pages.BasePage;
import pages.RegistrationPage;
import utilities.DriverSetup;

public class AutomationPracticeFormTest_NormalFormFillup extends DriverSetup {
    RegistrationPage registrationPage = new RegistrationPage();

    //Normal Test inputting value from the code
    @Test
    public void loginTest() throws InterruptedException {
        getDriver().get("https://demoqa.com/automation-practice-form");
        BasePage basePage = new BasePage();

        registrationPage.firstName("Akash");
        registrationPage.lastName("Ahmed");
        registrationPage.email("akashahmed@gmail.com");
        registrationPage.gender();
        registrationPage.MobileNumber("09989877661");
        registrationPage.setDateOfBirth("1999","June","10");
        registrationPage.subject("Science");
        basePage.scrollToBottom();
        registrationPage.getHobbies("Sports");
        registrationPage.setUPLOADPICURE("F:\\AutomationPractice\\AutomationPractice\\src\\test\\java\\webtests\\resources\\img\\Screenshot_1.png");
        registrationPage.getCurrentAddress("Savar,Dhaka,Bangladesh");
        registrationPage.ClickSubmit();
        String successMessage = registrationPage.getSuccessmessage();
        assert successMessage.equals("Thanks for submitting the form") : "Success message is not as expected.";
        basePage.takeScreenshot("src\\test\\java\\images\\Test1.jpg");
        registrationPage.closebutton();
        Thread.sleep(3000);

    }
}
