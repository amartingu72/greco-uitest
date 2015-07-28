package com.greco.ui_test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.greco.ui_test.admin.po.LoginAdmPage;
import com.greco.ui_test.admin.po.NewcommunityPage;
import com.greco.ui_test.admin.po.SelectcomPage;

public class NewCommunityTest {
	WebDriver driver;
	
	
	/**
	 * Accedemos a la página newcommunity.
	 */
	@Before
	public void setUp() {
		driver = TestConfiguration.getDriver();
		driver.get(TestConfiguration.ADMIN_URL);
		
	}
	
	@After
	public void tearDown(){
		driver.quit();
	}
	
	/**
	 * Un usuario sin comunidades (USER01) intenta crear una nueva comunidad. 
	 * Introduce comunidad con blancos
	 * Comunidad="    "
	 * Activa=Valor por defecto.
	 * Código postal= COM01_ZIPCODE
	 * País=COM01_COUNTRY
	 * Notas= COM01_NOTES
	 */
	@Test
	public void test01(){
		LoginAdmPage loginAdmPage=new LoginAdmPage(driver);
		SelectcomPage selectComPage=loginAdmPage.submitLoginOk(TestConfiguration.USER01_EMAIL, TestConfiguration.USER01_PWD);
		NewcommunityPage newCommunityPage=selectComPage.newCommunity();
		newCommunityPage.typeName("")
			.typeCountry(TestConfiguration.COM01_COUNTRY)
			.typeZipcode(TestConfiguration.COM01_ZIPCODE)	
			.typeNotes(TestConfiguration.COM01_NOTES);
				
		newCommunityPage.submitKo();	
		
	}
	
	
	
	
	
	/**
	 * Un usuario sin comunidades (USER01) crea una nueva comunidad. 
	 * Comunidad=COM01_NAME
	 * Activa=Valor por defecto.
	 * Código postal= COM01_ZIPCODE
	 * País=COM01_COUNTRY
	 * Notas= COM01_NOTES
	 */
	@Test
	public void test02(){
		
		
	}
	
	
	/**
	 * Un usuario sin comunidades (USER01) intenta crear una nueva comunidad. 
	 * Introduce comunidad con blancos
	 * Comunidad="    "
	 * Activa=Valor por defecto.
	 * Código postal= COM01_ZIPCODE
	 * País=COM01_COUNTRY
	 * Notas= COM01_NOTES
	 */
	@Test
	public void test03(){}
	
	
	/**
	 * Un usuario sin comunidades (USER01) intenta crear una nueva comunidad. 
	 * Introduce comunidad con blancos
	 * Comunidad="    "
	 * Activa=Valor por defecto.
	 * Código postal= COM01_ZIPCODE
	 * País=COM01_COUNTRY
	 * Notas= COM01_NOTES
	 */
	@Test
	public void test04(){}
}
