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
import org.openqa.selenium.interactions.Actions;

public class TestCaseThree {

	@Test
	public void test() throws InterruptedException {
		
		//Ubica la version de chrome driver la cual tenemos debe coincidir con la versión del navegador de chrome
		System.setProperty("webDriver.chrome.driver", "./src/test/resources/ChromeDriver/chromedriver.exe");

        // Inicializar el WebDriver (en este caso, Chrome)
        WebDriver driver = new ChromeDriver();

        // Navegar a la página de Demo QA
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        
        //Tiempo de espera 3 segundos
        Thread.sleep(3000);
        
        // Crear una instancia de JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Hacer scroll hacia abajo en la página
        js.executeScript("window.scrollBy(0, 300);"); // Se usa el valor de 300 según cuantos pixeles baja en el scroll
        
       
        // Localizar los elementos y dar click en el modulo Widget
        WebElement Widgets = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[4]"));
        Widgets.click();
        
        //Tiempo de espera 3 segundos y bajar scroll
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0, 500);");
        
        //Localizar el slider y dar click en la opcion slider
        WebElement Slider = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[4]/div/ul/li[4]"));
        Slider.click();
        
        // Encontrar el elemento del slider
	    WebElement slider = driver.findElement(By.xpath("//*[@id=\"sliderContainer\"]"));
	
	    // Obtener el tamaño del slider
	    int sliderWidth = slider.getSize().getWidth();
	
	    // Crear una instancia de la clase Actions para mover el slider
	    Actions actions = new Actions(driver);
	
	    // Mover el slider a la posición deseada, para este caso se mueve al negativo hasta que dio el valor 3 ya que no es lineal
	    actions.dragAndDropBy(slider, -270, 0).build().perform();
        
	  
	    //Obtener el elemento donde se encuentra el valor del slider
        WebElement Valor = driver.findElement(By.xpath("//*[@id=\"sliderValue\"]"));
       
        //Valida si el slider es 3
        String ValorObtenido = Valor.getAttribute("value");
        String ValorEsperado = "3";
      
        if (ValorObtenido.contains(ValorEsperado)) {
            System.out.println("Posicion 3 del slider");
        } else {
            System.out.println("No esta en la posición 3");
        }

        // Cerrar el navegador
        driver.quit();
		
	}

}
