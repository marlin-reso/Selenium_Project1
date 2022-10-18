package php.crm.Vtiger.Project1.pomRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewCampaignPage {
	
	public CreatingNewCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "Campaigns_editView_fieldName_campaignname")
	private WebElement campaignNameTextField;
	
	@FindBy(id = "Campaigns_editView_fieldName_closingdate")
	private WebElement expectedClosingDateCalender;
	
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveButton;

	public WebElement getCampaignNameTextField() {
		return campaignNameTextField;
	}

	public WebElement getExpectedClosingDateCalender() {
		return expectedClosingDateCalender;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void createNewCampaignAction(String campaignName, String date) {
		campaignNameTextField.sendKeys(campaignName);
		expectedClosingDateCalender.sendKeys(date);
		expectedClosingDateCalender.sendKeys(Keys.ENTER);
		saveButton.click();
	}
}
