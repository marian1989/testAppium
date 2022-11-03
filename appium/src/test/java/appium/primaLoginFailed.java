package appium;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.logging.Level;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class primaLoginFailed {
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
    	
    	  //login test Android failed//
    	
    	  Thread.sleep(5000);
    	  
    	  driver.findElement(By.xpath("//*[@text='Další']")).click();
    	  Thread.sleep(1000);
          driver.findElement(By.xpath("//*[@text='Další']")).click();
          Thread.sleep(1000);
          driver.findElement(By.xpath("//*[@text='Další']")).click();
          Thread.sleep(2000);
          driver.findElement(By.xpath("//*[@text='Přihlásit se']")).click();
          
          Thread.sleep(1000);
          driver.findElement(By.xpath("//*[@text='Email']")).click();
          Thread.sleep(5000);
          
          driver.findElement(By.xpath("//*[@text='Email']")).sendKeys("marianjavorsky89@gmail.com");
          Thread.sleep(1000);
          
          driver.findElement(By.xpath("//*[@text='Heslo']")).click();
          Thread.sleep(1000);
          
          driver.findElement(By.xpath("//*[@text='Heslo']")).sendKeys("Marian847");
          Thread.sleep(1000);
          
          driver.findElement(By.xpath("//*[@text='Přihlásit se']")).click();
          Thread.sleep(10000);
          
          
          
          
      	    //Checking if failed login///////////////////
          
     		System.out.println("Checking Login>");    
     		
     		
     		try {
     			
     			  driver.findElement(By.xpath("//*[@text='Přihlásit se']"));;
     	          System.out.println("Login Failed");
     	         
     	     /////////Screenshot failed login ////////////
     	         
     	         File file= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
     	         SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
    	         Date date = new Date();
    	         String fileName = sdf.format(date);
     	         FileUtils.copyFile(file, new File(fileName+".png"));
     	          
     	        }
     		
     		catch (NoSuchElementException e) {
     	          System.out.println("Checking login> Test Done");
     	        }
     		
     		System.out.println("Login > Test > Failed");
     		
     	 } 
      }
    
   
   
       
    