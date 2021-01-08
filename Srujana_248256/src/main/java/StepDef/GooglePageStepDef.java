package StepDef;
import java.util.List;
//import java.io.FileNotFoundException;
//import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import cucumber.api.DataTable;
//import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GooglePageStepDef 
{
    static Properties prop;
	WebDriver driver;
	
   @Given("^User Login$")
   public void User_Login(DataTable credentials) throws Throwable 
   {
	   String title="Hotel Booking Application";
       System.setProperty("webdriver.chrome.driver","C:\\Users\\ELCOT\\Downloads\\chromedriver_win32\\chromedriver.exe");
       driver=new ChromeDriver();
  	   driver.get(System.getProperty("user.dir")+"\\Resources\\login.html");
  	 
  	   driver.manage().window().maximize();
      
  	   WebElement  heading =driver.findElement(By.xpath("//h1[contains(text(),'Hotel Booking Application')]"));
       String s=heading.getText();
	   Assert.assertEquals(s, title);	   
       System.out.println("Login Page Title Success");
    
       //Getting invalid inputs
	   List<List<String>> data = credentials.raw();
       driver.findElement(By.name("userName")).sendKeys(data.get(0).get(0)); 
       System.out.println("User name entered is : "+data.get(0).get(0));
       driver.findElement(By.className("btn")).click();
       Thread.sleep(200);
       
       driver.findElement(By.name("userName")).sendKeys(data.get(0).get(1)); 
       System.out.println("User name entered is : "+data.get(0).get(1));
       driver.findElement(By.className("btn")).click();
       Thread.sleep(200);
       
       
       driver.findElement(By.name("userPwd")).sendKeys(data.get(1).get(1)); 
       driver.findElement(By.className("btn")).click();
       Thread.sleep(200);
       
       driver.findElement(By.name("userPwd")).sendKeys(data.get(1).get(0)); 
       driver.findElement(By.className("btn")).click();
       Thread.sleep(200);
       
       System.out.println("User Login Success");
    }
   
   @When("^User entered valid credentials$")
   public void User_entered_valid_credentials(DataTable roombooking) throws Throwable
   {
   	   driver.manage().window().maximize();
   	   String title = "Hotel Booking";
       System.out.println("User is in Home Page");
       if(driver.getTitle().equalsIgnoreCase(title))
          {
        	System.out.println("Home Page Title succes");
          }
       List<List<String>> data = roombooking.raw();
       
       driver.findElement(By.className("btn")).click();
       Alert alert1 = driver.switchTo().alert();
       System.out.println("Alert message for First name:" +alert1.getText());
       Thread.sleep(200);
       alert1.accept();
       
    
       driver.findElement(By.id("txtFirstName")).sendKeys(data.get(0).get(0));
       driver.findElement(By.className("btn")).click();
        alert1 = driver.switchTo().alert();
       System.out.println("Alert message for Last name:" +alert1.getText());
       Thread.sleep(200);
       alert1.accept();
       
       
       driver.findElement(By.id("txtLastName")).sendKeys(data.get(1).get(0));
       driver.findElement(By.className("btn")).click();
        alert1 = driver.switchTo().alert();
       System.out.println("Alert message for Email:" +alert1.getText());
       Thread.sleep(200);
       alert1.accept();
       
       driver.findElement(By.id("txtEmail")).sendKeys(data.get(2).get(0));
       driver.findElement(By.className("btn")).click();
        alert1 = driver.switchTo().alert();
       System.out.println("Alert message for invalid email address:" +alert1.getText());
       Thread.sleep(200);
       alert1.accept();
       
       driver.findElement(By.id("txtEmail")).clear();
       driver.findElement(By.id("txtEmail")).sendKeys(data.get(2).get(1));
       driver.findElement(By.className("btn")).click();
        alert1 = driver.switchTo().alert();
       System.out.println("Alert message for Phone Number:" +alert1.getText());
       Thread.sleep(200);
       alert1.accept();
              
       driver.findElement(By.id("txtPhone")).sendKeys(data.get(3).get(0));
       driver.findElement(By.className("btn")).click();
        alert1 = driver.switchTo().alert();
       System.out.println("Alert message for Invalid Phone Number:" +alert1.getText());
       Thread.sleep(200);
       alert1.accept();
       
       driver.findElement(By.id("txtPhone")).clear();
       driver.findElement(By.id("txtPhone")).sendKeys(data.get(3).get(1));
       driver.findElement(By.className("btn")).click();
        alert1 = driver.switchTo().alert();
       System.out.println("Alert message for Invalid Phone Number:" +alert1.getText());
       Thread.sleep(200);
       alert1.accept();
       
       driver.findElement(By.id("txtPhone")).clear();
       driver.findElement(By.id("txtPhone")).sendKeys(data.get(3).get(2));
       driver.findElement(By.className("btn")).click();
        alert1 = driver.switchTo().alert();
       System.out.println("Alert message for City:" +alert1.getText());
       Thread.sleep(200);
       alert1.accept();
       
       driver.findElement(By.cssSelector("body>div>div>form>table>tbody>tr:nth-child(6)>td:nth-child(2)>textarea")).sendKeys(data.get(4).get(0));
      
     
       WebElement element = driver.findElement(By.name("city"));
       Select drpCity=new Select(element);
       drpCity.selectByVisibleText((data.get(5).get(0)));
       driver.findElement(By.className("btn")).click();
        alert1 = driver.switchTo().alert();
       System.out.println("Alert message for State:" +alert1.getText());
       Thread.sleep(200);
       alert1.accept();  
       
       element =driver.findElement(By.name("state"));
       Select drpSt=new Select(element);
       drpSt.selectByVisibleText((data.get(6).get(0)));
       driver.findElement(By.className("btn")).click();
        alert1 = driver.switchTo().alert();
       System.out.println("Alert message for Number of Persons:" +alert1.getText());
       Thread.sleep(200);
       alert1.accept(); 
       
       element =driver.findElement(By.name("persons"));
       Select drpPs=new Select(element);
       drpPs.selectByVisibleText((data.get(7).get(0)));
       driver.findElement(By.className("btn")).click();
        alert1 = driver.switchTo().alert();
       System.out.println("Alert message for CardHolder Name:" +alert1.getText());
       Thread.sleep(200);
       alert1.accept();
       
       driver.findElement(By.id("txtCardholderName")).sendKeys(data.get(8).get(0));
       driver.findElement(By.className("btn")).click();
        alert1 = driver.switchTo().alert();
       System.out.println("Alert message for Debit Card Number:" +alert1.getText());
       Thread.sleep(200);
       alert1.accept();
       
       driver.findElement(By.id("txtDebit")).sendKeys(data.get(9).get(0));
       driver.findElement(By.className("btn")).click();
        alert1 = driver.switchTo().alert();
       System.out.println("Alert message for CVV:" +alert1.getText());
       Thread.sleep(200);
       alert1.accept();
       
       driver.findElement(By.id("txtCvv")).sendKeys(data.get(10).get(0));
       driver.findElement(By.className("btn")).click();
        alert1 = driver.switchTo().alert();
       System.out.println("Alert message for CVV:" +alert1.getText());
       Thread.sleep(200);
       alert1.accept();
       
       driver.findElement(By.id("txtMonth")).sendKeys(data.get(11).get(0));
       driver.findElement(By.className("btn")).click();
        alert1 = driver.switchTo().alert();
       System.out.println("Alert message for CVV:" +alert1.getText());
       Thread.sleep(200);
       alert1.accept();
       
       driver.findElement(By.id("txtYear")).sendKeys(data.get(12).get(0));
       driver.findElement(By.className("btn")).click();
       
      
       System.out.println("Booking Completed");
   }

       @Then("^Success$")
       public void Success()throws Throwable{
       String title = "Booking Completed!" ;
       WebElement  successpage =driver.findElement(By.xpath("//h1[contains(text(),'Booking Completed!')]"));
       String s1 = successpage.getText();
	   Assert.assertEquals(s1, title);	   
       System.out.println("Booking Success");
       
       
           driver.close();
       }
      
       }
