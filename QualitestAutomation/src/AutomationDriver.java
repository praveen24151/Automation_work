import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class AutomationDriver {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\\\Program Files\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(); // creating the instance of chromedriver.
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");//Directed to website link
		AutomationDriver.exercise1(driver);//accessing the static method function.
		AutomationDriver.exercise2(driver);
		AutomationDriver.exercise3(driver);
		AutomationDriver.exercise4(driver);
		AutomationDriver.exercise5(driver);
		AutomationDriver.exercise6(driver);
		AutomationDriver.exercise7(driver);
		AutomationDriver.exercise8(driver);
		AutomationDriver.exercise9(driver);
		
					
	}
	
	    //

	private static void exercise1(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		driver.findElement(By.cssSelector("input[value*='radio1']")).click();//Clicking radio button through click() button
		Assert.assertTrue(driver.findElement(By.xpath("//*[@value='radio1']")).isSelected());
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("input[value*='radio2']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@value='radio2']")).isSelected());
		Thread.sleep(2000);
		
		
		driver.findElement(By.cssSelector("input[value*='radio3']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@value='radio3']")).isSelected());
			
		
	}
	private static void exercise2 (WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		driver.findElement(By.id("autocomplete")).sendKeys("United State(USA)");//we used unique value as id 
		Thread.sleep(2000);
		
		List<WebElement> options = driver.findElements(By.xpath("//input[@type='text']"));
		for (WebElement option : options)
			if (option.getText().equalsIgnoreCase("United State")) {
				option.click();
				break;
             }
		}
	
	private static void exercise3 (WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver.findElement(By.id("dropdown-class-example")).click();
		
		driver.findElement(By.cssSelector("option[value*='option1']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("option[value*='option2']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("option[value*='option3']")).click();
		Thread.sleep(1000);
		   }

	private static void exercise4 (WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		driver.findElement(By.id("checkBoxOption1")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("checkBoxOption1")).click();
		
		driver.findElement(By.id("checkBoxOption2")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("checkBoxOption2")).click();
		
		driver.findElement(By.id("checkBoxOption3")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("checkBoxOption3")).click();
		AutomationDriver.exerciseFourPointOne(driver);
		AutomationDriver.exerciseFourPointtwo(driver);
		}

	private static void exerciseFourPointOne(WebDriver driver) {
		// TODO Auto-generated method stub
		driver.findElement(By.id("checkBoxOption1")).click();
		Assert.assertTrue(driver.findElement(By.name("checkBoxOption1")).isSelected());
		
		driver.findElement(By.id("checkBoxOption2")).click();
		Assert.assertTrue(driver.findElement(By.name("checkBoxOption2")).isSelected());
		
		driver.findElement(By.id("checkBoxOption3")).click();
		Assert.assertTrue(driver.findElement(By.name("checkBoxOption3")).isSelected());
	
	}

	private static void exerciseFourPointtwo(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(2000);
		driver.findElement(By.id("checkBoxOption1")).click();
		Assert.assertFalse(driver.findElement(By.name("checkBoxOption1")).isSelected());
		Thread.sleep(2000);
		
		driver.findElement(By.id("checkBoxOption2")).click();
		Assert.assertFalse(driver.findElement(By.name("checkBoxOption2")).isSelected());
		Thread.sleep(2000);
		
		driver.findElement(By.id("checkBoxOption3")).click();
		Assert.assertFalse(driver.findElement(By.name("checkBoxOption3")).isSelected());
	
	}
	private static void exercise5 (WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("http://www.qaclickacademy.com/practice.php");
		
		driver.findElement(By.id("openwindow")).click();
		
		Set<String> Windows = driver.getWindowHandles();
		
		java.util.Iterator<String> iter = Windows.iterator();
		
		String parentid = iter.next();
			
		Thread.sleep(3000);
		
		driver.switchTo().window(parentid);

	}
	
	private static void exercise6 (WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		driver.findElement(By.id("opentab")).click();
		Thread.sleep(2000);

		Set<String> window = driver.getWindowHandles();

		java.util.Iterator<String> it = window.iterator();

		String parent = it.next();

		it.next();

		String daughter = it.next();
		Thread.sleep(2000);

		driver.switchTo().window(daughter);

		driver.close();

		driver.switchTo().window(parent);
		
	}
	
	private static void exercise7 (WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub

		driver.findElement(By.name("enter-name")).sendKeys("hello everyone");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@value='Alert']")).click();
		Thread.sleep(2000);
		
		driver.switchTo().alert().accept();
		
	}
	
	private static void exercise8 (WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		JavascriptExecutor js =(JavascriptExecutor)driver;//creating javascriptExecutor object to tell selinium to run java code
		js.executeScript("window.scrollBy(0,600)");//movement of window
		Thread.sleep(500);
		//Verify that  row in the table contains content
		WebElement table=driver.findElement(By.id("product"));
		List<WebElement> secondrow=table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th"));
		System.out.println(secondrow.get(0).getText());
		System.out.println(secondrow.get(1).getText());
		System.out.println(secondrow.get(2).getText());
	}
	private static void exercise9 (WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		Actions a = new Actions(driver);
		Thread.sleep(3000);
		
		a.moveToElement(driver.findElement(By.xpath("//button[@id='mousehover']"))).click().build().perform();
		Thread.sleep(5000);
		
		a.moveToElement(driver.findElement(By.cssSelector("a[href='#top']"))).click().build().perform();

}
	
	
	
}
  
  
	
	
	
	


