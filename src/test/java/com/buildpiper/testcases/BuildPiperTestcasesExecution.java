package com.buildpiper.testcases;

import java.util.ArrayList;

import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.buildpiper.base.BaseTest;
import com.buildpiper.listeners.RetryCountIfFailed;
import com.buildpiper.pages.BuildPipeLinePage;
import com.buildpiper.pages.LoginPage;
import com.buildpiper.pages.ServiceCreationPage;
import com.buildpiper.utils.Configuration;
import com.buildpiper.utils.FrameworkConfig;
import com.buildpiper.utils.XlsReadData;

/**
 * @author: SagarT
 * @reviewer: @
 * 
 *
 */

@Listeners(com.buildpiper.report.ExtentReportListener.class)

public class BuildPiperTestcasesExecution extends BaseTest {
	
	FrameworkConfig config = ConfigFactory.create(FrameworkConfig.class);


    XlsReadData reader = new XlsReadData(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\BuildPiperTestData.xlsx");
	
	@Test(groups = { "Regression" },priority = 0)
	@RetryCountIfFailed(2)
	public void BuildPipeLine() {
		
		new LoginPage().login(reader.getCellData("UserData", "username", 2), reader.getCellData("UserData", "password", 2));
		new ServiceCreationPage().accountPreRequisites();
		new BuildPipeLinePage().buildAndValidateConsolePage(reader.getCellData("Pipeline", "applicationName", 2),reader.getCellData("Pipeline", "existingPipeline", 2));

	}
	
	@Test(groups = { "Regression" },priority = 0)
	@RetryCountIfFailed(2)
	public void managePopupTest() {
		
		new LoginPage().login(config.username(), config.password());		
		new BuildPipeLinePage().managePopupTest(reader.getCellData("Pipeline", "applicationName", 2),reader.getCellData("Pipeline", "existingPipeline", 2));

	}
	
	@Test(groups = { "Regression" },priority = 1)
	@RetryCountIfFailed(2)	
	public void CreateBasicPipeLine() {
		
		
		
		ArrayList<String> userRoleList = new ArrayList<String>();
		userRoleList.add("DEV");
		userRoleList.add("QA");
		userRoleList.add("DEVOPS");
		
		new LoginPage().login(reader.getCellData("UserData", "username", 2), reader.getCellData("UserData", "password", 2));
		new ServiceCreationPage().accountPreRequisites();
		new BuildPipeLinePage().createBasicPipeline(reader.getCellData("Pipeline", "applicationName", 2),reader.getCellData("Pipeline", "versionType", 2),reader.getCellData("Pipeline", "retentionCount", 2),reader.getCellData("Pipeline", "triggerType", 2),userRoleList,reader.getCellData("Pipeline", "jobType", 2),reader.getCellData("Pipeline", "fromEnv", 2),reader.getCellData("Pipeline", "jobType2", 2),reader.getCellData("Pipeline", "toEnv", 2),reader.getCellData("Pipeline", "ArtifactName", 2),reader.getCellData("Pipeline", "jobType3", 2),reader.getCellData("Pipeline", "ArtifactName2", 2),reader.getCellData("Pipeline", "prodEnv", 2));
		//new BuildPipeLinePage().executeBasicPipeline();
		
	}
	
	@Test(groups = { "Regression" },priority = 2)
	@RetryCountIfFailed(2)	
	public void CreateJiraPipeLine() {
		
		ArrayList<String> userRoleList = new ArrayList<String>();
		userRoleList.add("DEV");
		userRoleList.add("QA");
		userRoleList.add("DEVOPS");
		
		new LoginPage().login(reader.getCellData("UserData", "username", 2), reader.getCellData("UserData", "password", 2));
		new ServiceCreationPage().accountPreRequisites();
		new BuildPipeLinePage().createJiraPipeline(reader.getCellData("Pipeline", "applicationName", 2),reader.getCellData("Pipeline", "versionType", 2),reader.getCellData("Pipeline", "retentionCount", 2),reader.getCellData("Pipeline", "triggerType", 2),userRoleList);

	}

//	@Test(groups = { "Regression" },priority = 3)
//	@RetryCountIfFailed(2)	
//	public void runBasicPipeLine() {
//		
//		new LoginPage().login(reader.getCellData("UserData", "username", 2), reader.getCellData("UserData", "password", 2));
//		new BuildPipeLinePage().executeBasicPipeline(reader.getCellData("Pipeline", "applicationName", 2),reader.getCellData("Pipeline", "existingPipeline", 2));
//		
//	}
	
	@Test(groups = { "Regression" },priority = 4)
	@RetryCountIfFailed(2)	
	public void CreateBasicPipeLineNegative1() {
		
		
		
		ArrayList<String> userRoleList = new ArrayList<String>();
		userRoleList.add("DEV");
		userRoleList.add("QA");
		userRoleList.add("DEVOPS");
		
		new LoginPage().login(reader.getCellData("UserData", "username", 2), reader.getCellData("UserData", "password", 2));
		new BuildPipeLinePage().createBasicPipelineNegativeTest4(reader.getCellData("Pipeline", "applicationName", 3),reader.getCellData("Pipeline", "versionType", 3),reader.getCellData("Pipeline", "retentionCount", 3),reader.getCellData("Pipeline", "triggerType", 3),userRoleList,reader.getCellData("Pipeline", "existingPipeline", 3));
		//new BuildPipeLinePage().executeBasicPipeline();
		
	}
	
	@Test(groups = { "Regression" },priority = 5)
	@RetryCountIfFailed(2)	
	public void CreateBasicPipeLineNegative2() {
		
		
		
		ArrayList<String> userRoleList = new ArrayList<String>();
		userRoleList.add("DEV");
		userRoleList.add("QA");
		userRoleList.add("DEVOPS");
		
		new LoginPage().login(reader.getCellData("UserData", "username", 2), reader.getCellData("UserData", "password", 2));
		new BuildPipeLinePage().createBasicPipelineNegativeTest5(reader.getCellData("Pipeline", "applicationName", 4),reader.getCellData("Pipeline", "versionType", 4),reader.getCellData("Pipeline", "retentionCount", 4),reader.getCellData("Pipeline", "triggerType", 4),userRoleList);
		//new BuildPipeLinePage().executeBasicPipeline();
		
	}
	
}
