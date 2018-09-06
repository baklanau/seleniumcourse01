import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Lesson51 {
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

        driver.get("https://ebay.com");

        WebElement electronics = driver.findElement(By.xpath("//tr[@role='list']//a[text()='Электроника']"));
        WebElement element = driver.findElement(By.xpath("//tr[@role='list']//a[text()='Электроника']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(electronics).build().perform();

        actions.dragAndDrop(element,electronics).build().perform();

        //actions.clickAndHold(element).moveToElement(electronics).release().build().perform();

        //actions.doubleClick(element);

//        actions.contextClick(element);
//
//        Action action = actions.clickAndHold(element).moveToElement(electronics).release().build();
//
//        action.perform();

        //driver.quit();

    }
}
