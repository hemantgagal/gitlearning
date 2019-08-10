package com.evs.vtiger.framework.testcases.marketing;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Exception.FilloException;

import com.evs.vtiger.framework.pages.home.myhome.MyHomePage;
import com.evs.vtiger.framework.pages.login.login.LoginPage;
import com.evs.vtiger.framework.util.TestDataUtil;
import com.evs.vtiger.framework.util.WebUtil;

public class Leads_Cases {
    
	public void navigation(String brName, String url) throws IOException{
		 WebUtil.openApp(brName, url);
			LoginPage.validLogin();
			
			WebUtil.Validate.validateText("User_Login_Login_BT", "V_HomePageHeader");
			MyHomePage.navigateToMarketingLeadPage();
	}
	
	@Parameters({"Browser", "url"})
	@Test
	public  void tc_ValidateCreateLead(String b, String u) throws IOException, FilloException{
		List<Integer> liData=TestDataUtil.getAllMatchedRowNumberList("TC002");
		for(int i=0; i<=liData.size()-1; i++){
		    TestDataUtil.getTestCaseData_poi(liData.get(i));
		    navigation(b, u);
			
		}
		
		
		
	}
    
	@Test
	public  void tc_Create_EditLead() throws FilloException, IOException{
		List<Integer> liData=TestDataUtil.getAllMatchedRowNumberList("TC002");
		for(int i=0; i<=liData.size()-1; i++){
		    TestDataUtil.getTestCaseData_poi(liData.get(i));
	         
		    
		    
		}
		
	}
	
}
