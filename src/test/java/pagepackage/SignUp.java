package pagepackage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUp {
	@FindBy(xpath="//*[@id=\"signin2\"]")
	WebElement signuplink;
	
	@FindBy(xpath="//*[@id=\"sign-username\"]")
	WebElement username;
	@FindBy(xpath="//*[@id=\"sign-password\"]")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")
	WebElement signupbtn;
	
	@FindBy(xpath="//*[@id=\"signInModal\"]/div/div/div[3]/button[1]")
	WebElement closebtn;
	
	
	WebDriver driver;
	public SignUp(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void signuppage(String username1,String password1) throws InterruptedException  {
		signuplink.click();
		username.sendKeys(username1);
		password.sendKeys(password1);
		signupbtn.click();
		Thread.sleep(1000);
		Alert ref=driver.switchTo().alert();
		ref.accept();
		closebtn.click();
		
		}
}
