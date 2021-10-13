 import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteRegrasDeNegocio {
	
	private WebDriver driver;
	
	@Before
	public void inicio(){
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(850, 1200));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}
	
	@After
	public void fim() {
		driver.close();
	}
	
	@Test
	public void DeveValidarNomeObrigatorio() {
		//inicio();	
		WebElement botao = driver.findElement(By.id("elementosForm:cadastrar"));
		botao.click();
		driver.switchTo().alert();
		Assert.assertEquals("Nome eh obrigatorio", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		//driver.close();
				
	}
	@Test
	public void DeveValidarSobrenomeObrigatorio() {
				
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Lislaine");
		WebElement botao = driver.findElement(By.id("elementosForm:cadastrar"));
		botao.click();
		driver.switchTo().alert();
		Assert.assertEquals("Sobrenome eh obrigatorio", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
	}
	@Test
	public void DeveValidarSexoObrigatorio() {
				
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Lislaine");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("de Souza");
		WebElement botao = driver.findElement(By.id("elementosForm:cadastrar"));
		botao.click();
		driver.switchTo().alert();
		Assert.assertEquals("Sexo eh obrigatorio", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
	}
	@Test
	public void DeveValidarComidas() {
				
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Lislaine");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("de Souza");
		driver.findElement(By.id("elementosForm:sexo:1")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		WebElement botao = driver.findElement(By.id("elementosForm:cadastrar"));
		botao.click();
		driver.switchTo().alert();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
	}
	@Test
	public void DeveValidarEsportes() {
				
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Lislaine");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("de Souza");
		driver.findElement(By.id("elementosForm:sexo:1")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		WebElement elementDuplo = driver.findElement(By.id("elementosForm:esportes"));
		Select combos = new Select(elementDuplo);
		combos.selectByVisibleText("Corrida");
		combos.selectByVisibleText("O que eh esporte?");
		WebElement botao = driver.findElement(By.id("elementosForm:cadastrar"));
		botao.click();
		driver.switchTo().alert();
		Assert.assertEquals("Voce faz esporte ou nao?", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
	}

}
