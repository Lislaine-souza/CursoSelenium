import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteRegrasDeNegocio {
	@Test
	public void DeveValidarNomeObrigatorio() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(850, 1200));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		WebElement botao = driver.findElement(By.id("elementosForm:cadastrar"));
		botao.click();
		driver.switchTo().alert();
		Assert.assertEquals("Nome eh obrigatorio", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.close();
				
	}
	@Test
	public void DeveValidarSobrenomeObrigatorio() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(850, 1200));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Lislaine");
		WebElement botao = driver.findElement(By.id("elementosForm:cadastrar"));
		botao.click();
		driver.switchTo().alert();
		Assert.assertEquals("Sobrenome eh obrigatorio", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.close();
	}
	@Test
	public void DeveValidarSexoObrigatorio() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(850, 1200));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Lislaine");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("de Souza");
		WebElement botao = driver.findElement(By.id("elementosForm:cadastrar"));
		botao.click();
		driver.switchTo().alert();
		Assert.assertEquals("Sexo eh obrigatorio", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.close();
	}
	@Test
	public void DeveValidarComidas() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(850, 1200));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
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
		driver.close();
	}
	@Test
	public void DeveValidarEsportes() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(850, 1200));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
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
		driver.close();
	}

}
