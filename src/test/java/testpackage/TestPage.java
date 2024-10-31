package testpackage;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pagepackage.AboutUs;
import pagepackage.Cart;
import pagepackage.ContactUs;
import pagepackage.Login;
import pagepackage.LogoutPage;
import pagepackage.SignUp;

public class TestPage {
	WebDriver driver;
	
@BeforeTest
public void setUp()
{
driver=new ChromeDriver();
driver.get("https://www.demoblaze.com/index.html");
}

@Test(priority=1)
public void contactusPage() throws InterruptedException
{
	ContactUs obj_contact=new ContactUs(driver);
	obj_contact.contactPage();
	obj_contact.sendMessage("aswa@gmail.com","Aswaty M","New user , Very old collection of laptops");
}
@Test(priority=2)
public void aboutUs() throws InterruptedException
{
	AboutUs obj_about=new AboutUs(driver);
	obj_about.playVideo();
	
}
@Test(priority=3)
public void cartPage() throws InterruptedException, IOException
{
	Cart cart_obj=new Cart(driver);
	cart_obj.clickCart();
	cart_obj.takescreenshot();
}

@Test(priority=5)
public void loginpage() throws InterruptedException, IOException
{
	Login login_obj=new Login(driver);
	login_obj.loginpage();	

}

@Parameters({"username","password"})
@Test(priority=4)
public void signupPage(String username,String password)throws InterruptedException
{
	SignUp sign_obj=new SignUp(driver);
	sign_obj.signuppage(username,password);
	
}



@Test(priority=6)
public void logoutpage() throws InterruptedException
{
	LogoutPage logout=new LogoutPage(driver);
	logout.logoutpage();
}

}
