package Utilities;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SeleniumDriverUtilities {
	protected static WebDriver Driver;
	private static int _timeout = 30;

	public static WebDriver getDriver() {
		return Driver;
	}

	public static void setDriver(WebDriver DRIVER) {
		Driver = DRIVER;
	}

	public static Boolean navigateToURL(String URL) {
		try {
			//webdriver.chrome.driver
			String	projectPath = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", projectPath+"\\driver\\chromedriver.exe");
			Driver = new ChromeDriver();
			Driver.manage().deleteAllCookies();
			Driver.manage().window().maximize();
			Driver.navigate().to(URL);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void setTimeout(int timeout) {
		SeleniumDriverUtilities._timeout = timeout;
	}


	public static int getTimeout() {
		return SeleniumDriverUtilities._timeout;
	}

	//wait
	public static Boolean waitForElement(String xpath) {
		Boolean foundElement = false;
		try {
			int waitCount = 0;
			while (!foundElement && waitCount < getTimeout()) {
				try {
					WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(getTimeout()));
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
					foundElement = true;
				} catch (Exception e) {
					waitCount++;
				}
			}
			return foundElement;
		} catch (Exception e) {
			return false;
		}
	}

	public static Boolean waitForElement(String xpath, int duration) {
		Boolean foundElement = false;
		try {
			int waitCount = 0;
			while (!foundElement && waitCount < duration) {
				try {
					WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(getTimeout()));
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
					foundElement = true;
				} catch (Exception e) {
					waitCount++;
				}
			}
			return foundElement;
		} catch (Exception e) {
			return false;
		}
	}

	//click
	public static Boolean clickElement(String xpath) {
		try {
			waitForElement(xpath);
			WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(getTimeout()));
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			element.click();

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static Boolean enterText(String xpath, String text) {
		try {
			waitForElement(xpath);
			WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(getTimeout()));
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			element.clear();
			element.sendKeys(text);

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static String retrieveElementText(String xpath) {
		try {
			waitForElement(xpath);
			WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(getTimeout()));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

			return element.getText();
		} catch (Exception e) {
			return null;
		}
	}
}
