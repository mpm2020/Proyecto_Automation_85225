package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import paginas.LoginPage;

public class PracticaM4 {
	
	private WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
	    options.addArguments("--incognito");
	    driver=new ChromeDriver(options);
	    driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		
	}

	@AfterClass
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
		
	}
	
    @Test
    @Parameters({"url","email","password"})
	public void testLogin(String url, String email, String password) {
		
    	driver.get(url);
    	
    	LoginPage login = new LoginPage(driver);
    	login.loginpag(email, password);
    	Assert.assertTrue(login.isLoggedIn(),"Usuario no logueado");
    	
	
	}
	
}
