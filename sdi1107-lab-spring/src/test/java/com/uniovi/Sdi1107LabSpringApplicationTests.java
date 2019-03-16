package com.uniovi;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

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
	public void testRegiterConDatosValidos() throws Exception {
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
	public void testRegisterNombreApellidoCorreoVacios() throws Exception {
		driver.get("http://localhost:8090/signup");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("ContraseñaPrueba");
		driver.findElement(By.name("passwordConfirm")).clear();
		driver.findElement(By.name("passwordConfirm")).sendKeys("ContraseñaPrueba");
		driver.findElement(By.id("registerButton")).click();
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
		driver.findElement(By.id("registerButton")).click();
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

	@Test
	public void testLoginAdminValido() throws Exception {
		driver.get("http://localhost:8090/login");
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("admin@email.com");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
	}

	@Test
	public void testLoginStandardValido() throws Exception {
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
	public void testLoginStandardVacio() throws Exception {
		driver.get("http://localhost:8090/login?logout");
		driver.findElement(By.id("loginButton")).click();
	}

	@Test
	public void testLoginStandardContraseñaIncorrecta() throws Exception {
		driver.get("http://localhost:8090/login?logout");
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("pablo@uniovi.es");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("holaaa");
		driver.findElement(By.id("loginButton")).click();
	}

	@Test
	public void testLoginStandardEmailIncorrecto() throws Exception {
		driver.get("http://localhost:8090/login?error");
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("cristobal@gmail.com");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("user123");
		driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
	}

	@Test
	public void testLogout() throws Exception {
		driver.get("http://localhost:8090/home");
		driver.findElement(By.id("Desconectar")).click();
	}

	@Test
	public void testUsuariosEnElSistema() throws Exception {
		driver.get("http://localhost:8090/home");
		driver.findElement(By.linkText("Gestión de usuarios")).click();
		driver.findElement(By.linkText("Usuarios")).click();
	}

	@Test
	public void testEliminarPrimerUsuario() throws Exception {
		driver.get("http://localhost:8090/home");
		driver.findElement(By.linkText("Gestión de usuarios")).click();
		driver.findElement(By.linkText("Usuarios")).click();
		driver.findElements(By.className("borrar")).get(0);
		driver.findElement(By.id("deleteButton")).click();

	}

	@Test
	public void testEliminarÚltimoUsuario() throws Exception {
		driver.get("http://localhost:8090/user/list");
		driver.findElement(By.id("deleteButton")).click();
		driver.findElement(By.id("deleteButton")).click();
		List<WebElement> a = driver.findElements(By.className("borrar"));
		driver.findElements(By.className("borrar")).get(a.size() - 1);
	}

	@Test
	public void testEliminarTresUsuarios() throws Exception {
		driver.get("http://localhost:8090/home");
		driver.findElement(By.linkText("Gestión de usuarios")).click();
		driver.findElement(By.linkText("Usuarios")).click();
		driver.findElement(By.name("idsUser")).click();
		driver.findElement(By.id("deleteButton")).click();
		driver.findElement(By.id("deleteButton")).click();
		driver.findElement(By.id("deleteButton")).click();
	}

	@Test
	public void testAgregarUnaOfertaValida() throws Exception {
		driver.get("http://localhost:8090/home");
		driver.findElement(By.linkText("Ofertas")).click();
		driver.findElement(By.linkText("Añadir oferta")).click();
		driver.findElement(By.id("title")).click();
		driver.findElement(By.id("title")).clear();
		driver.findElement(By.id("title")).sendKeys("Seat Panda");
		driver.findElement(By.id("details")).clear();
		driver.findElement(By.id("details")).sendKeys("Es un buen coche");
		driver.findElement(By.id("price")).clear();
		driver.findElement(By.id("price")).sendKeys("500");
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Precio'])[1]/following::button[1]"))
				.click();
		driver.findElement(By.linkText("Ofertas")).click();
		driver.findElement(By.linkText("Mis ofertas")).click();
	}

	@Test
	public void testAgregarOfertaInvalida() throws Exception {
		driver.get("http://localhost:8090/home");
		driver.findElement(By.linkText("Ofertas")).click();
		driver.findElement(By.linkText("Añadir oferta")).click();
		driver.findElement(By.id("details")).click();
		driver.findElement(By.id("details")).clear();
		driver.findElement(By.id("details")).sendKeys("Estado seminuevo");
		driver.findElement(By.id("price")).clear();
		driver.findElement(By.id("price")).sendKeys("10.0");
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Precio'])[1]/following::button[1]"))
				.click();
	}

	@Test
	public void testListarMisOfertas() throws Exception {
		driver.get("http://localhost:8090/home");
		driver.findElement(By.linkText("Ofertas")).click();
		driver.findElement(By.linkText("Mis ofertas")).click();
	}

	@Test
	public void testBorrarPrimeraOferta() throws Exception {
		driver.get("http://localhost:8090/sale/list");
		driver.findElement(By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Con cordajes y grips recambiables'])[1]/following::input[1]"))
				.click();
	}

	@Test
	public void testBorrarUltimaOferta() throws Exception {
		driver.get("http://localhost:8090/sale/list");
		driver.findElement(By.linkText("2")).click();
		driver.findElement(By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Emblemático disco de la banda de Hard Rock'])[1]/following::input[1]"))
				.click();
	}

	@Test
	public void testBuscarCampoVacio() throws Exception {
		driver.get("http://localhost:8090/home");
		driver.findElement(By.linkText("Ofertas")).click();
		driver.findElement(By.linkText("Ofertas disponibles")).click();
		driver.findElement(By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Ofertas disponibles'])[2]/following::button[1]"))
				.click();
	}

	@Test
	public void testBuscarInexistente() throws Exception {
		driver.get("http://localhost:8090/sale/listAll?searchText=");
		driver.findElement(By.name("searchText")).click();
		driver.findElement(By.name("searchText")).clear();
		driver.findElement(By.name("searchText")).sendKeys("wertyhjk");
		driver.findElement(By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Ofertas disponibles'])[2]/following::button[1]"))
				.click();
	}

	@Test
	public void testComprarSaldoPositivo() throws Exception {
		driver.get("http://localhost:8090/sale/listAll?searchText=wertyhjk");
		driver.findElement(By.linkText("Ofertas")).click();
		driver.findElement(By.linkText("Ofertas disponibles")).click();
		driver.findElement(By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Película del director Michael Bay'])[1]/following::input[1]"))
				.click();
	}

	@Test
	public void testComprarSaldoCero() throws Exception {
		driver.get("http://localhost:8090/sale/listAll");
		driver.findElement(By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Fantásticos para pasar el día en familia'])[1]/following::input[1]"))
				.click();
	}

}
