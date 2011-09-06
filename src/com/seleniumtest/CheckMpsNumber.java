package com.seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Test;
import junit.framework.*;

public class CheckMpsNumber extends TestCase{
	
	private WebDriver driver = new FirefoxDriver();
	private String baseUrl = "http://www.dodspeople.com/";

	@Override
	public void setUp() throws Exception {
  	  driver.get(baseUrl);
	}
	
	@Override
    public void tearDown() throws Exception {
   	  driver.quit(); 
    }
	
	@Test
    public void testMPnumber() throws Exception {
		//go to the MP list
    	driver.get("http://www.dodspeople.com/Page.aspx?pageid=52&BC=pageid");
    	
    	//checking pagination numbers
    	assertEquals(driver.findElement(By.xpath("//div[@id='divAlphabeticalPaging']/p/span[1]/div/a")).getText(),"A (17)");
    	
    	/*assertTrue(selenium.isTextPresent("B (76)"));
    	assertTrue(selenium.isTextPresent("C (46)"));
    	assertTrue(selenium.isTextPresent("D (37)"));
    	assertTrue(selenium.isTextPresent("E (18)"));
    	assertTrue(selenium.isTextPresent("F (20)"));
    	assertTrue(selenium.isTextPresent("G (36)"));
    	assertTrue(selenium.isTextPresent("H (60)"));
		assertTrue(selenium.isTextPresent("I (1)"));
		assertTrue(selenium.isTextPresent("J (21)"));
		assertTrue(selenium.isTextPresent("K (11)"));
		assertTrue(selenium.isTextPresent("L (36)"));
		assertTrue(selenium.isTextPresent("M (71)"));
		assertTrue(selenium.isTextPresent("N (8)"));
		assertTrue(selenium.isTextPresent("O (10)"));
		assertTrue(selenium.isTextPresent("P (22)"));
		assertTrue(selenium.isTextPresent("Q (1)"));
		assertTrue(selenium.isTextPresent("R (32)"));
		assertTrue(selenium.isTextPresent("S (56)"));
		assertTrue(selenium.isTextPresent("T (17)"));
		assertTrue(selenium.isTextPresent("U (2)"));
		assertTrue(selenium.isTextPresent("V (6)"));
		assertTrue(selenium.isTextPresent("W (43)"));
		assertTrue(selenium.isTextPresent("Y (2)"));
		assertTrue(selenium.isTextPresent("Z (1)"));*/
    	
    	//Printing the total MP's counter number
    	System.out.println(driver.findElement(By.xpath("//div[@class='rightBox2Content']/span")).getText());
    }	
}

