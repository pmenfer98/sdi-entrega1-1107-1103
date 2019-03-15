package com.uniovi.tests;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WallapopTests {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testLoginConDatosValidos() throws Exception {
    driver.get("http://localhost:8090/signup");
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Juan Carlos");
    driver.findElement(By.name("lastName")).click();
    driver.findElement(By.name("lastName")).clear();
    driver.findElement(By.name("lastName")).sendKeys("Álvarez García");
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("UO123456@uniovi.es");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("ContraseñaContra");
    driver.findElement(By.name("passwordConfirm")).click();
    driver.findElement(By.name("passwordConfirm")).clear();
    driver.findElement(By.name("passwordConfirm")).sendKeys("ContraseñaContra");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Confirmar contrase�a'])[1]/following::button[1]")).click();
  }
  
  @Test
  public void testRegisterNombreApellidoCorreoVacios() throws Exception {
    driver.get("http://localhost:8090/signup");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("ContraseñaPrueba");
    driver.findElement(By.name("passwordConfirm")).clear();
    driver.findElement(By.name("passwordConfirm")).sendKeys("ContraseñaPrueba");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Confirmar contrase�a'])[1]/following::button[1]")).click();
  }
  
  @Test
  public void testRegisterContraseñasInvalidas() throws Exception {
    driver.get("http://localhost:8090/signup");
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Marco");
    driver.findElement(By.name("lastName")).clear();
    driver.findElement(By.name("lastName")).sendKeys("Fernández Pérez");
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("UO278634@uniovi.es");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("ContraseñaC");
    driver.findElement(By.name("passwordConfirm")).clear();
    driver.findElement(By.name("passwordConfirm")).sendKeys("Contraseña");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Confirmar contrase�a'])[1]/following::button[1]")).click();
  }
  
  @Test
  public void testRegisterEmailExistente() throws Exception {
    driver.get("http://localhost:8090/signup");
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Julián");
    driver.findElement(By.name("lastName")).clear();
    driver.findElement(By.name("lastName")).sendKeys("Bermúdez García");
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("pablo@uniovi.es");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("HOLAprueba");
    driver.findElement(By.name("passwordConfirm")).clear();
    driver.findElement(By.name("passwordConfirm")).sendKeys("HOLAprueba");
    driver.findElement(By.name("passwordConfirm")).sendKeys(Keys.ENTER);
  }
 
  
}