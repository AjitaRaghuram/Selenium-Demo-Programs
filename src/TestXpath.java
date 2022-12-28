//soft assertion and hard assertion

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.asserts.SoftAssert;

public class TestXpath {

	public static void main(String[] args) {

		System.out.println("execution Started");
		System.getProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
		WebDriver driver = new SafariDriver();
		driver.manage().window().maximize();

//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.get("https://www.amazon.com/");
		driver.findElement(By.xpath("//div[@class='nav-line-1-container']")).click();
		driver.findElement(By.id("createAccountSubmit")).click();

		String checkCreateAccount = driver.findElement(By.cssSelector("h1.a-spacing-small")).getText();
		String expectedCreateAccount = "Createaccount";
		System.out.println("this is the first time :" + checkCreateAccount);
//		Assert.assertEquals(checkCreateAccount, expectedCreateAccount);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(checkCreateAccount, expectedCreateAccount, "not the expected page");

		driver.navigate().back();
		String checksignin = driver.findElement(By.cssSelector("h1.a-spacing-small")).getText();
		String expectedsignin = "Sign in";
		System.out.println("you are in sign in page :" + checksignin);
//		Assert.assertEquals(checksignin, expectedsignin);
		sa.assertEquals(checksignin, expectedsignin);

		driver.navigate().forward();
		String checkCreateAccount2 = driver.findElement(By.cssSelector("h1.a-spacing-small")).getText();
		System.out.println("this is the second time :" + checkCreateAccount2);
//		Assert.assertEquals(checkCreateAccount2, expectedCreateAccount);
		sa.assertEquals(checkCreateAccount2, expectedCreateAccount, "not the expected page");
		
		if(checkCreateAccount2==expectedCreateAccount) {
			System.out.println("execution passed");
		}
		else {
			System.out.println("execution not passed");
		}
		//System.out.println("execution passed");
		driver.quit();

	}

}
