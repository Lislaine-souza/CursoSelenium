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
private CampoTreinamentoPage page;
	
	@Before
	public void inicio(){
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(850, 1200));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		new DSL(driver); 
		page = new CampoTreinamentoPage(driver);
	}
	
	@After
	public void fim() {
		driver.close();
	}
	
	@Test
	public void DeveEfetuarTodoCadastro() {
		
		page.setNome("Lislaine");
		//dsl.escreve("elementosForm:nome", "Lislaine");
		page.setSobrenome("de Souza");
		//dsl.escreve("elementosForm:sobrenome", "de Souza");
		page.setSexoFeminino();
		page.setComidaPizza();
		page.setEscolaridade("Mestrado");
		page.setEsportes("Natacao");
		page.setCadastrar();
		
				
//		Verificar se foi cadastrado
		
		Assert.assertTrue(page.obterResultadoCadastro().startsWith("Cadastrado!"));
		Assert.assertTrue(page.obterNomeCadastro().endsWith("Lislaine"));
		Assert.assertEquals("Sobrenome: de Souza",page.obterSobreNomeCadastro());
		Assert.assertEquals("Sexo: Feminino",page.obterSexoCadastro());
		Assert.assertEquals("Comida: Pizza", page.obterComidaCadastro());
		Assert.assertEquals("Escolaridade: mestrado", page.obterEscolaridadeCadastro());
		Assert.assertEquals("Esportes: Natacao", page.obterEsporteCadastro());
		
		//Assert.assertTrue(driver.findElement(By.id("descEscolaridade")).getText().endsWith("Mestrado")); 
		//Assert.assertTrue(driver.findElement(By.id("descEsportes")).getText().endsWith("Natacao"));
		
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("\nFIM DO TESTE :D");
		
	}

}
