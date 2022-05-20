package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver() {
    }

    private static AndroidDriver<AndroidElement> driver;
    public static String userName = "hkksrkc1";
    public static String accessKey = "sVkrv1YNrVGCWusu9rrk";

    public static AndroidDriver<AndroidElement> get() {
        if (driver == null) {
            String platform = ConfigurationReader.get("platform");
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();


            switch (platform) {
                case "android":

                    desiredCapabilities.setCapability("platformName", "Android");
                    desiredCapabilities.setCapability("platformVersion", "11.0");
                    desiredCapabilities.setCapability("deviceName", "Pixel_2");
                    desiredCapabilities.setCapability("automationName", "UiAutomator2");
                    desiredCapabilities.setCapability("app", "C:\\Users\\Mehmet\\Desktop\\com.ApidemosCucumber\\apidemos.apk");

                    try {
                        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
                        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "browserstack":

                    desiredCapabilities.setCapability("os_version", "9.0");
                    desiredCapabilities.setCapability("device", "Google Pixel 3");
                    desiredCapabilities.setCapability("app", "bs://83f53bd8d4aad4259091bc9d409667afad19a2a9");
                    try {
                        driver = new AndroidDriver<AndroidElement>(new URL("https://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"), desiredCapabilities);
                        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                default:

            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}