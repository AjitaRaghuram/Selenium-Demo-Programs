import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocatorLearning {

	public static void main(String[] args) {

		// below code for chrome browser
		// to specify the browser that we are going to use
		System.getProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
		
		// use the web browser interface to use the method of that particular WD create
		// an object and use it
		WebDriver driver = new SafariDriver();
		driver.manage().window().maximize();// maximize the window

		// to add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		// use the driver to get the web browser
		driver.get("https://www.amazon.com/");
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		// for explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email")));

		driver.findElement(By.name("email")).sendKeys("ajitaraghuram@gmail.com");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.name("password")).sendKeys("nopasswordjusttesting");
		driver.findElement(By.id("signInSubmit")).click();

		//driver.findElement(By.xpath("//a[@href='/gp/bestsellers/?ref_=nav_cs_bestsellers']")).click();
		//driver.findElement(By.xpath("//a[@href='/gp/most-wished-for/ref=zg_bs_tab']")).click();
		//System.out.println(driver.findElement(By.xpath("//h2[@class='a-carousel-heading a-inline-block']")).getText());//inspect
		
		driver.quit();

	}

}
