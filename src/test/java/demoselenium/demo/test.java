package demoselenium.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

public class test {

    @Test
    public void seleTest() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.facebook.com");
        Thread.sleep(3000);
        By chained = new ByChained(By.cssSelector("[data-testid=royal_login_form]"),By.id("email"));
        driver.findElement(chained).sendKeys("hence@gamil.com");
        Thread.sleep(3000);
        driver.quit();
    }

}