import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownClass {

	public static void main(String[] args) throws InterruptedException {
// TODO Auto-generated method stub
		System.getProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
		WebDriver driver = new SafariDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@value='GOI']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']"))
				.click();
		WebElement chkseniorcitizen = driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount"));
		chkseniorcitizen.click();
		Thread.sleep(2000);
		WebElement chkindianarmedforce = driver.findElement(By.id("ctl00_mainContent_chk_IndArm"));
		chkindianarmedforce.click();
		Thread.sleep(2000);
		WebElement radioRoundtrip = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1"));
		radioRoundtrip.click();
		// Thread.sleep(2000);
		// WebElement radioMulticity =
		// driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_2"));
		// radioMulticity.click();

		WebElement currencyDrpdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select selDrpdown = new Select(currencyDrpdown);
		// selectBYIndex()
		selDrpdown.selectByIndex(3);
		System.out.println(selDrpdown.getFirstSelectedOption().getText());
		Thread.sleep(1000);
		selDrpdown.selectByValue("USD");
		System.out.println(selDrpdown.getFirstSelectedOption().getText());
		Thread.sleep(1000);
		selDrpdown.selectByVisibleText("INR");
		System.out.println(selDrpdown.getFirstSelectedOption().getText());
		Thread.sleep(1000);
		selDrpdown.selectByValue("AED");
		System.out.println(selDrpdown.getFirstSelectedOption().getText());
		Thread.sleep(1000);

		driver.quit();

	}

}
