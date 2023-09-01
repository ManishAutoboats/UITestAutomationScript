package helper;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class base {

	public static Properties pro;
	public static WebDriver driver;
	static {

		try {
			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java/resource/env.properties");
			pro = new Properties();
			pro.load(file);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   //Need to fix issue
	}

	@Before
	public void setup() {

		String browserName = pro.getProperty("browser");
		if (browserName.equals("Chrome")) {
			ChromeOptions options=new ChromeOptions();
			options.addArgument("detach",true);
			 driver = new ChromeDriver(options);
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();

			driver.get(pro.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
	}

	@After
	public void tearDown(Scenario s) throws IOException {
		if (s.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File("Screenshots" + s.getName() + ".png"));
		}
		driver.quit();
	}

	public void selectBootstrapDown(List<WebElement> list, String expectedValue) {
		for (WebElement e : list) {
			String s = e.getText();
			if (s.equals("expectedValue")) {
				e.click();
				break;
			}
		}

	}

}
