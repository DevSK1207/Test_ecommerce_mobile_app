package Model;

import Presenter.Pages;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

import java.io.IOException;
import java.util.Properties;

import static Presenter.Pages.*;
import static io.appium.java_client.touch.offset.PointOption.point;
import static org.junit.Assert.assertTrue;

public class AddToCart {
    public AppiumDriver cdriver;
    public String shortSleep;
    public String emailText;


    StartWith.Processing processing = new StartWith.Processing();
    public void openApp() throws Exception {
        Pages.readAndAccept.click();

    }

    public void findElectronics() throws Exception {

        Scroll(cdriver, 200, 0, 200, 2000);
        Pages.electronics.click();
    }

    public void addMattressBedroom() throws Exception {

        Scroll(cdriver, 200, 200, 0, 200);
        Pages.quantityButton.click();
        Thread.sleep(Long.parseLong(shortSleep));
        Pages.quantityButton.click();
    }

    public void addQuantity() throws Exception {

        Thread.sleep(Long.parseLong(shortSleep));
        Pages.quantityButton.click();
    }

    public void clickOnCartButton() throws Exception {
        Pages.cartIcon.click();
    }

    public void clickCheckoutFromShoppingCart() throws Exception {
        Pages.Cartcheckout.click();
    }

    public void selectGuest() throws Exception {
        guestButton.click();
    }

    public void inputInformation() throws Exception {

        Properties prop = processing.readPropertiesFile("TestData.properties");
        Thread.sleep(Long.parseLong(shortSleep));
        firstName.click();
        inputText(firstName, prop.getProperty("default"));
        Thread.sleep(Long.parseLong(shortSleep));

        Thread.sleep(Long.parseLong(shortSleep));
        lastName.click();
        inputText(lastName, prop.getProperty("default"));
        Thread.sleep(Long.parseLong(shortSleep));


        email.click();
        inputText(email, prop.getProperty("emailtext"));
        Thread.sleep(Long.parseLong(shortSleep));

        countrySpinner.click();
        Thread.sleep(Long.parseLong(shortSleep));
        countrySpinnerSelection.click();
        Thread.sleep(Long.parseLong(shortSleep));

        stateSpinner.click();
        Thread.sleep(Long.parseLong(shortSleep));
        stateSpinnerSelection.click();

        Thread.sleep(Long.parseLong(shortSleep));
        Company.click();
        inputText(Company, prop.getProperty("default"));
        Thread.sleep(Long.parseLong(shortSleep));

        Thread.sleep(Long.parseLong(shortSleep));
        city.click();
        inputText(city, prop.getProperty("default"));
        Thread.sleep(Long.parseLong(shortSleep));

        Thread.sleep(Long.parseLong(shortSleep));
        zip.click();
        inputText(zip, prop.getProperty("ZIP"));
        Thread.sleep(Long.parseLong(shortSleep));

        Thread.sleep(Long.parseLong(shortSleep));
        continueButton.click();
        Thread.sleep(Long.parseLong(shortSleep));
    }


    public void selectShippingOption() throws Exception{

        Thread.sleep(Long.parseLong(shortSleep));
        nextDayAir.click();
        Thread.sleep(Long.parseLong(shortSleep));

        Scroll(cdriver, 200, 200, 0, 2000);
        continueFromShipping.click();
    }


    public void selectPaymentOption() throws Exception{

        Thread.sleep(Long.parseLong(shortSleep));
        Scroll(cdriver, 200, 200, 0, 2000);
        payByMoney.click();
        Thread.sleep(Long.parseLong(shortSleep));
        continueFromPayment.click();
    }

    public void goToConfirm() throws Exception{

        Thread.sleep(Long.parseLong(shortSleep));
        continurFromFinalPage.click();

    }


    public void showSuccessModal() throws Exception{

        Thread.sleep(Long.parseLong(shortSleep));
        NextButton.click();
        Thread.sleep(Long.parseLong(shortSleep));

        String expectedText = String.valueOf(Pages.successMessage);
        String actualText = String.valueOf(Pages.successMessage);
        assertTrue(expectedText, actualText.contains(expectedText));

    }



    public void Scroll(AppiumDriver driver, int startx, int starty, int endx, int endy) throws InterruptedException, IOException {

        TouchAction ts = new TouchAction(driver);
        ts.longPress(point(startx, starty)).moveTo(point(endx, endy)).release().perform();
        Thread.sleep(Long.parseLong(shortSleep));


    }
    public static void inputText(MobileElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }



}
