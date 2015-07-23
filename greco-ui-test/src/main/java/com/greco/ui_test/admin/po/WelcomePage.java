package com.greco.ui_test.admin.po;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**
 * Precondiciones: no deben existir en la base de datos los usuario 
 * @author AMG
 *
 */

public class WelcomePage {
	private final WebDriver driver;
	//Indentificador del formulario principal por el cual identificamos que la página es la que corresponde.
	private final String formId="welcomeForm";
	
	public WelcomePage(WebDriver driver) {
		this.driver = driver;
	       

        // Check that we're on the right page.
        //Lo comprobamos por el id del formulario.
        try {
        	driver.findElement(By.id(formId));
        } catch (NoSuchElementException e){
        	throw new IllegalStateException("Página no corresponde a la clase. No entruentro formulario " + formId);	
        }
		
	}
	
	
}
