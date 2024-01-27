# Technical test ilana lab
technical test ilana lab


Las pruebas se hicieron en mi pantalla del portatil, es decir en una Pantalla de portátil de 15 pulgadas con resolución 1366 px por 768 px. (No utilizar una segunda pantalla mas grande)

Todos los casos con el lenguaje de programación Java en el IDE de eclipse, y para el ultimo punto utilizando Selenium Web Driver

Para poder ejecutar las pruebas automatizadas:

Existen dos proyectos, el proyecto "ExamenIlanLab" tiene los dos primeros puntos los cuales son los ejercicios de FooBar y NumeroFeliz, y el proyecto "PruebaAutomatizadaPuntoTres" el cual tiene los tres puntos de automatización de selenium.

Para el proyecto "ExamenIlanLab" crear un proyecto java y ejecutar ambos archvivos .java (FooBar y NumeroFeliz)

Para el proyecto "PruebaAutomatizadaPuntoTres" se crea un proyecto Maven en donde:

1) Valida que se tenga configurado correctamente el archivo chromeDriver y que sea compatible con la version actual del navegador chrome, en mi caso la V121.0.6167.86--->Ubicación src/test/resources
2) Validar el archivo pom.xml que tenga correctamente las dependencias de maven y junit tal cual en la versiones como las tengo. (Ubicado en el proyecto por fuera de las subcarpetas)
3) Los tres casos de pruebas estan nombrados como TestCaseOne (el del formulario), TestCaseTwo (el de los links), TestCaseThree (El del slider) (ubicados en la carpeta src/test/java)
Nota:No alcance a organizar el codigo con el patron POM

-Cuando se vayan a ejecutar los casos de prueba ejecutarlos como JUnit Test