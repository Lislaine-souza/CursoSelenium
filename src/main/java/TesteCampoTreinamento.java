import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.validator.PublicClassValidator;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.sun.tools.javac.util.List;

public class TesteCampoTreinamento {
	@Test
	public void testeTextField() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 1000));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste");
		Assert.assertEquals("Teste", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		
		 //define um TimeOut para em caso de não encontrar elementos na página.
		 // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  driver.close();
		
	}
	
	@Test
	public void deveInteragirComTextArea() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 1000));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste area\na letra n pula linha\nacho que isso");
		//Assert.assertEquals("teste area", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		
		
		driver.close();
		
	}
	
	@Test
	public void deveInteragirComRadioButton() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 1000));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		
		driver.close();
		
	}
	
	@Test
	public void deveInteragirComCheckBox() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 1000));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		
		driver.close();
		
	}
	
	@Test
	public void deveInteragirComCombo() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 1000));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		//Os index começam do zero
		//combo.selectByIndex(2);
		//Ou podemos passar o valor do elemneto
		//combo.selectByValue("superior");
		//Ou selecionar valor visivel
		combo.selectByVisibleText("2o grau completo");
		Assert.assertEquals("2o grau completo",combo.getFirstSelectedOption().getText());
		
		driver.close();
	
	}
	
	@Test
	public void deveVerificarValoresCombo() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 1000));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		java.util.List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());
		
		boolean encontrou = false;
		for(WebElement option:  options) {
			if(option.getText().equals("Mestrado")){
				encontrou = true;
				break;	
			}
			
		}
		
		Assert.assertTrue(encontrou);	
	}

}
