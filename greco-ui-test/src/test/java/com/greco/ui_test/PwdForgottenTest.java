package com.greco.ui_test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.greco.ui_test.admin.po.LoginAdmPage;
import com.greco.ui_test.admin.po.PwdforgottenPage;

public class PwdForgottenTest {
	WebDriver driver;
	PwdforgottenPage pwdForgottenPage;
		
	/**
	 * Accedemos a la página newaccount.
	 */
	@Before
	public void setUp() {
		driver = TestConfiguration.getDriver();
		driver.get(TestConfiguration.ADMIN_URL);
		LoginAdmPage loginAdmPage=new LoginAdmPage(driver);
		pwdForgottenPage=loginAdmPage.pwdForgotten();
	}
	
	@After
	public void tearDown(){
		driver.quit();
	}
	
	/**
	 * email vacío
	 * email=
	 * Se queda en la página.
	 */
	@Test
	public void test01(){
		pwdForgottenPage.typeEmail("");
		pwdForgottenPage.submitKo();
		
	}
	
	/**
	 * email con formato incorrecto.
	 * email: user01@
	 * Se queda en la página.
	 */
	@Test
	public void test02(){
		pwdForgottenPage.typeEmail("user01@");
		pwdForgottenPage.submitKo();
		
	}
	
	/**
	 * email de usuario que no existe.
	 * email: user02.gmail.com
	 * Se queda en la página.
	 */
	@Test
	public void test03(){
		pwdForgottenPage.typeEmail(TestConfiguration.USER02_EMAIL);
		pwdForgottenPage.submitKo();
	}
	
	
	/**
	 * Cambio de contraseña con éxito.
	 */
	@Test
	public void test04(){
		pwdForgottenPage.typeEmail(TestConfiguration.USER03_EMAIL);
		pwdForgottenPage.submitOk();
	}
}
