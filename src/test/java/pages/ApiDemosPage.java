package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ApiDemosPage extends BasePage {
    @AndroidFindBy(accessibility = "Preference")
    public WebElement preference;

    @AndroidFindBy(accessibility = "3. Preference dependencies")
    public WebElement prefence3;

    @AndroidFindBy(id = "android:id/checkbox")
    public WebElement checkbox;
    @AndroidFindBy(xpath = "(//*[@class=\"android.widget.RelativeLayout\"])[2]")
    public WebElement wifiSettings;

    @AndroidFindBy(id = "android:id/edit")
    public WebElement edit;
    @AndroidFindBy(id = "android:id/button1")
    public WebElement okButton;



}
