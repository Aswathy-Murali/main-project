package pagepackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	WebDriver driver;
	 
	@FindBy(xpath="/html/body/nav/div[1]/ul/li[6]/a")
	WebElement logoutlink;
	
	public LogoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public void logoutpage() throws InterruptedException {
		Thread.sleep(1000);
		logoutlink.click();
		
	}

}
