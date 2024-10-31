package pagepackage;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.openqa.selenium.io.FileHandler;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Login {
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"login2\"]")
	WebElement loginlink;
	
	@FindBy(xpath="//input[@id=\"loginusername\"]")
	WebElement username1;
	@FindBy(xpath="//input[@id=\"loginpassword\"]")
	WebElement password1;
	
	@FindBy(xpath="//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")
	WebElement loginbtn;
	
	@FindBy(xpath="//*[@id=\"logInModal\"]/div/div/div[3]/button[1]")
	WebElement closebtn;
	

	
	public Login(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void loginpage() throws InterruptedException, IOException
	{
		loginlink.click();		
		FileInputStream io=new FileInputStream("C:/Users/user/eclipse-workspace/project_main/logindetails/logindata.xlsx");
		try (XSSFWorkbook wb = new XSSFWorkbook(io)) {
			XSSFSheet sh=wb.getSheet("Sheet1");
			int row=sh.getLastRowNum();
			for(int i=1;i<=row;++i) {
				String username=sh.getRow(i).getCell(0).getStringCellValue();
				String password=sh.getRow(i).getCell(1).getStringCellValue();		
				username1.sendKeys(username);
				password1.sendKeys(password);
				loginbtn.click();		

			Thread.sleep(1000);
			Alert ref=driver.switchTo().alert();
			ref.accept();
			Thread.sleep(1000);
			username1.clear();
			password1.clear();
			}
		}
		
		String expurl="https://www.demoblaze.com/index.html";
		String actualurl=driver.getCurrentUrl();
		Assert.assertEquals(expurl, actualurl);
		closebtn.click();
		Thread.sleep(1000);
		
	}

	
	
}