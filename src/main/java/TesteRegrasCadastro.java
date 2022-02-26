import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class TesteRegrasCadastro {
	private WebDriver driver;
	private CampoTreinamentoPage page;
	
	@Parameter
	public String nome;
	@Parameter(value=1) 
	public String sobrenome;
	@Parameter(value=2)
	public String sexo;
	@Parameter(value=3)
	public List<String> comidas;
	@Parameter(value=4)
	public String [] esportes;
	@Parameter(value=5)
	public String msg;
	
	@Before
	public void inicio(){
		//driver = new ChromeDriver();
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(850, 1200));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage(driver);
	}
	
	@After
	public void fim() {
		driver.close();
	}
	
	@Parameters
	public static Collection<Object[]> getCollection(){
		return Arrays.asList(new Object [] [] {
			{"", "", "", Arrays.asList(), new String[] {}, "Nome eh obrigatorio"},
			{"Lislaine", "", "", Arrays.asList(), new String[] {}, "Sobrenome eh obrigatorio"},
			{"Lislaine", "souza", "", Arrays.asList(), new String[] {}, "Sexo eh obrigatorio"},
			{"Lislaine", "souza", "Feminino", Arrays.asList("Carne", "vegetariano"), new String[] {}, "Tem certeza que voce eh vegetariano?"},
			{"Lislaine", "souza", "Feminino", Arrays.asList("Carne"), new String[] {"Corrida", "O que eh esporte?"}, "Voce faz esporte ou nao?"},
						
		});
	}
@Test
public void DeveValidarRegras() {
		
		
		page.setNome(nome);
		page.setSobrenome(sobrenome);
		if (sexo.equals("Feminino")) {
			page.setSexoFeminino();
		}
		if (sexo.equals("Masculino")){
			page.setSexoMasculino();
		}
		if(comidas.contains("Carne")) page.setComidaCarne();
		if(comidas.contains("pizza")) page.setComidaPizza();
		if(comidas.contains("vegetariano")) page.setComidaVegetariano();
			
		page.setEsportes(esportes);
		page.setCadastrar();
		System.out.println(msg);
		
		driver.switchTo().alert();
		Assert.assertEquals(msg, driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
	}
}
