package com.greco.ui_test.admin.po;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class NewaccountPage {
	private final WebDriver driver;
	//Indentificador del formulario principal por el cual identificamos que la página es la que corresponde.
	private final String formId="newAccountForm";
	
	public NewaccountPage(WebDriver driver) {
		this.driver = driver;
	       

        // Check that we're on the right page.
        //Lo comprobamos por el id del formulario.
        try {
        	driver.findElement(By.id(formId));
        } catch (NoSuchElementException e){
        	throw new IllegalStateException("Página no corresponde a la clase. No entruentro el formulario " + formId);	
        }
		
	}
	
	By emailLocator = By.id(formId + ":email");
    By nickLocator = By.id(formId + ":nickname");
    By myDataLocator = By.id(formId + ":myData");
    By pwdLocator = By.id(formId + ":pwd");
    By pwdConfirmationLocator = By.id(formId + ":passwordConfirm");
    By nextButtonLocator = By.id(formId + ":nextBtn");

    /**
     * Pulsamos botón Seguir y falla alguna de las validaciones de los campos
     * @return
     */
    public NewaccountPage nextKO(){
    	driver.findElement(nextButtonLocator).click();
        return new NewaccountPage(driver);   
    }
    
    
    /**
     * Pulsamos botón Seguir y falla alguna de las validaciones de los campos
     * @return
     */
    public WelcomePage nextOK(){
    	driver.findElement(nextButtonLocator).click();
        return new WelcomePage(driver);   
    }
    
    //TYPEs.
 
    public NewaccountPage typeEmail(String email) {
        driver.findElement(emailLocator).sendKeys(email);
        
        return this;    
    }
    
    public NewaccountPage typeNickname(String nickname) {
        driver.findElement(nickLocator).sendKeys(nickname);
        return this;    
    }
    
    public NewaccountPage typeMyData(String myData) {
        driver.findElement(myDataLocator).sendKeys(myData);
        return this;    
    }
    
    public NewaccountPage typePassword(String password) {
        driver.findElement(pwdLocator).sendKeys(password);
        return this;    
    }
    
    public NewaccountPage typePasswordConfirmation(String password) {
        driver.findElement(pwdConfirmationLocator).sendKeys(password);
        return this;    
    }
    
    
	
}
