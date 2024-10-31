package pagepackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutUs {
	@FindBy(xpath="//*[@id=\"navbarExample\"]/ul/li[3]/a")
	WebElement aboutus_link;
	
	@FindBy(xpath="//*[@id=\"videoModal\"]/div/div/div[3]/button")
	WebElement closebtn;
	
    WebDriver driver;
	
	public AboutUs(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void playVideo() throws InterruptedException
	{
		aboutus_link.click();
		Thread.sleep(1000);
		closebtn.click();
		
	}
	
}