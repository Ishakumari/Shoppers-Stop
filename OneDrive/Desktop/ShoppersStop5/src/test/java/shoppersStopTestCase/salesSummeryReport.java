package shoppersStopTestCase;

import java.io.File;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import shoppersStopBase.TestBase;
import shoppersStopPages.loginPage;
import shoppersStopPages.reportingPage;

public class salesSummeryReport extends TestBase{
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
		reportingpage.clickOnSalesSummeryReport();

	}
	@Test(priority=1)
	public void validateTotalSaleInByDevice() throws InterruptedException {
		Thread.sleep(2000);
		reportingpage.clickOnByDevice();
		reportingpage.clickOnFilterForInSummeryReport();
		String SelectDate="Today";
		for(int i = 0; i<reportingpage.totalDateSelector();i++) {      
			WebElement day=reportingpage.getElementDateSelector().get(i);
			String day1=reportingpage.getElementDateSelector().get(i).getText();
			if(SelectDate.equalsIgnoreCase(day1)) {
				day.click();
				break;
			}
		} 
		reportingpage.clickOnArrowButtonInSummeryReport();
		Thread.sleep(4000);
		String totalSaleInByDevice=reportingpage.getTotalSales();
		Thread.sleep(3000);
		System.out.println("Total sales in the by device report is : "+totalSaleInByDevice);
		Thread.sleep(2000);
		
		reportingpage.clickOnDailySalesReport();
		reportingpage.clickOnFilterFor();             //clicked on filter for
		String SelectDate2="Today";
		for(int i = 0; i<reportingpage.totalDateSelector();i++) {      
			WebElement day=reportingpage.getElementDateSelector().get(i);
			String day1=reportingpage.getElementDateSelector().get(i).getText();
			if(SelectDate2.equalsIgnoreCase(day1)) {
				day.click();
				break;
			}
		}    
		reportingpage.clickOnButton(); 	
		Thread.sleep(4000);
		String totalSaleInDailySalesReport=reportingpage.getTotalSales();
		Thread.sleep(3000);
		System.out.println("Total sales in the daily sales report is : "+totalSaleInDailySalesReport);
		Assert.assertEquals(totalSaleInByDevice, totalSaleInDailySalesReport);
		System.out.println("In both report, total sales are equal - Test Case Pass");
	}
	@Test(priority=2)
	public void validateRefundSalesInByDevice() throws InterruptedException {
		Thread.sleep(2000);
		reportingpage.clickOnByDevice();
		reportingpage.clickOnFilterForInSummeryReport();
		String SelectDate="Today";
		for(int i = 0; i<reportingpage.totalDateSelector();i++) {      
			WebElement day=reportingpage.getElementDateSelector().get(i);
			String day1=reportingpage.getElementDateSelector().get(i).getText();
			if(SelectDate.equalsIgnoreCase(day1)) {
				day.click();
				break;
			}
		} 
		reportingpage.clickOnArrowButtonInSummeryReport();
		Thread.sleep(4000);
		String refundSaleInByDevice=reportingpage.getRefundSale();
		System.out.println("Total Refund in the by device report is : "+refundSaleInByDevice);
		
		reportingpage.clickOnDailySalesReport();
		reportingpage.clickOnFilterFor();             //clicked on filter for
		String SelectDate2="Today";
		for(int i = 0; i<reportingpage.totalDateSelector();i++) {      
			WebElement day=reportingpage.getElementDateSelector().get(i);
			String day1=reportingpage.getElementDateSelector().get(i).getText();
			if(SelectDate2.equalsIgnoreCase(day1)) {
				day.click();}}                                             //clicked on last week
		reportingpage.clickOnButton(); 	
		Thread.sleep(4000);
		String totalRefundInDailySalesReport=reportingpage.getRefundSale();
		Thread.sleep(3000);
		System.out.println("Total refund in the daily sales report is : "+totalRefundInDailySalesReport);
		Assert.assertEquals(refundSaleInByDevice, totalRefundInDailySalesReport);
		System.out.println("In both report, total refund are equal - Test Case Pass");
	}
	@Test(priority=3)
	public void validateTotalGrossSaleInByDevice() throws InterruptedException {
		reportingpage.clickOnByDevice();
		Thread.sleep(2000);
		String SelectDate="Today";
		reportingpage.clickOnFilterForInSummeryReport();
		for(int i = 0; i<reportingpage.totalDateSelector();i++) {      
			WebElement day=reportingpage.getElementDateSelector().get(i);
			String day1=reportingpage.getElementDateSelector().get(i).getText();
			if(SelectDate.equalsIgnoreCase(day1)) {
				day.click();
				break;
			}
		} 
		reportingpage.clickOnArrowButtonInSummeryReport();
		Thread.sleep(4000);
		String totalGrossSaleInByDevice=reportingpage.getGossSale();
		System.out.println("Total gross sales in the by device report is : "+totalGrossSaleInByDevice);
		
		reportingpage.clickOnDailySalesReport();
		reportingpage.clickOnFilterFor();             //clicked on filter for
		String SelectDate2="Today";
		for(int i = 0; i<reportingpage.totalDateSelector();i++) {      
			WebElement day=reportingpage.getElementDateSelector().get(i);
			String day1=reportingpage.getElementDateSelector().get(i).getText();
			if(SelectDate2.equalsIgnoreCase(day1)) {
				day.click();
				break;}}                                             //clicked on last week
		reportingpage.clickOnButton(); 	
		Thread.sleep(4000);
		String totalGrossSaleInDailySalesReport=reportingpage.getGossSale();
		Thread.sleep(3000);
		System.out.println("Total gross sales in the daily sales report is : "+totalGrossSaleInDailySalesReport);
		Assert.assertEquals(totalGrossSaleInByDevice, totalGrossSaleInDailySalesReport);
		System.out.println("In both report, total gross sales are equal - Test Case Pass");
	}
	@Test(priority=4)
	public void validateTotalTaxInByDevice() throws InterruptedException {
		reportingpage.clickOnByDevice();
		Thread.sleep(2000);
		String SelectDate="Today";
		reportingpage.clickOnFilterForInSummeryReport();
		for(int i = 0; i<reportingpage.totalDateSelector();i++) {      
			WebElement day=reportingpage.getElementDateSelector().get(i);
			String day1=reportingpage.getElementDateSelector().get(i).getText();
			if(SelectDate.equalsIgnoreCase(day1)) {
				day.click();
				break;
			}
		}
		reportingpage.clickOnArrowButtonInSummeryReport();
		Thread.sleep(4000);
		String totalTaxInByDevice=reportingpage.getTotalTax();
		System.out.println("Total tax in the by device report is : "+totalTaxInByDevice);
		
		reportingpage.clickOnDailySalesReport();
		reportingpage.clickOnFilterFor();             //clicked on filter for
		String SelectDate2="Today";
		for(int i = 0; i<reportingpage.totalDateSelector();i++) {      
			WebElement day=reportingpage.getElementDateSelector().get(i);
			String day1=reportingpage.getElementDateSelector().get(i).getText();
			if(SelectDate2.equalsIgnoreCase(day1)) {
				day.click();
				break;}}                                             //clicked on last week
		reportingpage.clickOnButton(); 	
		Thread.sleep(4000);
		String totalTaxDailySalesReport=reportingpage.getTotalTax();
		Thread.sleep(3000);
		System.out.println("Total tax in the daily sales report is : "+totalTaxDailySalesReport);
		Assert.assertEquals(totalTaxInByDevice, totalTaxDailySalesReport);
		System.out.println("In both report, total tax are equal - Test Case Pass");
	}
	@Test(priority=5)
	public void validateTotalDiscountInByDevice() throws InterruptedException {
		reportingpage.clickOnByDevice();
		Thread.sleep(2000);
		String SelectDate="Today";
		reportingpage.clickOnFilterForInSummeryReport();
		for(int i = 0; i<reportingpage.totalDateSelector();i++) {      
			WebElement day=reportingpage.getElementDateSelector().get(i);
			String day1=reportingpage.getElementDateSelector().get(i).getText();
			if(SelectDate.equalsIgnoreCase(day1)) {
				day.click();
				break;
			}
		} 
		reportingpage.clickOnArrowButtonInSummeryReport();
		Thread.sleep(4000);
		String totalDiscountInByDevice=reportingpage.getTotalDiscount();
		System.out.println("Total discount in the by device report is : "+totalDiscountInByDevice);
		
		reportingpage.clickOnDailySalesReport();
		reportingpage.clickOnFilterFor();             //clicked on filter for
		String SelectDate2="Today";
		for(int i = 0; i<reportingpage.totalDateSelector();i++) {      
			WebElement day=reportingpage.getElementDateSelector().get(i);
			String day1=reportingpage.getElementDateSelector().get(i).getText();
			if(SelectDate2.equalsIgnoreCase(day1)) {
				day.click();
				break;}}                                             //clicked on last week
		reportingpage.clickOnButton(); 	
		Thread.sleep(4000);
		String totalDiscountDailySalesReport=reportingpage.getTotalDiscount();
		Thread.sleep(3000);
		System.out.println("Total discount in the daily sales report is : "+totalDiscountDailySalesReport);
		Assert.assertEquals(totalDiscountInByDevice, totalDiscountDailySalesReport);
		System.out.println("In both report, total discount are equal - Test Case Pass");
	}
	@Test(priority=6)
	public void validateTotalNetSaleInByDevice() throws InterruptedException {
		reportingpage.clickOnByDevice();
		Thread.sleep(2000);
		String SelectDate="Today";
		reportingpage.clickOnFilterForInSummeryReport();
		for(int i = 0; i<reportingpage.totalDateSelector();i++) {      
			WebElement day=reportingpage.getElementDateSelector().get(i);
			String day1=reportingpage.getElementDateSelector().get(i).getText();
			if(SelectDate.equalsIgnoreCase(day1)) {
				day.click();
				break;
			}
		} 
		reportingpage.clickOnArrowButtonInSummeryReport();
		Thread.sleep(4000);
		String totalNetSaleInByDevice=reportingpage.getTotalNetSale();
		System.out.println("Total net sale in the by device report is : "+totalNetSaleInByDevice);
		
		reportingpage.clickOnDailySalesReport();
		reportingpage.clickOnFilterFor();             //clicked on filter for
		String SelectDate2="Today";
		for(int i = 0; i<reportingpage.totalDateSelector();i++) {      
			WebElement day=reportingpage.getElementDateSelector().get(i);
			String day1=reportingpage.getElementDateSelector().get(i).getText();
			if(SelectDate2.equalsIgnoreCase(day1)) {
				day.click();
				break;}}                                             //clicked on last week
		reportingpage.clickOnButton(); 	
		Thread.sleep(4000);
		String totalNetSaleInDailySalesReport=reportingpage.getTotalNetSale();
		Thread.sleep(3000);
		System.out.println("Total sales in the daily sales report is : "+totalNetSaleInDailySalesReport);
		Assert.assertEquals(totalNetSaleInByDevice, totalNetSaleInDailySalesReport);
		System.out.println("In both report, total net sale are equal - Test Case Pass");
	}
	@Test(priority=7, enabled=true)
	public void validateDownloadByDeviceSalesSummeryReport() throws InterruptedException{
		reportingpage.clickOnByDevice();
		Thread.sleep(2000);
		String SelectDate="Today";
		reportingpage.clickOnFilterForInSummeryReport();
		for(int i = 0; i<reportingpage.totalDateSelector();i++) {      
			WebElement day=reportingpage.getElementDateSelector().get(i);
			String day1=reportingpage.getElementDateSelector().get(i).getText();
			if(SelectDate.equalsIgnoreCase(day1)) {
				day.click();
				break;
			}
		} 
		reportingpage.clickOnArrowButtonInSummeryReport();
		Thread.sleep(4000);    		
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
	@Test(priority=8, enabled=true)
	public void validateDownloadByCashierSalesSummeryReport() throws InterruptedException{
		reportingpage.clickOnByCashier();
		Thread.sleep(2000);
		String SelectDate="Today";
		reportingpage.clickOnFilterForInSummeryReport();
		for(int i = 0; i<reportingpage.totalDateSelector();i++) {      
			WebElement day=reportingpage.getElementDateSelector().get(i);
			String day1=reportingpage.getElementDateSelector().get(i).getText();
			if(SelectDate.equalsIgnoreCase(day1)) {
				day.click();
				break;
			}
		} 
		reportingpage.clickOnArrowButtonInSummeryReport();
		Thread.sleep(4000);    		
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
	@Test(priority=9, enabled=false)
	public void validateTotalSaleInByCashier() throws InterruptedException {
		reportingpage.clickOnByCashier();
		Thread.sleep(2000);

		double sum=0;
		String SelectDate="Last Week";
		for(int a=0; a<1;a++) {
		reportingpage.clickOnFilterFor();             //clicked on filter for
		for(int i = 0; i<reportingpage.totalDateSelector();i++) {      
			WebElement cashierId=reportingpage.getElementDateSelector().get(i);
			cashierId.click();
			Thread.sleep(2000);
			
			reportingpage.clickOnFilterForInSummeryReport();
			for(int j = 0; j<reportingpage.totalDateSelector();j++) {      
				WebElement day=reportingpage.getElementDateSelector().get(j);
				String day1=reportingpage.getElementDateSelector().get(j).getText();
				if(SelectDate.equalsIgnoreCase(day1)) {
					day.click();
					reportingpage.clickOnArrowButtonInSummeryReport();
					Thread.sleep(2000);	
				}
			}
			String totalSales=reportingpage.getTotalSales();	
			System.out.println(totalSales);	
			sum=sum+Double.parseDouble(totalSales);
		}
		}
			int value2=(int)sum;
			System.out.println("Total sales in the cashier report is : "+value2);				

			reportingpage.clickOnDailySalesReport();
			reportingpage.clickOnFilterFor();             //clicked on filter for
			String SelectDate2="Last Week";
			for(int k = 0; k<reportingpage.totalDateSelector();k++) {      
				WebElement day=reportingpage.getElementDateSelector().get(k);
				String day1=reportingpage.getElementDateSelector().get(k).getText();
				if(SelectDate2.equalsIgnoreCase(day1)) {
					day.click();
					break;
				}
			}                                     //clicked on last week
			reportingpage.clickOnButton(); 	
			Thread.sleep(2000);
			double totalSaleInDailySalesReport=Double.parseDouble(reportingpage.getTotalSales());
			int value1=(int)totalSaleInDailySalesReport;
			System.out.println("Total sales in the daily sales report is : "+value1);
			Assert.assertEquals(value2, totalSaleInDailySalesReport);
			System.out.println("In both report, total sales are equal - Test Case Pass");
		

	}
		@Test(priority=10, enabled=false)
		public void validateRefundSalesInByCashier() throws InterruptedException {
			reportingpage.clickOnByCashier();
			String SelectDate="Last Week";
			for(int i = 0; i<reportingpage.totalDateSelector();i++) {      
				WebElement day=reportingpage.getElementDateSelector().get(i);
				String day1=reportingpage.getElementDateSelector().get(i).getText();
				if(SelectDate.equalsIgnoreCase(day1)) {
					day.click();
					break;
				}
			} 
			String refundSaleInByCashier=reportingpage.getRefundSale();
			System.out.println("Total Refund in the by cashier report is : "+refundSaleInByCashier);
			reportingpage.clickOnDailySalesReport();
			reportingpage.clickOnFilterFor();             //clicked on filter for
			String SelectDate2="Last Week";
			for(int i = 0; i<reportingpage.totalDateSelector();i++) {      
				WebElement day=reportingpage.getElementDateSelector().get(i);
				String day1=reportingpage.getElementDateSelector().get(i).getText();
				if(SelectDate2.equalsIgnoreCase(day1)) {
					day.click();}}                                             //clicked on last week
			reportingpage.clickOnButton(); 	
			Thread.sleep(2000);

			String totalRefundInDailySalesReport=reportingpage.getRefundSale();
			System.out.println("Total refund in the daily sales report is : "+totalRefundInDailySalesReport);

			Assert.assertEquals(refundSaleInByCashier, totalRefundInDailySalesReport);
			System.out.println("In both report, total refund are equal - Test Case Pass");
		}
		@Test(priority=11, enabled=false)
		public void validateTotalGrossSaleInByCashier() throws InterruptedException {
			reportingpage.clickOnByCashier();
			String SelectDate="Last Week";
			for(int i = 0; i<reportingpage.totalDateSelector();i++) {      
				WebElement day=reportingpage.getElementDateSelector().get(i);
				String day1=reportingpage.getElementDateSelector().get(i).getText();
				if(SelectDate.equalsIgnoreCase(day1)) {
					day.click();
					break;
				}
			} 
			String totalGrossSaleInByCashier=reportingpage.getGossSale();
			System.out.println("Total gross sales in the by cashier report is : "+totalGrossSaleInByCashier);
			reportingpage.clickOnDailySalesReport();
			reportingpage.clickOnFilterFor();             //clicked on filter for
			String SelectDate2="Last Week";
			for(int i = 0; i<reportingpage.totalDateSelector();i++) {      
				WebElement day=reportingpage.getElementDateSelector().get(i);
				String day1=reportingpage.getElementDateSelector().get(i).getText();
				if(SelectDate2.equalsIgnoreCase(day1)) {
					day.click();
					break;}}                                             //clicked on last week
			reportingpage.clickOnButton(); 	
			Thread.sleep(2000);

			String totalGrossSaleInDailySalesReport=reportingpage.getGossSale();
			System.out.println("Total gross sales in the daily sales report is : "+totalGrossSaleInDailySalesReport);

			Assert.assertEquals(totalGrossSaleInByCashier, totalGrossSaleInDailySalesReport);
			System.out.println("In both report, total gross sales are equal - Test Case Pass");
		}
		@Test(priority=12, enabled=false)
		public void validateTotalTaxInByCashier() throws InterruptedException {
			reportingpage.clickOnByCashier();
			String totalTaxInByCashier=reportingpage.getTotalTax();
			System.out.println("Total tax in the by cashier report is : "+totalTaxInByCashier);
			reportingpage.clickOnDailySalesReport();
			reportingpage.clickOnFilterFor();             //clicked on filter for
			String SelectDate="Today";
			for(int i = 0; i<reportingpage.totalDateSelector();i++) {      
				WebElement day=reportingpage.getElementDateSelector().get(i);
				String day1=reportingpage.getElementDateSelector().get(i).getText();
				if(SelectDate.equalsIgnoreCase(day1)) {
					day.click();
					break;}}                                             //clicked on last week
			reportingpage.clickOnButton(); 	
			Thread.sleep(2000);

			String totalTaxDailySalesReport=reportingpage.getTotalTax();
			System.out.println("Total tax in the daily sales report is : "+totalTaxDailySalesReport);

			Assert.assertEquals(totalTaxInByCashier, totalTaxDailySalesReport);
			System.out.println("In both report, total tax are equal - Test Case Pass");
		}
		@Test(priority=13, enabled=false)
		public void validateTotalDiscountInByCashier() throws InterruptedException {
			reportingpage.clickOnByCashier();
			String totalDiscountInByCashier=reportingpage.getTotalDiscount();
			System.out.println("Total discount in the by cashier report is : "+totalDiscountInByCashier);
			reportingpage.clickOnDailySalesReport();
			reportingpage.clickOnFilterFor();             //clicked on filter for
			String SelectDate="Today";
			for(int i = 0; i<reportingpage.totalDateSelector();i++) {      
				WebElement day=reportingpage.getElementDateSelector().get(i);
				String day1=reportingpage.getElementDateSelector().get(i).getText();
				if(SelectDate.equalsIgnoreCase(day1)) {
					day.click();
					break;}}                                             //clicked on last week
			reportingpage.clickOnButton(); 	
			Thread.sleep(2000);


			String totalDiscountDailySalesReport=reportingpage.getTotalDiscount();
			System.out.println("Total discount in the daily sales report is : "+totalDiscountDailySalesReport);

			Assert.assertEquals(totalDiscountInByCashier, totalDiscountDailySalesReport);
			System.out.println("In both report, total discount are equal - Test Case Pass");
		}
		@Test(priority=14, enabled=false)
		public void validateTotalNetSaleInByCashier() throws InterruptedException {
			reportingpage.clickOnByCashier();
			String totalNetSaleInByCashier=reportingpage.getTotalNetSale();
			System.out.println("Total net sale in the by cashier report is : "+totalNetSaleInByCashier);
			reportingpage.clickOnDailySalesReport();
			reportingpage.clickOnFilterFor();             //clicked on filter for
			String SelectDate="Today";
			for(int i = 0; i<reportingpage.totalDateSelector();i++) {      
				WebElement day=reportingpage.getElementDateSelector().get(i);
				String day1=reportingpage.getElementDateSelector().get(i).getText();
				if(SelectDate.equalsIgnoreCase(day1)) {
					day.click();
					break;}}                                             //clicked on last week
			reportingpage.clickOnButton(); 	
			Thread.sleep(2000);


			String totalNetSaleInDailySalesReport=reportingpage.getTotalNetSale();
			System.out.println("Total sales in the daily sales report is : "+totalNetSaleInDailySalesReport);

			Assert.assertEquals(totalNetSaleInByCashier, totalNetSaleInDailySalesReport);
			System.out.println("In both report, total net sale are equal - Test Case Pass");
		}
	}
