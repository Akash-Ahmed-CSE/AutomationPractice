package pages;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static utilities.DriverSetup.getDriver;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;
public class BasePage {

	public WebElement getElemnt(By locator) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void clickOnElement(By locator) {
		getElemnt(locator).click();
	}

	public String getElementText(By locator) {
		return getElemnt(locator).getText();
	}

	public void clickElementByText(String text) {
		WebElement element = getDriver().findElement(By.xpath("//*[text()='" + text + "']"));
		String elementText = element.getText();
		element.click();
		System.out.println("Clicked on element with text: " + elementText);
	}

	public void writeText(By locator, String text) {
		getElemnt(locator).sendKeys(text);

	}
	public void writeTextAndEnterCkick(By locator, String text) {
		getElemnt(locator).sendKeys(text);
		getElemnt(locator).sendKeys(Keys.ENTER);
	}

	public String getAlertText() {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		return alert.getText();
	}
	public void selectOptionByValue(By locator, String value) {

		WebElement selectElement = getDriver().findElement(locator);
		Select dropdown = new Select(selectElement);
		dropdown.selectByValue(value);
	}
	public void selectOptionByText(By locator, String text) {
		WebElement selectElement = getDriver().findElement(locator);
		Select dropdown = new Select(selectElement);
		dropdown.selectByVisibleText(text);
	}
	public void uploadImage(By locator,String fileLocation){
		getElemnt(locator).sendKeys(fileLocation);
	}


	public void waitForElement(By locator) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public void scrollToBottom() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	public boolean isElementPresent(By locator) {
		try {
			getDriver().findElement(locator);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	public void takeScreenshot(String screenshotFilePath) {
		try {
			Thread.sleep(2000);
			// Convert WebDriver instance to TakesScreenshot
			TakesScreenshot screenshot = (TakesScreenshot) getDriver();

			// Capture screenshot as File
			File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

			// Copy the screenshot to the specified file path
			FileHandler.copy(srcFile, new File(screenshotFilePath));
			System.out.println("Screenshot saved to: " + screenshotFilePath);
		} catch (IOException e) {
			System.out.println("Failed to save screenshot: " + e.getMessage());
		} catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}


