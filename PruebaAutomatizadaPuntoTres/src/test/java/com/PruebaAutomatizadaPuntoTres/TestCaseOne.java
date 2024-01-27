package com.PruebaAutomatizadaPuntoTres;

import static org.junit.Assert.*;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.CdpVersionFinder;

public class TestCaseOne {

	@Test
	public void testMain() throws InterruptedException {
		
		//Ubica la version de chrome driver la cual tenemos debe coincidir con la version del navegador de chrome
		System.setProperty("webDriver.chrome.driver", "./src/test/resources/ChromeDriver/chromedriver.exe");

        // Inicializar el WebDriver (en este caso, Chrome)
        WebDriver driver = new ChromeDriver();

        // Navegar a la página de Demo QA y maximizamos la pantalla
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        
        //Tiempo de espera 3 segundos
        Thread.sleep(3000);
        
     // Crear una instancia de JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Hacer scroll hacia abajo en la página
        js.executeScript("window.scrollBy(0, 300);"); // Se usa el valor de 300 según cuantos pixeles baja en el scroll
        
        
        // Localizar los elementos
        WebElement Formulario = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[2]"));
        
        // Dar Click en el formulario y espera de 3 segundos
        Formulario.click();
        Thread.sleep(3000);
        
        // Se vuelve a bajar scroll
        js.executeScript("window.scrollBy(0, 500);");
        
        // Se da click al boton PracticeForm que abre el formulario
        WebElement PracticeForm = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[2]/div"));
        PracticeForm.click();
        
        //Llenar datos del formulario como nombre, apellido, correo
        WebElement Name = driver.findElement(By.id("firstName"));
        Name.sendKeys("Luis");
        
        WebElement LastName = driver.findElement(By.id("lastName"));
        LastName.sendKeys("Valencia");
        
        WebElement Email = driver.findElement(By.id("userEmail"));
        Email.sendKeys("lvalenciaarias@gmail.com");
        
        //Scroll abajo otra vez
        js.executeScript("window.scrollBy(0, 50);");
        
        //Llenar el checkbox de genero
        WebElement CheckGender = driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]"));
        CheckGender.click();
        
      //Llenar el campo de Mobile
        WebElement Mobile = driver.findElement(By.id("userNumber"));
        Mobile.sendKeys("3148510846");
        
        //Llenar la fecha de nacimiento, este campo ya tiene una fecha por defecto, por lo que se procede a borrarlo primero
        WebElement DateBirth = driver.findElement(By.id("dateOfBirthInput"));
        DateBirth.sendKeys(Keys.CONTROL + "a");
        DateBirth.sendKeys(Keys.SPACE);
        DateBirth.sendKeys("05 Jan 2000");
        DateBirth.sendKeys(Keys.ENTER);
        
        //disminuir el zoom al 50 % debido a que no se visualiza el boton submit para enviar formulario
        js.executeScript("document.body.style.zoom='" + 50 + "%'");
        Thread.sleep(3000);
        
        //Localizar boton submit y pulsarlo.
        WebElement Submit = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        Submit.sendKeys(Keys.ENTER);
        
        
        
        // Encontrar un elemento que contenga el mensaje de envio correcto
        WebElement elementoFinal = driver.findElement(By.xpath("//*[@id=\"example-modal-sizes-title-lg\"]"));

        // Obtener el texto del elemento
        String mensajeEnPagina = elementoFinal.getText();

        // Mensaje que se quiere validar
        String mensajeEsperado = "Thanks for submitting the form";

        // Validar si el mensaje esperado está presente en la página
        if (mensajeEnPagina.contains(mensajeEsperado)) {
            System.out.println("El mensaje esperado esta presente despues de enviar el formulario");
        } else {
            System.out.println("El mensaje esperado no está presente en la página despues de enviar el formulario");
        }
        

        // Cerrar el navegador
        driver.quit();
		
	}


}
