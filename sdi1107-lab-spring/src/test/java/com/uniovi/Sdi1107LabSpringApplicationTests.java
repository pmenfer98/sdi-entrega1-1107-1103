package com.uniovi;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.uniovi.utils.SeleniumUtils;

//Ordenamos las pruebas por el nombre del método
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Sdi1107LabSpringApplicationTests {
	// En Windows (Debe ser la versión 65.0.1 y desactivar las actualizacioens
	// automáticas)):
	static String PathFirefox64 = "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe";
	static String Geckdriver022 = "C:\\Users\\Pablo\\Desktop\\SDI\\PL-SDI-Sesión5-material\\geckodriver024win64.exe";
	// Común a Windows y a MACOSX
	static WebDriver driver = getDriver(PathFirefox64, Geckdriver022);
	static String URL = "http://localhost:8090";

	public static WebDriver getDriver(String PathFirefox, String Geckdriver) {
		System.setProperty("webdriver.firefox.bin", PathFirefox);
		System.setProperty("webdriver.gecko.driver", Geckdriver);
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

	@Before
	public void setUp() throws Exception {
		driver.navigate().to(URL);
	}

	@After
	public void tearDown() throws Exception {
		driver.manage().deleteAllCookies();
	}

	@BeforeClass
	static public void begin() {
	}

	// Al finalizar la última prueba
	@AfterClass
	static public void end() {
		// Cerramos el navegador al finalizar las pruebas
		driver.quit();
	}

	@Test
	public void prueba1() throws Exception {
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
		driver.findElement(By.id("registerButton")).click();
	}

	@Test
	public void prueba2() throws Exception {
		driver.get("http://localhost:8090/signup");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("ContraseñaPrueba");
		driver.findElement(By.name("passwordConfirm")).clear();
		driver.findElement(By.name("passwordConfirm")).sendKeys("ContraseñaPrueba");
		driver.findElement(By.id("registerButton")).click();
	}

	@Test
	public void prueba3() throws Exception {
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
		driver.findElement(By.id("registerButton")).click();
	}

	@Test
	public void prueba4() throws Exception {
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

	@Test
	public void prueba5() throws Exception {
		driver.get("http://localhost:8090/login");
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("admin@email.com");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
	}

	@Test
	public void prueba6() throws Exception {
		driver.get("http://localhost:8090/login?logout");
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("pablo@uniovi.es");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("user123");
		driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
	}

	@Test
	public void prueba7() throws Exception {
		driver.get("http://localhost:8090/login?logout");
		driver.findElement(By.id("loginButton")).click();
	}

	@Test
	public void prueba8() throws Exception {
		driver.get("http://localhost:8090/login?logout");
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("pablo@uniovi.es");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("holaaa");
		driver.findElement(By.id("loginButton")).click();
	}

	@Test
	public void prueba9() throws Exception {
		driver.get("http://localhost:8090/login?error");
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("cristobal@gmail.com");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("user123");
		driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
	}

	@Test
	public void prueba10() throws Exception {
		driver.get("http://localhost:8090/login");
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("admin@email.com");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
		SeleniumUtils.esperarSegundos(driver, 2);
		driver.findElement(By.id("Desconectar")).click();
	}
	
	 @Test
	  public void prueba11() throws Exception {
	    driver.get("http://localhost:8090/");
	    driver.findElement(By.id("myNavbar")).click();
	    SeleniumUtils.textoNoPresentePagina(driver, "Desconectar");
	  }

	@Test
	public void prueba12() throws Exception {
		driver.get("http://localhost:8090/login?logout");
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("admin@email.com");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.id("loginButton")).click();
		SeleniumUtils.esperarSegundos(driver, 2);
		driver.findElement(By.linkText("Gestión de usuarios")).click();
		driver.findElement(By.linkText("Usuarios")).click();
	}

	@Test
	public void prueba13() throws Exception {
		driver.get("http://localhost:8090/login?logout");
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("admin@email.com");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
		SeleniumUtils.esperarSegundos(driver, 2);
		driver.findElement(By.linkText("Gestión de usuarios")).click();
		driver.findElement(By.linkText("Usuarios")).click();
		driver.findElement(By.name("idsUser")).click();
		driver.findElements(By.className("borrar")).get(0);
		SeleniumUtils.esperarSegundos(driver, 2);
		driver.findElement(By.id("deleteButton")).click();

	}

	@Test
	public void prueba14() throws Exception {

		driver.get("http://localhost:8090/");
		driver.findElement(By.linkText("Entrar")).click();
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("admin@email.com");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.id("loginButton")).click();
		SeleniumUtils.esperarSegundos(driver, 2);
		driver.findElement(By.linkText("Gestión de usuarios")).click();
		driver.findElement(By.linkText("Usuarios")).click();
		driver.findElement(By.name("idsUser")).click();
		SeleniumUtils.esperarSegundos(driver, 2);
		driver.findElement(By.id("deleteButton")).click();
		List<WebElement> a = driver.findElements(By.className("borrar"));
		driver.findElements(By.className("borrar")).get(a.size() - 1);

	}

	@Test
	public void prueba15() throws Exception {
		driver.get("http://localhost:8090/login");
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("admin@email.com");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
		SeleniumUtils.esperarSegundos(driver, 2);
		driver.findElement(By.linkText("Gestión de usuarios")).click();
		driver.findElement(By.linkText("Usuarios")).click();
		driver.findElement(By.name("idsUser")).click();
		driver.findElement(By.name("idsUser")).click();
		driver.findElement(By.name("idsUser")).click();
		SeleniumUtils.esperarSegundos(driver, 2);
		driver.findElement(By.id("deleteButton")).click();
		driver.findElements(By.className("borrar")).get(0);
		driver.findElements(By.className("borrar")).get(1);
		driver.findElements(By.className("borrar")).get(2);

	}

	@Test
	public void prueba16() throws Exception {
		driver.get("http://localhost:8090/login");
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("danielLlana_98@gmail.com");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("user123");
		driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
		SeleniumUtils.esperarSegundos(driver, 2);
		driver.findElement(By.linkText("Ofertas")).click();
		driver.findElement(By.linkText("Añadir oferta")).click();
		driver.findElement(By.id("title")).click();
		driver.findElement(By.id("title")).clear();
		driver.findElement(By.id("title")).sendKeys("Documental de jaguares");
		driver.findElement(By.id("details")).click();
		driver.findElement(By.id("details")).clear();
		driver.findElement(By.id("details")).sendKeys("Ideal para ver a estos grandes felinos en libertad");
		driver.findElement(By.id("price")).clear();
		driver.findElement(By.id("price")).sendKeys("10.0");
		SeleniumUtils.esperarSegundos(driver, 2);
		driver.findElement(By.id("buttonUpload")).click();
	}

	@Test
	public void prueba17() throws Exception {
		driver.get("http://localhost:8090/");
		driver.findElement(By.linkText("Entrar")).click();
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("danielLlana_98@gmail.com");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("user123");
		driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
		SeleniumUtils.esperarSegundos(driver, 2);
		driver.findElement(By.linkText("Ofertas")).click();
		driver.findElement(By.linkText("Añadir oferta")).click();
		driver.findElement(By.id("details")).click();
		driver.findElement(By.id("details")).clear();
		driver.findElement(By.id("details")).sendKeys("Prueba");
		SeleniumUtils.esperarSegundos(driver, 2);
		driver.findElement(By.id("buttonUpload")).click();
	}

	@Test
	public void prueba18() throws Exception {
		driver.get("http://localhost:8090/login?logout");
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("danielLlana_98@gmail.com");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("user123");
		driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
		SeleniumUtils.esperarSegundos(driver, 2);
		driver.findElement(By.linkText("Ofertas")).click();
		driver.findElement(By.linkText("Mis ofertas")).click();
	}

	@Test
	public void prueba19() throws Exception {
		driver.get("http://localhost:8090/login");
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("danielLlana_98@gmail.com");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("user123");
		driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
		SeleniumUtils.esperarSegundos(driver, 2);
		driver.findElement(By.linkText("Ofertas")).click();
		driver.findElement(By.linkText("Mis ofertas")).click();
		driver.findElement(By.id("buttonDelete")).click();
	}

	@Test
	public void prueba20() throws Exception {
		driver.get("http://localhost:8090/login?logout");
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("danielLlana_98@gmail.com");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("user123");
		driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
		SeleniumUtils.esperarSegundos(driver, 2);
		driver.findElement(By.linkText("Ofertas")).click();
		driver.findElement(By.linkText("Mis ofertas")).click();
		driver.findElement(By.linkText("Última")).click();
		driver.findElement(By.id("buttonDelete")).click();
	}

	@Test
	public void prueba21() throws Exception {
		driver.get("http://localhost:8090/login?logout");
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("danielLlana_98@gmail.com");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("user123");
		driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
		SeleniumUtils.esperarSegundos(driver, 2);
		driver.findElement(By.linkText("Ofertas")).click();
		driver.findElement(By.linkText("Ofertas disponibles")).click();
		driver.findElement(By.id("searchButton")).click();
	}

	@Test
	public void prueba22() throws Exception {
		driver.get("http://localhost:8090/login?logout");
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("danielLlana_98@gmail.com");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("user123");
		driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
		SeleniumUtils.esperarSegundos(driver, 2);
		driver.findElement(By.linkText("Ofertas")).click();
		driver.findElement(By.linkText("Ofertas disponibles")).click();
		driver.findElement(By.name("searchText")).click();
		driver.findElement(By.name("searchText")).clear();
		driver.findElement(By.name("searchText")).sendKeys("aqASWDTF");
		driver.findElement(By.id("searchButton")).click();
	}

	@Test
	public void prueba23() throws Exception {
		 driver.get("http://localhost:8090/login?logout");
		    driver.findElement(By.name("username")).click();
		    driver.findElement(By.name("username")).clear();
		    driver.findElement(By.name("username")).sendKeys("danielLlana_98@gmail.com");
		    driver.findElement(By.name("password")).click();
		    driver.findElement(By.name("password")).clear();
		    driver.findElement(By.name("password")).sendKeys("user123");
		    driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
		    SeleniumUtils.esperarSegundos(driver, 2);
		    driver.findElement(By.linkText("Ofertas")).click();
		    driver.findElement(By.linkText("Ofertas disponibles")).click();
		    SeleniumUtils.esperarSegundos(driver, 2);
		    driver.findElement(By.id("buyButton")).click();
	}

	@Test
	public void prueba24() throws Exception {
		 driver.get("http://localhost:8090/login");
		    driver.findElement(By.name("username")).click();
		    driver.findElement(By.name("username")).clear();
		    driver.findElement(By.name("username")).sendKeys("danielLlana_98@gmail.com");
		    driver.findElement(By.name("password")).click();
		    driver.findElement(By.name("password")).clear();
		    driver.findElement(By.name("password")).sendKeys("user123");
		    driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
		    SeleniumUtils.esperarSegundos(driver, 2);
		    driver.findElement(By.linkText("Ofertas")).click();
		    driver.findElement(By.linkText("Ofertas disponibles")).click();
		    driver.findElement(By.id("buyButton")).click();
	}
	
	@Test
	public void prueba25() throws Exception {
		 driver.get("http://localhost:8090/login?logout");
		    driver.findElement(By.name("username")).click();
		    driver.findElement(By.name("username")).clear();
		    driver.findElement(By.name("username")).sendKeys("danielLlana_98@gmail.com");
		    driver.findElement(By.name("password")).clear();
		    driver.findElement(By.name("password")).sendKeys("user123");
		    driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
		    driver.findElement(By.linkText("Ofertas")).click();
		    driver.findElement(By.linkText("Ofertas disponibles")).click();
		    driver.findElement(By.id("buyButton")).click();
	}
	
	@Test
	public void prueba26() throws Exception {
	driver.get("http://localhost:8090/login?logout");
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("danielLlana_98@gmail.com");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("user123");
    driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
    SeleniumUtils.esperarSegundos(driver, 2);
    driver.findElement(By.linkText("Ofertas")).click();
    driver.findElement(By.linkText("Ofertas compradas")).click();
	}
	
	@Test
	public void prueba27() throws Exception {
		driver.get("http://localhost:8090/");
		SeleniumUtils.esperarSegundos(driver, 2);
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='English'])[1]/preceding::span[2]")).click();
	    driver.findElement(By.id("btnEnglish")).click();
	    driver.findElement(By.linkText("Login")).click();
	    driver.findElement(By.name("username")).click();
	    driver.findElement(By.name("username")).clear();
	    driver.findElement(By.name("username")).sendKeys("admin@email.com");
	    driver.findElement(By.name("password")).click();
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys("admin");
	    driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
	    SeleniumUtils.esperarSegundos(driver, 2);
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Users'])[1]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='English'])[1]/following::span[1]")).click();
	    driver.findElement(By.linkText("Gestión de usuarios")).click();
	    driver.findElement(By.linkText("Usuarios")).click();
	    driver.findElement(By.id("btnLanguage")).click();
	    SeleniumUtils.esperarSegundos(driver, 2);
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Idioma'])[1]/following::span[2]")).click();
	    driver.findElement(By.id("Desconectar")).click();
	    driver.findElement(By.name("username")).click();
	    driver.findElement(By.name("username")).clear();
	    driver.findElement(By.name("username")).sendKeys("danielLlana_98@gmail.com");
	    driver.findElement(By.name("password")).click();
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys("user123");
	    driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
	    SeleniumUtils.esperarSegundos(driver, 2);
	    driver.findElement(By.linkText("Ofertas")).click();
	    driver.findElement(By.linkText("Añadir oferta")).click();
	    SeleniumUtils.esperarSegundos(driver, 2);
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Mi dinero'])[1]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Idioma'])[1]/following::span[2]")).click();
	}
	
	
	 @Test
	  public void prueba28() throws Exception {
	    driver.get("http://localhost:8090/");
	    driver.findElement(By.id("myNavbar")).click();
	    SeleniumUtils.textoNoPresentePagina(driver, "Gestión de usuarios");
	  }
	 
	 @Test
	  public void prueba29() throws Exception {
	    driver.get("http://localhost:8090/");
	    driver.findElement(By.id("myNavbar")).click();
	    SeleniumUtils.textoNoPresentePagina(driver, "Mis ofertas");
	  }
	 
	 @Test
	  public void prueba30() throws Exception {
	    driver.get("http://localhost:8090/login?logout");
	    driver.findElement(By.name("username")).click();
	    driver.findElement(By.name("username")).clear();
	    driver.findElement(By.name("username")).sendKeys("danielLlana_98@gmail.com");
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys("user123");
	    driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
	    SeleniumUtils.textoNoPresentePagina(driver, "Gestión de usuarios");
	  }
	 
	 

}
