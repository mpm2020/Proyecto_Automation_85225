package pruebas;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticaM6 {
	WebDriver driver;
	//URLS TEST
	//String url="https://demo.guru99.com/test/upload/";
	//String url="https://demo.guru99.com/test/table.html";
	String url="https://practice-automation.com/popups/";
	
	@BeforeMethod
	public void setUp() {
		driver =new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	//Upload file test
	@Test(enabled=false)
	public void uploadFile() throws InterruptedException {
		WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));
		uploadElement.sendKeys("C:\\Users\\user\\eclipse-workspace\\eduit_85225\\Prueba.txt");
		Thread.sleep(2000); // Esperar 2 segundos para ver el archivo cargado		
	}
	
	// Table test
	@Test(enabled=false)
	public void getCell()
	{
		WebElement cell=driver.findElement(By.xpath("//tbody/tr[4]/td[3]"));
		String cellText=cell.getText();
		Assert.assertEquals(cellText, "8");
	}
	
	// Alert test
	@Test
	public void notification() throws InterruptedException{
		WebElement btnButton=driver.findElement(By.id("alert"));
		btnButton.click();
		Thread.sleep(2000); // Esperar 2 segundos para ver el resultado
		Alert Notification=driver.switchTo().alert();
		Notification.accept();
		Thread.sleep(2000); // Esperar 2 segundos para ver el resultado
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
