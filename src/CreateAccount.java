
/*a program to create a new account in amazon*/
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;

public class CreateAccount {

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
		driver.findElement(By.xpath("//input[@id='ap_password_check']")).sendKeys("abcdef");// re-password
		driver.findElement(By.xpath("//input[@id='continue']")).click();// submit or continue

		// code giving an exception must be checked:: invalid_selector_exception
		// the verify email address form
		String verifyEmail = driver.findElement(By.xpath("//div[@class='a-row a-spacing-small']/div/h1")).getText();
		String expectedEmail = "Verify email address";
		
		
		Assert.assertEquals(verifyEmail, expectedEmail, "You are not in  VERIFY EMAIL ADDRESS page");
		System.out.println("you are in VERIFY EMAIL ADDRESS page :" + verifyEmail);

		
		// enter OTP this //input[@name='code']
		driver.findElement(By.xpath("//input[@name='code']")).sendKeys("12345");
		// //input[@class='a-button-input']
		driver.findElement(By.xpath("//input[@class='a-button-input']")).click();// submit or continue

		
		// failed and still in verify address page

		String verifyEmail1 = driver.findElement(By.xpath("//div[@class='a-row a-spacing-small']/div/h1")).getText();

		Assert.assertEquals(verifyEmail1, expectedEmail, "You are not in VERIFY EMAIL ADDRESS page");
		System.out.println("you are in VERIFY EMAIL ADDRESS page :" + verifyEmail1);

		 
		driver.navigate().back();
		driver.navigate().back();

		String checkCreateAccount1 = driver.findElement(By.cssSelector("h1.a-spacing-small")).getText();

		// to check if you are in the create account page
		Assert.assertEquals(checkCreateAccount1, expectedCreateAccount, "You are not in CREATE ACCOUNT page");
		System.out.println("you are in CREATE ACCOUNT page :" + checkCreateAccount1);

		driver.navigate().back();

		String checkSignIn1 = driver.findElement(By.cssSelector("h1.a-spacing-small")).getText();

		Assert.assertEquals(checkSignIn1, expectedSignIn, "You are not in SIGN IN page");
		System.out.println("you are in sign in page :" + checkSignIn1);
		
		driver.quit();

	}

}
