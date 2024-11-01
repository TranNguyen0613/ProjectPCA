package Test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SignInTest {
	@Test
	public void start() {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Actions action = new Actions(driver);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://pca.lubrytics.com/#/login");

		By userNameBy = By.id("username");
		By passWordlBy = By.id("password");
		By buttonBy = By.xpath("(//button[@type='submit'])[1]");
		By dayFieldBy = By.xpath("(//input[@placeholder='Select day'])[1]");
		By dayCheckBy = By.xpath("(//div[@aria-selected='true'])[1]");
		By projectCodeBy = By.xpath("//div[@class='ant-select-selection__placeholder']");
		By submitBtnBy = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/button");
		By viewReportBy = By.xpath("(//button[@class='ant-btn ant-btn-primary'])[1]");
		By extendSearchBy = By.xpath("(//div[@role='button'])[1]");
		By codeSearchBy = By.xpath("(//div[@class='ant-select-selection__rendered'])[1]");
		By btnSearchBy = By.xpath("(//button[@class='ant-btn mb-2 ant-btn-primary'])[1]");
		By btnResetBy = By.xpath("(//button[@class='ant-btn mb-2 mr-2 ant-btn-danger'])[1]");

		wait.until(ExpectedConditions.visibilityOfElementLocated(userNameBy))
				.sendKeys("quetran.nguyen@estuary.solutions");
		wait.until(ExpectedConditions.visibilityOfElementLocated(passWordlBy)).sendKeys("Okitasouji%1802");
		wait.until(ExpectedConditions.visibilityOfElementLocated(buttonBy)).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(dayFieldBy)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(dayCheckBy)).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(projectCodeBy)).click();
		action.sendKeys("HBL-NCAPP-OP-24").perform();
		action.click().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(submitBtnBy)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(viewReportBy)).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(extendSearchBy)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(codeSearchBy)).click();
		action.sendKeys("HBL-NCAPP-OP-24").perform();
		action.click().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(btnSearchBy)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(btnResetBy)).click();

	}
	



}
