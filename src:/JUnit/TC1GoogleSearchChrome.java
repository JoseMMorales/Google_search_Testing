package google_Search_JUnit;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC1GoogleSearchChrome {
  
  private WebDriver driver;
  By BarLocator = By.name("q");
  By SearchButtonLocator = By.name("btnK");
  
  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "/.............../chromedriver");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.google.com/");
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
  }

  @Test
  public void test() throws InterruptedException {
    Thread.sleep(2000);
    if(driver.findElement(BarLocator).isDisplayed()) {
      driver.findElement(BarLocator).sendKeys("Guru99");
      driver.findElement(BarLocator).click();
      driver.findElement(SearchButtonLocator).click();
    }else {
      System.out.println("Search Bar is not displayed!");
    }
    List<WebElement> H3Text = driver.findElements(By.tagName("h3"));
    assertEquals("Meet Guru99 - Free Training Tutorials & Video for IT Courses", H3Text.get(0).getText());	
  }
}
