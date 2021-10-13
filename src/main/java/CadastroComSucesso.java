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

public class CadastroComSucesso {
	
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
	public void DeveEfetuarTodoCadastro() {
		
//		Preenche o campo nome e verifica
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Lislaine");
		Assert.assertEquals("Lislaine", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		
//		Prenche o campo sobrenome e verifica
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("de Souza");
		Assert.assertEquals("de Souza", driver.findElement(By.id("elementosForm:sobrenome")).getAttribute("value"));
		
//		Seleciona a opção e verifica
		driver.findElement(By.id("elementosForm:sexo:1")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:1")).isSelected());
		
//		seleciona os checks boxs e verifica
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());
		
//		selecionando um combo
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Especializacao");
		Assert.assertEquals("Especializacao",combo.getFirstSelectedOption().getText());
		
//		selecionar combo duplos
		WebElement elementDuplo = driver.findElement(By.id("elementosForm:esportes"));
		Select combos = new Select(elementDuplo);
		combos.selectByVisibleText("Natacao");
		combos.selectByVisibleText("Corrida");
//		verificando se o combo foi selecionado
		java.util.List<WebElement> allSelectedOpitions = combos.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOpitions.size());
		
//		Clicar no botão cadastrar
		WebElement botao = driver.findElement(By.id("elementosForm:cadastrar"));
		botao.click();
		
//		Verificar se foi cadastrado
		
		Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
		Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Lislaine"));
		Assert.assertTrue(driver.findElement(By.id("descSobrenome")).getText().endsWith("de Souza"));
		Assert.assertTrue(driver.findElement(By.id("descSexo")).getText().endsWith("Feminino"));
		Assert.assertTrue(driver.findElement(By.id("descComida")).getText().endsWith("Carne Pizza"));
		Assert.assertTrue(driver.findElement(By.id("descEscolaridade")).getText().endsWith("especializacao"));
		Assert.assertTrue(driver.findElement(By.id("descEsportes")).getText().endsWith("Natacao Corrida"));
		
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("\nFIM DO TESTE :D");
		
	}

}
