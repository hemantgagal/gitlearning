package com.evs.vtiger.framework.util;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

 public class WebUtil {
	  private   WebDriver DRIVER;     /// static variable - sefault value null in case of object
	  private static JSUtil JSObj;
	   private static ActionsUtil ActionsObj;
	   private static WebUtil UtilObject;
	   public static WebUtil getUtilObject(){
		  if(UtilObject==null){
			  UtilObject=new WebUtil(); 
		  }
		  return UtilObject;
	   }
	   
     public WebDriver getDriver(){ 
    	return DRIVER; 
     }
	 public  JSUtil JSWay(){
	    	if(JSObj==null){
	    		JSObj=new JSUtil();
			}
			return JSObj;
		}
	    
	    public  ActionsUtil actionsWay(){
	       	if(ActionsObj==null){
	       		ActionsObj=new ActionsUtil();
			}
			return ActionsObj;
		}
	
	
	
	public void getSnapshot(String destFilePath) throws IOException{
		Object x="abcd";
		String y=(String) x;
		
		TakesScreenshot tss=(TakesScreenshot) DRIVER;
		File fileObj=tss.getScreenshotAs(OutputType.FILE);
		File destFile=new File(destFilePath);
		FileUtils.copyFile(fileObj, destFile);
	}
	
	public  void launchBrowser(String browserName){
	
			if(browserName.equalsIgnoreCase("FF")){
				DRIVER=new FirefoxDriver();
				//return driver;
			}else if(browserName.equalsIgnoreCase("CH")){
				System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
				DRIVER=new ChromeDriver();
			
				//return driver;
			}else if(browserName.equalsIgnoreCase("IE")){
				System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
				DRIVER=new InternetExplorerDriver();
				//return driver;
			}
			DRIVER.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			DRIVER.manage().window().maximize();
			
			
	}
	
	public void openURL(String url){
		DRIVER.get(url);
	}
	
	public void openApp(String browserName, String url){
		launchBrowser(browserName);
		openURL(url);
	}
	
	  public void input(String locator, String value){
		   WebElement weObj= getWebElement(locator);
		   if(checkWebElementforAction(weObj)==true){
			   weObj.sendKeys(value);
		   }
		}
	  public void click(String locator){
		   WebElement weObj= getWebElement(locator);
		   if(checkWebElementforAction(weObj)==true){
			   weObj.click();
		   }
		   
		}
	
	  public void selectByPartialText(String locator, String optionText){
		   WebElement weObj= getWebElement(locator);
		   if(checkWebElementforAction(weObj)==true){
			   Select selObj=new Select(weObj);
			   List<WebElement> liWE=selObj.getOptions();
			   for(int i=0; i<=liWE.size()-1;i++){
            	   WebElement we=liWE.get(i);
            	   String txt=we.getText();
            	   if(txt.toLowerCase().contains(optionText.toLowerCase())){
            		   selObj.selectByIndex(i);
            		  
            	   }
               }
			   
		   }
		   
		}
	  
	  public void uncheckCheckbox(String locator){
		  WebElement weObj= getWebElement(locator);
		  if(checkWebElementforAction(weObj)==true){
			 if( weObj.isSelected()==true){
				 weObj.click(); 
			 }
			   
		   }  
	  } 
	  public void checkCheckbox(String locator){
		  WebElement weObj= getWebElement(locator);
		  if(checkWebElementforAction(weObj)==true){
			 if( weObj.isSelected()==false){
				 weObj.click(); 
			 }
			   
		   }  
	  }
	  
	  
	  public void selectByText(String locator, String optionText){
		   WebElement weObj= getWebElement(locator);
		   if(checkWebElementforAction(weObj)==true){
			   Select selObj=new Select(weObj);
			   selObj.selectByVisibleText(optionText);
		   }
		   
		}
	  public void selectByIndex(String locator, int optionIndex){
		   WebElement weObj= getWebElement(locator);
		   if(checkWebElementforAction(weObj)==true){
			   Select selObj=new Select(weObj);
			   selObj.selectByIndex(optionIndex);
		   }
		   
		}
	  
	  public void selectByValue(String locator, String optionValue){
		   WebElement weObj= getWebElement(locator);
		   if(checkWebElementforAction(weObj)==true){
			   Select selObj=new Select(weObj);
			   selObj.selectByValue(optionValue);
		   }
		   
		}
	  
	  private boolean checkWebElementforAction(WebElement we){
		  if(we.isDisplayed()==true){
			  if(we.isEnabled()){
				  return true;
			  }else{
				  System.out.println("Item is not clickable");
			  }
		  }else{
			  System.out.println("Item is not visible");
		  }
		  return false;
	  }
	  
	public WebElement getWebElement(String locator){
		   String[] locArr=locator.split("##");
		   String locatorType=locArr[1];
		   String locatorValue=locArr[0];
		   WebElement we=null;
		   if(locatorType.equalsIgnoreCase("XP")){
			   we=DRIVER.findElement(By.xpath(locatorValue));
		   }else if(locatorType.equalsIgnoreCase("CSS")){
			   we=DRIVER.findElement(By.cssSelector(locatorValue));
		   }else if(locatorType.equalsIgnoreCase("CLS")){
			   we=DRIVER.findElement(By.className(locatorValue));
		   }else if(locatorType.equalsIgnoreCase("ID")){
			   we=DRIVER.findElement(By.id(locatorValue));
		   }else if(locatorType.equalsIgnoreCase("NM")){
			   we=DRIVER.findElement(By.name(locatorValue));
		   }else if(locatorType.equalsIgnoreCase("LK")){
			   we=DRIVER.findElement(By.linkText(locatorValue));
		   }else if(locatorType.equalsIgnoreCase("PLK")){
			   we=DRIVER.findElement(By.partialLinkText(locatorValue));
		   }else{
			   System.out.println(locatorType+" - Wrong locator type. Please check");
		   }
		   return we;
	}
	
	public  void setFocusByTitle(String expTitle){
	    Set<String> winHnadleSet=DRIVER.getWindowHandles();
		Iterator<String> winHnadleIT=winHnadleSet.iterator();
		while (winHnadleIT.hasNext()==true){
			String hndlvalue=winHnadleIT.next();
			System.out.println(hndlvalue);
			DRIVER.switchTo().window(hndlvalue);
			String title=DRIVER.getTitle();
			if(title.equalsIgnoreCase(expTitle)){
				break;
			}
		}
	}
	
	public  void setFocusByPartialTitle( String expTitle){
	    Set<String> winHnadleSet=DRIVER.getWindowHandles();
		Iterator<String> winHnadleIT=winHnadleSet.iterator();
		while (winHnadleIT.hasNext()==true){
			String hndlvalue=winHnadleIT.next();
			System.out.println(hndlvalue);
			DRIVER.switchTo().window(hndlvalue);
			String title=DRIVER.getTitle().toLowerCase();
			if(title.contains(expTitle.toLowerCase())){
				break;
			}
		}
	}
	
	
	public  void setFocusByURL( String expURL){
	    Set<String> winHnadleSet=DRIVER.getWindowHandles();
		Iterator<String> winHnadleIT=winHnadleSet.iterator();
		while (winHnadleIT.hasNext()==true){
			String hndlvalue=winHnadleIT.next();
			System.out.println(hndlvalue);
			DRIVER.switchTo().window(hndlvalue);
			String url=DRIVER.getCurrentUrl();
			if(url.equalsIgnoreCase(expURL)){
				break;
			}
		}
	}
	
	public  void setFocusByPartialURL( String expURL){
		expURL=expURL.toLowerCase();
		Set<String> winHnadleSet=DRIVER.getWindowHandles();
			Iterator<String> winHnadleIT=winHnadleSet.iterator();
			while (winHnadleIT.hasNext()==true){
				String hndlvalue=winHnadleIT.next();
				System.out.println(hndlvalue);
				DRIVER.switchTo().window(hndlvalue);
				String url=DRIVER.getCurrentUrl();
				if(url.equalsIgnoreCase(expURL)){
					break;
				}
			}
	}
	
	
}
