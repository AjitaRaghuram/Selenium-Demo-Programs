
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class InvokeDrivers {

	public static void main(String[] args) {

		// below code for chrome browser
		// to specify the browser that we are going to use
		System.getProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
		
		

		// use the web browser interface to use the method of that particular WD create
		// an object and use it
		WebDriver driver = new SafariDriver();

		// below code for MSEdge browser
		// System.setProperty("webdriver.edge.driver", "C:\\Ajita\\Selenium
		// Drivers\\edgedriver\\msedgedriver.exe");
		// WebDriver driver=new EdgeDriver();

		// below code for Firefox browser
		// System.setProperty("webdriver.gecko.driver", "C:\\Ajita\\Selenium
		// Drivers\\geckodriver64\\geckodriver.exe");
		// WebDriver driver=new FirefoxDriver();

		// use the driver to get the web browser
		driver.get("https://www.amazon.com/");

	}

}
