package demoselenium.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class test {

    @Test
    public void seleTest() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");              // for CI environments
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("http://www.facebook.com");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ByChained chained = new ByChained(By.cssSelector("[data-testid=royal_login_form]"), By.id("email"));

            WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(chained));
            emailInput.sendKeys("hence@gamil.com");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
