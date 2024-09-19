package tr.abdullah.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import tr.abdullah.utils.AndroidActions;

public class WallpaperPage extends AndroidActions {

    AndroidDriver driver;

    public WallpaperPage(AndroidDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.backdrops.wallpapers:id/btn_apply")
    private WebElement setButton;

    @AndroidFindBy(id = "com.backdrops.wallpapers:id/home_screen")
    private WebElement homeScreenButton;

    public void clickSetBtn() {
        setButton.click();
    }

    public void clickHomeScreenBtn() {
        homeScreenButton.click();
    }

    public void switchPhoneHomeScreen() throws InterruptedException {

        Thread.sleep(5000);
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
    }
}