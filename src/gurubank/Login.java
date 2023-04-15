package gurubank;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.demo.guru99.com/V4/");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.name("uid")).sendKeys("mngr493349");
		driver.findElement(By.name("password")).sendKeys("pApEsYt");
		driver.findElement(By.name("btnLogin")).click();
		String expected=" Guru99 Bank Manager HomePage ";
		String actual=driver.getTitle();
		System.out.println(actual);
		if(actual.equalsIgnoreCase(expected.trim()))
		{
			System.out.println("login successful");
		}
		else
		{
			System.out.println("login failed");
		}
		Thread.sleep(5000);
		driver.close();
		String path=System.getProperty("user.dir");
		System.out.println(path);
	}

}
