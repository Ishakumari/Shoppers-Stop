package shoppersStopBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

	public static WebDriver driver;
	//public static File folder;
@BeforeSuite
	public static void initialize() throws InterruptedException {

		//folder=new File(UUID.randomUUID().toString());
		//folder.mkdir();

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Cravrr\\OneDrive\\Desktop\\ShoppersStop\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();



		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://ssadmin.cravrr.com/");
	}
@AfterSuite
public void tearDown(){
driver.quit();
}

}


