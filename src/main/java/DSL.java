import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
	
	private WebDriver driver;
	
	public DSL(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	/********* TextField e TextArea ************/
	
	public void escreve(By by,String texto) {
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(texto);
	}

	public void escreve(String id_campo, String texto) {
		escreve(By.id(id_campo), texto);
		
	} 
	
	public String obterValorCampo(String id_campo) {
		return driver.findElement(By.id(id_campo)).getAttribute("value");
	}
	
	/********* Radio e Check ************/
	
	public void clicarRadio(String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public boolean isRadioMarcado(String id) {
		return driver.findElement(By.id(id)).isSelected();
	}
	
	/********* Combo ************/
	
	public void selecionarCombo(String id, String valor) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);	
	}
	
	public String obterValorCombo(String id) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
		
	}
	
	/********* Botao ************/
	
	public void clicarBotao(String id) {
		driver.findElement(By.id(id)).click();
	}
	
	/********* Link ************/
	
	public void clicarLink(String link) {
		driver.findElement(By.id(link)).click();
	}
	
	/********* Textos ************/
	
	public String obterTexto(By by) {
		return driver.findElement(by).getText();
		
	}
	
	public String obterTexto(String id) {
		return obterTexto(By.id(id));
		
	}
	
	/********* Alerts ************/
	
	public String alertaObterTexto(){
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

	public String alertaObterTextoEAceita(){
		Alert alert = driver.switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;
		
	}
}
