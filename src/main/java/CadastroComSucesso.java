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
private DSL dsl;
	
	@Before
	public void inicio(){
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(850, 1200));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver); 
	}
	
	@After
	public void fim() {
		driver.close();
	}
	
	@Test
	public void DeveEfetuarTodoCadastro() {
		
		dsl.escreve("elementosForm:nome", "Lislaine");
		dsl.escreve("elementosForm:sobrenome", "de Souza");
		dsl.clicarRadio("elementosForm:sexo:1");
		dsl.clicarRadio("elementosForm:comidaFavorita:2");
		dsl.clicarRadio("elementosForm:comidaFavorita:0");
		dsl.selecionarCombo("elementosForm:escolaridade", "Especializacao");
		dsl.selecionarCombo("elementosForm:esportes", "Natacao");
		dsl.selecionarCombo("elementosForm:esportes", "Corrida");
		dsl.clicarBotao("elementosForm:cadastrar");
		/*driver.findElement(By.id("elementosForm:nome")).sendKeys("Lislaine");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("de Souza");
		driver.findElement(By.id("elementosForm:sexo:1")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Especializacao");
				
		WebElement elementDuplo = driver.findElement(By.id("elementosForm:esportes"));
		Select combos = new Select(elementDuplo);
		combos.selectByVisibleText("Natacao");
		combos.selectByVisibleText("Corrida");

		WebElement botao = driver.findElement(By.id("elementosForm:cadastrar"));
		botao.click();*/
		
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
