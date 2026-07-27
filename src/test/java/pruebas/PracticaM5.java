package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import paginas.LoginPage;

public class PracticaM5 {
	
    String url="https://automationexercise.com/login";
	private WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
	    options.addArguments("--incognito");
	    driver=new ChromeDriver(options);
	    driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
	    driver.get(url);
	}

	@AfterMethod
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
		
	}
	
    @Test(dataProvider="loginData_valid")
	public void testLogin(String email, String password) {    	
    	LoginPage login = new LoginPage(driver);
    	login.loginpag(email, password);
    	Assert.assertTrue(login.isLoggedIn());
    	
	
	}
       
    @Test(dataProvider="loginData_invalid")
  	public void testInvalidLogin(String email, String password) {    	
      	LoginPage login = new LoginPage(driver);
      	login.loginpag(email, password);
      	Assert.assertTrue(login.isNotLogged());
      	
  	
  	}
    @DataProvider(name="loginData_valid")
    public Object[][] loginData_valid() {
		return new Object[][] {
			{"test_ar@test.com", "12345"},
			{"test_br@test.com", "12345" } };
		}
	
    @DataProvider(name="loginData_invalid")
    public Object[][] loginData_invalid() {
		return new Object[][] {
			{"test@test.com", "12"},
			{"test@test.com", "123" } };
		}
		
}
