package appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.logging.Level;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class primaSignUpAndroid {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Untitled";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();
    
    @Before
    public void setUp() throws MalformedURLException, InterruptedException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.NO_RESET, true);
        dc.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "cz.iprima.app");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "cz.pixelmate.prima.ui.activity.MainActivity");
        driver = new AndroidDriver<>(new URL("http://localhost:4724/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
           
    }

    @Test
    public void primaSingUp() throws InterruptedException {
    	
    	Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@text='Další']")).click();
        driver.findElement(By.xpath("//*[@text='Další']")).click();
        driver.findElement(By.xpath("//*[@text='Další']")).click();
        
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@text='Vytvořit účet']")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Souhlasit a zavřít: Souhlasit s naším zpracováním údajů a zavřít']")));
        driver.findElement(By.xpath("//*[@text='Souhlasit a zavřít: Souhlasit s naším zpracováním údajů a zavřít']")).click();
        driver.findElement(By.xpath("//*[@text='Pan']")).click();
        
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@text='Jméno a přijmení']")).click();
        Thread.sleep(1000);
        driver.getKeyboard().sendKeys("Janko Hrasko");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@text='Rok narození']")).click();
        Thread.sleep(2000);
        driver.getKeyboard().sendKeys("1989");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@text='Psč']")).click();
        driver.getKeyboard().sendKeys("14000");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@text='Email']")).click();
        driver.getKeyboard().sendKeys("marianjavorsky@zoznam.sk");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@text='Heslo']")).click();
        driver.getKeyboard().sendKeys("Marian1989");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@text='Heslo znovu']")).click();
        driver.getKeyboard().sendKeys("Marian1989");
        Thread.sleep(3000);
        
        // scroll metod //
        
        Dimension dimension = driver.manage().window().getSize();
        int start_x = (int) (dimension.width * 0.5);
        int start_y = (int) (dimension.height * 0.8);
        
        int end_x = (int) (dimension.width * 0.2);
        int end_y = (int) (dimension.height * 0.2);
        
        TouchAction ts = new TouchAction(driver);
        ts.press(PointOption.point(start_x, start_y))
              .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
              .moveTo(PointOption.point(end_x, end_y)).release().perform();
        
        ////////////////////////////////////////////////////////////////////////
        
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@text='Vzdělání']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@text='Vyšší odborné']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@text='Profesní postavení']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@text='Podnikatel']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@resource-id='lbl-agreement-newsletter-checkbox']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@resource-id='lbl-agreement-checkbox']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@text='Další']")).click();
        
        
        System.out.println("TEST COMPLETE");    
  
      
    }
}