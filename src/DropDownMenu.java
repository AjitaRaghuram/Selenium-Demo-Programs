import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropDownMenu {

	public static void main(String[] args) {

		System.getProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
		WebDriver driver = new SafariDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String url = "https://rahulshettyacademy.com/dropdownsPractise/";
		driver.get(url);

		WebElement moneyOpt=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select opt1=new Select(moneyOpt);
		
		//select index
		opt1.selectByIndex(3);
		String expecptedCurrency="USD";
		String selectedCurrency=opt1.getFirstSelectedOption().getText();
		System.out.println("The currency option we selected is : "+selectedCurrency);
		Assert.assertEquals(expecptedCurrency, selectedCurrency);
		
		//select by visibllity
		opt1.selectByVisibleText("INR");
		expecptedCurrency="INR";
		selectedCurrency=opt1.getFirstSelectedOption().getText();
		System.out.println("The currency option we selected is : "+selectedCurrency);
		Assert.assertEquals(expecptedCurrency, selectedCurrency);
		
		//select by selectByValue
		selectedCurrency="AED";
		opt1.selectByValue(selectedCurrency);
		expecptedCurrency="AED";
		selectedCurrency=opt1.getFirstSelectedOption().getText();
		System.out.println("The currency option we selected is : "+selectedCurrency);
		Assert.assertEquals(expecptedCurrency, selectedCurrency);
		
		System.out.println("Program Successfully Executed");
		 driver.quit();

	}

}
