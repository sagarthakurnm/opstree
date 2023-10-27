package com.buildpiper.pages;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.buildpiper.base.BasePage;
import com.buildpiper.utils.Configuration;
import com.buildpiper.utils.Pause;
import com.buildpiper.utils.RandomStrings;

import junit.framework.Assert;


/**
 * @author sagarT
 * @reviewer:
 *
 */
public class BuildPipeLinePage extends BasePage {

	String pipelineName = "BasicPipeline" + RandomStrings.generateRandomString(9);
	 
	
//	@FindBy(xpath = "//li//button[contains(@class,'main-nav-1')][contains(.,'perfeasy-app')]" )
//	WebElement poc_qaProjectLink;
	
	@FindBy(xpath = "//button//span[2][@class='flaticon-expand-arrow']/../..//li//span[contains(.,'Pipeline Overview')]" )
	WebElement pipelineOverviewLink;
	
	@FindBy(xpath = "//li//button[contains(@class,'main-nav-1')]//span[@title]")
	List<WebElement> poc_qaProjectLink;
	
	
	@FindBy(xpath = "//div[@class='service-name']//a[contains(.,'Build-pipeline')]" )
	WebElement PipelineSubject;
	
	@FindBy(xpath = "//span[@title='Run Pipeline']/button" )
	WebElement executePipeLineButton;
	
	@FindBy(xpath = "//a[@title='view logs']" )
	WebElement viewLogsLink;
	
	@FindBy(xpath = "//div[@class='md-step active md-step-log']//div[@class='md-step-circle success']/..//div[contains(.,'Post Hooks Executing')]" )
	WebElement postHookExecutingSuccessLink;
	
	@FindBy(xpath = "//button[contains(@class,'btn-link-green')][text()=' Switch to User Portal']")
	WebElement switchToUSer;
	
	@FindBy(xpath = "//button[@type='button' and @aria-controls='menu-appbar']//div//div")
	WebElement userMenuAppBar;
	
	@FindBy(xpath = "//div[@class='input-component']//input[@name='name' and @placeholder='Name']")
	WebElement searchPipeLine;
	
	@FindBy(xpath = "//button[@title='View Execution History']")
	WebElement pipeLineExecutionHistory;
	
	@FindBy(xpath = "//button[@title='Replay Pipeline']")
	WebElement reExecutePipeLineBtn;
	
	@FindBy(xpath = "//a[contains(@href,'/application/')][contains(@href,'/pipeline/')][contains(@href,'/execution/')]")
	WebElement existingPipeLine;

	/**
	 * 
	 */
	public BuildPipeLinePage() {

	}
	public BuildPipeLinePage buildAndValidateConsolePage(String appName, String existingPipelineName) {
//		ui_click(userMenuAppBar, "userMenuAppBar");		
//		ui_click(switchToUSer, "switching to user account");
		boolean projectSelection = false;
		ui_wait(5);
		ui_IsElementDisplay(ui_waitForElementToDisplay(poc_qaProjectLink.get(0), Pause.MEDIUM));
		for(WebElement element:poc_qaProjectLink) {
			if(element.getText().trim().equalsIgnoreCase(appName)) {
				element.click();
				projectSelection = true;
				break;
			}
		}
		if(projectSelection) {
		ui_click(pipelineOverviewLink, "Poc_QA pipelineOverviewLink");
//		ui_IsElementDisplay(ui_waitForElementToDisplay(PipelineSubject, Pause.MEDIUM));
		ui_IsElementDisplay(ui_waitForElementToDisplay(searchPipeLine, Pause.MEDIUM));
		ui_clearAndSetValue(searchPipeLine, existingPipelineName);
		searchPipeLine.sendKeys(Keys.ENTER);
		ui_click(pipeLineExecutionHistory, "view pipeline excution history");
		ui_IsElementDisplay(ui_waitForElementToDisplay(reExecutePipeLineBtn, Pause.MEDIUM));
		ui_click(reExecutePipeLineBtn, "view pipeline re-excution history");
//		ui_click(executePipeLineButton, "Poc_QA execution Start");
		ui_wait(5);
		ui_IsElementDisplay(ui_waitForElementToDisplay(existingPipeLine, Pause.MEDIUM));
		ui_click(existingPipeLine, "Poc_QA execution Start");
		
		ui_IsElementDisplay(ui_waitForElementToDisplay(viewLogsLink, Pause.MEDIUM));
		ui_click(viewLogsLink, "Poc_QA click on View Logs");
		ui_switchToNewWindow();
		ui_IsElementDisplay(ui_waitForElementToDisplay(postHookExecutingSuccessLink, Pause.MEDIUM));
		ui_click(postHookExecutingSuccessLink, "postHookExecuting click for Console Logs");
		ui_wait(10);
		List<String> consoleLogs = ui_getTextForElements("//div[@class='d-grid grid-temp-log-line']//span");
		boolean status = consoleLogs.get(0).length()>0;
		Reporter.log("Successful Validate the Console logs", status);
		}
		return this;
	}
	
	@FindBy(xpath = "//a[@class='btn btn-submit' and text()='Add Pipeline']")
	WebElement continueBtn;
	
	@FindBy(xpath = "//div//input[@name='name' and @placeholder='Give a name to the pipeline']")
	WebElement addNameToNewPipeline;
	
	@FindBy(xpath = "//select[@name='version' and @class='select']")
	WebElement selectPipelineVersionDropdown;
	
	@FindBy(xpath = "//input[@name='retention_execution_count' and @placeholder='Retention Count']")
	WebElement retentionCountField;
	
	@FindBy(xpath = "//label[@class='MuiFormControlLabel-root']/span[1]")
	List<WebElement> MUIRadioButtonsChecked;
	
	@FindBy(xpath = "//div[contains(@class,'MuiFormGroup')][@role='radiogroup']//input")
	List<WebElement> triggerTypeRadioBtn;
	
	@FindBy(xpath = "//div[@class='input-component']//input[@type='checkbox']")
	List<WebElement> pipelineAssignUserRoleCheckbox;
	
	@FindBy(xpath = "//button[contains(@class,'btn-save btn')][text()='Save']")
	WebElement savePipeline;
	@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1']")
	WebElement muiTypographyBody;
	
	
	@FindBy(xpath = "//p[@class='pipeline-name']")
	WebElement validatePipelineName;
	
	@FindBy(xpath = "//button//div[@class='text-btn'][text()='Add New Stage']")
	WebElement addNewStageToPipeline;
	
	@FindBy(xpath = "//input[@name='name' and @placeholder='Stage name goes here']")
	WebElement stageName;
	
	@FindBy(xpath = "//div[@class='btn btn-add'][text()='ADD']")
	WebElement addStageBtn;
	
	@FindBy(xpath = "//div[@class='text-btn'][text()='Add New Job ']")
	WebElement addNewJobBtn;
	
	@FindBy(xpath = "//div[contains(@data-rbd-draggable-id,'stage-qa')]//div[@class='text-btn'][text()='Add New Job ']")
	WebElement addNewJobBtnUnderSecondStage;
	
	@FindBy(xpath = "//div[contains(@data-rbd-draggable-id,'stage-prod')]//div[@class='text-btn'][text()='Add New Job ']")
	WebElement addNewJobBtnUnderThirdStage;
	
	@FindBy(xpath = "//select[@name='task_type' and @class='select']")
	WebElement selectJobType;
	
	@FindBy(xpath = "//select[@name='env' and @class='select']")
	WebElement selectFromEnv;
	
	@FindBy(xpath = "//span[text()='automation-682046mu117xjpt']")
	WebElement serviceComponent;
	
	@FindBy(xpath = "//span[text()='automation-682046mu117xjpt']")
	WebElement serviceComponent1;
	
	@FindBy(xpath = "//select[@name='artifact_source' and @class='select']")
	WebElement selectArtifact;
	
	@FindBy(xpath = "//select[@name='target_env' and @class='select']")
	WebElement targetEnv;
	
	@FindBy(xpath = "//button[contains(@class,'btn-save')]")
	WebElement saveWorkFlowBtn;
	
	public BuildPipeLinePage createBasicPipeline(String appName,String versionType,String retentionCount,String triggerType,ArrayList<String>pipelineUser,String jobType,String fromEnv,String jobType2,String toEnv,String ArtifactName,String jobType3,String ArtifactName2,String prodEnv) {
		
		String StageName1 = "dev" + RandomStrings.generateRandomString(7);
		String StageName2 = "qa" + RandomStrings.generateRandomString(7) + "fromdev";
		String StageName3 = "prod" + RandomStrings.generateRandomString(7) + "fromqa";
//		ui_IsElementDisplay(ui_waitForElementToDisplay(userMenuAppBar, Pause.MEDIUM));
//		ui_click(userMenuAppBar, "userMenuAppBar");		
//		ui_click(switchToUSer, "switching to user account");
		
		boolean projectSelection = false;
		ui_IsElementDisplay(ui_waitForElementToDisplay(poc_qaProjectLink.get(0), Pause.MEDIUM));
		for(WebElement element:poc_qaProjectLink) {
			if(element.getText().trim().equalsIgnoreCase(appName)) {
				element.click();
				projectSelection = true;
				break;
			}
		}
		if(projectSelection) {
		ui_click(pipelineOverviewLink, "Poc_QA pipelineOverviewLink");
		ui_click(continueBtn, "clicks on add pipeline button");
		ui_setvalue(addNameToNewPipeline, "Gives unique name to pipeline", pipelineName);
		Select dropdown = new Select(selectPipelineVersionDropdown);
		dropdown.selectByVisibleText(versionType);
		ui_clearAndSetValue(retentionCountField, retentionCount);
		
		
		
        for (int i = 0; i < triggerTypeRadioBtn.size(); i++) {
        	if (triggerType.contains(triggerTypeRadioBtn.get(i).getAttribute("value").trim()) && !(MUIRadioButtonsChecked.get(i).getAttribute("class").contains("Mui-checked"))) {
        		ui_click(triggerTypeRadioBtn.get(i),"Selecting the Radio button named as -"+triggerTypeRadioBtn.get(i).getAttribute("value").trim());
        		break;
        	}
        }
//		if (triggerTypeRadioBtn.getAttribute("value").equals("Manual"))
//			ui_click(triggerTypeRadioBtn, "Poc_QA triggerTypeRadioBtn");
        ui_wait(2);
        ui_MoveToElement(muiTypographyBody, "moving to muiTypographyBodyn");
       
        ui_wait(2);
        for (int i = 0; i < pipelineAssignUserRoleCheckbox.size(); i++) {
        	if (pipelineUser.contains(pipelineAssignUserRoleCheckbox.get(i).getAttribute("value").trim())) {
        		
        		ui_ActionMoveAndClick(pipelineAssignUserRoleCheckbox.get(i),"Clicking on radio Button-"+pipelineAssignUserRoleCheckbox.get(i));
        	}
        		//.click();        	}
        }
        ui_wait(2);
        ui_click(savePipeline, "clicks on save pipeline button");
		ui_IsElementDisplay(ui_waitForElementToDisplay(validatePipelineName, Pause.MEDIUM));
        String validatePipelineNameActual = validatePipelineName.getText().trim();
        Assert.assertEquals(validatePipelineNameActual, pipelineName);
		ui_IsElementDisplay(ui_waitForElementToDisplay(addNewStageToPipeline, Pause.MEDIUM));
        ui_click(addNewStageToPipeline, "adds first stage"); // adds first stage
		ui_IsElementDisplay(ui_waitForElementToDisplay(stageName, Pause.MEDIUM));
        ui_setvalue(stageName, "sets first stage name", StageName1);
        ui_click(addStageBtn, "adds button for first stage");
		ui_IsElementDisplay(ui_waitForElementToDisplay(addNewJobBtn, Pause.MEDIUM));
        ui_click(addNewJobBtn, "clicks on new job"); // adds build job to dev 
		ui_IsElementDisplay(ui_waitForElementToDisplay(selectJobType, Pause.MEDIUM));
		Select dropdown1 = new Select(selectJobType);
		dropdown1.selectByVisibleText(jobType);
		Select dropdown2 = new Select(selectFromEnv);
		dropdown2.selectByVisibleText(fromEnv);
		ui_IsElementDisplay(ui_waitForElementToDisplay(serviceComponent, Pause.MEDIUM));
		ui_click(serviceComponent, "selects service component under the env");
		ui_click(addStageBtn, "clicks add stage btn");
		ui_IsElementDisplay(ui_waitForElementToDisplay(addNewJobBtn, Pause.MEDIUM));
        ui_click(addNewJobBtn, "clicks on new job"); // adds deploy job to dev
		ui_IsElementDisplay(ui_waitForElementToDisplay(selectJobType, Pause.MEDIUM));
		Select dropdown3 = new Select(selectJobType);
		dropdown3.selectByVisibleText(jobType2);
		Select dropdown4 = new Select(selectFromEnv);
		dropdown4.selectByVisibleText(fromEnv);
		ui_IsElementDisplay(ui_waitForElementToDisplay(serviceComponent1, Pause.MEDIUM));
		ui_click(serviceComponent1, "selects service component under the env");
		Select dropdown5 = new Select(selectArtifact);
		dropdown5.selectByVisibleText(ArtifactName);
		ui_click(addStageBtn, "clicks add stage btn");
		ui_IsElementDisplay(ui_waitForElementToDisplay(addNewStageToPipeline, Pause.MEDIUM));
        ui_click(addNewStageToPipeline, "adds second stage"); // adds second stage
		ui_click(addStageBtn, "clicks add stage btn");
		ui_IsElementDisplay(ui_waitForElementToDisplay(stageName, Pause.MEDIUM));
        ui_setvalue(stageName, "sets first stage name", StageName2);
		ui_click(addStageBtn, "clicks add stage btn");
		ui_IsElementDisplay(ui_waitForElementToDisplay(addNewJobBtnUnderSecondStage, Pause.MEDIUM));
        ui_click(addNewJobBtnUnderSecondStage, "clicks on new job"); // adds promote job from dev
		ui_IsElementDisplay(ui_waitForElementToDisplay(selectJobType, Pause.MEDIUM));
		Select dropdown6 = new Select(selectJobType);
		dropdown6.selectByVisibleText(jobType3);
		Select dropdown7 = new Select(selectFromEnv);
		dropdown7.selectByVisibleText(fromEnv);
		ui_wait(3);
		//ui_IsElementDisplay(ui_waitForElementToDisplay(targetEnv, Pause.MEDIUM));
		Select dropdown8 = new Select(targetEnv);
		dropdown8.selectByVisibleText(toEnv);
		ui_IsElementDisplay(ui_waitForElementToDisplay(serviceComponent, Pause.MEDIUM));
		ui_click(serviceComponent, "selects service component under the env");
		Select dropdown9 = new Select(selectArtifact);
		dropdown9.selectByVisibleText(ArtifactName2);
        ui_click(addStageBtn, "adds button for second stage");
//		ui_IsElementDisplay(ui_waitForElementToDisplay(addNewJobBtnUnderSecondStage, Pause.MEDIUM));
//        ui_click(addNewJobBtnUnderSecondStage, "clicks on new job"); // adds build job to qa
//		Select dropdown10 = new Select(selectJobType);
//		dropdown10.selectByVisibleText(jobType);
//		Select dropdown11 = new Select(selectFromEnv);
//		dropdown11.selectByVisibleText(toEnv);
//		ui_IsElementDisplay(ui_waitForElementToDisplay(serviceComponent, Pause.MEDIUM));
//		ui_click(serviceComponent, "selects service component under the env");
//		ui_click(addStageBtn, "clicks add stage btn");
		ui_IsElementDisplay(ui_waitForElementToDisplay(addNewJobBtnUnderSecondStage, Pause.MEDIUM));
        ui_click(addNewJobBtnUnderSecondStage, "clicks on new job"); // adds deploy job to qa
		Select dropdown12 = new Select(selectJobType);
		dropdown12.selectByVisibleText(jobType2);
		Select dropdown13 = new Select(selectFromEnv);
		dropdown13.selectByVisibleText(toEnv);
		ui_IsElementDisplay(ui_waitForElementToDisplay(serviceComponent1, Pause.MEDIUM));
		ui_click(serviceComponent1, "selects service component under the env");
		Select dropdown14 = new Select(selectArtifact);
		dropdown14.selectByVisibleText(ArtifactName2);
		ui_click(addStageBtn, "clicks add stage btn");
		ui_IsElementDisplay(ui_waitForElementToDisplay(addNewStageToPipeline, Pause.MEDIUM));
        ui_click(addNewStageToPipeline, "adds third stage"); // adds third stage
        ui_setvalue(stageName, "sets first stage name", StageName3);
        ui_click(addStageBtn, "adds button for third stage");
		ui_IsElementDisplay(ui_waitForElementToDisplay(addNewJobBtnUnderThirdStage, Pause.MEDIUM));
        ui_click(addNewJobBtnUnderThirdStage, "clicks on new job"); // adds promote job from qa
		Select dropdown15 = new Select(selectJobType);
		dropdown15.selectByVisibleText(jobType3);
		Select dropdown16 = new Select(selectFromEnv);
		dropdown16.selectByVisibleText(toEnv);
//		ui_IsElementDisplay(ui_waitForElementToDisplay(targetEnv, Pause.MEDIUM));
		ui_wait(3);
		Select dropdown17 = new Select(targetEnv);
		dropdown17.selectByVisibleText(prodEnv);
		ui_IsElementDisplay(ui_waitForElementToDisplay(serviceComponent1, Pause.MEDIUM));
		ui_click(serviceComponent1, "selects service component under the env");
		Select dropdown18 = new Select(selectArtifact);
		dropdown18.selectByVisibleText(ArtifactName2);
		ui_click(addStageBtn, "clicks add stage btn");

		ui_IsElementDisplay(ui_waitForElementToDisplay(addNewJobBtnUnderThirdStage, Pause.MEDIUM));
        ui_click(addNewJobBtnUnderThirdStage, "clicks on new job"); // adds deploy job to prod
		Select dropdown21 = new Select(selectJobType);
		dropdown21.selectByVisibleText(jobType2);
		Select dropdown22 = new Select(selectFromEnv);
		dropdown22.selectByVisibleText(prodEnv);
		ui_IsElementDisplay(ui_waitForElementToDisplay(serviceComponent, Pause.MEDIUM));
		ui_click(serviceComponent, "selects service component under the env");
		Select dropdown19 = new Select(selectArtifact);
		dropdown19.selectByVisibleText(ArtifactName2);
		ui_click(addStageBtn, "clicks add stage btn");
		ui_wait(3);
		ui_IsElementDisplay(ui_waitForElementToDisplay(saveWorkFlowBtn, Pause.MEDIUM));
        ui_click(saveWorkFlowBtn, "clicks save workflow btn");
        ui_wait(10);
		}
		return this;
	}	

	/**
	 * 
	 */
	
	@FindBy(xpath = "//input[@name='name' and @placeholder='Name']")
	WebElement searchPipeLineInput;
	
	@FindBy(xpath = "//button[@class='btn btn-submit'][text()='Refresh']")
	WebElement refreshpipelinePage;

	@FindBy(xpath = "//a[contains(text(),'BasicPipeline')]")
	WebElement pipelineHyperLink;
	
	public BuildPipeLinePage executeBasicPipeline(String appName,String pipelineNameArg) {
		ui_IsElementDisplay(ui_waitForElementToDisplay(userMenuAppBar, Pause.MEDIUM));
		ui_click(userMenuAppBar, "userMenuAppBar");		
		ui_click(switchToUSer, "switching to user account");
		boolean projectSelection = false;
		ui_IsElementDisplay(ui_waitForElementToDisplay(poc_qaProjectLink.get(0), Pause.MEDIUM));
		for(WebElement element:poc_qaProjectLink) {
			if(element.getText().trim().equalsIgnoreCase(appName)) {
				element.click();
				projectSelection = true;
				break;
			}
		}
		if(projectSelection) {
		ui_click(pipelineOverviewLink, "Poc_QA pipelineOverviewLink");
		ui_IsElementDisplay(ui_waitForElementToDisplay(searchPipeLineInput, Pause.MEDIUM));
		ui_clearAndSetValue(searchPipeLineInput, pipelineNameArg);
		searchPipeLineInput.sendKeys(Keys.ENTER);
		ui_wait(5);
		ui_IsElementDisplay(ui_waitForElementToDisplay(executePipeLineButton, Pause.MEDIUM));
		ui_click(executePipeLineButton, "pipeline execution Start");
		ui_wait(2);
//		ui_click(executePipeLineButton, "pipeline execution Start");
//		ui_wait(2);
//		ui_click(executePipeLineButton, "pipeline execution Start");
		ui_IsElementDisplay(ui_waitForElementToDisplay(pipelineHyperLink, Pause.MEDIUM));
		ui_click(pipelineHyperLink, "clicks pipeline hyperlink");
		ui_IsElementDisplay(ui_waitForElementToDisplay(viewLogsLink, Pause.MEDIUM));
		ui_click(viewLogsLink, "Poc_QA click on View Logs");
		ui_switchToNewWindow();
//		ui_IsElementDisplay(ui_waitForElementToDisplay(postHookExecutingSuccessLink, Pause.MEDIUM));
//		ui_click(postHookExecutingSuccessLink, "postHookExecuting click for Console Logs");
//		ui_wait(10);
//		List<String> consoleLogs = ui_getTextForElements("//div[@class='d-grid grid-temp-log-line']//span");
//		boolean status = consoleLogs.get(0).length()>0;
//		Reporter.log("Successful Validate the Console logs", status);
		}
		return this;
	}
	
	String PipelineYAMLFilePath = System.getProperty("user.dir")+"\\src\\test\\resources\\testfiles\\upload\\UploadYAML\\JiraPipeline.yml";
	
	@FindBy(xpath = "//label[@for='file-input']//span[text()='upload']")
	WebElement uploadYAML;
	
	public BuildPipeLinePage createJiraPipeline(String appName,String versionType,String retentionCount,String triggerType,ArrayList<String>pipelineUser) {
		
		String pipelineName1 = "AdvanceJiraPipeline" + RandomStrings.generateRandomString(9);
//		String StageName1 = "dev" + RandomStrings.generateRandomString(7);
//		String StageName2 = "qa" + RandomStrings.generateRandomString(7);
//		String StageName3 = "prod" + RandomStrings.generateRandomString(7);
//		ui_IsElementDisplay(ui_waitForElementToDisplay(userMenuAppBar, Pause.MEDIUM));
//		ui_click(userMenuAppBar, "userMenuAppBar");		
//		ui_click(switchToUSer, "switching to user account");
		
		boolean projectSelection = false;
		ui_IsElementDisplay(ui_waitForElementToDisplay(poc_qaProjectLink.get(0), Pause.MEDIUM));
		for(WebElement element:poc_qaProjectLink) {
			if(element.getText().trim().equalsIgnoreCase(appName)) {
				element.click();
				projectSelection = true;
				break;
			}
		}
		if(projectSelection) {
		ui_click(pipelineOverviewLink, "Poc_QA pipelineOverviewLink");
		ui_click(continueBtn, "clicks on add pipeline button");
		ui_setvalue(addNameToNewPipeline, "Gives unique name to pipeline", pipelineName1);
		Select dropdown = new Select(selectPipelineVersionDropdown);
		dropdown.selectByVisibleText(versionType);
		ui_clearAndSetValue(retentionCountField, retentionCount);

        for (int i = 0; i < triggerTypeRadioBtn.size(); i++) {
        	if (triggerType.contains(triggerTypeRadioBtn.get(i).getAttribute("value").trim()) && !(MUIRadioButtonsChecked.get(i).getAttribute("class").contains("Mui-checked"))) {
        		ui_click(triggerTypeRadioBtn.get(i),"Selecting the Radio button named as -"+triggerTypeRadioBtn.get(i).getAttribute("value").trim());
        		break;
        	}
        }
//		if (triggerTypeRadioBtn.getAttribute("value").equals("Manual"))
//			ui_click(triggerTypeRadioBtn, "Poc_QA triggerTypeRadioBtn");
        ui_wait(2);
        ui_MoveToElement(muiTypographyBody, "moving to muiTypographyBodyn");
       
        ui_wait(2);
        for (int i = 0; i < pipelineAssignUserRoleCheckbox.size(); i++) {
        	if (pipelineUser.contains(pipelineAssignUserRoleCheckbox.get(i).getAttribute("value").trim())) {
        		
        		ui_ActionMoveAndClick(pipelineAssignUserRoleCheckbox.get(i),"Clicking on radio Button-"+pipelineAssignUserRoleCheckbox.get(i));
        	}
        }
        ui_wait(2);
        ui_click(savePipeline, "clicks on save pipeline button");
		ui_IsElementDisplay(ui_waitForElementToDisplay(validatePipelineName, Pause.MEDIUM));
        String validatePipelineNameActual = validatePipelineName.getText().trim();
        Assert.assertEquals(validatePipelineNameActual, pipelineName1);
		ui_IsElementDisplay(ui_waitForElementToDisplay(uploadYAML, Pause.MEDIUM));
        ui_click(uploadYAML, "clicks on upload YAML");
		ui_wait(5);
		ui_FileUpload(Configuration.get("browser"), PipelineYAMLFilePath);
		ui_wait(15);
		ui_getUIDriver().switchTo().defaultContent();

        ui_click(saveWorkFlowBtn, "clicks save workflow btn");
		}
		return this;
	}
	
	@FindBy(xpath = "//div[contains(@class,'alert alert-dismissible')]//p")
	WebElement errorMessage;
	
	public BuildPipeLinePage createBasicPipelineNegativeTest4(String appName,String versionType,String retentionCount,String triggerType,ArrayList<String>pipelineUser, String existingPipelineName) {
		ui_IsElementDisplay(ui_waitForElementToDisplay(userMenuAppBar, Pause.MEDIUM));
		ui_click(userMenuAppBar, "userMenuAppBar");		
		ui_click(switchToUSer, "switching to user account");
		boolean projectSelection = false;
		ui_IsElementDisplay(ui_waitForElementToDisplay(poc_qaProjectLink.get(0), Pause.MEDIUM));
		for(WebElement element:poc_qaProjectLink) {
			if(element.getText().trim().equalsIgnoreCase(appName)) {
				element.click();
				projectSelection = true;
				break;
			}
		}
		if(projectSelection) {
		ui_click(pipelineOverviewLink, "Poc_QA pipelineOverviewLink");
		ui_click(continueBtn, "clicks on add pipeline button");
		ui_setvalue(addNameToNewPipeline, "Gives unique name to pipeline", existingPipelineName);
		Select dropdown = new Select(selectPipelineVersionDropdown);
		dropdown.selectByVisibleText(versionType);
		ui_clearAndSetValue(retentionCountField, retentionCount);
		
		
		
        for (int i = 0; i < triggerTypeRadioBtn.size(); i++) {
        	if (triggerType.contains(triggerTypeRadioBtn.get(i).getAttribute("value").trim()) && !(MUIRadioButtonsChecked.get(i).getAttribute("class").contains("Mui-checked"))) {
        		ui_click(triggerTypeRadioBtn.get(i),"Selecting the Radio button named as -"+triggerTypeRadioBtn.get(i).getAttribute("value").trim());
        		break;
        	}
        }

        ui_wait(2);
        ui_MoveToElement(muiTypographyBody, "moving to muiTypographyBodyn");
       
        ui_wait(2);
        for (int i = 0; i < pipelineAssignUserRoleCheckbox.size(); i++) {
        	if (pipelineUser.contains(pipelineAssignUserRoleCheckbox.get(i).getAttribute("value").trim())) {
        		
        		ui_ActionMoveAndClick(pipelineAssignUserRoleCheckbox.get(i),"Clicking on radio Button-"+pipelineAssignUserRoleCheckbox.get(i));
        	}
        }
        ui_wait(2);
        ui_click(savePipeline, "clicks on save pipeline button");
		ui_IsElementDisplay(ui_waitForElementToDisplay(saveWorkFlowBtn, Pause.MEDIUM));
        ui_click(saveWorkFlowBtn, "clicks save workflow btn");
		ui_IsElementDisplay(ui_waitForElementToDisplay(errorMessage, Pause.MEDIUM));
		Assert.assertEquals("There are no jobs in this stage, No stage added", errorMessage.getText().trim());
		}
	    return this;
   }
	
	@FindBy(xpath = "//input[@name='retention_execution_count' and @placeholder='Retention Count' and @class='error']")
	WebElement errorMessage2;
	
	public BuildPipeLinePage createBasicPipelineNegativeTest5(String appName,String versionType,String retentionCount,String triggerType,ArrayList<String>pipelineUser) {
		ui_IsElementDisplay(ui_waitForElementToDisplay(userMenuAppBar, Pause.MEDIUM));
		ui_click(userMenuAppBar, "userMenuAppBar");		
		ui_click(switchToUSer, "switching to user account");
		boolean projectSelection = false;
		ui_IsElementDisplay(ui_waitForElementToDisplay(poc_qaProjectLink.get(0), Pause.MEDIUM));
		for(WebElement element:poc_qaProjectLink) {
			if(element.getText().trim().equalsIgnoreCase(appName)) {
				element.click();
				projectSelection = true;
				break;
			}
		}
		if(projectSelection) {
		ui_click(pipelineOverviewLink, "Poc_QA pipelineOverviewLink");
		ui_click(continueBtn, "clicks on add pipeline button");
		ui_setvalue(addNameToNewPipeline, "Gives unique name to pipeline", pipelineName);
		Select dropdown = new Select(selectPipelineVersionDropdown);
		dropdown.selectByVisibleText(versionType);
		ui_clearAndSetValue(retentionCountField, retentionCount);
		
		
		
        for (int i = 0; i < triggerTypeRadioBtn.size(); i++) {
        	if (triggerType.contains(triggerTypeRadioBtn.get(i).getAttribute("value").trim()) && !(MUIRadioButtonsChecked.get(i).getAttribute("class").contains("Mui-checked"))) {
        		ui_click(triggerTypeRadioBtn.get(i),"Selecting the Radio button named as -"+triggerTypeRadioBtn.get(i).getAttribute("value").trim());
        		break;
        	}
        }

        ui_wait(2);
        ui_MoveToElement(muiTypographyBody, "moving to muiTypographyBodyn");
       
        ui_wait(2);
        for (int i = 0; i < pipelineAssignUserRoleCheckbox.size(); i++) {
        	if (pipelineUser.contains(pipelineAssignUserRoleCheckbox.get(i).getAttribute("value").trim())) {
        		
        		ui_ActionMoveAndClick(pipelineAssignUserRoleCheckbox.get(i),"Clicking on radio Button-"+pipelineAssignUserRoleCheckbox.get(i));
        	}
        }
        ui_wait(2);
        ui_click(savePipeline, "clicks on save pipeline button");
		ui_IsElementDisplay(ui_waitForElementToDisplay(errorMessage2, Pause.MEDIUM));
		}
        return this;
	}
	
	@FindBy(xpath = "//button[contains(@class,'btn btn-danger')]//span[text()=' Manage Failures']")
	WebElement manageFailurePopUp;
	
	public BuildPipeLinePage managePopupTest(String appName, String existingPipelineName) {
		ui_click(userMenuAppBar, "userMenuAppBar");		
		ui_click(switchToUSer, "switching to user account");
		boolean projectSelection = false;
		ui_wait(5);
		ui_IsElementDisplay(ui_waitForElementToDisplay(poc_qaProjectLink.get(0), Pause.MEDIUM));
		for(WebElement element:poc_qaProjectLink) {
			if(element.getText().trim().equalsIgnoreCase(appName)) {
				element.click();
				projectSelection = true;
				break;
			}
		}
		if(projectSelection) {
		ui_click(pipelineOverviewLink, "Poc_QA pipelineOverviewLink");
//		ui_IsElementDisplay(ui_waitForElementToDisplay(PipelineSubject, Pause.MEDIUM));
		ui_IsElementDisplay(ui_waitForElementToDisplay(searchPipeLine, Pause.MEDIUM));
		ui_clearAndSetValue(searchPipeLine, existingPipelineName);
		searchPipeLine.sendKeys(Keys.ENTER);
		ui_click(pipeLineExecutionHistory, "view pipeline excution history");
		ui_IsElementDisplay(ui_waitForElementToDisplay(reExecutePipeLineBtn, Pause.MEDIUM));
		ui_click(reExecutePipeLineBtn, "view pipeline re-excution history");
//		ui_click(executePipeLineButton, "Poc_QA execution Start");
		ui_wait(5);
		ui_IsElementDisplay(ui_waitForElementToDisplay(existingPipeLine, Pause.MEDIUM));
		ui_click(existingPipeLine, "Poc_QA execution Start");
		ui_IsElementDisplay(ui_waitForElementToDisplay(manageFailurePopUp, Pause.MEDIUM));
		ui_click(manageFailurePopUp, "manage Failure PopUp");
		
		}
		return this;
	}

}
