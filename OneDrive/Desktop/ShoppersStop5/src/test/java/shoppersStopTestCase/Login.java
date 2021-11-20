package shoppersStopTestCase;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import shoppersStopBase.TestBase;
import shoppersStopPages.loginPage;

public class Login extends TestBase{
	public loginPage loginpage;
	
	@BeforeTest
	public void setUp() throws InterruptedException{
     loginpage=new loginPage();
	}
	
	@Test(priority=1)
	public void validateLoginfunctionality() throws InterruptedException {
		String HeaderOnDashboard="SHOPPERS STOP ADMIN";
		loginpage.enterEmloyeeID("7010014");
		Thread.sleep(2000);

		System.out.println("Employee Id has been entered");
		loginpage.enterPassword("123456");
		System.out.println("Password entered");
		Thread.sleep(2000);

		loginpage.clickOnLoginButton();
		Thread.sleep(2000);
		System.out.println("Clicked on login button");
		String header=loginpage.getHeader();
		System.out.println("Header on the dashboard is:" +header);
		Assert.assertEquals(HeaderOnDashboard, header);
		System.out.println("Login Test Case Pass");
	}
	@Test(priority=2)
	public void ValidateLogoutfunctionality() throws InterruptedException {
		Thread.sleep(2000);
		String headerOnLoginScreen="Sign in";
		//loginpage.clickOnViewBox();
		//Thread.sleep(2000);
		loginpage.clickOnViewBox();
		Thread.sleep(2000);
		System.out.println("Clicked On View Box");
		loginpage.clickOnLogout();
		Thread.sleep(1000);
		System.out.println("Clicked On Logout");
		String headerOnLoginScreen1=loginpage.getHeaderOnLoginScreen();
		System.out.println("Header on the login page: " +loginpage.getHeaderOnLoginScreen());
		if(headerOnLoginScreen.equalsIgnoreCase(headerOnLoginScreen1)){
			System.out.println("Logout successfully and Test Case Pass");

		}
	}


	

}
