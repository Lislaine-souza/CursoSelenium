 import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class RegrasDeNegocioTeste {
	
	private WebDriver driver;
	private CampoTreinamentoPage page;
	
	@Before
	public void inicio(){
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(850, 1200));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage(driver);
	}
	
	@After
	public void fim() {
		driver.close();
	}
	
	@Test
	public void DeveValidarNomeObrigatorio() {
		//inicio();	
		page.setCadastrar();
		Assert.assertEquals("Nome eh obrigatorio", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		//driver.close();
				
	}
	@Test
	public void DeveValidarSobrenomeObrigatorio() {
				
		page.setNome("Lislaine");
		page.setCadastrar();
		Assert.assertEquals("Sobrenome eh obrigatorio", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
	}
	@Test
	public void DeveValidarSexoObrigatorio() {
				
		page.setNome("Lislaine");
		page.setSobrenome("de Souza");
		page.setCadastrar();
		
		driver.switchTo().alert();
		Assert.assertEquals("Sexo eh obrigatorio", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
	}
	@Test
	public void DeveValidarComidas() {
				
		page.setNome("Lislaine");
		page.setSobrenome("de Souza");
		page.setSexoFeminino();
		page.setComidaCarne();
		page.setComidaVegetariano();
		page.setCadastrar();

		driver.switchTo().alert();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
	}
	@Test
	public void DeveValidarEsportes() {
		
		page.setNome("Lislaine");
		page.setSobrenome("de Souza");
		page.setSexoFeminino();
		page.setComidaCarne();
		page.setEsportes("Corrida", "O que eh esporte?");
		page.setCadastrar();
		
		driver.switchTo().alert();
		Assert.assertEquals("Voce faz esporte ou nao?", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
	}

}
