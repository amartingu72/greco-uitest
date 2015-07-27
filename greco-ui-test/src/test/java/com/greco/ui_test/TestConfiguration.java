package com.greco.ui_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestConfiguration {
	private static WebDriver driver = null;
	
	private final static int WEB_DRIVER=0;  //Firefox
	//private final int WEB_DRIVER=1;  //Chrome
	//private final int WEB_DRIVER=2;  //IE
	
	public final static String ADMIN_URL="http://localhost:8080/greco-console";
	//public final static String ADMIN_URL="https://amg-greco.rhcloud.com/";
	
	
	//USER01.Usuario que crearemos en la suite de test.
	public final static String USER01_EMAIL="user01@greco.es";
	public final static String USER01_NICKNAME="user01";
	public final static String USER01_MYDATA="Comentarios sobre user 01";
	public final static String USER01_PWD="user";
	
	
	//USER02 Usuario que no existe
	public final static String USER02_EMAIL="user02@greco.es";
	public final static String USER02_NICKNAME="user02";
	public final static String USER02_MYDATA="Comentarios sobre user 02";
	public final static String USER02_PWD="user";
	
	
	//USER03 Usuario para probar el cambio de contraseña. Requiere email válido.
	public final static String USER03_EMAIL="amartingu72@gmail.com";
	public final static String USER03_NICKNAME="amartingu72";
	public final static String USER03_MYDATA="Comentarios sobre user 03";
	public final static String USER03_PWD="a";
	
	
	
	
	   protected TestConfiguration() {
	      // Exists only to defeat instantiation.
	   }
	   public static WebDriver getDriver() {
	      switch (WEB_DRIVER){
	      case 0:
	    	  driver=new FirefoxDriver();
	    	  break;
	      case 1:
	    	  driver=new ChromeDriver();
	    	  break;
	      case 2: 
	    	  driver=new InternetExplorerDriver();
	    	  break;
	      default:
	    	  driver=new FirefoxDriver();
	      }
	      return driver;
	   }
	   
	   
}
