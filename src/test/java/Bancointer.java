import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bancointer {
	
	
	WebDriver driver; 

	@Before
	public void setUp() throws Exception {
		
		//codigo para indicar o navegador
		//./ -> raiz do projeto
    System.setProperty("webdriver.chrome.driver", 
    		"./Driver/chromedriver.exe");
    
    //comandos para abrir 4devs
    driver = new ChromeDriver();
    driver.get("https://www.4devs.com.br/gerador_de_pessoas");
    driver.manage().window().maximize();
    //clicar no botao (GERAR PESSOAS)
    driver.findElement(By.cssSelector("#bt_gerar_pessoa")).click();
    
    //Armazenar informações do 4devs
    Thread.sleep(500);
    String nome =  driver.findElement(By.cssSelector("#nome")).getText();
    Thread.sleep(500);
    String tel = driver.findElement(By.cssSelector("#celular")).getText();
    Thread.sleep(500);
    String e = driver.findElement(By.cssSelector("#email")).getText();
    Thread.sleep(500);
    String cpf = driver.findElement(By.cssSelector("#cpf")).getText();
    Thread.sleep(500);
    String data = driver.findElement(By.cssSelector("#data_nasc")).getText();
    
    //fechar 4devs
    Thread.sleep(1000);
    driver.quit();
    
    
		//comando para chamar o driver dentro do before
		driver = new ChromeDriver();
		//comando para indicar URL
		driver.get("https://www.bancointer.com.br/");
		//comando para maximizar a tela
		driver.manage().window().maximize();
		//comando para interagir com os elementos
		driver.findElement(By.cssSelector("#gatsby-focus-wrapper > div > header > section > div > div > div > div > div.styles__LogoNIcons-sc-1gbjc3e-6.gjJzHM > div.styles__SearchNFlags-sc-1gbjc3e-8.yVPnY > div.styles__ButtonsWrapper-sc-1gbjc3e-9.PKrxs > button:nth-child(1)")).click();
		Thread.sleep(2000); //para dar uma pausa no codigo
		driver.findElement(By.cssSelector("#onetrust-accept-btn-handler")).click();
		driver.findElement(By.id("nome")).sendKeys(nome);
		Thread.sleep(1000);
		driver.findElement(By.id("celular")).sendKeys(tel);
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys(e);
		Thread.sleep(1000);
		driver.findElement(By.id("cpf")).sendKeys(cpf);
		Thread.sleep(1000);
		driver.findElement(By.id("dataNascimento")).sendKeys(data);
		//clicar no checkbox
		driver.findElement(By.cssSelector("body > div.style__ModalContent-wuavw4-0.hOXgJK > div.style__Container-sc-138k8xa-0.dlLgSU.d-flex.align-items-center > div > div:nth-child(2) > form > div > div:nth-child(6) > div > label")).click();
	    //clicar no botão "continuar"
		driver.findElement(By.cssSelector("body > div.style__ModalContent-wuavw4-0.hOXgJK > div.style__Container-sc-138k8xa-0.dlLgSU.d-flex.align-items-center > div > div:nth-child(2) > form > div > div.col-12.text-center > button")).click();
		
		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		
	}

	@Test
	public void test() throws InterruptedException {
		Thread.sleep(2000);
		String texto = driver.findElement(By.cssSelector("body > div.style__ModalContent-wuavw4-0.hOXgJK > div.style__Container-sc-138k8xa-0.dlLgSU.d-flex.align-items-center.sent > div > p")).getText();
		System.out.println(texto);
		assertEquals("Prontinho! Recebemos os seus dados.",texto);
		
	}

}
