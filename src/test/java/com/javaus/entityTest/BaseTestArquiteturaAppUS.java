package com.javaus.entityTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest
public class BaseTestArquiteturaAppUS {

	@Autowired
	protected Environment environment;

	private WebDriver driver;
	private WebElement searchResults;

	@BeforeEach
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@AfterEach
	public void closeBrowser() {
		driver.quit();
	}
	
    
    @Test
    public void deveEncontrarHaPaginaDeTesteCustomizadaDoSpringBoot() {
            
       	String devUrl = environment.getProperty("environments.dev.url");
    	String serverPort = environment.getProperty("server.porta.teste"); 
    	String TextoDeBusca = environment.getProperty("texto.de.busca.teste.arqui");
    	String urlTeste = devUrl.concat(":").concat(serverPort);
    	
    	System.out.println("Url de teste....... " + urlTeste);
    	
    	driver.get(urlTeste); // endereco da pagina de teste 
    	    	   	
      	searchResults = driver.findElement(By.xpath("//*[contains(text(),'"+ TextoDeBusca +"')]"));
        assertTrue(searchResults.isDisplayed());
    }
}
