import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Lesson47 {
    public static void main(String[] args) {
        String osName = System.getProperty("os.name");

        System.out.println(osName);

        if (osName.contains("Mac")) {
            System.setProperty("webdriver.gecko.driver"
                    ,"/Users/dzb/IdeaProjects/seleniumcourse01/drivers/geckodriver");
            System.setProperty("selenium.browser", "Firefox");

        } else if (osName.contains("Win")) {
            System.setProperty("webdriver.gecko.driver"
                    , "C:\\Users\\Dmitry B\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");
            System.setProperty("selenium.browser", "Firefox");

        } else {
            System.out.println("Add any drivers for browsers for your OS");
        }

        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.get("https://accounts.google.com/signup/v2/webcreateaccount?continue=https%3A%2F%2Fwww.google.com%2F&hl=ru&flowName=GlifWebSignIn&flowEntry=SignUp");

        driver.quit();
    }
}
