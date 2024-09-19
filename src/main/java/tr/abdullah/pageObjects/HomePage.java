package tr.abdullah.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import tr.abdullah.utils.AndroidActions;

public class HomePage extends AndroidActions {

    AndroidDriver driver;

    public HomePage(AndroidDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.backdrops.wallpapers:id/toolbar_title")
    private WebElement appLogo;

    public boolean checkOpenHomePage() {
        return appLogo.isDisplayed();
    }
}