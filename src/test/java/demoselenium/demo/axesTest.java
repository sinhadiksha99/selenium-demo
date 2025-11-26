package demoselenium.demo;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class axesTest {
    @Test
    public void seleTest() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://money.rediff.com/gainers/bse/daily/groupa");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        Set<String> windows = driver.getWindowHandles();
        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(2)).ignoring(ElementNotInteractableException.class);
        WebElement zuariSele = driver.findElement(By.xpath("//*[text()='Emami']/self::a"));
        System.out.println(zuariSele.getText());
        driver.quit();
    }

}
