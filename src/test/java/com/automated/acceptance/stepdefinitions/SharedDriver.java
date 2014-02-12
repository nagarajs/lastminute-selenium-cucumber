package com.automated.acceptance.stepdefinitions;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import cucumber.annotation.Before;

/**
 * <p>
 * Example of a WebDriver implementation that has delegates all methods to a static instance (REAL_DRIVER) that is only 
 * created once for the duration of the JVM. The REAL_DRIVER is automatically closed when the JVM exits. This makes 
 * scenarios a lot faster since opening and closing a browser for each scenario is pretty slow.
 * To prevent browser state from leaking between scenarios, cookies are automatically deleted before every scenario.
 * </p>
 * <p>
 * A new instance of SharedDriver is created for each Scenario and passed to yor Stepdef classes via Dependency Injection
 * </p>
 * <p>
 * As a bonus, screenshots are embedded into the report for each scenario. (This only works
 * if you're also using the HTML formatter).
 * </p>
 * <p>
 * A new instance of the SharedDriver is created for each Scenario and then passed to the Step Definition classes'
 * constructor. They all receive a reference to the same instance. However, the REAL_DRIVER is the same instance throughout
 * the life of the JVM.
 * </p>
 */
public class SharedDriver extends EventFiringWebDriver {
    private static final WebDriver REAL_DRIVER = createWebBrowser();
    //private static final WebDriver REAL_DRIVER = new FirefoxDriver();
    private static final Thread CLOSE_THREAD = new Thread() {
        @Override
        public void run() {
            REAL_DRIVER.close();
        }
    };

    static {
        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
    }

    public SharedDriver() {
        super(REAL_DRIVER);
    }

    @Override
    public void close() {
        if(Thread.currentThread() != CLOSE_THREAD) {
            throw new UnsupportedOperationException("You shouldn't close this WebDriver. It's shared and will close when the JVM exits.");
        }
        super.close();
    }
    
    private static WebDriver createWebBrowser(){
  

        String serverHub = System.getProperty("test.hubUrl");
        String testBrowser = System.getProperty("test.browserName");
        String testBrowserVersion = System.getProperty("test.browserVersion");
        String platform = System.getProperty("test.platform");
        String baseUrl = System.getProperty("test.baseUrl");
        String path = System.getProperty("test.path");
        String environment = System.getProperty("test.environment");
        
        System.out.println("creating WebDriver with the following properties: " + "\n" +
                "test.hubUrl=" + serverHub + "\n" +
                "test.browserName" + testBrowser + "\n" +
                "test.browserVersion=" + testBrowserVersion + "\n" +
                "test.platform=" + platform + "\n" +
                "test.baseUrl=" + baseUrl + "\n" +
                "test.path=" + path + "\n" +
                "test.environment=" + environment);

    	
    	DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName(testBrowser);
		if("windows".equalsIgnoreCase(platform)){
			capability.setPlatform(Platform.WINDOWS);
		} else {
			capability.setPlatform(Platform.MAC);
		}
		
		capability.setVersion(testBrowserVersion);
		
	
		
		WebDriver driver;
        if ("local".equals(System.getProperty("test.environment"))) {
            driver = new FirefoxDriver();
        } else {
            driver = createRemoteWebDriver(serverHub, capability);
        }

        return driver;
    }
    

    private static WebDriver createRemoteWebDriver(String serverHub, DesiredCapabilities capability) {
        try {
            return new RemoteWebDriver(new URL(serverHub), capability);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }


    @Before
    public void deleteAllCookies() {
        manage().deleteAllCookies();
    } 
}
