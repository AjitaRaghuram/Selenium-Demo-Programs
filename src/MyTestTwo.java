import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class MyTestTwo {

	public static void main(String[] args) throws InterruptedException {

		System.getProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
		WebDriver driver = new SafariDriver();

		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.findElement(By.xpath("//a[@href='http://jqueryui.com/draggable/']")).click();
		System.out.println(driver.findElement(By.className("entry-title")).getText());

		driver.findElement(By.xpath("//a[@href='http://jqueryui.com/droppable/']")).click();
		System.out.println(driver.findElement(By.className("entry-title")).getText());

		driver.findElement(By.xpath("//a[@href='http://jqueryui.com/resizable/']")).click();
		System.out.println(driver.findElement(By.className("entry-title")).getText());

		driver.findElement(By.xpath("//a[@href='http://jqueryui.com/selectable/']")).click();
		System.out.println(driver.findElement(By.className("entry-title")).getText());

		driver.findElement(By.xpath("//a[@href='http://jqueryui.com/sortable/']")).click();
		System.out.println(driver.findElement(By.className("entry-title")).getText());

		driver.findElement(By.xpath("//a[@href='https://api.jqueryui.com/']")).click();
		System.out.println(driver.findElement(By.className("entry-title")).getText());

		driver.findElement(By.xpath("//a[@href='https://jqueryui.com/themeroller/']")).click();
		System.out.println(driver.findElement(By.className("entry-title")).getText());

		//driver.findElement(By.xpath("(//li[@class='menu-item'])[1]")).click();
		

		// driver.quit();
	}

}
