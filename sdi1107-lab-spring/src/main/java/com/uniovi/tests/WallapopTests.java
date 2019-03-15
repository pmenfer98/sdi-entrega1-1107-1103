package com.uniovi.tests;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
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
  public void loginTest() throws Exception {
    driver.get("http://localhost:8090/");
    driver.findElement(By.linkText("Identificate")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("lucasFernandez@gmail.com");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("holaaaa");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password:'])[1]/following::button[1]")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("pablo@uniovi.es");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("holaaaaaaaaa");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password:'])[1]/following::button[1]")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("pablo@uniovi.es");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin123");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password:'])[1]/following::button[1]")).click();
  }
  
  @Test
  public void logoutTest() throws Exception {
    driver.get("http://localhost:8090/home");
    driver.findElement(By.linkText("Desconectar")).click();
  }
  
  
  
  @Test
  public void registerTest() throws Exception {
    driver.get("http://localhost:8090/");
    driver.findElement(By.linkText("Registrate")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Juan Carlos");
    driver.findElement(By.name("lastName")).click();
    driver.findElement(By.name("lastName")).clear();
    driver.findElement(By.name("lastName")).sendKeys("Álvarez García");
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("juancaAlvarez@gmail.com");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("adiosss");
    driver.findElement(By.name("passwordConfirm")).click();
    driver.findElement(By.name("passwordConfirm")).clear();
    driver.findElement(By.name("passwordConfirm")).sendKeys("jajajaja");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password:'])[1]/following::button[1]")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Juan Carlos");
    driver.findElement(By.name("lastName")).click();
    driver.findElement(By.name("lastName")).clear();
    driver.findElement(By.name("lastName")).sendKeys("Álvarez García");
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("juancaAlvarez@gmail.com");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("contraseña");
    driver.findElement(By.name("passwordConfirm")).click();
    driver.findElement(By.name("passwordConfirm")).clear();
    driver.findElement(By.name("passwordConfirm")).sendKeys("contraseña");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Las contraseñas no coinciden'])[1]/following::button[1]")).click();
  }
  
 
  
}