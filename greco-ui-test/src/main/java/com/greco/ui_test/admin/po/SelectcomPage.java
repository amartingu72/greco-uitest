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
	
	By newCommunityBtnLocator=By.id("selectCommunityForm:newComBtn");
	
	
	/**
	 * Indica si el usuario que accedió a esta página tiene una o más comunidades disponibles.
	 * @return Si (true), no (false)
	 */
	public boolean communitiesAvailables(){
		boolean ret=true;
		try {
        	driver.findElement(By.id("selectCommunityForm:noCommunityLabel"));
        } catch (NoSuchElementException e){
        	ret=false;	
        }
		return ret;
	}
	
	public NewcommunityPage newCommunity(){
		driver.findElement(newCommunityBtnLocator).click();
		return new NewcommunityPage(driver);
	}
}
