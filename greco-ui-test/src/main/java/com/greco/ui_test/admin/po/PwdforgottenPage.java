package com.greco.ui_test.admin.po;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class PwdforgottenPage {
	private final WebDriver driver;
	//Indentificador del formulario principal por el cual identificamos que la página es la que corresponde.
	private final String formId="pwdForgottenForm";
	
	public PwdforgottenPage(WebDriver driver) {
		this.driver = driver;
	       

        // Check that we're on the right page.
        //Lo comprobamos por el id del formulario.
        try {
        	driver.findElement(By.id(formId));
        } catch (NoSuchElementException e){
        	throw new IllegalStateException("Página no corresponde a la clase. No entruentro formulario " + formId);	
        }
		
	}
	By emailLocator = By.id(formId + ":email");
    By submitButtonLocator = By.id(formId + ":submitBtn");
    

	public PwdforgottenPage typeEmail(String email) {
        // This is the only place that "knows" how to enter a username
        driver.findElement(emailLocator).sendKeys(email);

        // Return the current page object as this action doesn't navigate to a page represented by another PageObject
        return this;    
    }
	
	/**
	 * Tras hacer un sbmit, detecta el error y va a la página de pwd enviada.
	 * @return
	 */
	public PwdsentPage submitOk() {
        // This is the only place that submits the login form and expects the destination to be the home page.
        // A seperate method should be created for the instance of clicking login whilst expecting a login failure. 
        driver.findElement(submitButtonLocator).click();

        // Return a new page object representing the destination. Should the login page ever
        // go somewhere else (for example, a legal disclaimer) then changing the method signature
        // for this method will mean that all tests that rely on this behaviour won't compile.
        return new PwdsentPage(driver);    
    }
	
	/**
	 * Tras hacer un submit, detecta un error y se queda en la misma página.
	 * @return
	 */
	public PwdforgottenPage submitKo() {
        // This is the only place that submits the login form and expects the destination to be the home page.
        // A seperate method should be created for the instance of clicking login whilst expecting a login failure. 
        driver.findElement(submitButtonLocator).click();

        // Return a new page object representing the destination. Should the login page ever
        // go somewhere else (for example, a legal disclaimer) then changing the method signature
        // for this method will mean that all tests that rely on this behaviour won't compile.
        return new PwdforgottenPage(driver);    
    }
	
}
