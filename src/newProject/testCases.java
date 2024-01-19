package newProject;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testCases {
	WebDriver driver = new ChromeDriver();
	Random rand = new Random();

	@BeforeTest
	public void setup() {
		driver.get("https://www.almosafer.com/ar/");
		driver.manage().window().maximize();
		WebElement firstScreenButton = driver
				.findElement(By.cssSelector("button[class='sc-jTzLTM eJkYKb cta__button cta__saudi btn btn-primary']"));
		firstScreenButton.click();
	}

	@Test()
	public void myTest() throws InterruptedException {
		Thread.sleep(2000);
		WebElement chaltesElement = driver.findElement(By.cssSelector("#uncontrolled-tab-example-tab-chalets"));
		chaltesElement.click();
		WebElement citiesList = driver.findElement(By.className("sc-gYtlsd"));
		citiesList.click();
		WebElement theCity = driver.findElement(By.cssSelector("button:nth-child(7)"));
		theCity.click();
		WebElement searchButton = driver
				.findElement(By.cssSelector(".Button__Btn-sc-xr32du-0.bwtwxz.sc-imAxmJ.gVJtmY"));
		searchButton.click();
		Thread.sleep(4000);
		List<WebElement> chaltes = driver.findElements(By.className("Button__Btn-sc-xr32du-0"));
		chaltes.get(1).click();
		Thread.sleep(3000);
		WebElement loginDateElement = driver.findElement(By.id("js-C2CGuestSearchBoxDatePickerCheckInDate"));
		loginDateElement.click();

		WebElement loginDate = driver.findElement(By.className("DayPicker-Day--today"));
		loginDate.click();
		WebElement logoutDate = driver.findElement(By.xpath(
				"/html/body/div[2]/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div[2]/div[3]/div[7]"));
		logoutDate.click();
		Thread.sleep(2000);
		WebElement bookNowButton = driver.findElement(By.className("btn-large"));
		bookNowButton.click();

	}

	@AfterTest
	public void postTest() {
	}

}
