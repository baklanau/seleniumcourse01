import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lesson54 {
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

        WebDriver driver = new ChromeDriver();

        driver.get("http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html");
        String mainWindow = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[text()='Oracle Binary Code License Agreement for Java SE']")).click();

        for(String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }

        driver.findElement(By.xpath("//a[text()=' Technology Network']")).click();

        driver.switchTo().window(mainWindow);

        driver.findElement(By.xpath("//a/span[text()='Overview']")).click();


        driver.get("http://signup.live.com");
        String mainTab = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[text()='Условия использования']")).click();

//        driver.findElement(By.xpath("//a[text()='соглашения об использовании служб Майкрософт']")).click();
//
//        for (String tab : driver.getWindowHandles()){
//            driver.switchTo().window(tab);
//        }
//
//        driver.findElement(By.xpath("(//span[text()='Часто задаваемые вопросы']/parent::a)[2]")).click();
//
//        driver.switchTo().window(mainTab);
//
//        driver.findElement(By.xpath(".//*[@id='LastName']")).sendKeys("test");

 //       driver.quit();


    }
}
