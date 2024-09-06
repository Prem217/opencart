package extra;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class screenshot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		
		String timestamp=new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
		
		
		TakesScreenshot takesscreenshot=(TakesScreenshot)driver;
		File sourcepath=takesscreenshot.getScreenshotAs(OutputType.FILE);	

		
		File targetpath=new File(System.getProperty("user.dir")+"\\screenshot\\test" + timestamp + ".png");
		

		
		sourcepath.renameTo(targetpath);
		

	}

}
