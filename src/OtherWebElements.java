import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;

public class OtherWebElements {

	public static void main(String[] args) {
	
		System.getProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
		WebDriver driver = new SafariDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String url = "https://rahulshettyacademy.com/dropdownsPractise/";
		driver.get(url);
		
		WebElement tripOption=driver.findElement(By.cssSelector("input#ctl00_mainContent_rbtnl_Trip_1"));
		tripOption.click();
		String radioActive=tripOption.getAttribute("checked");
		Assert.assertEquals(radioActive, "true");
		
		driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).click();
		boolean checkBoxStatus=driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).isSelected();
		Assert.assertEquals(checkBoxStatus,true);
		//driver.switchTo().alert().accept();
		
	}

}
