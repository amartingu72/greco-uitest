package com.greco.ui_test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.greco.ui_test.admin.po.LoginAdmPage;
import com.greco.ui_test.admin.po.SelectcomPage;




public class AdmLoginTest {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = TestConfiguration.getDriver();
		driver.get(TestConfiguration.ADMIN_URL);
	}
	
	@After
	public void tearDown(){
		driver.quit();
	}
	
	
	
	@Test
	/**
	 * Usuario no existe.
	 * Usuario: user02@greco.es
	 * Contraseña: user02
	 * Resultado: nos quedamos en la página de login.
	 */
	public void test01(){
		LoginAdmPage loginAdmPage=new LoginAdmPage(driver);
		loginAdmPage.submitLoginKo(TestConfiguration.USER02_EMAIL,TestConfiguration.USER02_PWD);
	}
	
	@Test
	/**
	 * Usuario existe y contraseña no coincide.
	 * Usuario: user01@greco.es
	 * Contraseña: user
	 * Resultado: nos quedamos en la página de login.
	 */
	public void test02(){
		LoginAdmPage loginAdmPage=new LoginAdmPage(driver);
		loginAdmPage.submitLoginKo(TestConfiguration.USER01_EMAIL,"una_inventada");
	}
	
	@Test
	/**
	 * Usuario existe y la contraseña coincide. Este usuario no administra ninguna comunidad.
	 * Usuario: user01@greco.es
	 * Contraseña: user01
	 * Resultado: vamos la página de welcome pero debe aparecer el mensaje de que no hay comunidades.
	 */
	public void test03(){
		LoginAdmPage loginAdmPage=new LoginAdmPage(driver);
		SelectcomPage selectcomPage=loginAdmPage.submitLoginOk(TestConfiguration.USER01_EMAIL,TestConfiguration.USER01_PWD);
		assertTrue("No apareció el mensaje de ausencia de comunidades esperado", selectcomPage.communitiesAvailables());
		
	}
	
	@Test
	/**
	 * Usuario existe y no pongo contraseña
	 * Usuario: user01@greco.es
	 * Contraseña: 
	 * Resultado: nos quedamos en la página de login.
	 */
	public void test04(){
		LoginAdmPage loginAdmPage=new LoginAdmPage(driver);
		loginAdmPage.submitLoginKo(TestConfiguration.USER01_EMAIL,"");
	}
	
	//TODO Fatal una prueba de que cuando un usuario tiene más de una comunidad le aparece en el lógin. 
	

}
