package educacionit_85225.eduit_85225;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticaM1 {
	//Variables que necesitaremos para nuestra prueba
	String url="https://practicetestautomation.com/practice-test-login/";

	@Test @Disabled
	public void laboratorio1() {
		System.out.println("Hola Mundo de Automatizacion");
	}

	@Test
	public void loginTest() {
		//1.Definir navegador a utilizar
		WebDriver driver= new ChromeDriver();
		driver.manage().deleteAllCookies();// Borrar cookies
		driver.manage().window().maximize();// Maximizar ventana
		//2.Abrir navegador con la URL
		driver.get(url);
		//3. Ingresar usuario
		WebElement txt_Username=driver.findElement(By.id("username"));
		txt_Username.sendKeys("student");
		//4. Ingresar contraseña
		WebElement txt_Password=driver.findElement(By.id("password"));
		txt_Password.sendKeys("Password123");
		//5.Click login
		WebElement btn_Login=driver.findElement(By.id("submit"));
		btn_Login.click();
		//6.Cerrar navegador
	    driver.quit();



	}
    @Test
	public void loginTest_Firefox() {
		
	}

}
