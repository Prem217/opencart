package Testbase;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;




public class baseclass {

	static public WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass(groups= {"sanity","regression","master"})
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException
	{
		
		
		FileReader file=new FileReader(".//src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
			
		logger=LogManager.getLogger(this.getClass());
	
		switch(br.toLowerCase())
		{
		case "chrome": driver=new ChromeDriver();
		break;
		case "edge": driver=new EdgeDriver();
		break;
		default:
			System.out.println("No matching Browser");
			return;
		}
		

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));
//		driver.get("http://localhost/opencart/upload/index.php?route=account/account");
		driver.manage().window().maximize();
		
	}

	@AfterClass(groups= {"sanity","regression","master"})
	public void Teardown()
	{
		driver.quit();
	}

	
	public String randomestring()
	{
		String genaratedstring=RandomStringUtils.randomAlphabetic(5);
		return genaratedstring;
		
	}
	
	public String randomnumber()
	{
		String genaratedstring=RandomStringUtils.randomNumeric(10);
		return genaratedstring;
		
	}
	
	public String randomalphanumeric()
	{
		String str=RandomStringUtils.randomAlphabetic(4);
		String num=RandomStringUtils.randomNumeric(2);
		return (str+"@"+num);
					
	}
	public String captureScreen(String tname)throws IOException 
	{
		String timestamp=new SimpleDateFormat("yyyyMMddhhss").format(new Date());
		
		TakesScreenshot takescreenshot=(TakesScreenshot) driver;
		File sourcefile= takescreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timestamp + ".png";
		File tragetFile=new File(targetFilePath);
		
		sourcefile.renameTo(tragetFile);
		
		return targetFilePath;
		
	}
	
	
	
	

}

