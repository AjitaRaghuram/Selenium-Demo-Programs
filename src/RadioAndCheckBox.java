import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class RadioAndCheckBox {

	public static void main(String[] args) {
		
		System.getProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
		WebDriver driver = new SafariDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		 String url ="https://www.amazon.com/";
		 driver.get(url);
		 String searchElement ="tee shirts for teen girls";	 
		 driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchElement);
		 driver.findElement(By.id("nav-search-submit-button")).click();
		 driver.findElement(By.xpath("//div[@id='primeRefinements']//span/a/div/label/i[@class='a-icon a-icon-checkbox']")).click();
		 driver.findElement(By.xpath("//div[@id='deliveryRelatedProgramsRefinements']//span/a/div/label/i[@class='a-icon a-icon-checkbox']")).click();
		 driver.findElement(By.xpath("//div[@id='reviewsRefinements']//span//i[@class='a-icon a-icon-star-medium a-star-medium-4']")).click();
		 
		 String minPrice="15";
		 String maxPrice="50";
		 driver.findElement(By.xpath("//input[@id='low-price']")).sendKeys(minPrice);
		 driver.findElement(By.xpath("//input[@id='high-price']")).sendKeys(maxPrice);
		 driver.findElement(By.cssSelector("button#a-autoid-24-announce")).click();
		 
		 
		 System.out.println("Program Successfully Executed");
//		 driver.quit();
		 		 
		 
		 

	}

}
