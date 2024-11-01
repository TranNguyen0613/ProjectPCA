package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SignIn {

	private WebDriver driver;

	By headerPageText = By.xpath("");
	By emailInput = By.id("");
	By passwordInput = By.id("");
	By signinBtn = By.id("");
	By errorMsgText = By.id("");

	public SignIn(WebDriver driver) {
		this.driver = driver;
	}

	public String getSignInTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}

	public boolean verifySignInPageTitle() {
		String expectedTitle = "Sign In";
		return getSignInTitle().equals(expectedTitle);
	}

	public boolean verifySignInText() {
		WebElement element = driver.findElement(headerPageText);
		String pageText = element.getText();
		String expectedPageText = "Forgot Username/Password?";
		return pageText.contains(expectedPageText);
	}

	public void signin(String username, String password) throws Exception {
		enterEmail(username);
		enterPassword(password);
		Thread.sleep(1000);
	}

	public boolean verifySignIn() {
		enterEmail("test");
		enterPassword("pass");
		return getErrorMessage().contains("incorrect");
	}

	public void enterEmail(String email) {
		WebElement emailTxtBox = driver.findElement(emailInput);
		if (emailTxtBox.isDisplayed())
			emailTxtBox.sendKeys(email);
	}

	public void enterPassword(String password) {
		WebElement passwordTxtBox = driver.findElement(passwordInput);
		if (passwordTxtBox.isDisplayed())
			passwordTxtBox.sendKeys(password);
	}

	public void clickSignIn() {
		WebElement signin = driver.findElement(signinBtn);
		if (signin.isDisplayed()) {
			signin.click();
		}
	}


	public String getErrorMessage() {
		String strErrorMsg = null;
		WebElement errorMsg = driver.findElement(errorMsgText);
		if (errorMsg.isDisplayed() && errorMsg.isEnabled())
			strErrorMsg = errorMsg.getText();
		return strErrorMsg;
	}

	public void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load Request to complete.");
		}
	}
}
