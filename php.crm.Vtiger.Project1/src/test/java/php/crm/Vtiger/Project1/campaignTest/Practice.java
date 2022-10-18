package php.crm.Vtiger.Project1.campaignTest;

import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import php.crm.Vtiger.Project1.genericUtitlity.JavaUtility;

public class Practice {

	@Test 
	public void b() {
	
		Date date = new Date();
		System.out.println(date.getDate());
		
		System.out.println(date.getMonth()+1);
		String year = date.getYear()+"";
		System.out.println(year.substring(1, 3));
		
		System.out.println("Demo Print");
		System.out.println("Demo Print");

	}
	
}
