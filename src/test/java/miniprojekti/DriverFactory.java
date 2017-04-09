package miniprojekti;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Marko Vainio on 8.4.2017.
 */
public class DriverFactory {
    private DriverFactory() {
    }

    private static DriverFactory instance = new DriverFactory();

    public static DriverFactory getInstance() {
        return instance;
    }

    // thread local driver object for webdriver
    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() {
        @Override
        protected WebDriver initialValue() {
            ChromeDriverManager.getInstance().setup();
            return  new ChromeDriver(); // or other browser drivers
        }
    };

    // call this method to get the driver object and launch the browser
    public WebDriver getDriver() {
        ChromeDriverManager.getInstance().setup();
        return driver.get();
    }

    // Quits the driver and closes the browser
    public void removeDriver() {
        driver.get().quit();
        driver.remove();
    }
}
