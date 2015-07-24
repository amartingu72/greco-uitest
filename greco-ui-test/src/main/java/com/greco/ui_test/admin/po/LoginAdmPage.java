package com.greco.ui_test.admin.po;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;


/**
 * Objeto para gestión de test de la página de incio de la consola de administración.
 * @author AMG
 *
 */
public class LoginAdmPage{
	private final WebDriver driver;
	//Indentificador del formulario principal por el cual identificamos que la página es la que corresponde.
	private final String formId="adminLoginForm";
	
	
	
	
	
	public LoginAdmPage(WebDriver driver) {
		this.driver = driver;
	       

        // Check that we're on the right page.
        //Lo comprobamos por el id del formulario.
        try {
        	driver.findElement(By.id(formId));
        } catch (NoSuchElementException e){
        	throw new IllegalStateException("Página no corresponde a la clase. No entruentro el formulario " + formId);	
        }
		
	}
	
	By usernameLocator = By.id(formId + ":username");
    By passwordLocator = By.id(formId + ":passwd");
    By loginButtonLocator = By.id(formId + ":loginBtn");
    By newAccountButtonLocator = By.id(formId + ":newAccountBtn");

	public LoginAdmPage typeUsername(String username) {
        // This is the only place that "knows" how to enter a username
        driver.findElement(usernameLocator).sendKeys(username);

        // Return the current page object as this action doesn't navigate to a page represented by another PageObject
        return this;    
    }

    // The login page allows the user to type their password into the password field
    public LoginAdmPage typePassword(String password) {
        // This is the only place that "knows" how to enter a password
        driver.findElement(passwordLocator).sendKeys(password);

        // Return the current page object as this action doesn't navigate to a page represented by another PageObject
        return this;    
    }
    
    public SelectcomPage submitLoginOk() {
        // This is the only place that submits the login form and expects the destination to be the home page.
        // A seperate method should be created for the instance of clicking login whilst expecting a login failure. 
        driver.findElement(loginButtonLocator).click();

        // Return a new page object representing the destination. Should the login page ever
        // go somewhere else (for example, a legal disclaimer) then changing the method signature
        // for this method will mean that all tests that rely on this behaviour won't compile.
        return new SelectcomPage(driver);    
    }
    
    /**
     * Login con éxito.
     * @param username Usuario.
     * @param pwd Contraseña
     * @return Página de selección de contraseña
     */
    public SelectcomPage submitLoginOk(String username, String pwd){
    	typeUsername(username);
    	typePassword(pwd);
    	return submitLoginOk();
    }
    
    /**
     * Login con éxito.
     * @param username Usuario.
     * @param pwd Contraseña
     * @return Página de selección de contraseña
     */
    public LoginAdmPage submitLoginKo(String username, String pwd){
    	typeUsername(username);
    	typePassword(pwd);
    	driver.findElement(loginButtonLocator).click();
    	
    	return new LoginAdmPage(driver);
    }
    
    
    /**
     * Crear nueva cuenta.
     * @return Página de nueva cuenta.
     */
    public NewaccountPage newAccount(){
    	 driver.findElement(newAccountButtonLocator).click();
    	 return new NewaccountPage(driver);
    }
	

}
