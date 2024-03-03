import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import org.openqa.selenium.remote.DesiredCapabilities;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.offset.PointOption.point;

public class AppiumSetup {

StartWith.Processing processing = new StartWith.Processing();
    private AppiumDriverLocalService service;
    public static String parentWindow;
    public static AppiumDriver adriver;
    public static AppiumDriver idriver;
    public static AppiumDriver mdriver;

    public String deviceID;
    public String deviceName;
    public String PlatformVersion;
    public String appPackage;
    public String appActivity;
    public String Zip;

    public String shortSleep;

    public String midSleep;

    public String deepSleep;
    public String email;
    public static int port;

    public String NormalText;
    public String udid;
    public String platformName;


    //Properties prop = processing.readPropertiesFile("TestData.properties");

    public AppiumSetup() throws Exception {
        variableInitialization();
        //variableInitialization1();
        port=findAvailablePort();

    }


    public void variableInitialization() throws IOException {
        Properties prop = processing.readPropertiesFile("TestData.properties");
        deviceName=System.getProperty("deviceName",prop.getProperty("deviceName"));
        appActivity=System.getProperty("deviceName",prop.getProperty("appActivity"));
        appPackage=System.getProperty("deviceName",prop.getProperty("appPackage"));
        udid=System.getProperty("deviceName",prop.getProperty("udid"));
        platformName=System.getProperty("deviceName",prop.getProperty("platformName"));
        shortSleep = prop.getProperty("shortSleep");
        midSleep = prop.getProperty("midSleep");
        deepSleep = prop.getProperty("deepSleep");
        email = prop.getProperty("emailtext");
        NormalText = prop.getProperty("default");
        Zip = prop.getProperty("Zip");
    }


    public void AppiumServerStart(int port)
    {
        AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder()
                .usingPort(port)
                .withArgument(() -> "--log-level", "info");
        service = AppiumDriverLocalService.buildService(appiumServiceBuilder);
        service.start();
        System.out.println("\n\n\nStarted Appium Server at : " + port);
    }

    public void getDeviceList() throws IOException, InterruptedException {
        String commandString1 = String.format("%s", "adb devices");
        Process process = Runtime.getRuntime().exec(commandString1);
        process.waitFor(3, TimeUnit.SECONDS);
        //Thread.sleep(3000);
        String udid = getOutputFromCommand(process);
    }

    public void ExecuteCommand(String command) throws IOException {
        Process P;
        P=Runtime.getRuntime().exec(command, null, null);
        try {
            P.waitFor();
            //Thread.sleep(10000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String result = getOutputFromCommand(P);
        System.out.println("Output: "+result);
    }
    public String getOutputFromCommand(Process process) throws IOException {
        String output2 = "";
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "";
        while ((line = reader.readLine()) != null) {
            output2 = output2.concat(line);
        }
        return output2;
    }

    public int findAvailablePort() throws IOException {
        int retries = 10;
        while (retries > 0) {
            try (ServerSocket socket = new ServerSocket(0)) {
                return socket.getLocalPort();
            } catch (IOException e) {
                retries--;
            }
        }
        throw new IOException("Could not find available port after 10 attempts");
    }

    public void getDeviceCapabilities() throws IOException {
        if(deviceName.equals("GalaxyM31.properties"))
        {
            Properties prop = processing.readPropertiesFile("DeviceProperties/"+deviceName);
            deviceID = prop.getProperty("udid");
            deviceName = prop.getProperty("deviceName");
            PlatformVersion = prop.getProperty("platformName");
            appActivity = prop.getProperty("appActivity");
            appPackage = prop.getProperty("appPackage");
        }

    }
    public void androidAppLauncher() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        getDeviceCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.UDID, deviceID);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PlatformVersion);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
        capabilities.setCapability("appium:skipUnlock", true);
        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability("autoDismissAlerts", true);
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("enableMultiWindows", true);
        capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, findAvailablePort());
        capabilities.setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES, false);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        //capabilities.setCapability("appium:app", prop.getProperty("appPath"));
        adriver = new AppiumDriver(new URL("http://0.0.0.0:"+port+"/wd/hub"), capabilities);
        Thread.sleep(Long.parseLong(midSleep));
    }

    public void Scroll(AppiumDriver driver, int sx, int sy, int mx, int my) throws InterruptedException {

        TouchAction ts = new TouchAction(driver);
        ts.longPress(point(sx, sy)).moveTo(point(mx, my)).release().perform();
        Thread.sleep(Long.parseLong(shortSleep));

    }


}
