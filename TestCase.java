package com.evs.vtiger.framework.util;

import com.evs.vtiger.framework.pages.login.login.LoginPage;
import com.evs.vtiger.framework.pages.marketing.contacts.ContactLanding_Page;

public class TestCase {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebUtil umObj=WebUtil.getUtilObject();
		umObj.openApp("FF", "http://gmail.com");;
		umObj.input("//input[@name='']##XP", "");
		
	
		new LoginPage().validLogin();
		new ContactLanding_Page().openCreateContact();
		new
		
		
	}
 
}
