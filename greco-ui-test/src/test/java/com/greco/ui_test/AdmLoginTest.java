package com.greco.ui_test;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.greco.ui_test.admin.po.LoginAdmPage;



public class AdmLoginTest {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("http://localhost:8080/greco-console/");
	}
	
	
	@Test
	/**
	 * Usuario sin comunidad
	 */
	public void test01(){
		LoginAdmPage loginAdmPage=new LoginAdmPage(driver);
		loginAdmPage.typeUsername("alberto@isban.es");
		loginAdmPage.typePassword("a");
		assertNotNull(loginAdmPage.submitLogin());
	}

}
