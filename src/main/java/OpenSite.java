
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class OpenSite {
    private WebDriver driver;

    @Before
    public void setUp() {

        // If you want to disable infobars please use this code
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");

        // Initialize path to ChromeDriver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        // Initialize instance of ChromeDriver and add options
        driver = new ChromeDriver(options);

        // Set 10 second for implicitly wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Maximize window
        driver.manage().window().maximize();
    }

    @Test
    public void testOpenGoogleTest() {
        // Open Google
        driver.get("https://google.com.ua");
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Automation testing");
        driver.findElement(By.xpath("//div[@class='VlcLAe']//input[@value='Пошук Google']")).click();
        // //h3[@class='LC20lb'][contains(.,'Test Automation vs. Automated Testing')]

        while (driver.findElements(
                By.xpath("//h3[@class='LC20lb'][contains(.,'Test Automation vs. Automated Testing')]")).size() == 0) {
            driver.findElement(By.xpath("//a[@id='pnnext']")).click();
            if (driver.findElements(
                    By.xpath("//h3[@class='LC20lb'][contains(.,'Test Automation vs. Automated Testing')]")).size() != 0) {
                break;
            }
    }

    driver.findElement(By.xpath("//h3[@class='LC20lb'][contains(.,'Test Automation vs. Automated Testing')]")).click();
        String Url = driver.getCurrentUrl();
        if (Url.equals("https://www.qasymphony.com/blog/test-automation-automated-testing/")) {
            System.out.println("The site is correct");
        } else {
            System.out.println("The site is not correct");
        }
}

    @After
    public void tearDown() {
        driver.quit();
    }


    }
