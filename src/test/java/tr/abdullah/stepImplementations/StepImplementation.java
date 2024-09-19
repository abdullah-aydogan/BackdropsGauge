package tr.abdullah.stepImplementations;

import com.thoughtworks.gauge.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import tr.abdullah.pageObjects.HomePage;
import tr.abdullah.testUtils.BaseTest;

import java.io.IOException;

public class StepImplementation extends BaseTest {

    public Logger logger = LoggerFactory.getLogger(getClass());
    public HomePage homePage;

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
    public void implementation5() {

    }

    @Step("Arama kismina <string> yazilir.")
    public void implementation6(String wallpaperName) {

    }

    @Step("Arama sonucunda duvar kagidinin gozuktugu kontrol edilir.")
    public void implementation7() {

    }

    @Step("Cikan duvar kagidi favorilere eklenir.")
    public void implementation8() {

    }

    @Step("Favorilere eklendigine dair toast mesaj kontrol edilir.")
    public void implementation9() {

    }

    @Step("Uygulama ana ekranina gecis yapilir.")
    public void implementation10() {

    }

    @Step("Favoriler sekmesine gecis yapilir.")
    public void implementation11() {

    }

    @Step("Favoriler kisminda duvar kagidinin gozuktugu kontrol edilir.")
    public void implementation12() {

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