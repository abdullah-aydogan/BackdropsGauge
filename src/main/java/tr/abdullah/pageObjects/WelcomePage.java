package tr.abdullah.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import tr.abdullah.utils.AndroidActions;

public class WelcomePage extends AndroidActions {

    AndroidDriver driver;

    public WelcomePage(AndroidDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.backdrops.wallpapers:id/app_icon")
    private WebElement appLogo;

    @AndroidFindBy(id = "com.backdrops.wallpapers:id/btnSkip")
    private WebElement acceptButton;

    public boolean openAppControl() {
        return appLogo.isDisplayed();
    }

    public HomePage goToHomePage() {

        acceptButton.click();
        return new HomePage(driver);
    }
}