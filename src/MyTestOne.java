import java.time.Duration;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class MyTestOne {

	public static void main(String[] args) throws InterruptedException {


		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.com/");

		//to maximize the web page
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		//JavascriptExecutor js = (JavascriptExecutor)driver;

		WebElement SearchBox = driver.findElement(By.id("twotabsearchtextbox"));
		SearchBox.sendKeys("JBL earphones");

		WebElement SearchIcon = driver.findElement(By.id("nav-search-submit-button"));
		SearchIcon.click();
		/*WebElement CheckBox = driver.findElement(By.className("a-icon a-icon-checkbox"));
				CheckBox.click();*/
		// to slow down the process to watch the steps
		Thread.sleep(4000);

		//js.executeScript("window.scrollBy(0,4000)");

		Thread.sleep(4000);

		String newone="first string";
		String second="first string and second";
		second.contains(newone);		

		driver.quit();

	}

}
