package e_cart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class verifycostinlistpageanddetailspage {

	public static void main(String[] args) throws Throwable {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://live.techpanda.org/index.php/");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[.=\"Mobile\"]")).click();
		String cost1=driver.findElement(By.xpath("(//span[@class='price'])[3]")).getText();
		System.out.println(cost1);
		driver.findElement(By.xpath("//a[@title='Xperia']")).click();
		String cost2=driver.findElement(By.xpath("//span[@class='price']")).getText();
		System.out.println(cost2);
		if(cost1.equals(cost2))
		{
			System.out.println("cost of product in list page and details page are equal");
		}
		else
		{
			System.out.println("cost of product in list page and details page are not equal");
		}
		Thread.sleep(3000);
		driver.close();
}
}
