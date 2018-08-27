package mingeso.WebdriverTest;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AgregarProblemaProfesor {
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
  public void testAgregarProblemaProfesor() throws Exception {
    driver.get("http://localhost:3000/add");
    driver.findElement(By.id("formBasicText")).click();
    driver.findElement(By.id("formBasicText")).clear();
    driver.findElement(By.id("formBasicText")).sendKeys("Titulo 1");
    driver.findElement(By.name("inputValue")).click();
    driver.findElement(By.name("inputValue")).clear();
    driver.findElement(By.name("inputValue")).sendKeys("10");
    new Select(driver.findElement(By.name("inputType"))).selectByVisibleText("Entero");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Campo obligatorio.'])[2]/following::option[2]")).click();
    driver.findElement(By.name("output")).click();
    driver.findElement(By.name("output")).clear();
    driver.findElement(By.name("output")).sendKeys("100");
    driver.findElement(By.name("description")).click();
    driver.findElement(By.name("description")).clear();
    driver.findElement(By.name("description")).sendKeys("Multiplicar la entrada por 10.");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Campo obligatorio.'])[4]/following::button[1]")).click();
    assertEquals("Incorporated: Titulo 1 with 1 inputs", closeAlertAndGetItsText());
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
