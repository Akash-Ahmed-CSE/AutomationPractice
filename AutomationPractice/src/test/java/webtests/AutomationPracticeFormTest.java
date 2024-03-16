package webtests;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.RegistrationPage;
import utilities.DriverSetup;

import java.io.FileReader;

public class AutomationPracticeFormTest extends DriverSetup {
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

//    RegistrationPage registrationPage = new RegistrationPage();

    @DataProvider()
    public Object[][] getStudentRegistrationData() {
        String csvFilePath = "src/test/java/Data/data.csv";

        List<String[]> data = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            data = reader.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }

        Object[][] dataArray = new Object[data.size()][6]; // Assuming there are 6 columns in your CSV file
        for (int i = 0; i < data.size(); i++) {
            String[] row = data.get(i);
            for (int j = 0; j < 6; j++) {
                dataArray[i][j] = row[j]; // Assuming there are 6 columns in your CSV file
            }
        }

        return dataArray;
    }
    //Testcase done from the CSV file
    @Test(dataProvider = "getStudentRegistrationData")
    public void studentRegistrationTest(String firstName, String lastName, String email, String mobileNumber, String subject, String currentAddress) throws InterruptedException {
        getDriver().get("https://demoqa.com/automation-practice-form");
        BasePage basePage = new BasePage();
        registrationPage.firstName(firstName);
        registrationPage.lastName(lastName);
        registrationPage.email(email);
        registrationPage.gender();
        registrationPage.MobileNumber(mobileNumber);
        registrationPage.setDateOfBirth("1999", "June", "10");
        registrationPage.subject(subject);
        basePage.scrollToBottom();
        registrationPage.getCurrentAddress(currentAddress);
        registrationPage.ClickSubmit();
        registrationPage.closebutton();
        Thread.sleep(3000);
    }



//    //New test case to check of null vale lets the user to save the vale
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

    /*
        If my testcase failes the system will take a Screenshot automatically
        You will find all the Screenshots in location: "AutomationPractice\src\test\java\images"
        */
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
