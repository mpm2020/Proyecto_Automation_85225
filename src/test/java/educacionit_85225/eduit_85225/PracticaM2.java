package educacionit_85225.eduit_85225;

import java.time.Duration;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PracticaM2 {
	//Variables que necesitaremos para nuestra prueba
	String url="https://automationexercise.com/login";

	@Test
	public void registerNewAccount() {
		String uniqueEmail="test"+ UUID.randomUUID().toString().substring(0, 5)+"@test.com";

		ChromeOptions options = new ChromeOptions();
		//Tamaño de la ventana
		options.addArguments("--start-maximized");
		//Perfil Incognito
		options.addArguments("--incognito");

		WebDriver driver= new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		try {
			
		driver.get(url);
		
		//Name
		WebElement txt_Name=driver.findElement(By.name("name"));
		txt_Name.sendKeys("Juan");

		//Email
		WebElement txt_Email=driver.findElement(By.cssSelector("input[data-qa='signup-email']"));
		txt_Email.sendKeys(uniqueEmail);

		//Signup button
		WebElement btn_Signup=driver.findElement(By.cssSelector("button[data-qa='signup-button']"));
		btn_Signup.click();

		//Genero	
		 WebElement rdbtn_Genero=wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
		 rdbtn_Genero.click();
				
		//Password
		WebElement txt_Password=driver.findElement(By.id("password"));
		txt_Password.sendKeys("Password123!");
		

		//Days
		Select drp_Days=new Select(driver.findElement(By.id("days")));
		drp_Days.selectByVisibleText("10");
		
		//Months
		Select drp_Months=new Select(driver.findElement(By.id("months")));
		drp_Months.selectByVisibleText("January");
		
		//Years
		Select drp_Years=new Select(driver.findElement(By.id("years")));
		drp_Years.selectByVisibleText("1990");

		//First Name
		WebElement txt_FirstName=driver.findElement(By.id("first_name"));
		txt_FirstName.sendKeys("Juan");

		//Last Name
		WebElement txt_LastName=driver.findElement(By.id("last_name"));
		txt_LastName.sendKeys("Perez");

		//Address
		WebElement txt_Address=driver.findElement(By.id("address1"));
		txt_Address.sendKeys("Calle Falsa 123");

		//Country
		Select drp_Country=new Select(driver.findElement(By.id("country")));
		drp_Country.selectByVisibleText("Canada");

		//State
		WebElement txt_State=driver.findElement(By.id("state"));
		txt_State.sendKeys("Ontario");

		//City
		WebElement txt_City=driver.findElement(By.id("city"));
		txt_City.sendKeys("Toronto");
		
		//Zipcode
		WebElement txt_Zipcode=driver.findElement(By.id("zipcode"));
		txt_Zipcode.sendKeys("M5V 2T6");
		
		//Mobile Number	
		WebElement txt_MobileNumber=driver.findElement(By.id("mobile_number"));
		txt_MobileNumber.sendKeys("123456789");
		
		//Create Account button
		
		WebElement btn_CreateAccount=driver.findElement(By.cssSelector("button[data-qa='create-account']"));
		btn_CreateAccount.click();
		}
		finally {
			driver.quit();
		}


	}
}