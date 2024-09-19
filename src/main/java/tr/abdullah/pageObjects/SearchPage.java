package tr.abdullah.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import tr.abdullah.utils.AndroidActions;

import java.util.List;

public class SearchPage extends AndroidActions {

    AndroidDriver driver;

    public SearchPage(AndroidDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "android:id/search_src_text")
    private WebElement searchBox;

    @AndroidFindBy(id = "com.backdrops.wallpapers:id/wall_title")
    private List<WebElement> wallpaperTitles;

    @AndroidFindBy(id = "com.backdrops.wallpapers:id/fav_off")
    private List<WebElement> favOffIcons;

    @AndroidFindBy(id = "com.backdrops.wallpapers:id/fav_on")
    private List<WebElement> favOnIcons;

    @AndroidFindBy(id = "android:id/search_close_btn")
    private WebElement searchCloseButton;

    public void searchWallpaper(String wallpaperName) {

        searchBox.click();
        searchBox.sendKeys(wallpaperName);
    }

    public void checkWallpaper(String wallpaperName) {
        Assert.assertEquals(wallpaperTitles.get(0).getText(), wallpaperName);
    }

    public void clickFavIcon() {
        favOffIcons.get(0).click();
    }

    public boolean checkFavIcons() {
        return favOnIcons.get(0).isDisplayed();
    }

    public HomePage returnHomePage() throws InterruptedException {

        searchCloseButton.click();
        Thread.sleep(2000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));

        return new HomePage(driver);
    }
}