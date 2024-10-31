package pagepackage;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart {
WebDriver driver;
@FindBy(xpath="//*[@id=\"cartur\"]") 
WebElement cartbtn;

public Cart(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
public void clickCart() throws InterruptedException
{
	cartbtn.click();
	Thread.sleep(1000);
	driver.navigate().back();
}
public void takescreenshot()throws IOException
{
	
	
	  
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileHandler.copy(src,new File("C:/Users/user/eclipse-workspace/project_main/logindetails/screen1.png"));

}
}
