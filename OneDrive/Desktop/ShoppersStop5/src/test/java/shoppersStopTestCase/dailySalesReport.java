package shoppersStopTestCase;

import java.io.File;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import shoppersStopBase.TestBase;
import shoppersStopPages.loginPage;
import shoppersStopPages.reportingPage;

public class dailySalesReport extends TestBase{
	public loginPage loginpage;
	public reportingPage reportingpage;
	//public Login login;


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
		Thread.sleep(2000);
		reportingpage.clickOnReporting();
		}	
		@Test(priority=1)
		public void validateDailySalesReport() throws InterruptedException {
			reportingpage.clickOnDailySalesReport();
			Thread.sleep(2000);
			reportingpage.clickOnFilterFor();             //clicked on filter for
			String SelectDate="Today";
			for(int i = 0; i<reportingpage.totalDateSelector();i++) {      
				WebElement day=reportingpage.getElementDateSelector().get(i);
				String day1=reportingpage.getElementDateSelector().get(i).getText();
				if(SelectDate.equalsIgnoreCase(day1)) {
					day.click();}}                                             //clicked on last week
			reportingpage.clickOnButton();                                     //clicked on arrow button
			Thread.sleep(2000);		
			for(int i=0; i<reportingpage.totalRowSize(); i++) {
				System.out.println(reportingpage.getColumnFirstdata().get(i).getText()+"="+reportingpage.getColumnSeconddata().get(i).getText());
				//System.out.println(reportingpage.getColumnSeconddata().get(i).getText());
			}
		}

		@Test(priority=2, enabled=true)
		public void validateRefundSalesales() throws InterruptedException {
			Thread.sleep(3000);
			reportingpage.clickOnDailySalesReport();
			Thread.sleep(2000);
			reportingpage.clickOnFilterFor();             //clicked on filter for
			String SelectDate="Today";
			for(int i = 0; i<reportingpage.totalDateSelector();i++) {      
				WebElement day=reportingpage.getElementDateSelector().get(i);
				String day1=reportingpage.getElementDateSelector().get(i).getText();
				if(SelectDate.equalsIgnoreCase(day1)) {
					day.click();}}                                             //clicked on last week
			reportingpage.clickOnButton();                                     //clicked on arrow button
			Thread.sleep(2000);
			float RefundSale=Float.parseFloat(reportingpage.getRefundSale());
			System.out.println("Refund Sale in Daily Sale Report is "+RefundSale);
			int value1=(int)RefundSale;
			//void report
			reportingpage.clickOnVoidReport();
			Thread.sleep(2000);
			reportingpage.clickOnFilterFor();             //clicked on filter for
			String SelectDate2="Today";
			for(int i = 0; i<reportingpage.totalDateSelector();i++) {      
				WebElement day=reportingpage.getElementDateSelector().get(i);
				String day1=reportingpage.getElementDateSelector().get(i).getText();
				if(SelectDate2.equalsIgnoreCase(day1)) {
					day.click();}}                                             //clicked on last week
			reportingpage.clickOnButton();    
			String SelectNoOFOrderShowsInOnePage="500";
			Thread.sleep(2000);
			reportingpage.clickOnPagination();
			for(int i = 0; i<reportingpage.totalDateSelector();i++) {
				WebElement day=reportingpage.getElementDateSelector().get(i);
				String day1=reportingpage.getElementDateSelector().get(i).getText();
				if(SelectNoOFOrderShowsInOnePage.equalsIgnoreCase(day1)) {
					day.click();
				}
			}

			System.out.println("Total post void order is "+reportingpage.totalVoidOrder());
			float sum=0;
			for(int i=0; i<reportingpage.totalVoidOrder(); i++){
				String invoiceAmount=reportingpage.getElementVoidOrder().get(i).getText();
				System.out.println(invoiceAmount);
				sum=sum+Float.parseFloat(invoiceAmount);
			}
			System.out.println("Sum of Post Void Orders"+sum);
			int value2=(int)sum;
			Assert.assertEquals(value1, value2);
			System.out.println("test case pass");		
		}
		@Test(priority=3, enabled=true)
		public void validateDownloadDailySalesReport() throws InterruptedException{
			reportingpage.clickOnDailySalesReport();
			Thread.sleep(2000);
			reportingpage.clickOnFilterFor();             //clicked on filter for
			String SelectDate="Today";
			for(int i = 0; i<reportingpage.totalDateSelector();i++) {      
				WebElement day=reportingpage.getElementDateSelector().get(i);
				String day1=reportingpage.getElementDateSelector().get(i).getText();
				if(SelectDate.equalsIgnoreCase(day1)) {
					day.click();}}                                             //clicked on last week
			reportingpage.clickOnButton();    		
			reportingpage.clickOnExport();
			Thread.sleep(2000);
			reportingpage.clickOnExportAsExcel();
			Thread.sleep(4000);
			File fileLocation=new File("C:\\Users\\Cravrr\\Downloads");
			File[] totalFiles=fileLocation.listFiles();
			for(File file:totalFiles) {
				if(file.getName().equals("Daily Sales Report")) {
					System.out.println("File is downloaded");
					break;
				}
			}

		}
	}










