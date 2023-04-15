package e_cart;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Techpandamobile {

	public static void main(String[] args) throws Throwable {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://live.techpanda.org/index.php/");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		if("Home page".equalsIgnoreCase(driver.getTitle()))
		{
			System.out.println("Home page Title is matched");
		}
		else
		{
			System.out.println(" Home page Title is not matched");
		}
		driver.findElement(By.xpath("//a[.='Mobile']")).click();

		if("Mobile".equalsIgnoreCase(driver.getTitle()))
		{
			System.out.println("Mobile page Title is matched");
		}
		else
		{
			System.out.println(" Mobile page Title is not matched");
		}
		Select s=new Select(driver.findElement(By.xpath("(//select[@title='Sort By'])[1]")));
		s.selectByVisibleText("Name");
		Date d=new Date();
		DateFormat df=new SimpleDateFormat("dd/MMM/YYYY hh:mm:ss");
		String date=df.format(d);
		System.out.println(date);

		Actions act=new Actions(driver);
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ARROW_DOWN).perform();
		
		Thread.sleep(3000);
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File f=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f,new File("D:\\screenshots\\mobile.png"));
		
		Thread.sleep(3000);
		driver.close();
	}

}
