> Em desenvolvimento :warning:

# Curso Selenium
<h3>WebDrive JAVA</h3>

1. Primeiro desafio

<p>Efetuar o cadastro simples com os campos:</p>
<ul>
<li>Nome</li>
<li>Sobrenome</li>
<li>Sexo</li>
<li>Comida favorita</li>
<li>Escolaridade</li>
<li>Pratica Esportes?</li>
<li>clicar no botão "cadastrar"</li>
<li>Verificar se foi cadastrado com sucesso.</li>
</ul>

![basic auth](https://github.com/Lislaine-souza/CursoSelenium/blob/main/doc/desafio01.gif)
#

2. Segundo desafio

<p>Testar regras de negócio:</p>

<h5>Campos obrigatórios</h5>
<h6>(Não podem estar vazio)</h6>

* Nome
* Sobrenome
* Sexo


<h5>Campos com regras de opções</h5>
<h6>(Não é obrigatório escolher uma opção)</h6>


* Comidas: o usuário não pode escolher a opção vegetariano com a opção carne ou frango.

* Esportes: o usuário não pode escolher a  opção o que é esporte? com alguma opção de esporte.(corrida,futbol,etc...)

![basic auth](https://github.com/Lislaine-souza/CursoSelenium/blob/main/doc/desafio02.gif)
#

3. Reúso de código e soluções para evitar repetição.

<h4>como melhor o código?</h4>
<p>
Temos duas maneira de melhorar o código.

1° Solução<br>
   Seria criar um método, e chamar esse método em cada teste.<br>
   Lembrando de tornar a variável global caso for necessário.
<br>
<br>
 
  ```java
 
  public class TesteRegrasDeNegocio {
	
	private WebDriver driver;
  
  public void inicio(){
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(850, 1200));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}
  
  @Test
	public void DeveValidarNomeObrigatorio() {
		inicio();	
		WebElement botao = driver.findElement(By.id("elementosForm:cadastrar"));
		botao.click();
		driver.switchTo().alert();
		Assert.assertEquals("Nome eh obrigatorio", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.close();
				
	}
  
  ```
  
<br>
<br>
  
   
2° Solução<br>
   Para determinar que um método vai ser executado antes dos demais métodos da classe de teste utilizamos a anotações do framework JUnit:<br>
   @Before -  vai ser executado antes de cada caso de teste.<br>
   @After  -  vai ser executado depois de cada caso de teste.
  
   Assim tornando o código ainda mais dry e eficiente.
  
<br>
<br>

```java

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
  
		WebElement botao = driver.findElement(By.id("elementosForm:cadastrar"));
		botao.click();
		driver.switchTo().alert();
		Assert.assertEquals("Nome eh obrigatorio", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
						
	}

```

</p>






