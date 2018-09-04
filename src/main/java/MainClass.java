import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dmitry B\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().setSize(new Dimension(900, 500));
        driver.manage().window().maximize();

        driver.get("http://ya.ru");
        driver.navigate().to("http://google.by");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.get("http://en.wikipedia.org");

        WebElement link = driver.findElement(By.linkText("Log in"));
        WebElement link2 = driver.findElement(By.partialLinkText("Donate"));
        WebElement searchField = driver.findElement(By.name("search"));
        WebElement searchButton = driver.findElement(By.className("searchButton"));
        WebElement viewSourceLink = driver.findElement(By.id("ca-viewsource"));
        WebElement inputTag = driver.findElement(By.tagName("input"));
        WebElement searchInput = driver.findElement(By.cssSelector("input#searchInput"));
        WebElement logo = driver.findElement(By.xpath("//a[@class='mw-wiki-logo']"));
        WebElement searchButtonXpath = driver.findElement(By.xpath("//input[@id='searchButton']"));
        searchButtonXpath.click();

        //43 lesson
        driver.get("https://github.com/");
        WebElement buttonSignUp = driver
                .findElement(By.xpath("//form[@class='home-hero-signup js-signup-form']//button[contains(@class, 'f4')]"));
        //buttonSignUp.submit();
        System.out.println("Button text is: " + buttonSignUp.getText());

        //driver.findElement(By.xpath("//a[text()='Sign in']")).click();
        //driver.quit();

        driver.get("facebook.com");
        driver.findElement(By.xpath("//label[@id='loginbutton']/input")).submit();
    }
}
