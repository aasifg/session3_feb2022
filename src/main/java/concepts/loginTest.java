package concepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginTest {

WebDriver driver;
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver","driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/billing/?ng=login/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	@Test
	public void loginTest() {
		//you need to use the storing web element type which selenium offers we use it as =value; basically create a variable
		
		
		
		//This is webelement concept
		WebElement USER_NAME_ELEMENT=driver.findElement(By.xpath("//input[@id='username']"));
		WebElement PASSWORD_ELEMENT=driver.findElement(By.xpath("//input[@name='password']"));
		WebElement SIGNIN_BUTTON_ELEMENT=driver.findElement(By.xpath("//button[@type ='submit']"));
		WebElement DASHBOARDLOGO_ELEMENT=driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2"));
	
		
		
		//always go with this sequence id,name,class whichever comes first
		
		//This is BY element concept
		By USER_NAME_FIELD=By.xpath("//input[@id='username']");
		By PASSWORD_FIELD=By.xpath("//input[@id='password']");
		By SIGNIN_BUTTON_FIELD=By.xpath("//button[@name='login']");
		
		By DASHBOARDLOGO_FIELD=By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");
		
		//this is when we use the webelement concept
//		USER_NAME_ELEMENT.sendKeys("demo@techfios.com");
//		PASSWORD_ELEMENT.sendKeys("abc123");
//		SIGNIN_BUTTON_ELEMENT.click();
//		
		//this is when we use the BY element concept
		//ASK THIS QUESTION???!!!! WHY DO we use driver.findelemet and not USER_FIELD.sendkeys like we did for webelement concept
		driver.findElement(USER_NAME_FIELD).sendKeys("demo@techfios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc1234");
		driver.findElement(SIGNIN_BUTTON_FIELD).click();
		
		//WebDriverWait wait = new WebDriverWait(driver, 10);
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARDLOGO_FIELD));
		//interview Q about webdriver wait
		// ***When we apply webdriver wait within the expected conditions if the condition doesnt meet timeout exception occurs****
		//
			
		Assert.assertTrue("page not found!!!",DASHBOARDLOGO_ELEMENT.isDisplayed());
		
//		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("abc123");
//		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demo@techfios.com");
		
		
		
	}
	
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
		
	}
	
	
	
	
}
