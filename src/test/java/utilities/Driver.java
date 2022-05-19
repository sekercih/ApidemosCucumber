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

    public static AndroidDriver<AndroidElement> get(){
        if (driver==null){
            String platform = ConfigurationReader.get("platform");
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

            switch (platform){
                case "android":

                    desiredCapabilities.setCapability("platformName", "Android");
                    desiredCapabilities.setCapability("platformVersion", "11.0");
                    desiredCapabilities.setCapability("deviceName", "Pixel_2");
                    desiredCapabilities.setCapability("automationName", "UiAutomator2");
                    desiredCapabilities.setCapability("app", "C:\\Users\\Mehmet\\Desktop\\com.ApidemosCucumber\\apidemos.apk");
                    try {
                        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
                        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    }catch (MalformedURLException e){
                        e.printStackTrace();
                    }
                    break;
                default:

            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }
}