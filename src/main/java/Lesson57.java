import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Lesson57 {
    public static void main(String[] args) {
        String osName = System.getProperty("os.name");

        System.out.println(osName);

        if (osName.contains("Mac")) {
            System.setProperty("webdriver.chrome.driver"
                    , "/Users/dzb/Downloads/chromedriver");

            System.setProperty("selenium.browser", "Chrome");

        } else if (osName.contains("Win")) {
            System.setProperty("webdriver.chrome.driver"
                    , "C:\\Users\\Dmitry B\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");

            System.setProperty("selenium.browser", "Chrome");

        } else {
            System.out.println("Add any drivers for browsers for your OS");
        }

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://github.com");

        WebElement signInButon = driver.findElement(By.xpath("//a[text()='Sign in']"));

        System.out.println(driver.findElements(By.xpath("//a[text()='Log in']")).size());

        if (driver.findElements(By.xpath("//a[text()='Log in']")).size() > 0) {
            System.out.println("Such element is presented");
        }
        else {
            System.out.println("Can not find such element");
        }

        driver.quit();
    }
}
