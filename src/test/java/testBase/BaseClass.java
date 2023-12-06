package testBase;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass 

{
	static public WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass(groups = {"sanity", "regression","master"})
	@Parameters({"os", "browser"})
	public void setUp(String os, String br) throws IOException
	{
		//--------Loading Properties File---------------
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		
		
		//---------Loading log4j2 xml file-----------
		
		logger = LogManager.getLogger(this.getClass());
		
		//--------Remote Machine --Browser and OS Setup--------
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities Cap = new DesiredCapabilities();
			
			//-------------Set OS ----------------
			if(os.equals("Windows"))
			{
				Cap.setPlatform(Platform.WIN11);
			}
			
			else if(os.equalsIgnoreCase("mac"))
			{
				Cap.setPlatform(Platform.MAC);
			}
			
			else
			{
				System.out.println("No OS matched....");
				return;
			}
			
			//-------------Set Browser-------------
			switch(br.toLowerCase())
			{
			case "chrome": Cap.setBrowserName("chrome");break;
			case "edge" : Cap.setBrowserName("MicrosoftEdge");break;
			default: System.out.println("Matching Browser is not found"); return;
			}
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), Cap);
			
		}
		
		//--------Local Machine-------selecting the browser------------
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
		
			switch(br.toLowerCase())
			{
			case "chrome": 	driver = new ChromeDriver();break;
			case "edge" :	driver = new EdgeDriver(); break;
			default: System.out.println("Matching Browser is not found"); return;
			}
			
		}
			
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(p.getProperty("appURL"));
			driver.manage().window().maximize();
		
		
	}
	
	@AfterClass (groups = {"sanity", "regression","master"})
	public void tearDown()
	{
		driver.quit();
	}
	
	
	//-------Methods to call random data------------
	public String randomeString()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomeNumber()
	{
		String generatedString = RandomStringUtils.randomNumeric(5);
		return generatedString;
	}
	
	public String randomeAlphaNumeric()
	{
		String str = RandomStringUtils.randomAlphabetic(3);
		String num = RandomStringUtils.randomNumeric(3);
		return (str+"@"+num);
		
	}
	

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	

}

