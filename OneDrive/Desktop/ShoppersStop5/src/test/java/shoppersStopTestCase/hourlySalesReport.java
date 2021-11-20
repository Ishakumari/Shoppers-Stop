package shoppersStopTestCase;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import shoppersStopBase.TestBase;
import shoppersStopPages.loginPage;
import shoppersStopPages.reportingPage;

public class hourlySalesReport extends TestBase{
	public loginPage loginpage;
	public reportingPage reportingpage;


	@BeforeTest
	public void setUp() throws InterruptedException{
		loginpage=new loginPage();
		reportingpage=new reportingPage();
		loginpage.enterEmloyeeID("7010014");
		System.out.println("Employee Id has been entered");
		loginpage.enterPassword("123456");
		System.out.println("Password entered");
		loginpage.clickOnLoginButton();
		Thread.sleep(3000);
		System.out.println("Clicked on login button");
		reportingpage.clickOnReporting();
		Thread.sleep(3000);
	}
	@Test(priority=1)
	public void validateTotalCheck() throws InterruptedException {
		reportingpage.clickOnHourlySalesReport();
		Thread.sleep(2000);
		String selectTotalHour="25";
		reportingpage.clickOnPagination();
		for(int i = 0; i<reportingpage.totalDateSelector();i++) {
			WebElement hourElement=reportingpage.getElementDateSelector().get(i);
			String hour=reportingpage.getElementDateSelector().get(i).getText();
			if(selectTotalHour.equalsIgnoreCase(hour)) {
				hourElement.click();
				break;
			}
		}
		double sum=0;
		System.out.println(reportingpage.TotalCheck());
		for(int i=0; i<reportingpage.TotalCheck(); i++){
			//String invoiceAmount=reportingpage.getElementVoidOrder().get(i).getText();	
			String CheckElement=reportingpage.getElementTotalCheck().get(i).getText();
			System.out.println(CheckElement);
			sum=sum+Double.parseDouble(CheckElement);
		}	
		int value2=(int)sum;
		System.out.println("Sum of total check in Hourly Sales Report: "+value2);

		reportingpage.clickOnDailySalesReport();
		double value1=Double.parseDouble(reportingpage.getTotalCheckCount());
		int value=(int)value1;
		System.out.println("Total check count in the daily sales report is: "+value);
		Assert.assertEquals(value2, value);
		System.out.println("test case pass");
	}
	@Test(priority=2)
	public void validateTotalNetSale() throws InterruptedException {
		reportingpage.clickOnHourlySalesReport();
		Thread.sleep(2000);
		String selectTotalHour="25";
		reportingpage.clickOnPagination();
		for(int i = 0; i<reportingpage.totalDateSelector();i++) {
			WebElement hourElement=reportingpage.getElementDateSelector().get(i);
			String hour=reportingpage.getElementDateSelector().get(i).getText();
			if(selectTotalHour.equalsIgnoreCase(hour)) {
				hourElement.click();
				break;
			}
		}
		double sum=0;
		System.out.println(reportingpage.TotalCheck());
		for(int i=0; i<reportingpage.TotalNetSales(); i++){
			//String invoiceAmount=reportingpage.getElementVoidOrder().get(i).getText();	
			String CheckElement=reportingpage.getElementTotalNetSales().get(i).getText();
			System.out.println(CheckElement);
			sum=sum+Double.parseDouble(CheckElement);
		}	
		int value2=(int)sum;
		System.out.println("Sum of net sales in Hourly Sales Report: "+value2);

		reportingpage.clickOnDailySalesReport();
		double value1=Double.parseDouble(reportingpage.getTotalNetSale());
		int value=(int)value1;
		System.out.println("Total net sales in the daily sales report is: "+value);
		Assert.assertEquals(value2, value);
		System.out.println("test case pass");
	}
	@Test(priority=3)
	public void validateTotalGrossSale() throws InterruptedException {
		reportingpage.clickOnHourlySalesReport();
		Thread.sleep(2000);
		String selectTotalHour="25";
		reportingpage.clickOnPagination();
		for(int i = 0; i<reportingpage.totalDateSelector();i++) {
			WebElement hourElement=reportingpage.getElementDateSelector().get(i);
			String hour=reportingpage.getElementDateSelector().get(i).getText();
			if(selectTotalHour.equalsIgnoreCase(hour)) {
				hourElement.click();
				break;
			}
		}
		double sum=0;
		System.out.println(reportingpage.TotalCheck());
		for(int i=0; i<reportingpage.TotalGrossSales(); i++){
			//String invoiceAmount=reportingpage.getElementVoidOrder().get(i).getText();	
			String CheckElement=reportingpage.getElementTotalGrossSales().get(i).getText();
			System.out.println(CheckElement);
			sum=sum+Double.parseDouble(CheckElement);
		}	
		int value2=(int)sum;
		System.out.println("Sum of gross sales in Hourly Sales Report: "+value2);

		reportingpage.clickOnDailySalesReport();
		double value1=Double.parseDouble(reportingpage.getGossSale());
		int value=(int)value1;
		System.out.println("Total gross sales in the daily sales report is: "+value);
		Assert.assertEquals(value2, value);
		System.out.println("test case pass");
	}
	@Test(priority=4)
	public void validateTotalPercentage() throws InterruptedException {
		int percentage=100;
		reportingpage.clickOnHourlySalesReport();
		Thread.sleep(2000);
		reportingpage.clickOnFilterFor();             //clicked on filter for
		String SelectDate="Yesterday";
		for(int i = 0; i<reportingpage.totalDateSelector();i++) {      
			WebElement day=reportingpage.getElementDateSelector().get(i);
			String day1=reportingpage.getElementDateSelector().get(i).getText();
			if(SelectDate.equalsIgnoreCase(day1)) {
				day.click();}}                                             //clicked on last week
		reportingpage.clickOnButton();                                     //clicked on arrow button
		Thread.sleep(2000);		
		String selectTotalHour="25";
		reportingpage.clickOnPagination();
		for(int i = 0; i<reportingpage.totalDateSelector();i++) {
			WebElement hourElement=reportingpage.getElementDateSelector().get(i);
			String hour=reportingpage.getElementDateSelector().get(i).getText();
			if(selectTotalHour.equalsIgnoreCase(hour)) {
				hourElement.click();
				break;
			}
		}
		
		double sum=0;
		System.out.println(reportingpage.TotalCheck());
		for(int i=0; i<reportingpage.TotalPercentage(); i++){
			//String invoiceAmount=reportingpage.getElementVoidOrder().get(i).getText();	
			String CheckElement=reportingpage.getElementTotalPercentage().get(i).getText();
			System.out.println(CheckElement);
			sum=sum+Double.parseDouble(CheckElement);
		}	
		int value=(int)sum;
		System.out.println("Sum of percentage in Hourly Sales Report: "+sum);

		Assert.assertEquals(value, percentage);
		System.out.println("test case pass");
	}

}

