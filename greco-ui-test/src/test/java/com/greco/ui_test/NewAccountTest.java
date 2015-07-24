package com.greco.ui_test;




import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.greco.ui_test.admin.po.LoginAdmPage;
import com.greco.ui_test.admin.po.NewaccountPage;
/**
 * Precondición: delete from users where nickname in ('user01', 'user02') or email in ('user02@greco.es', 'user02@greco.es')
 * @author AMG
 *
 */
public class NewAccountTest {
	WebDriver driver;
	NewaccountPage newAccountPage;
	
	/**
	 * Accedemos a la página newaccount.
	 */
	@Before
	public void setUp() {
		driver = TestConfiguration.getDriver();
		driver.get(TestConfiguration.ADMIN_URL);
		LoginAdmPage loginAdmPage=new LoginAdmPage(driver);
		newAccountPage=loginAdmPage.newAccount();
	}
	
	@After
	public void tearDown(){
		driver.quit();
	}
	
	
	
	/**
	 * Email vacío.
	 * email:
	 * Nickname: user01
	 * Mis datos: Prueba user01.
	 * Contraseña: user
	 * Confirmación contraseña: user
	 * 
	 * Al pulsar "Seguir", se queda en la misma página.
	 */
	@Test
	public void test01(){
		
		
		newAccountPage.typeEmail("")
			.typeNickname(TestConfiguration.USER01_NICKNAME)
			.typeMyData(TestConfiguration.USER01_MYDATA)
			.typePassword(TestConfiguration.USER01_PWD)
			.typePasswordConfirmation(TestConfiguration.USER01_PWD);
		
		newAccountPage=newAccountPage.nextKO();
	}
	
	/**
	 * Email con formato incorrecto.
	 * email: user01 greco.es
	 * Nickname: user01
	 * Mis datos: Prueba user01.
	 * Contraseña: user
	 * Confirmación contraseña: user
	 * 
	 * Al pulsar "Seguir", se queda en la misma página.
	 */
	@Test
	public void test02(){
		
		newAccountPage.typeEmail("user01 greco.es")
			.typeNickname(TestConfiguration.USER01_NICKNAME)
			.typeMyData(TestConfiguration.USER01_MYDATA)
			.typePassword(TestConfiguration.USER01_PWD)
			.typePasswordConfirmation(TestConfiguration.USER01_PWD);
		
		newAccountPage.nextKO();
	}
	
	/**
	 * Nickname con blancos
	 * email: user01@greco.es
	 * Nickname: 
	 * Mis datos: Prueba user01.
	 * Contraseña: user
	 * Confirmación contraseña: user
	 * 
	 * Al pulsar "Seguir", se queda en la misma página.
	 */
	@Test
	public void test03(){
		
		newAccountPage.typeEmail(TestConfiguration.USER01_EMAIL)
			.typeNickname("    ")
			.typeMyData(TestConfiguration.USER01_MYDATA)
			.typePassword(TestConfiguration.USER01_PWD)
			.typePasswordConfirmation(TestConfiguration.USER01_PWD);
		
		newAccountPage.nextKO();
	}
	
	/**
	 * Nickname vacío.
	 * email: user01@greco.es
	 * Nickname: 
	 * Mis datos: Prueba user01.
	 * Contraseña: user
	 * Confirmación contraseña: user
	 * 
	 * Al pulsar "Seguir", se queda en la misma página.
	 */
	@Test
	public void test04(){
		
		newAccountPage.typeEmail(TestConfiguration.USER01_EMAIL)
			.typeNickname("")
			.typeMyData(TestConfiguration.USER01_MYDATA)
			.typePassword(TestConfiguration.USER01_PWD)
			.typePasswordConfirmation(TestConfiguration.USER01_PWD);
		
		newAccountPage.nextKO();
	}
	
	/**
	 * Creación de cuenta finalizada.
	 * email: user01@greco.es
	 * Nickname: user01
	 * Mis datos: Prueba user01.
	 * Contraseña: user
	 * Confirmación contraseña: user
	 * 
	 * Al pulsar "Seguir", pasa a la página de Welcome..
	 */
	@Test
	public void test05(){
		
		newAccountPage.typeEmail(TestConfiguration.USER01_EMAIL)
			.typeNickname(TestConfiguration.USER01_NICKNAME)
			.typeMyData(TestConfiguration.USER01_MYDATA)
			.typePassword(TestConfiguration.USER01_PWD)
			.typePasswordConfirmation(TestConfiguration.USER01_PWD);
		
		newAccountPage.nextOK();
	}
	
	/**
	 * Creación de cuenta con email dupliecado
	 * email: user01@greco.es
	 * Nickname: user02
	 * Mis datos: Prueba user02.
	 * Contraseña: user
	 * Confirmación contraseña: user
	 * 
	 * Al pulsar "Seguir", no cambia a la página de welcome.
	 */
	@Test
	public void test06(){
		
		newAccountPage.typeEmail(TestConfiguration.USER01_EMAIL)
			.typeNickname(TestConfiguration.USER02_NICKNAME)
			.typeMyData(TestConfiguration.USER02_MYDATA)
			.typePassword(TestConfiguration.USER02_PWD)
			.typePasswordConfirmation(TestConfiguration.USER02_PWD);
		
		newAccountPage.nextKO();
	}
	
	/**
	 * Creación de cuenta con nickname duplicado.
	 * email: user02@greco.es
	 * Nickname: user01
	 * Mis datos: Prueba user02.
	 * Contraseña: user
	 * Confirmación contraseña: user
	 * 
	 * Al pulsar "Seguir", no cambia a la página de welcome.
	 */
	@Test
	public void test07(){
		
		newAccountPage.typeEmail(TestConfiguration.USER02_EMAIL)
			.typeNickname(TestConfiguration.USER01_NICKNAME)
			.typeMyData(TestConfiguration.USER02_MYDATA)
			.typePassword(TestConfiguration.USER02_PWD)
			.typePasswordConfirmation(TestConfiguration.USER02_PWD);
		
		newAccountPage.nextKO();
	}
	
	/**
	 * Creación de cuenta con contraseña no coincidente.
	 * email: user02@greco.es
	 * Nickname: user01
	 * Mis datos: Prueba user02.
	 * Contraseña: user
	 * Confirmación contraseña: user2
	 * 
	 * Al pulsar "Seguir", no cambia a la página de welcome.
	 */
	@Test
	public void test08(){
		
		newAccountPage.typeEmail(TestConfiguration.USER02_EMAIL)
			.typeNickname(TestConfiguration.USER02_NICKNAME)
			.typeMyData(TestConfiguration.USER02_MYDATA)
			.typePassword(TestConfiguration.USER02_PWD)
			.typePasswordConfirmation("una_inventada");
		
		newAccountPage.nextKO();
	}
	
	/**
	 * Creación de cuenta con contraseña vacía.
	 * email: user02@greco.es
	 * Nickname: user01
	 * Mis datos: Prueba user02.
	 * Contraseña: user
	 * Confirmación contraseña: user2
	 * 
	 * Al pulsar "Seguir", no cambia a la página de welcome.
	 */
	@Test
	public void test09(){
		
		newAccountPage.typeEmail(TestConfiguration.USER02_EMAIL)
			.typeNickname(TestConfiguration.USER02_NICKNAME)
			.typeMyData(TestConfiguration.USER02_MYDATA)
			.typePassword("")
			.typePasswordConfirmation("");
		
		newAccountPage.nextKO();
	}
}
