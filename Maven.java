package org.maven.com;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Maven {
	  static WebDriver driver;
	  static Select s;
	  static Actions ac;
	  static  Robot r;
	  static Alert a;
	public static void selectlocationtext(WebElement element,String value) 
	{
		s=new Select(element);
		s.selectByVisibleText(value);
    }
	
	public static void scrolldownpage(WebDriver driver2 )
	{
		JavascriptExecutor mn=(JavascriptExecutor)driver;
		mn.executeScript("argument[0].scrollintoview(true)", driver2);
	}
	public static  void ScrollupPage(WebElement element)
	{
		JavascriptExecutor mn=(JavascriptExecutor)driver;
		mn.executeScript("argument[0].scrollintoview(true)", element);
    }
	public static void movetoelement(WebElement element)
	{
		ac.moveToElement(element).perform();
		
	}
	public static void dragandDrop(WebElement source,WebElement des)
	{
		ac.dragAndDrop(source, des).perform();;
		
	}
	public static void doubleclick(WebElement element)
	{ 
		ac=new Actions(driver);
		ac.doubleClick().perform();
	}
	public static void contextclick(WebElement element)
	{
		ac=new Actions(driver);
		ac.contextClick().perform();
		
	}
	public static void clickonHold(WebElement element)
	{
		ac=new Actions(driver);
	    ac.clickAndHold().perform();
	}
	
    public static void launchbrowserchrome(String browser)
    {
    	
       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
    }
    public static void launchbrowserid()
    {
    	WebDriverManager.firefoxdriver().setup();
    	driver=new FirefoxDriver();
    }
    public static void edgeBrowser() 
    {
    	WebDriverManager.firefoxdriver().setup();
    	driver=new EdgeDriver();
    }
    public static void robote(int value) throws AWTException
    {
    	r=new Robot();
    	r.keyPress(value);
    	r.keyRelease(value);
  			
    }
    public static  void actionsendkey(CharSequence[] keys)
    {
    	ac=new Actions(driver);
        ac.sendKeys(keys);
    	
    }
    public static void screenshot(String filepath) throws IOException
    {
    	TakesScreenshot m=((TakesScreenshot)driver);
    	File source = m.getScreenshotAs(OutputType.FILE);
    	File des=new File(filepath);
    	FileUtils.copyFile(source, des);
    	
    }
        
   public static  void mamizewindow()
   {
	  driver.manage().window().maximize();
   }
    public static void currenturl()
    {
    	driver.getCurrentUrl();
    }
    public static void pagesource()
    {
    	driver.getPageSource();
    }
    public static void loadurl(String url)
    {
    	driver.get(url);
    }
    public static void mimimize()
    {
    	driver.manage().window().maximize();
    }
    public static void simplealert()
    {
    	a=driver.switchTo().alert();
    	a.accept(); 	
    }
    public static void confirmalert()
    {
    	a=driver.switchTo().alert();
    	a.dismiss(); 	
    }
    public static void promptalert(String value)
    {
    	a=driver.switchTo().alert();
    	a.sendKeys(value);	
    }
    public static String getattribute(WebElement element)
    {
    	String m = element.getAttribute("Value");
    	System.out.println(m);
    	return m;
    }
    public static String gettitle(String title)
    {
    	return driver.getTitle();
    	
    }
    public static void navigation(String url) 
    {
     driver.navigate().to(url);
    }
   public static void forward()
   {
	   driver.navigate().forward();
   }
    	
   public static void backward()
   {
	   driver.navigate().back();
	   
   }
   public static void refresh()
   {
	driver.navigate().refresh();   
   }
}

