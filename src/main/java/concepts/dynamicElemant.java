package concepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class dynamicElemant {
	
WebDriver driver;
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver","driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.cnn.com/?refresh=1");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	@Test
	public void locateElements() throws InterruptedException {
		
		
		driver.findElement(By.xpath("//article[@class='cd cd--card cd--article cd--idx-1 cd--large cd--vertical cd--has-siblings cd--has-media cd--media__image']/child::div/descendant::div/child::a/descendant::img")).click();
// So basically to find xpath go look at the link through dom find child and descendant to come upto 1 of 1
// use these when looking for child and descendants /child::div if div or whatever it shows sometimes could be h3
	}
	
	@After
	public void tearDown() {
	//	driver.close();
	//	driver.quit();
		
	}
	

	
}
