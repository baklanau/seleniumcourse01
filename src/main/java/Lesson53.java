import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Lesson53 {

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
            System.out.println("Add any drivers for browsers for your OS");
        }

        //WebDriver driver = new FirefoxDriver();
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html");
        driver.findElement(By.xpath("//a[text()='jdk-8u181-windows-x64.exe']")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().accept();

        driver.get("http://google.com");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("confirm('Are you sure?');");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.switchTo().alert().dismiss();



//        driver.quit();
    }
}