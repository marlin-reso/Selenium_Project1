package php.crm.Vtiger.Project1.campaignTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.bouncycastle.crypto.engines.CamelliaEngine;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.ContainerNetwork.Ipam;

import php.crm.Vtiger.Project1.genericUtitlity.BaseClass;
import php.crm.Vtiger.Project1.genericUtitlity.ExcelUtility;
import php.crm.Vtiger.Project1.genericUtitlity.IPathConstant;
import php.crm.Vtiger.Project1.genericUtitlity.JavaUtility;
import php.crm.Vtiger.Project1.pomRepository.CampaignDetailsPage;
import php.crm.Vtiger.Project1.pomRepository.CampaignsPage;
import php.crm.Vtiger.Project1.pomRepository.CreatingNewCampaignPage;
import php.crm.Vtiger.Project1.pomRepository.HomePage;

@Listeners(php.crm.Vtiger.Project1.genericUtitlity.ListenersImplementationClass.class)
public class CreateCampaignTest extends BaseClass {
	
	@Test //(retryAnalyzer = php.crm.Vtiger.Project1.genericUtitlity.IRetryAnalyserImplementationClass.class)
	public void createCampaignAndVerfiyCampaignNameTest() throws EncryptedDocumentException, IOException {
		
		HomePage home = new HomePage(driver);
		home.clickOnCampaignOption();
		
		CampaignsPage campaign = new CampaignsPage(driver);
		campaign.clickOnAddCampaign();
		
		int randomNo = jutils.generateRandomNumber(IPathConstant.RANDOM_NUMBER);
		
		ExcelUtility eUtils = new ExcelUtility();
		String campaignName = eUtils.fetchDataFromExcelFile(IPathConstant.SHEET_NAME, 1, 0);
		String expectedCampaignName = campaignName+randomNo;
		String date = eUtils.fetchDataFromExcelFile(IPathConstant.SHEET_NAME, 1, 1);
		
		CreatingNewCampaignPage newCampaign = new CreatingNewCampaignPage(driver);
		newCampaign.createNewCampaignAction(expectedCampaignName, date);
		
		CampaignDetailsPage campaignDetails = new CampaignDetailsPage(driver);
		String actualCampaignName = campaignDetails.verifyCampaignName(campaignName);
		System.out.println(actualCampaignName);
		System.out.println(expectedCampaignName);
		
		Assert.assertEquals(actualCampaignName, expectedCampaignName);
		System.out.println("Campaign Name is verified");
		
		
			
	}

}
