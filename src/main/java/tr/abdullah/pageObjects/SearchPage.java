package tr.abdullah.pageObjects;

import io.appium.java_client.android.AndroidDriver;
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

    public void searchWallpaper(String wallpaperName) {

        searchBox.click();
        searchBox.sendKeys(wallpaperName);
    }

    public void checkWallpaper(String wallpaperName) {
        Assert.assertEquals(wallpaperTitles.get(0).getText(), wallpaperName);
    }
}