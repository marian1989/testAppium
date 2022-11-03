package appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class primaLoginIOS{
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Untitled";
    protected IOSDriver<IOSElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();
    
    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "16.1");
        dc.setCapability(MobileCapabilityType.UDID, "Iphone 14");
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "cz.iprima.app");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "cz.pixelmate.prima.ui.activity.MainActivity");
        dc.setCapability(MobileCapabilityType.NO_RESET, true);
        driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testUntitled() {
    }

}