import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;

public class TheFirstTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/mariamkhalatova/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
//      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://picsartstage2.com/");
        new WebDriverWait(driver,2).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".pa-uiLib-headerAuth-signInBtn.pa-uiLib-headerAuth-authBtn")));

        WebElement loginButton = driver.findElement(By.cssSelector("[data-test='headerAuth-signInBtn pa-uiLib-headerAuth-authBtn']"));
        loginButton.click();
//      Thread.sleep(1000);
        new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("username")));


        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("mariam.khalatova@picsart.com");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("Maldives032!");
        Thread.sleep(5000);

        WebElement signInButton = driver.findElement(By.cssSelector(".pa-uiLib-authentication-btn.primary"));
        signInButton.click();
        Thread.sleep(5000);
        String expectedUrl = "https://picsartstage2.com/create";
        System.out.println(expectedUrl);
        String a = driver.getCurrentUrl();
        System.out.println(a);
        if (a.equals(expectedUrl)){
         System.out.println("Navigated to correct webpage");
        } else {System.out.println("wrong");
        //        driver.quit();
    }
    }}