import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteCampoTreinamento {
	@Test
	public void teste() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 1000));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
	}

}
