package com.evs.vtiger.framework.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

 class JSUtil {
       private JavascriptExecutor JS;
	 public void jsClick(String locator){
		 if(JS==null){
			 JS=(JavascriptExecutor) WebUtil.getUtilObject().getDriver(); 
		 }
		 WebElement we=WebUtil.getUtilObject().getWebElement(locator);
		JS.executeScript("arguments[0].click()", we);
	 }
	 
	public void jsInput (String locator, String valueInput){
		if(JS==null){
			 JS=(JavascriptExecutor) WebUtil.getUtilObject().getDriver(); 
		 }
		 WebElement we=WebUtil.getUtilObject().getWebElement(locator);
		JS.executeScript("arguments[0].setAttribute('value', '" + valueInput +"')", we);
	}
public void jsMouseOver(String locator){
	if(JS==null){
		 JS=(JavascriptExecutor) WebUtil.getUtilObject().getDriver(); 
	 }
	 WebElement we=WebUtil.getUtilObject().getWebElement(locator);
	 String jsScript="if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
	JS.executeScript(jsScript, we);
}

}
