package newProject;

import java.time.Duration;
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
		WebElement chaltesElement = driver.findElement(By.id("uncontrolled-tab-example-tab-chalets"));
		chaltesElement.click();
		WebElement placeholderElement = driver.findElement(By.className("erpSii"));
		placeholderElement.click();
		Thread.sleep(2000);
		WebElement theCity = driver.findElement(By.cssSelector("button:nth-child(7)"));
		theCity.click();
		WebElement loginDateElement = driver.findElement(By.id("js-C2CGuestSearchBoxDatePickerCheckInDate"));
		loginDateElement.click();

		List<WebElement> allDates = driver.findElements(By.className("DayPicker-Day"));
		for (int i = 0; i < allDates.size(); i++) {
			int num = rand.nextInt(allDates.size());
			String isDateVisable = allDates.get(num).getAttribute("aria-disabled");
			boolean isDateEnableAsBollen = Boolean.parseBoolean(isDateVisable);

			if (isDateEnableAsBollen == true) {
				continue;

			}

			allDates.get(num).click();
			break;

		}
		Thread.sleep(2000);
		for (int j = 0; j < allDates.size(); j++) {
			int number = rand.nextInt(allDates.size());
			String isDateEnable = allDates.get(number).getAttribute("aria-disabled");
			boolean isDateEnableAsBollen = Boolean.parseBoolean(isDateEnable);
			if (isDateEnableAsBollen == true) {
				continue;

			}
			allDates.get(number).click();
			break;

		}
		WebElement searchButton = driver
				.findElement(By.cssSelector(".Button__Btn-sc-xr32du-0.bwtwxz.sc-imAxmJ.gVJtmY"));
		searchButton.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30000));
		List<WebElement> chaltes = driver.findElements(By.className("btn-medium"));
		chaltes.get(1).click();

		WebElement bookNowButton = driver.findElement(By.className("BookNowButton__StyledButton-sc-1hapap0-0"));
		bookNowButton.click();

	}

	@AfterTest
	public void postTest() {
	}

}
