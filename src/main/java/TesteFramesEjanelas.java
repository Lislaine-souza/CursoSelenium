import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteFramesEjanelas {
	@Test
	public void DeveIntergirComFrames() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(850, 1200));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.switchTo().frame("frame1");
		driver.findElement(By.id("frameButton")).click();
		
		Alert alerta = driver.switchTo().alert();
		String texto = alerta.getText();
		Assert.assertEquals("Frame OK!", texto);
		alerta.accept();
		driver.switchTo().defaultContent();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
		
		driver.close();
	}
	@Test
	public void DeveIntergirComJanelas() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(850, 1200));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("buttonPopUpEasy")).click();
		driver.switchTo().window("Popup");
		driver.findElement(By.tagName("textarea")).sendKeys("deu certo!");
		driver.close();
		driver.switchTo().window("");
		driver.findElement(By.tagName("textarea")).sendKeys("e agora!");
		
	}
	@Test
	public void DeveIntergirComJanelasSemTitulo() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(850, 1200));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("buttonPopUpHard")).click();
		//System.out.print(driver.getWindowHandle());
		//System.out.print(driver.getWindowHandles());
		
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[1]);
		driver.findElement(By.tagName("textarea")).sendKeys("deu certo!");
		driver.close();
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
		driver.findElement(By.tagName("textarea")).sendKeys("e agora!");
		driver.close();
		
	}
		

}
