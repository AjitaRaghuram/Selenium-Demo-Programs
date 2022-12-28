import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlretHandling {

	public static void main(String[] args) {
		
		System.getProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
		WebDriver driver = new SafariDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String url = "https://rahulshettyacademy.com/AutomationPractice/";
		driver.get(url);

		
		WebElement radioOption = driver.findElement(By.xpath("//input[@value='radio3']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='radio3']")));
		wait.until(ExpectedConditions.visibilityOf(radioOption));
		radioOption.click();

		//Auto suggestive drop down
		WebElement country = driver.findElement(By.cssSelector("input#autocomplete"));
		country.sendKeys("New");

		//List<WebElement> Options = driver.findElements(By.cssSelector(".ui-menu-item-wrapper"));
		List<WebElement> Options = driver.findElements(By.xpath("//div[@class='ui-menu-item-wrapper']"));
		
		for (WebElement option : Options) {
			String cName = option.getText();
			System.out.println("the value is:" + cName);

			if (cName.equalsIgnoreCase("New Zealand")) {
				option.click();
				break;
			}

		}
		// selection using check boxes
		driver.findElement(By.cssSelector("input#checkBoxOption1")).click();
		driver.findElement(By.cssSelector("input#checkBoxOption2")).click();

		// Alert Handling
		String namegiven = "Ajita";
		driver.findElement(By.cssSelector("input#name")).sendKeys(namegiven);
		System.out.println("The name given: " + namegiven);
		driver.findElement(By.cssSelector("input#alertbtn")).click();
		String strextracted = driver.switchTo().alert().getText();
		System.out.println("captures value : " + strextracted);
		driver.switchTo().alert().accept();

		namegiven = "Raghu";
		driver.findElement(By.cssSelector("input#name")).sendKeys(namegiven);
		System.out.println("The name given: " + namegiven);
		driver.findElement(By.xpath("//input[@class='btn-style'][2]")).click();
		strextracted = driver.switchTo().alert().getText();
		System.out.println("captures value : " + strextracted);

		if (namegiven.equalsIgnoreCase("ajita")) {
			System.out.println("this is " + namegiven + " is the person expected");
			driver.switchTo().alert().accept();
		} else {
			System.out.println("this is " + namegiven + " not the expected person");
			driver.switchTo().alert().dismiss();
		}

		driver.quit();
	}

}
