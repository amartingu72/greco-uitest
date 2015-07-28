package com.greco.ui_test.admin.po;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class NewcommunityPage {
	private final WebDriver driver;
	//Indentificador del formulario principal por el cual identificamos que la página es la que corresponde.
	private final String formId="editCommForm";
	
	public NewcommunityPage(WebDriver driver) {
		this.driver = driver;
	       

        // Check that we're on the right page.
        //Lo comprobamos por el id del formulario.
        try {
        	driver.findElement(By.id(formId));
        } catch (NoSuchElementException e){
        	throw new IllegalStateException("Página no corresponde a la clase. No entruentro formulario " + formId);	
        }
		
	}
	
	By nameLocator = By.id(formId + ":name");
    By activeLocator = By.id(formId + ":enabled");
    By zipLocator = By.id(formId + ":zipcode");
    By countryLocator = By.id(formId + ":country");
    By notesLocator = By.id(formId + ":notes");
    By nextLocator = By.id(formId + ":nextBtn");
	
	public NewcommunityPage typeName(String name){
		
		driver.findElement(nameLocator).sendKeys(name);
        return this;  
	}
	
	public NewcommunityPage typeEnabled(){
		
		if ( !driver.findElement(activeLocator).isSelected() )
		
			driver.findElement(activeLocator).sendKeys(Keys.SPACE);
        return this;  
	}
	
	public NewcommunityPage typeDisabled(){
		
		if ( driver.findElement(activeLocator).isSelected() )
		
			driver.findElement(activeLocator).sendKeys(Keys.SPACE);
        return this;  
	}
	
	public NewcommunityPage typeZipcode(String zipcode){
		driver.findElement(zipLocator).click();
		driver.findElement(zipLocator).sendKeys(zipcode);
        return this;  
	}
	
	public NewcommunityPage typeCountry(String country){
		Select selectBox=new Select(driver.findElement(countryLocator));
		selectBox.selectByValue(country);
        return this;  
	}
	
	public NewcommunityPage typeNotes(String notes){
		
		driver.findElement(notesLocator).sendKeys(notes);
        return this;  
	}
	
	public NewcommunityPage submitKo() {
        // This is the only place that submits the login form and expects the destination to be the home page.
        // A seperate method should be created for the instance of clicking login whilst expecting a login failure. 
        driver.findElement(nextLocator).click();

        // Return a new page object representing the destination. Should the login page ever
        // go somewhere else (for example, a legal disclaimer) then changing the method signature
        // for this method will mean that all tests that rely on this behaviour won't compile.
        return new NewcommunityPage(driver);  
	}

}
