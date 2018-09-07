import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Lesson48 {
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

        driver.get("https://market.yandex.ru");

        driver.findElement(By.xpath("//a[text()='Бытовая техника']")).click();
        driver.findElement(By.xpath("//a[text()='Холодильники']")).click();

        List<WebElement> checkboxes = driver.findElements(By.xpath("//legend[text()='Производитель']/following-sibling::ul//span/.."));

        if (checkboxes.size() == 12) System.out.println("it's ok");
        else System.out.println("FAIL");

        //checkboxes.get(3).click();

        for (WebElement checkbox : checkboxes) {
            checkbox.click();
        }

        //driver.quit();
    }
}
