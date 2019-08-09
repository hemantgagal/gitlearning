package com.evs.vtiger.framework.util;

public class Web {
	
   private static WebUtil webObj;
   private static JSUtil JSObj;
   private static ActionsUtil ActionsObj;
   
	public static WebUtil WebDriverWay(){
		if(webObj==null){
			webObj=new WebUtil();
		}
		return webObj;
	}
    public static JSUtil JSWay(){
    	if(JSObj==null){
    		JSObj=new JSUtil();
		}
		return JSObj;
	}
    
    public static ActionsUtil actionsWay(){
       	if(ActionsObj==null){
       		ActionsObj=new ActionsUtil();
		}
		return ActionsObj;
	}
}
