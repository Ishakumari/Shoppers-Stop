package shoppersStopPages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import shoppersStopBase.TestBase;


public class reportingPage extends TestBase{
	public reportingPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//tbody[@class=\"MuiTableBody-root\"]/tr")
	WebElement multiRow;
	@FindBy(xpath="//p[contains(text(),'Reporting')]")
	WebElement reporting;
	@FindBy(xpath="//p[contains(text(),'Daily Sales Report')]")
	WebElement dailySalesReport;
	@FindBy(xpath="//tbody/tr/td[1]")
	List<WebElement> firtRow;
	@FindBy(xpath="//tbody/tr/td[2]")
	List<WebElement> secondRow;
	@FindBy(xpath="//span[@class=\"material-icons MuiIcon-root\"]")
	WebElement export;
	@FindBy(xpath="//li[@role=\"menuitem\"]")
	WebElement exportAsExcel;
	@FindBy(xpath="//div[@id='demo-simple-select']")
	WebElement filterFor;
	@FindBy(xpath="//body/div[@id='menu-']/div[3]/ul[1]/li[3]")
	WebElement lastWeek;
	@FindBy(xpath="//body/div[@id='menu-']/div[3]/ul[1]/li[2]")
	WebElement yesterday;
	@FindBy(xpath="//body/div[@id='root']/div[1]/main[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/button[1]")
	WebElement button;
	
	@FindBy(xpath="//tbody/tr[1]/td[2]")
	WebElement totalSales;
	@FindBy(xpath="//tbody/tr[2]/td[2]")
	WebElement refundSale;
	@FindBy(xpath="//tbody/tr[3]/td[2]")
	WebElement grossSale;
	@FindBy(xpath="//tbody/tr[4]/td[2]")
	WebElement totalTax;
	@FindBy(xpath="//tbody/tr[5]/td[2]")
	WebElement totalDiscount;
	@FindBy(xpath="//tbody/tr[6]/td[2]")
	WebElement NetSale;
	@FindBy(xpath="//tbody/tr[7]/td[2]")
	WebElement totalCheckCount;
	//Void Report
	@FindBy(xpath="//p[contains(text(),'Void Report')]")
	WebElement VoidReport;
	@FindBy(xpath="//tbody/tr/td[6]")
	List<WebElement> invoiceAmountinVoidreport;
	
	//invoiceReport
	@FindBy(xpath="//tr/td[10]")
	List<WebElement> listofGrossSale;
	@FindBy(xpath="//tr/td[9]")
	List<WebElement> tax;
	@FindBy(xpath="//tr/td[8]")
	List<WebElement> discount;
	@FindBy(xpath="//tr/td[7]")
	List<WebElement> netSale;
	@FindBy(xpath="//tr/td[1]")
	List<WebElement> checkCount;	
	@FindBy(xpath="//input[@placeholder=\"Search\"]")
	WebElement searchBox;
	@FindBy(xpath="//*[@class=\"MuiSelect-root MuiSelect-select MuiTablePagination-select MuiSelect-selectMenu MuiInputBase-input\"]")
	WebElement pagination;
//	@FindBy(xpath="")
//	List<WebElement> selectNoOfOrder;
	@FindBy(xpath="//li[@role=\"option\"]")
	List<WebElement> dateSelector;
	@FindBy(xpath="//p[contains(text(),'Invoice Report')]")
	WebElement invoiceReport;
	@FindBy(xpath="//tbody/tr[1]/td[5]")
	WebElement invoiceNo;
	
	// Sales Summery Report
	@FindBy(xpath="//p[contains(text(),'Sales Summary Report')]")
	WebElement salesSummeryReport;
	@FindBy(xpath="//p[contains(text(),'By Device')]")
	WebElement byDevice;
	@FindBy(xpath="//p[contains(text(),'By Cashier')]")
	WebElement byCashier;
	@FindBy(xpath="/html/body/div[1]/div/main/div[2]/div/div/div[1]/div[2]/div[2]/div/div/div")
	WebElement filterForInSummeryReport;
	@FindBy(xpath="//*[@id=\"root\"]/div/main/div[2]/div/div/div[1]/div[2]/div[3]/div/button/span[1]")
	WebElement arrowButtonInSummeryReport;
	
	//Hourly Sales Report
	@FindBy(xpath="//p[contains(text(),'Hourly Sales Report')]")
	WebElement hourlySalesReport;
	@FindBy(xpath="//tr/td[2]")
	List<WebElement> totalCheck;
	@FindBy(xpath="//tr/td[3]")
	List<WebElement> netSales;
	@FindBy(xpath="//tr/td[4]")
	List<WebElement> grossSales;
	@FindBy(xpath="//tr/td[5]")
	List<WebElement> percentage;
	@FindBy(xpath="//div[contains(text(),'Hourly Sales Report')]")
	WebElement headerOfHourlySalesReport;
	

	public void clickOnReporting() {
		reporting.click();
	}
	public void clickOnDailySalesReport() {
		dailySalesReport.click();
	}
	public int totalRowSize() {
		return firtRow.size();
	}
	public List<WebElement>  getColumnFirstdata() {
		List<WebElement> element=firtRow;
		return element;
	}
	public List<WebElement>  getColumnSeconddata() {
		List<WebElement> element=secondRow;
		return element;
	}
	public void clickOnExport() {
		export.click();
	}
	public void clickOnExportAsExcel() {
		exportAsExcel.click();
	}
public void clickOnFilterFor() {
	filterFor.click();
}
public void clickOnlastWeek() {
	lastWeek.click();
}
public void clickOnYesterday() {
	yesterday.click();
}
public void clickOnButton() {
	button.click();
}
public String getTotalSales() {
	return totalSales.getText();
}
public String getRefundSale() {
	return refundSale.getText();
}
public String getGossSale() {
	return grossSale.getText();
}
public String getTotalTax() {
	return totalTax.getText();
}
public String getTotalDiscount() {
	return totalDiscount.getText();
}
public String getTotalNetSale() {
	return NetSale.getText();
}
public String getTotalCheckCount() {
	return totalCheckCount.getText();
}
public void clickOnVoidReport() {
	VoidReport.click();
}
public int totalVoidOrder() {
	return invoiceAmountinVoidreport.size();
}
public List<WebElement> getElementVoidOrder() {
	List<WebElement> element=invoiceAmountinVoidreport;
	return element;
}
public List<WebElement> getElementGrossSale() {
	List<WebElement> element=listofGrossSale;
	return element;
}
public int grossSaleCount() {
	return listofGrossSale.size();
}
public int taxCount() {
	return tax.size();
}
public List<WebElement> getElementTax() {
	List<WebElement> element=tax;
	return element;
}
public int discountCount() {
	return discount.size();
}
public List<WebElement> getElementDiscount() {
	List<WebElement> element=discount;
	return element;
}
public int netSaleCount() {
	return netSale.size();
}
public List<WebElement> getElementNetSale() {
	List<WebElement> element=netSale;
	return element;
}
public String enterOrderInSearch(String order) {
	searchBox.sendKeys(order);
	return order;
}
public List<WebElement> getElementDateSelector() {
	List<WebElement> element=dateSelector;
	return element;
}
public int totalDateSelector() {
	return dateSelector.size();
}
public List<WebElement> getElementCheckCount() {
	List<WebElement> element=checkCount;
	return element;
}
public int CheckCount() {
	return checkCount.size();
}

public void clickOnInvoiceReport() {
	invoiceReport.click();
}
public String getInvoiceNo() {
	return invoiceNo.getText();
}
public void clickOnPagination() {
	pagination.click();
}

public void clickOnSalesSummeryReport() {
	salesSummeryReport.click();
}
public void clickOnByDevice() {
	byDevice.click();
}
public void clickOnByCashier() {
	byCashier.click();
}
public void clickOnFilterForInSummeryReport() {
	filterForInSummeryReport.click();
}
public void clickOnArrowButtonInSummeryReport() {
	arrowButtonInSummeryReport.click();
}
public void clickOnHourlySalesReport() {
	hourlySalesReport.click();
}
public void getHeaderOfHourlySalesReport() {
	headerOfHourlySalesReport.getText();
}
public List<WebElement> getElementTotalCheck() {
	List<WebElement> element=totalCheck;
	return element;
}
public int TotalCheck() {
	return totalCheck.size();
}
public List<WebElement> getElementTotalNetSales() {
	List<WebElement> element=netSales;
	return element;
}
public int TotalNetSales() {
	return netSales.size();
}
public List<WebElement> getElementTotalGrossSales() {
	List<WebElement> element=grossSales;
	return element;
}
public int TotalGrossSales() {
	return grossSales.size();
}
public List<WebElement> getElementTotalPercentage() {
	List<WebElement> element=percentage;
	return element;
}
public int TotalPercentage() {
	return percentage.size();
}
}
