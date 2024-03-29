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

4. DSL - línguagens próprias para um problema. (Métodos especificos)

Criei uma Class para fazer todos os métodos que fossem necessário para o projeto, assim o código fica mais legível e organizado.

![basic auth](https://github.com/Lislaine-souza/CursoSelenium/blob/main/doc/fotoDSL.png)


</p>

5. Page Objects. (Classe com métodos especificos)

PageObject é um padrão de design que ajuda a aprimorar a manutenção de testes e reduzir a duplicação de código, 
também pode ser utilizado para descrever e documentar o fluxo de uma aplicação.

![basic auth](https://github.com/Lislaine-souza/CursoSelenium/blob/main/doc/fotoPAGE.png)

6. Teste Parametrizável 

Fazer uma classe genérica, que possa ser usada em várias aplicações.<br>
O nome dessa técnica é Data Driven Testing (testes orientados a dados).

Criamos um método estático que nos retorna uma coleção de arrays de objetos.
retornando a matriz de objetos que mapeamos.

``` java
public static Collection<Object[]> getCollection(){
		return Arrays.asList(new Object [] [] {
			{},
			{},
		});
	}


```






