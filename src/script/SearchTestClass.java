package script;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;





public class SearchTestClass {

	static String URL="https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_csharp_search/862b0faa506b8487c25a3384cfde8af4/static/attachments/reference_page.html";
	static WebDriver driver=null;

	static
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/driver/chromedriver.exe");
		
	}
	@Before
	public void Openapp()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
	}
	
	

	@Test
	
	public void test_MainScreen()
	
	{
		

		driver.findElement(By.xpath("//div[@id='search-form']/div/input")).sendKeys("ABC");
	// driver.findElement(By.xpath("//div[@id='search-form']/div//div[text()='Provide some query']"));
		String typetext = driver.findElement(By.xpath("//div[@id='search-form']/div/input")).getAttribute("type");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			if(typetext.equals("text")) {
				
				System.out.println("Text fields are validated");
				}else 
				{
					
					System.out.println("Text fields validations are failed...!");					
				
			}
			driver.findElement(By.xpath("//div[@id='search-form']/div/input")).sendKeys("ABC");
			
			WebElement searchbutton = driver.findElement(By.xpath("//div[@id='search-form']/div/button"));
			if(searchbutton.isDisplayed()) {
				
				System.out.println("Search button is dispalyed..!");
			}
			else {
				
				System.out.println("Search button is NOT dispalyed..!");
			}
			searchbutton.click();
	}
	@Test
	public void test_Emptyscreen()
	{
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id='search-form']/div/input")).clear();
	driver.findElement(By.xpath("//div[@id='search-form']/div/button")).click();
	
	
	WebElement SearcHResult = driver.findElement(By.xpath("//div[@id='search-form']/div//div[text()='Provide some query']"));
		
		String str = SearcHResult.getText();
		
		if(str.equals("Provide some query")) {
			
			System.out.println("Provide some query is displayed");
			
		}
		else {
			System.out.println("No text is displayed");
		}
	}
	
	@Test
	public void test_Searchisland()
	
	{

		 WebDriverWait wait = new WebDriverWait(driver, 40);
		driver.findElement(By.xpath("//div[@id='search-form']/div/input")).sendKeys("isla");
		driver.findElement(By.xpath("//div[@id='search-form']/div/button")).click();
	List<WebElement> Searchresult	= driver.findElements(By.xpath("//div[@id='search-form']/div/ul[@id='search-results']"));
	int size= Searchresult.size();
	System.out.println(size);
//	List<WebElement> result=	driver.findElements(By.xpath("//div[@id='search-form']/div/ul[@id='search-results']/li[i]"));

	 List<WebElement> links = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("li")));
	 for (int i = 0; i < links.size(); i++)
	 {
	  System.out.println(links.get(i).getText());
	 }

	
}

	
	@Test
	public void test_Feedback()
	{
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[@id='search-form']/div/input")).clear();
		driver.findElement(By.xpath("//div[@id='search-form']/div/input")).sendKeys("castle");
		driver.findElement(By.xpath("//div[@id='search-form']/div/button")).click();
		WebElement SearcHResult = driver.findElement(By.xpath("	//div/div[2]/ul/div[text()='No results']"));
String str = SearcHResult.getText();
		
		if(str.equals("No results")) {
			
			System.out.println("No results displayed for Castle");
			
		}
		else {
			System.out.println("result diplayed for castle search");
		}
	}
	@Test
	public void test_PortRoyal()
	{
	
		 WebDriverWait wait = new WebDriverWait(driver, 40);
		driver.findElement(By.xpath("//div[@id='search-form']/div/input")).clear();
		driver.findElement(By.xpath("//div[@id='search-form']/div/input")).sendKeys("Port Royal");
		driver.findElement(By.xpath("//div[@id='search-form']/div/button")).click();
		
		List<WebElement> Searchresult	= driver.findElements(By.xpath("//div[@id='search-form']/div/ul[@id='search-results']/li"));
		int size= Searchresult.size();
		System.out.println(size);
	
		 List<WebElement> links = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("li")));
		 for (int i = 0; i < links.size(); i++)
		 {
		  System.out.println(links.get(i).getText());
		 }
		}
	
	@After
	public void closeApp()
	{
		driver.quit();
	}
}
