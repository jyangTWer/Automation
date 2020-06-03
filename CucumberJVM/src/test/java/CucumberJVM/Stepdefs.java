import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

public class Stepdefs {
    private String today;
    private Boolean actualAnswer;

    @Given("Open home page of baidu")
    public void Open_home_page_of_baidu() {
      // System.setProperty("webdriver.gecko.driver", "geckodriver");
      System.setProperty("webdriver.chrome.driver", "chromedriver");
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("https://www.baidu.com/");
      driver.findElement(By.id("kw")).clear();
      driver.findElement(By.id("kw")).sendKeys("selenium");
      driver.findElement(By.id("su")).click();
      driver.quit();
    }
}
