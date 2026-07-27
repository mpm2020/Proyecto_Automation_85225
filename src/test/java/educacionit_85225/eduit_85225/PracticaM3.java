package educacionit_85225.eduit_85225;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



public class PracticaM3 {
	
	private WebDriver driver;
	private WebDriverWait wait;
	String url="https://automationexercise.com/login";
	
	@BeforeSuite
	public void initSuite()	{
		System.out.println("====== Iniciando Suite de Pruebas ====");
	}
	
	@AfterSuite
	public void finalizeSuite()	{
		System.out.println("====== Finalizando Suite de Pruebas ====");
	}
	
	@BeforeMethod
	public void setUp()
	{
		System.out.println("Iniciando Test");
		
		ChromeOptions options = new ChromeOptions();
		//Tamaño de la ventana
		options.addArguments("--start-maximized");
		//Perfil Incognito
		options.addArguments("--incognito");

		driver= new ChromeDriver(options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get(url);
		
		
	}
	
	@AfterMethod
	public void tearDown() throws IOException
	{
		System.out.println("Finalizando Test");
		//Captura de pantalla antes de cerrar el navegador
		capturaPantalla();
		driver.quit();
	}
	
	@Test(priority=2)
	public void registerNewAccount_1() {
		System.out.println("Ejecutando Test");
		
		String uniqueEmail="test"+ UUID.randomUUID().toString().substring(0, 5)+"@test.com";

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
		
		//Aserciones para validar que la cuenta fue creada correctamente
		WebElement successMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@data-qa='account-created']")));
		
		String expectedTest="ACCOUNT CREATED!";
		String actualText=successMessage.getText();
		Assert.assertEquals(actualText,expectedTest,"El mensaje de cuenta creada no es el esperado");
		
	}
	
	@Test(priority=1)
	public void registerNewAccount_2() {
		System.out.println("Ejecutando Test");
		
		String uniqueEmail="test"+ UUID.randomUUID().toString().substring(0, 5)+"@test.com";

		//Name
		WebElement txt_Name=driver.findElement(By.name("name"));
		txt_Name.sendKeys("Mariana");

		//Email
		WebElement txt_Email=driver.findElement(By.cssSelector("input[data-qa='signup-email']"));
		txt_Email.sendKeys(uniqueEmail);

		//Signup button
		WebElement btn_Signup=driver.findElement(By.cssSelector("button[data-qa='signup-button']"));
		btn_Signup.click();

		//Genero	
		 WebElement rdbtn_Genero=wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender2")));
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
		txt_FirstName.sendKeys("Mariana");

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
		
		//Aserciones para validar que la cuenta fue creada correctamente
		WebElement successMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@data-qa='account-created']")));
		
		String expectedTest="ACCOUNT CREATED!";
		String actualText=successMessage.getText();
		Assert.assertEquals(actualText,expectedTest,"El mensaje de cuenta creada no es el esperado");
		
	}
	
	private void capturaPantalla() throws IOException {
		
		if (driver==null)return;
		File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Path destDir=Path.of("..","eduit_85225","Evidencias");
		Files.createDirectories(destDir);
		Path dest=destDir.resolve("pantalla_"+System.currentTimeMillis()+".png");
		Files.copy(screen.toPath(), dest, StandardCopyOption.REPLACE_EXISTING);
		System.out.println("Captura de pantalla guardada en: "+dest.toAbsolutePath());
				
	}
	
}
