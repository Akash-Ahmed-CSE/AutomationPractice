package webtests;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.RegistrationPage;
import utilities.DriverSetup;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AutomationPracticeFormTest_DataReadFromCSV extends DriverSetup {


    RegistrationPage registrationPage = new RegistrationPage();
    BasePage basePage = new BasePage();
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

    }
}
