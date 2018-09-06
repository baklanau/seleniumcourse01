import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Lesson52 {
    public static void main(String[] args) {
        String osName = System.getProperty("os.name");

        System.out.println(osName);

        if (osName.contains("Mac")) {
//            System.setProperty("webdriver.gecko.driver"
//                    ,"/Users/dzb/IdeaProjects/seleniumcourse01/drivers/geckodriver");

            System.setProperty("webdriver.chrome.driver"
                    , "/Users/dzb/Downloads/chromedriver");

            //System.setProperty("selenium.browser", "Firefox");
            System.setProperty("selenium.browser", "Chrome");

        } else if (osName.contains("Win")) {
//            System.setProperty("webdriver.gecko.driver"
//                    , "C:\\Users\\Dmitry B\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");

            System.setProperty("webdriver.chrome.driver"
                    , "C:\\Users\\Dmitry B\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");

            //System.setProperty("selenium.browser", "Firefox");
            System.setProperty("selenium.browser", "Chrome");

        } else {
            System.out.println("Add any drivers for browsers for your OS");;
        }

        //WebDriver driver = new FirefoxDriver();
        WebDriver driver = new ChromeDriver();

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        //jse.executeScript("alert('Hello!');");

        driver.get("http://en.wikipedia.org");

        jse.executeScript("window.scrollBy(0, 1000)", "");
       // jse.executeScript("window.scrollBy(0, -1000)", "");
        //driver.quit();
    }
}
