package com.seleniumtest;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Test;
import junit.framework.*;

public class EuMonitoringPublishCheckTest extends TestCase{
	
	private WebDriver driver = new FirefoxDriver();
	private String baseurl = "http://172.30.0.90:8080/alfresco/faces/jsp/login.jsp";
	
	@Override
	public void setUp() throws Exception {
  	  driver.get(baseurl);
	}
	
    @Test
    public void testPublish_and_Check() throws Exception {
    	
    	try {	
    	///////// BACK-END ARTICLE PUBLISHING  \\\\\\\\\\\\\
        driver.findElement(By.id("loginForm:user-name")).sendKeys("admin");
        driver.findElement(By.name("loginForm:user-password")).sendKeys("admin");
        driver.findElement(By.name("loginForm:submit")).click();
        
        driver.findElement(By.xpath("(//table[@class='recordSet']/tbody/tr[1]/td[1]/a[2])[1]")).click();
        String title = driver.findElement(By.name("dialog:dialog-body:task-props:prop_dodseuingestionwfx003a_newTitle:dodseuingestionwfx003a_newTitle")).getValue();
        System.out.println(title + " published");
        
        driver.findElement(By.name("dialog:transition_Emailx0020_andx0020_Publishx0020_document")).click();
    
        ///////// FRONT-END ARTICLE PUBLISHING CHECK  \\\\\\\\\\\\\
        driver.get("http://uat.dodsmonitoring.eu.parlicom.local");
        driver.findElement(By.linkText("Archive")).click();
        
        driver.findElement(By.name("email")).sendKeys("lorenzo.urbini@edgeint.net");
        driver.findElement(By.name("password")).sendKeys("lugano83");
        driver.findElement(By.name("confirm")).click();
        
        assertTrue(assertLinkPresent(driver, title));

        }catch(Exception e) {}
    }
	
	@Override
    public void tearDown() throws Exception {
   	  driver.quit(); 
    }
	
	public static boolean assertLinkPresent(WebDriver driver, String text) {
	    try {
	        driver.findElement(By.linkText(text));        
	    } catch (NoSuchElementException ex) { 
	    	return false;
	    }
	    return true;
	}
    
}

