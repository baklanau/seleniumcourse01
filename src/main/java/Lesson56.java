import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Lesson56 {
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
            System.out.println("Add any drivers for browsers for your OS");;
        }

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

//        driver.get("http://www.w3schools.com/jsref/prop_pushbutton_disabled.asp");
//
//        WebElement button1 = driver.findElement(By.xpath("//button[text()='My Button']"));
//        WebElement button2 = driver.findElement(By.xpath("//a[@title='Home']"));
//
//        System.out.println(button1.isEnabled());
//        System.out.println(button2.isEnabled());
//
//        if (button1.isEnabled()) button1.click();
//        if (button2.isEnabled()) button2.click();

        driver.get("http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html");

        WebElement rb1 = driver.findElement(By.xpath("(//input[@name='agreementjdk-8u181-oth-JPR'])[1]"));
        WebElement rb2 = driver.findElement(By.xpath("(//input[@name='agreementjdk-8u181-oth-JPR'])[2]"));

        System.out.println("Radio button 2 selected: " + rb2.isSelected());

        if (!rb1.isSelected()) rb1.click();

        driver.get("http://ebay.com");

        WebElement link1 = driver.findElement(By.xpath("//a[contains(text(), 'Бытовая электроника')]"));
        WebElement link2 = driver.findElement(By.xpath("//a[text()='Подписки']"));

        System.out.println(link1.isDisplayed());
        System.out.println(link2.isDisplayed());

        if (link1.isDisplayed()) link1.click();
        else link2.click();

        driver.quit();
    }
}
