import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Lesson62 {
    static WebDriver driver;
    public static void main(String[] args) {
        String osName = System.getProperty("os.name");

        System.out.println(osName);

        if (osName.contains("Mac")) {
            System.setProperty("webdriver.chrome.driver"
                    , "/Users/dzb/Downloads/chromedriver");

            System.setProperty("selenium.browser", "Chrome");

        } else if (osName.contains("Win")) {
            System.setProperty("phantomjs.binary.path"
                    , "C:\\Users\\Dmitry B\\IdeaProjects\\testselenium\\drivers\\phantomjs.exe");

            //System.setProperty("selenium.browser", "Chrome");

        } else {
            System.out.println("Add any drivers for browsers for your OS");
        }

        //driver = new PhantomJSDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://images.google.com");

        driver.findElement(By.xpath("//a[@aria-label=\"Поиск по картинке\"]")).click();
        driver.findElement(By.xpath("//a[text()='Загрузить файл']")).click();
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\screenshots\\1.png");

        driver.quit();
    }
}
