package Presenter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class Pages {

    //AppiumDriver driver;
    AppiumDriver driver;
    //Constructor
    @FindBy(id="com.nopstation.nopcommerce.nopstationcart:id/btnAccept")
    public static MobileElement readAndAccept;

    @FindBy(id="com.nopstation.nopcommerce.nopstationcart:id/counterIcon")
    public static MobileElement cartIcon;

    @FindBy(id="com.nopstation.nopcommerce.nopstationcart:id/btnGuestCheckout")
    public static MobileElement guestButton;

    @FindBy(id="com.nopstation.nopcommerce.nopstationcart:id/etEmail")
    public static MobileElement email;
    @FindBy(id="com.nopstation.nopcommerce.nopstationcart:id/countrySpinner")
    public static MobileElement countrySpinner;

    @FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]")
    public static MobileElement countrySpinnerSelection;
    @FindBy(id="com.nopstation.nopcommerce.nopstationcart:id/stateSpinner")
    public static MobileElement stateSpinner;

    @FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]")
    public static MobileElement stateSpinnerSelection;

    @FindBy(id="com.nopstation.nopcommerce.nopstationcart:id/etCompanyName")
    public static MobileElement Company;

    @FindBy(id="com.nopstation.nopcommerce.nopstationcart:id/etCity")
    public static MobileElement city;

    @FindBy(id="com.nopstation.nopcommerce.nopstationcart:id/etStreetAddress")
    public static MobileElement streetAddress;

    @FindBy(id="com.nopstation.nopcommerce.nopstationcart:id/etZipCode")
    public static MobileElement zip;

    @FindBy(id="com.nopstation.nopcommerce.nopstationcart:id/btnContinue")
    public static MobileElement continueButton;

    @FindBy(id="com.nopstation.nopcommerce.nopstationcart:id/etFirstName")
    public static MobileElement firstName;

    @FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout[2]/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button")
    public static MobileElement continueFromShipping;

    @FindBy(id="com.nopstation.nopcommerce.nopstationcart:id/etLastName")
    public static MobileElement lastName;

    @FindBy(id="com.nopstation.nopcommerce.nopstationcart:id/btnContinue")
    public static MobileElement continurFromFinalPage;

    @FindBy(id="com.nopstation.nopcommerce.nopstationcart:id/md_text_message")
    public static MobileElement successMessage;

    @FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.widget.Button")
    public static MobileElement NextButton;

    @FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout[2]/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button")
    public static MobileElement continueFromPayment;

    @FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout[2]/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/com.bs.ecommerce.customViews.RadioGridGroupforReyMaterial/android.widget.RelativeLayout[4]/android.widget.LinearLayout/android.widget.TextView[1]")
    public static MobileElement payByMoney;

    @FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout[2]/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/com.bs.ecommerce.customViews.RadioGridGroupforReyMaterial/android.widget.RelativeLayout[4]/android.widget.TextView[1]")
    public static MobileElement nextDayAir;



    @FindBy(id="com.nopstation.nopcommerce.nopstationcart:id/btnCheckOut")
    public static MobileElement Cartcheckout;


    @FindBy(xpath="(//android.widget.ImageView[@content-desc=\"Placeholder\"])[4]")
    public static MobileElement electronics;
    @FindBy(xpath="(//android.widget.ImageButton[@content-desc=\"Placeholder\"])[3]")
    public static MobileElement quantityButton;
}
