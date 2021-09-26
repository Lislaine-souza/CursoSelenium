import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteGoogle {
	
	@Test
	public void teste() {
		System.setProperty("webdriver.gecko.driver", "C:\\Github\\Selenium-iniciante02\\driver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		Assert.assertEquals("Google", driver.getTitle());
	}

}
