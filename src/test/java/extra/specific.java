package extra;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class specific {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--headless=new");
		
		WebDriver driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
	
		WebElement ts=driver.findElement(By.xpath("(//div[@class='category-item'])[3]"));
		
		File sourcepath=ts.getScreenshotAs(OutputType.FILE);
		
		File targetpath=new File(System.getProperty("user.dir")+"//screenshot//ggassas.png");
		
		sourcepath.renameTo(targetpath);
		

		



	}

}
