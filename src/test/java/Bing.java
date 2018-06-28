import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Bing {
	
WebDriver driver; 
	
	@BeforeClass
	public void TestInitiator() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sunanda1\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void Test001_LaunchBingTranslator() throws InterruptedException {		
		driver.get("https://www.bing.com/translator");	
		Thread.sleep(1000);
		String screenName = driver.findElement(By.cssSelector("a[title=\"Translator\"]")).getText();
		Assert.assertEquals(screenName,"Translator");
	}
	
	@Test
	public void Test002_Language1() throws InterruptedException {
		driver.findElement(By.cssSelector("select#t_sl")).click();
		Thread.sleep(1000);
		Select oSelect = new Select(driver.findElement(By.cssSelector("select#t_sl")));
		oSelect.selectByVisibleText("English");
	}
	
	@Test
	public void Test003_Language() throws InterruptedException {
		driver.findElement(By.cssSelector("select#t_tl")).click();
		Thread.sleep(1000);
		Select oSelect = new Select(driver.findElement(By.cssSelector("select#t_tl")));
		oSelect.selectByVisibleText("Hindi");
	}
	
	@Test
	public void Test004_EnterText() throws InterruptedException {
		driver.findElement(By.cssSelector("textarea#t_sv")).sendKeys("This is America.");
		String s1 = driver.findElement(By.cssSelector("textarea#t_sv")).getText();
		String s2 = driver.findElement(By.cssSelector("textarea#t_tv")).getText(); 
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("a#t_revIcon")).click();
		Thread.sleep(1000);
				
		driver.findElement(By.cssSelector("textarea#t_sv")).sendKeys(s2);
		driver.findElement(By.cssSelector("textarea#t_tv")).sendKeys(s1);
		Thread.sleep(1000);
		
		String sp2 = driver.findElement(By.cssSelector("textarea#t_tv")).getText();
		
		Assert.assertEquals(s1, sp2);
	}
	

}
