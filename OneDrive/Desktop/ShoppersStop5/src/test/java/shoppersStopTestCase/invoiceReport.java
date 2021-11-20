package shoppersStopTestCase;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import shoppersStopBase.TestBase;
import shoppersStopPages.loginPage;
import shoppersStopPages.reportingPage;

public class invoiceReport extends TestBase {
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
	//validate whether search functionality in the invoice report is working.
	public void validateSearchInInvoiceReort() throws InterruptedException {
		reportingpage.clickOnInvoiceReport();         //clicked on invoice report
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
		String order1=reportingpage.enterOrderInSearch("114-2854");      // entered order number in search box
		System.out.println("Entered order in search box is "+order1);
		Thread.sleep(2000);
		String searchedOrder=reportingpage.getInvoiceNo();                 // get invoice number of first row
		Thread.sleep(2000);
		System.out.println(searchedOrder);
		Assert.assertEquals(order1, searchedOrder);
		System.out.println("search functionality is working");}
	
	@Test(priority=2)
	//validate that gross sale in invoice report is equal to gross sale in daily sales report.
	public void validateGrossSale() throws InterruptedException {
		reportingpage.clickOnDailySalesReport();
		Thread.sleep(2000);
		double GrossSale=Double.parseDouble(reportingpage.getGossSale());
		int value1=(int)GrossSale;
		System.out.println(value1);
		System.out.println("Total gross sale in daily sales report : "+value1);
		String SelectNoOFOrderShowsInOnePage="500";
		reportingpage.clickOnInvoiceReport();
		Thread.sleep(2000);
		reportingpage.clickOnPagination();
		for(int i = 0; i<reportingpage.totalDateSelector();i++) {
			WebElement day=reportingpage.getElementDateSelector().get(i);
			String day1=reportingpage.getElementDateSelector().get(i).getText();
			if(SelectNoOFOrderShowsInOnePage.equalsIgnoreCase(day1)) {
				day.click();
			}
		}
		double sum=0;
		for(int i=0; i<reportingpage.grossSaleCount(); i++){
			//String invoiceAmount=reportingpage.getElementVoidOrder().get(i).getText();	
			String grossSale=reportingpage.getElementGrossSale().get(i).getText();
			System.out.println(grossSale);
			sum=sum+Double.parseDouble(grossSale);
		}	
		int value2=(int)sum;
		System.out.println("Sum of gross Sale in Invoice Report"+value2);

		Assert.assertEquals(value1, value2);
		System.out.println("test case pass");
	}
	@Test(priority=3)
	//validate that total tax in invoice report is equal to total tax in daily sales report.
	public void validateTotalTax() throws InterruptedException {
		String SelectNoOFOrderShowsInOnePage="500";
		reportingpage.clickOnInvoiceReport();
		Thread.sleep(2000);
		reportingpage.clickOnPagination();
		for(int i = 0; i<reportingpage.totalDateSelector();i++) {
			WebElement day=reportingpage.getElementDateSelector().get(i);
			String day1=reportingpage.getElementDateSelector().get(i).getText();
			if(SelectNoOFOrderShowsInOnePage.equalsIgnoreCase(day1)) {
				day.click();
			}
		}
		float sum=0;
		for(int i=0; i<reportingpage.taxCount(); i++){
			//String invoiceAmount=reportingpage.getElementVoidOrder().get(i).getText();	
			String Tax=reportingpage.getElementTax().get(i).getText();
			System.out.println(Tax);
			sum=sum+Float.parseFloat(Tax);
		}	
		int value2=(int)sum;
		System.out.println("Sum of total tax in Invoice Report"+value2);
		reportingpage.clickOnDailySalesReport();
		Thread.sleep(2000);
		float totalTax=Float.parseFloat(reportingpage.getTotalTax());
		int value1=(int)totalTax;
		System.out.println("Total tax in daily sales report : "+value1);
		Assert.assertEquals(value1, value2);
		System.out.println("test case pass");
	}
	
	@Test(priority=4)
	//validate that total discount in invoice report is equal to total discount in daily sales report.
	public void validateTotalDiscount() throws InterruptedException {
		String SelectNoOFOrderShowsInOnePage="500";
		reportingpage.clickOnInvoiceReport();
		Thread.sleep(2000);
		reportingpage.clickOnPagination();
		for(int i = 0; i<reportingpage.totalDateSelector();i++) {
			WebElement day=reportingpage.getElementDateSelector().get(i);
			String day1=reportingpage.getElementDateSelector().get(i).getText();
			if(SelectNoOFOrderShowsInOnePage.equalsIgnoreCase(day1)) {
				day.click();
			}
		}
		float sum=0;
		for(int i=0; i<reportingpage.discountCount(); i++){
			//String invoiceAmount=reportingpage.getElementVoidOrder().get(i).getText();	
			String Discount=reportingpage.getElementDiscount().get(i).getText();
			System.out.println(Discount);
			sum=sum+Float.parseFloat(Discount);
		}	
		int value2=(int)sum;
		System.out.println("Sum of total discount in Invoice Report"+value2);
		reportingpage.clickOnDailySalesReport();
		Thread.sleep(2000);
		float totalDiscount=Float.parseFloat(reportingpage.getTotalDiscount());
		int value1=(int)totalDiscount;
		System.out.println("Total Discount in daily sales report : "+value1);
		Assert.assertEquals(value1, value2);
		System.out.println("test case pass");
	}
	@Test(priority=5)
	//validate that total net sale in invoice report is equal to total net sale in daily sales report.
	public void validateTotalNetSale() throws InterruptedException {
		String SelectNoOFOrderShowsInOnePage="500";
		reportingpage.clickOnInvoiceReport();
		Thread.sleep(2000);
		reportingpage.clickOnPagination();
		for(int i = 0; i<reportingpage.totalDateSelector();i++) {
			WebElement day=reportingpage.getElementDateSelector().get(i);
			String day1=reportingpage.getElementDateSelector().get(i).getText();
			if(SelectNoOFOrderShowsInOnePage.equalsIgnoreCase(day1)) {
				day.click();
			}
		}
		float sum=0;
		for(int i=0; i<reportingpage.netSaleCount(); i++){
			//String invoiceAmount=reportingpage.getElementVoidOrder().get(i).getText();	
			String netSale=reportingpage.getElementNetSale().get(i).getText();
			System.out.println(netSale);
			sum=sum+Float.parseFloat(netSale);
		}	
		int value2=(int)sum;
		System.out.println("Sum of total net sale in Invoice Report"+value2);
		reportingpage.clickOnDailySalesReport();
		Thread.sleep(2000);
		float totalNetSale=Float.parseFloat(reportingpage.getTotalNetSale());
		int value1=(int)totalNetSale;
		System.out.println("Total net sale in daily sales report : "+value1);
		Assert.assertEquals(value1, value2);
		System.out.println("test case pass");
	}
	@Test(priority=6, enabled=false)
	//validate that total total check count in invoice report is equal to total check count in daily sales report.
	public void validateTotalCheckCount() throws InterruptedException {
		String SelectNoOFOrderShowsInOnePage="500";
		reportingpage.clickOnInvoiceReport();
		Thread.sleep(2000);
		reportingpage.clickOnPagination();
		for(int i = 0; i<reportingpage.totalDateSelector();i++) {
			WebElement day=reportingpage.getElementDateSelector().get(i);
			String day1=reportingpage.getElementDateSelector().get(i).getText();
			if(SelectNoOFOrderShowsInOnePage.equalsIgnoreCase(day1)) {
				day.click();
			}
		}
		float sum=0;
		for(int i=0; i<reportingpage.CheckCount(); i++){
			//String invoiceAmount=reportingpage.getElementVoidOrder().get(i).getText();	
			String checkCount=reportingpage.getElementCheckCount().get(i).getText();
			System.out.println(checkCount);
			sum=sum+Float.parseFloat(checkCount);
		}	
		int value2=(int)sum;
		System.out.println("Total check count in Invoice Report"+value2);
		reportingpage.clickOnDailySalesReport();
		Thread.sleep(2000);
		float totalCheckCount=Float.parseFloat(reportingpage.getTotalCheckCount());
		int value1=(int)totalCheckCount;
		System.out.println("Total net sale in daily sales report : "+value1);
		Assert.assertEquals(value1, value2);
		System.out.println("test case pass");
	}
	
}
