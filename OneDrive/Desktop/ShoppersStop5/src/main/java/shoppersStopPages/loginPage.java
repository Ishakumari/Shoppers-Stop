package shoppersStopPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import shoppersStopBase.TestBase;


public class loginPage extends TestBase {
	
	public loginPage() {
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//input[@name=\"EmployeeID\"]")
	WebElement employeeID;
	@FindBy(xpath="//input[@name=\"password\"]")
	WebElement password;
	@FindBy(xpath="//button[@type=\"button\"]")
	WebElement loginButton;
	@FindBy(xpath="//h4[@class=\"MuiTypography-root MuiTypography-h4 MuiTypography-colorTextPrimary MuiTypography-gutterBottom\"]")
	WebElement headerOnLoginScreen;
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div/div/div/div[1]/div/div[1]/p")
	WebElement paragraph;
	@FindBy(xpath="//div[contains(text(), 'SHOPPERS STOP ADMIN')]")
	WebElement header;
	
	@FindBy(xpath="//span[@class=\"MuiButton-label\"]")
	WebElement viewBox;
	@FindBy(xpath="//span[contains(text(), 'Logout')]")
	WebElement logout;
	
	public void enterEmloyeeID(String ID) {
		 employeeID.sendKeys(ID);
	}
public void enterPassword(String pwd) {
	password.sendKeys(pwd);
	}
public void clickOnLoginButton() {
	loginButton.click();
}
public String getHeader() {
	 return header.getText();
}
public void clickOnViewBox() {
	viewBox.click();
}
public void clickOnLogout() {
	logout.click();
}
public String getHeaderOnLoginScreen() {
	return headerOnLoginScreen.getText();
}
}
