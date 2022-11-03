package appium;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.logging.Level;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class primaLoginAndroid {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Untitled";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();
    
    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "cz.iprima.app");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "cz.pixelmate.prima.ui.activity.MainActivity");
        dc.setCapability(MobileCapabilityType.NO_RESET, true);
        driver = new AndroidDriver<>(new URL("http://localhost:4724/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void loginTestAndroid() throws InterruptedException, IOException {
    	
    	  //login test Android//
    	
    	  Thread.sleep(5000);
    	  
    	  driver.findElement(By.xpath("//*[@text='Další']")).click();
          driver.findElement(By.xpath("//*[@text='Další']")).click();
          driver.findElement(By.xpath("//*[@text='Další']")).click();
          driver.findElement(By.xpath("//*[@text='Přihlásit se']")).click();
          
          Thread.sleep(1000);
          driver.findElement(By.xpath("//*[@text='Email']")).click();
          
          Thread.sleep(5000);
          
          driver.findElement(By.xpath("//*[@text='Email']")).sendKeys("marianjavorsky25@gmail.com");
          Thread.sleep(1000);
          
          driver.findElement(By.xpath("//*[@text='Heslo']")).click();
          Thread.sleep(1000);
          
          driver.findElement(By.xpath("//*[@text='Heslo']")).sendKeys("Marian8476");
          Thread.sleep(1000);
          
          driver.findElement(By.xpath("//*[@text='Přihlásit se']")).click();
          
          
         Thread.sleep(5000);
         
         ///////Checking if failed login//////////
         
   		System.out.println("Checking Login>");    
   		
   		
   		try {
   			
   			  driver.findElement(By.xpath("//*[@text='Přihlásit se']"));
   	          System.out.println("Login Failed");
   	          
   	          
   	        }
   		 
   		catch (NoSuchElementException e) { 
   	          System.out.println("Checking login> Test Done");
   	          
   	        }
   		
   		  System.out.println("Login > Test > Failed");
   		
   	  } 	
    }

   
