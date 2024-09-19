package tr.abdullah.stepImplementations;

import com.thoughtworks.gauge.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import tr.abdullah.pageObjects.HomePage;
import tr.abdullah.pageObjects.SearchPage;
import tr.abdullah.testUtils.BaseTest;

import java.io.IOException;

public class StepImplementation extends BaseTest {

    public Logger logger = LoggerFactory.getLogger(getClass());
    public HomePage homePage;
    public SearchPage searchPage;

    String wallpaperName;

    @Step("Backdrops uygulamasi acilir.")
    public void openApp() throws IOException {

        logger.info("Uygulama aciliyor...");
        configureAppium();
    }

    @Step("Uygulamanin acildigi kontrol edilir.")
    public void checkOpenApp() {

        boolean openApp = welcomePage.openAppControl();
        Assert.assertTrue(openApp);

        if(openApp) {
            logger.info("Uygulama acildi.");
        }

        else {
            logger.error("Uygulama acilamadi.");
        }
    }

    @Step("<string> butonuna tiklanir.")
    public void clickButton(String btnName) {

        switch (btnName) {
            case "Accept and Continue":
                homePage = welcomePage.goToHomePage();
                logger.info(btnName + " butonuna tiklandi.");
                break;
        }
    }

    @Step("Anasayfanin acildigi kontrol edilir.")
    public void checkHomePage() {

        boolean openHomePage = homePage.checkOpenHomePage();
        Assert.assertTrue(openHomePage);

        if(openHomePage) {
            logger.info("Anasayfa acildi.");
        }

        else {
            logger.error("Anasayfa acilamadi.");
        }
    }

    @Step("Arama ikonuna tiklanir.")
    public void goSearchPage() {

        searchPage = homePage.goToSearchPage();
        logger.info("Arama ikonuna tiklandi.");
    }

    @Step("Arama kismina <string> yazilir.")
    public void searchWallpapers(String wallpaperName) {

        logger.info(wallpaperName + " isimli duvar kagidi araniyor...");
        this.wallpaperName = wallpaperName;
        searchPage.searchWallpaper(wallpaperName);
    }

    @Step("Arama sonucunda duvar kagidinin gozuktugu kontrol edilir.")
    public void checkWallpaperList() {

        logger.info("Duvar kagidi kontrolu yapiliyor...");
        searchPage.checkWallpaper(wallpaperName);
    }

    @Step("Cikan duvar kagidi favorilere eklenir.")
    public void addFavorites() {

        searchPage.clickFavIcon();
        logger.info("Duvar kagidi favorilere eklendi.");
    }

    @Step("Favorilere eklendigine dair kalp ikonu kontrol edilir.")
    public void checkFavIcon() {

        logger.info("Kalp ikonu kontrol ediliyor...");
        Assert.assertTrue(searchPage.checkFavIcons());
    }

    @Step("Uygulama ana ekranina gecis yapilir.")
    public void backHomePage() throws InterruptedException {

        homePage = searchPage.returnHomePage();
        logger.info("Anasayfaya gecis yapildi.");
    }

    @Step("Favoriler sekmesine gecis yapilir.")
    public void goToFavoritesList() {

        homePage.clickFavoritesTab();
        logger.info("Favoriler sekmesine gecis yapildi.");
    }

    @Step("Favoriler kisminda duvar kagidinin gozuktugu kontrol edilir.")
    public void checkFavoritesWallpaper() {

        logger.info("Duvar kagidi kontrol ediliyor...");
        homePage.checkFavoriteWallpaper(wallpaperName);
    }

    @Step("Gozuken duvar kagidina tiklanir.")
    public void implementation13() {

    }

    @Step("Duvar kagidinin uygulandigina dair toast mesaj kontrol edilir.")
    public void implementation14() {

    }

    @Step("Telefon ana ekranina gecis yapilir.")
    public void implementation15() {

    }
}