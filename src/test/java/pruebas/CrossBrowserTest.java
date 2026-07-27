package pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {
	WebDriver driver;
	String url="https://practicetestautomation.com/practice-test-login/";

	@Parameters("navegador")
	@BeforeMethod
	public void setUP(String navegador) {

		if(navegador.equalsIgnoreCase("chrome")) {

			driver=new ChromeDriver();

		}
		else {
			driver=new FirefoxDriver();


		}

		driver.get(url);
	}

	@Test
	public void testLogin() {
		//3. Ingresar usuario
		WebElement txt_Username=driver.findElement(By.id("username"));
		txt_Username.sendKeys("student");
		//4. Ingresar contraseña
		WebElement txt_Password=driver.findElement(By.id("password"));
		txt_Password.sendKeys("Password123");
		//5.Click login
		WebElement btn_Login=driver.findElement(By.id("submit"));
		btn_Login.click();

	}

	@AfterMethod
	public void cerrarNavegador() {

		driver.quit();
	}

}
