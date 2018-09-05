import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.System.getProperty;
import static java.lang.System.setOut;

public class MainClass {
    static WebDriver driver;

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
            System.out.println("Add any drivers for browsers for your OS");;
        }

        //System.setProperty("webdriver.chrome.driver", "/Users/dzb/Downloads/chromedriver");
        //System.setProperty("selenide.browser", "Chrome");

        driver = new FirefoxDriver();

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

        WebElement linkLogIn = driver.findElement(By.linkText("Log in"));
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


        driver.get("http://www.facebook.com");
        driver.findElement(By.xpath("//label[@id='loginbutton']/input")).submit();


        //44 lesson
        driver.get("http://en.wikipedia.org");
        driver.findElement(By.xpath("//input[@id='searchInput']")).sendKeys("Selenium WebDriver");
        driver.findElement(By.xpath("//input[@id='searchButton']")).click();
        System.out.println(driver.findElement(By.xpath("//div[@id='searchText']/input")).getAttribute("value"));
        driver.findElement(By.xpath("//div[@id='searchText']/input")).clear();

        driver.get("http://github.com");
        driver.findElement(By.xpath(".//*[@id='user[login]']")).sendKeys("testusername");
        driver.findElement(By.xpath(".//*[@id='user[password]']")).sendKeys("testpass");
        WebElement button = driver.findElement(By.xpath("//form[@class='home-hero-signup js-signup-form']//button"));
        button.submit();
//        driver.findElement(By.xpath("//a[text()='Sign in']")).click();
//
        driver.get("http://www.facebook.com");
        driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("testmail");
        driver.findElement(By.xpath(".//*[@id='pass']")).sendKeys("testpass");
        driver.findElement(By.xpath("//label[@id='loginbutton']/input")).submit();
        //driver.findElement(By.name("login")).submit();
        System.out.println("Mail is: " + driver.findElement(By.xpath(".//*[@id='email']")).getAttribute("value"));

        //45 lesson
        driver.get("http://en.wikipedia.org");

        WebElement link = driver.findElement(By.xpath("//li[@id='n-aboutsite']/a"));
        System.out.println(link.getText());
        link.click();
//label[@id='loginbutton']/input
        driver.get("http://github.com");
        driver.findElement(By.xpath("//li[@class='ml-lg-2']/a")).click();

        driver.get("http://en-gb.facebook.com");
        driver.findElement(By.xpath("//a[text()='Forgotten account?']")).click();

        //46 lesson - radio buttons ans check boxes
        driver.get("https://market.yandex.ru");

        driver.findElement(By.xpath("//a[text()='Бытовая техника']")).click();
        driver.findElement(By.xpath("//a[text()='Холодильники']")).click();
        System.out.println();
//        if (!driver.findElement(By.xpath("//span[text()='ATLANT']/../preceding-sibling::input")).isSelected()) {
//            driver.findElement(By.xpath("//span[text()='ATLANT']/..")).click();
//        }
//
//        System.out.println(driver.findElement(By.xpath("//span[text()='ATLANT']/../preceding-sibling::input")).isSelected());
        //driver.findElement(By.xpath("//span[text()='Bosch']")).click();
        //driver.findElement(By.xpath("//span[text()='LG']")).click();

        selectCheckBox("ATLANT");
        selectCheckBox("Bosch");
        selectCheckBox("LG");
        selectCheckBox("BEKO");

        deselectCheckBox("LG");

        System.out.println();

        System.out.println(driver.findElement(By.xpath("//span[text()='Самовывоз']/../preceding-sibling::input")).isSelected());
        driver.findElement(By.xpath("//span[text()='Самовывоз']")).click();
        System.out.println(driver.findElement(By.xpath("//span[text()='Самовывоз']/../preceding-sibling::input")).isSelected());


        driver.quit();
    }

    public static void selectCheckBox(String name) {
        String checkBoxXpath = "//span[text()='%s']/..";

        if (!driver.findElement(By.xpath(String.format(checkBoxXpath, name) + "/preceding-sibling::input")).isSelected()) {
            driver.findElement(By.xpath(String.format(checkBoxXpath, name))).click();
        }
    }

    public static void deselectCheckBox(String name) {
        String checkBoxXpath = "//span[text()='%s']/..";

        if (driver.findElement(By.xpath(String.format(checkBoxXpath, name) + "/preceding-sibling::input")).isSelected()) {
            driver.findElement(By.xpath(String.format(checkBoxXpath, name))).click();
        }
    }
}
