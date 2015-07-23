package com.greco.ui_test.admin.po;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class SelectcomPage {
	private final WebDriver driver;
	private final String formId="selectCommunityForm";
	
	public SelectcomPage(WebDriver driver) {
        this.driver = driver;
       

        // Check that we're on the right page.
        //Lo comprobamos por el id del formulario.
        try {
        	driver.findElement(By.id(formId));
        } catch (NoSuchElementException e){
        	throw new IllegalStateException("Página no corresponde a la clase. No entruentro el formulario " + formId);	
        }
        
        
    }
}
