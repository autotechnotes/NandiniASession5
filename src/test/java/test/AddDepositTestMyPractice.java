package test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddDepositTestMyPractice {
	
	@Test
	public void userShouldBeAbleToAddDeposit(){
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://techfios.com/test/billing/?ng=admin/");
				
		//Element library
		//Every page will have element library underneath it you will have methods
		WebElement usernameInputField = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		WebElement passwordInputField = driver.findElement(By.xpath("//input[contains(@type, 'pass')]"));
		WebElement signInButton = driver.findElement(By.xpath("//*[contains(@class, 'success block') and @type ='submit']"));

//		//xpath- (//input[@class='form-control'])[1]
//		//the above xpath, if it not the unique one enclose the entire thing in() , then give it number to tell it to pick that number 
//		//here the number is 1 so it will pick the first one. if specified 2 , it will pick the second one.
//      //driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("techfiosdemo@gmail.com");
		
		
		//validate if you went to the above website. just check if page opens or not
		//compare expected and actual title
		String expectedTitle = "Login - TechFios Test Application - Billing";
		String actualTitle = driver.getTitle();
		
		if(expectedTitle.toLowerCase().contains(actualTitle.toLowerCase())) {
			System.out.println("Test pass" + "Actual Title : " + actualTitle + "  Expected Title : " + expectedTitle + " - matched");
			
		}else {
			
			System.out.println( " Actual Title : " + actualTitle + "  Expected Title : " + expectedTitle + " - didn't match ");
			//you are taking control of java.You are throwing  an exception. 
			//if the test fails,it throws exception and stops it right here  and   the JUnit shows error 
			throw new RuntimeException("Test Failed.");
		}
		
		usernameInputField.sendKeys("techfiosdemo@gmail.com");
		passwordInputField.sendKeys("abc123");
		signInButton.click();
		
		
		
	}

}
