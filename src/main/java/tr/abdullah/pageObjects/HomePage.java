package tr.abdullah.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import tr.abdullah.utils.AndroidActions;

import java.util.List;

public class HomePage extends AndroidActions {

    AndroidDriver driver;

    public HomePage(AndroidDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.backdrops.wallpapers:id/toolbar_title")
    private WebElement appLogo;

    @AndroidFindBy(id = "com.backdrops.wallpapers:id/search")
    private WebElement searchButton;

    @AndroidFindBy(id = "com.backdrops.wallpapers:id/menu_favorite")
    private WebElement favoritesTab;

    @AndroidFindBy(id = "com.backdrops.wallpapers:id/wall_title")
    private List<WebElement> wallpaperTitles;

    public boolean checkOpenHomePage() {
        return appLogo.isDisplayed();
    }

    public SearchPage goToSearchPage() {

        searchButton.click();
        return new SearchPage(driver);
    }

    public void clickFavoritesTab() {
        favoritesTab.click();
    }

    public void checkFavoriteWallpaper(String wallpaperName) {
        Assert.assertEquals(wallpaperTitles.get(0).getText(), wallpaperName);
    }
}