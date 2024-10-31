package pagepackage;


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUs {
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"navbarExample\"]/ul/li[2]/a")
	WebElement contactus_link;
	
	@FindBy(xpath="//*[@id=\"recipient-email\"]")
	WebElement contactus_email;
	
	@FindBy(id="recipient-name")
	WebElement contactus_name;
	
	@FindBy(id="message-text")
	WebElement contactus_message;
	
	
	@FindBy(xpath="//*[@id=\"exampleModal\"]/div/div/div[3]/button[2]")
	WebElement sendButton;
	
	
	public ContactUs(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void contactPage()
	{
		contactus_link.click();
		
	}
	public void sendMessage(String email,String name,String msg) throws InterruptedException {
		
		contactus_email.sendKeys(email);
		Thread.sleep(1000);
		contactus_name.sendKeys(name);
		Thread.sleep(1000);
		contactus_message.sendKeys(msg);
		sendButton.click();
		Thread.sleep(1000);
		 Alert ref=driver.switchTo().alert();
		    ref.accept();
		    Thread.sleep(1000);
	}

	
	
}


