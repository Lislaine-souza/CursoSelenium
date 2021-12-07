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

public class TesteCampoTreinamento {
	
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
	public void testeTextField() {
		
		dsl.escreve("elementosForm:nome", "Teste");
		Assert.assertEquals("Teste", dsl.obterValorCampo("elementosForm:nome"));
		//driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste");
		//Assert.assertEquals("Teste", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		
//		define um TimeOut para em caso de não encontrar elementos na página.
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  
	}
	
	@Test
	public void testeTextFieldDuplo(){
		dsl.escreve("elementosForm:nome", "Lis");
		Assert.assertEquals("Lis", dsl.obterValorCampo("elementosForm:nome"));
		dsl.escreve("elementosForm:nome", "Souza");
		Assert.assertEquals("Souza", dsl.obterValorCampo("elementosForm:nome"));
	}
	
	@Test
	public void deveInteragirComTextArea() {
		
		dsl.escreve("elementosForm:sugestoes", "teste area");
		Assert.assertEquals("teste area", dsl.obterValorCampo("elementosForm:sugestoes"));
//		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste area");
//		Assert.assertEquals("teste area", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
				
	}
	 
	@Test
	public void deveInteragirComRadioButton() {
		
		dsl.clicarRadio("elementosForm:sexo:1");
		Assert.assertTrue(dsl.isRadioMarcado("elementosForm:sexo:1"));
		//driver.findElement(By.id("elementosForm:sexo:0")).click();
		//Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());

	}
	
	@Test
	public void deveInteragirComCheckBox() {
		
		dsl.clicarRadio("elementosForm:comidaFavorita:2");
		Assert.assertTrue(dsl.isRadioMarcado("elementosForm:comidaFavorita:2"));
		//driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		//Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
	
	}
	
	@Test
	public void deveInteragirComCombo() {
		
//		Os index começam do zero
//		combo.selectByIndex(2);
//		Ou podemos passar o valor do elemneto
//		combo.selectByValue("superior");
//		Ou selecionar valor visivel, nesse caso usamos o valor visivel
		dsl.selecionarCombo("elementosForm:escolaridade", "2o grau completo");
		Assert.assertEquals("2o grau completo",dsl.obterValorCombo("elementosForm:escolaridade"));
	
	}
	
	@Test
	public void deveVerificarValoresCombo() {
		
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
	
	@Test
	public void deveVerificarValoresComboMultiplo() {
		
		dsl.selecionarCombo("elementosForm:esportes", "Natacao");
		dsl.selecionarCombo("elementosForm:esportes", "Corrida");
		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
		
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		//combo.selectByVisibleText("Natacao");
		//combo.selectByVisibleText("Corrida");
		//combo.selectByVisibleText("O que eh esporte?");
		
		java.util.List<WebElement> allSelectedOpitions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectedOpitions.size());
		
		combo.deselectByVisibleText("Corrida");
		allSelectedOpitions = combo.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOpitions.size());
		
	}
	
	@Test
	public void deveInteragirComBotoes() {
		
		dsl.clicarBotao("buttonSimple");
		
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		//botao.click();
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));	
	}
	
	@Test
//  usamos @ignore para o teste não ser executado
//  @Ignore
	public void deveInteragirComLinks() {
		
		dsl.clicarLink("Voltar");
		Assert.assertEquals("Voltou!", dsl.obterTexto("resultado"));
		//driver.findElement(By.linkText("Voltar")).click();
		//Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());			
	}	
	  
	@Test
	public void deveBuscarTextosNaPagina() {
		
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", dsl.obterTexto(By.className("facilAchar")));
		//Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.className("facilAchar")).getText());				
//		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de treinamento"));
		
	}

}
