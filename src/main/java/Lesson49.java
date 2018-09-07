import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Lesson49 {
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

        driver.get("http://www.w3schools.com/html/html_tables.asp");

        WebElement tableElement = driver.findElement(By.xpath("//table[@id=\"customers\"]"));

        Table table = new Table(tableElement, driver);

        System.out.println("Rows number is: " + table.getRows().size());

        System.out.println(table.getValueFromCell(2, 3));
        System.out.println(table.getValueFromCell(4, 1));

        System.out.println(table.getValueFromCell(4, "Company"));
        System.out.println(table.getValueFromCell(1, "Country"));
        System.out.println(table.getValueFromCell(2, "Contact"));

        driver.quit();
    }
}
