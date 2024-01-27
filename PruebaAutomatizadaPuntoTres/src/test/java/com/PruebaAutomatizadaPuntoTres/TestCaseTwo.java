package com.PruebaAutomatizadaPuntoTres;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.CdpVersionFinder;

public class TestCaseTwo {


	@Test
	public void testMain() throws InterruptedException {
		
		//Ubica la version de chrome driver la cual tenemos debe coincidir con la versión del navegador de chrome
		System.setProperty("webDriver.chrome.driver", "./src/test/resources/ChromeDriver/chromedriver.exe");

        // Inicializar el WebDriver (en este caso, Chrome)
        WebDriver driver = new ChromeDriver();

        // Navegar a la página Demo QA
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        
        //Tiempo de espera 3 segundos
        Thread.sleep(3000);
        
        // Crear una instancia de JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Hacer scroll hacia abajo en la página
        js.executeScript("window.scrollBy(0, 300);"); // Se usa el valor de 300 según cuantos pixeles baja en el scroll
        
        
      
        
        // Localizar los elementos
        WebElement Elements = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]"));
        
        //Pulsar click en el menu Elements
        Elements.click();
        Thread.sleep(3000);
        
        // Hacer scroll hacia abajo otra vez
        js.executeScript("window.scrollBy(0, 500);");
        
        //Pulsar click en la opción Links
        WebElement Links = driver.findElement(By.xpath("//*[@id=\"item-5\"]"));
        Links.click();
        
        //Pulsar click en el primer link
        WebElement PrimerLink = driver.findElement(By.id("simpleLink"));
        PrimerLink.click();
        

        //Se obtiene el numero de pestañas abiertas
        Set<String> handles = driver.getWindowHandles();
        
        //Se itera y se obtiene la nueva pestaña la cual validamos si se abre correctamente
        for (String handle : handles) {
            driver.switchTo().window(handle);
            // Esta es la nueva pestaña
            if (driver.getTitle().equals("DEMOQA")) {
                System.out.println("El primer link abre la nueva pestaña correctamente");
                break;
            }
        }
        
        //cambiar de pestaña a la principal
        driver.switchTo().window((String) handles.toArray()[0]);
        
        //dar click al segundo link
        WebElement SegundoLink = driver.findElement(By.xpath("//*[@id=\"dynamicLink\"]"));
        SegundoLink.click();
        

        
        //Se itera y se obtiene la nueva pestaña la cual validamos si se abre correctamente
        for (String handle : handles) {
            driver.switchTo().window(handle);
            // Esta es la nueva pestaña del segundo link
            if (driver.getTitle().equals("DEMOQA")) {
                System.out.println("El Segundo link abre la nueva ventana correctamente");
                break;
            }
        }
        
        //cambiar de pestaña a la principal
        driver.switchTo().window((String) handles.toArray()[0]);
        
        
        //dar click al Tercer link
        WebElement LinkCreated = driver.findElement(By.xpath("//*[@id=\"created\"]"));
        LinkCreated.click();
        
        //dar click al cuarto link
        WebElement LinkNoContent = driver.findElement(By.xpath("//*[@id=\"no-content\"]"));
        LinkNoContent.click();
        
        //dar click al quinto link
        WebElement LinkMoved = driver.findElement(By.xpath("//*[@id=\"moved\"]"));
        LinkMoved.click();
        
        //dar click al Sexto link
        WebElement LinkBadRequest = driver.findElement(By.xpath("//*[@id=\"bad-request\"]"));
        LinkBadRequest.click();
        
        
        //dar click al Septimo link
        WebElement LinkUnauthorized = driver.findElement(By.xpath("//*[@id=\"unauthorized\"]"));
        LinkUnauthorized.click();
        
        //dar click al Octavo link
        WebElement LinkForbidden = driver.findElement(By.xpath("//*[@id=\"forbidden\"]"));
        LinkForbidden.click();
        
        //dar click al Noveno link
        WebElement LinkNotFound = driver.findElement(By.xpath("//*[@id=\"invalid-url\"]"));
        LinkNotFound.click();
      
        //Obtener Links
        WebElement TodosLinks = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]"));
        System.out.println("Estos son los links: \n"+TodosLinks.getText());
        
        //Dar click al primero en orden alfabetico
        WebElement LinkBR = driver.findElement(By.xpath("//*[@id=\"bad-request\"]"));
        LinkBR.click();
        
        //Se crea la variable para obtener los links y para validar el ultimo mensaje
        String TodosLosLinks = TodosLinks.getText();
        String mensajePrimerLinkAlfabetico = "Bad Request";
        
        //Se valida el ultimo mensaje que si se de el click correctamente al primero en orden alfabetico
        if (TodosLosLinks.contains(mensajePrimerLinkAlfabetico)) {
            System.out.println("Se da click al primer link en orden alfabetico y se muestra el mensaje correcto");
        } else {
            System.out.println("No se muestra el mensaje");
        }
        
        // Cerrar el navegador
        driver.quit();
		
      
	}
}
