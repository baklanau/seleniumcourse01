import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lesson55 {
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
        driver.manage().window().maximize();

        driver.get("http://signup.live.com");
        String mainTab = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[text()='Условия использования']")).click();

        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }

        driver.findElement(By.xpath("//a[text()='Часто задаваемые вопросы']")).click();

        driver.switchTo().window(mainTab);
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("testEmail@");
        driver.quit();
    }
}
