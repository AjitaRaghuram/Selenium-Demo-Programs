import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;

public class CheckPassword {

	public static void main(String[] args) {
		System.getProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
		WebDriver driver = new SafariDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://www.amazon.com/");
		driver.findElement(By.xpath("//div[@class='nav-line-1-container']")).click();// to go to sign-in page

		String checkSignIn = driver.findElement(By.cssSelector("h1.a-spacing-small")).getText();
		String expectedSignIn = "Sign in";

		Assert.assertEquals(checkSignIn, expectedSignIn, "You are not in SIGN IN page");
		System.out.println("you are in sign in page :" + checkSignIn);

		// to create new account page
		driver.findElement(By.xpath("//a[@id='createAccountSubmit']")).click();// to go to create new account page

		String checkCreateAccount = driver.findElement(By.cssSelector("h1.a-spacing-small")).getText();
		String expectedCreateAccount = "Create account";

		// to check if you are in the create account page
		Assert.assertEquals(checkCreateAccount, expectedCreateAccount, "You are not in CREATE ACCOUNT page");
		System.out.println("you are in CREATE ACCOUNT page :" + checkCreateAccount);

		// to fill in the form
		driver.findElement(By.xpath("//input[@id='ap_customer_name']")).sendKeys("Rowena");// name
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("sggemgam@gmail.com");// email id
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("abcdef");// password
		driver.findElement(By.xpath("//input[@id='ap_password_check']")).sendKeys("qwert");// re-password
		driver.findElement(By.xpath("//input[@id='continue']")).click();// submit or continue

		String verifyMsg = driver
				.findElement(By.xpath("//div[@id='auth-password-mismatch-alert']//div[@class='a-alert-content']"))
				.getText();
		String expectedMsg = "Passwords must match";
		System.out.println("msg dispalyed :" + verifyMsg + "\nmsg expected :" + expectedMsg);
		Assert.assertEquals(verifyMsg, expectedMsg, " Your password match ");
//		Assert.assertEquals(verifyMsg.contains(expectedMsg), " Your password match ");
		driver.quit();
	}

}
