package pages;

import org.openqa.selenium.By;

public class RegistrationPage extends BasePage{
    //Locators
    private By FIRST_NAME = By.cssSelector("#firstName");
    private By LAST_NAME = By.cssSelector("#lastName");
    private By EMAIL = By.xpath("//input[@id='userEmail']");
    private By GENDER = By.xpath("//label[normalize-space()='Male']");
    private By MOBILENUM = By.id("userNumber");
    private By dateOfBirthInputLocator  = By.xpath("//input[@id='dateOfBirthInput']");
    private By yearLocator  = By.cssSelector(".react-datepicker__year-select");
    private By monthLocator  = By.cssSelector(".react-datepicker__month-select");
    private By dayLocator  = By.cssSelector(".react-datepicker__day.react-datepicker__day--0");
    private By SUBJECT = By.id("subjectsInput");
    private By HOBBIES = By.id("hobbiesWrapper");
    private By UPLOADPICURE = By.id("uploadPicture");
    private By CURRENTADDRESS = By.id("currentAddress");
    private By SUBMIT = By.id("submit");

    private By SUCCESSMESSAGE = By.id("example-modal-sizes-title-lg");

    private By CLOSEBUTTON = By.id("closeLargeModal");
    public void firstName(String fName) {
        writeText(FIRST_NAME,fName);
    }
    public void lastName(String lName) {
        writeText(LAST_NAME,lName);
    }
    public void email(String email) {
        writeText(EMAIL,email);
    }
    public void gender(){
        clickOnElement(GENDER);
    }
    public void MobileNumber(String mobileNum) {
        writeText(MOBILENUM,mobileNum);
    }

    public void setDateOfBirth(String year, String month, String day) {
        // Click on date of birth input
        clickOnElement(dateOfBirthInputLocator);

        // Select year
        selectOptionByValue(yearLocator, year);

        // Select month
        selectOptionByText(monthLocator, month);

        // Select day
        By dayElementLocator = By.xpath(String.format("//div[contains(@class, 'react-datepicker__day') and text()='%s']", day));
        clickOnElement(dayElementLocator);
    }
    public void subject(String subject){
        writeTextAndEnterCkick(SUBJECT,subject);

    }
    public void getHobbies(String hobby){
        //waitForElement(HOBBIES);
        clickElementByText(hobby);
    }
    public void setUPLOADPICURE(String fileLocation){
        uploadImage(UPLOADPICURE,fileLocation);
    }
    public void getCurrentAddress(String address){
        writeTextAndEnterCkick(CURRENTADDRESS,address);
    }
    public void ClickSubmit(){
        clickOnElement(SUBMIT);
    }
    public String getSuccessmessage(){
        String text = getElementText(SUCCESSMESSAGE);
        return text;
    }
    public boolean getSuccessmessagePresent(){
        return isElementPresent(SUCCESSMESSAGE);
    }
    public void closebutton(){
        clickOnElement(CLOSEBUTTON);
    }


}
