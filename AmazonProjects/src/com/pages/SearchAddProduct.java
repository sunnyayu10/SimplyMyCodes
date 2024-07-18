package com.pages;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//import com.test.AmazonJdbc;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchAddProduct {

	public void search() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();

		WebElement pro = driver.findElement(By.linkText("Apple iPhone 15 (128 GB) - Black"));

		Thread.sleep(4000);

		Actions action = new Actions(driver);

		action.moveToElement(pro).click().perform();

		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());

		int i = windows.size();
		System.out.println("window size is : " + i);

		if (i > 1) {

			System.out.println(windows.get(1));
			driver.switchTo().window(windows.get(1));
		}

		driver.findElement(
				By.xpath("//div[@class='a-section a-spacing-none a-padding-none']//input[@id='add-to-cart-button']"))
				.click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@id='attach-sidesheet-view-cart-button']")).click();

		WebElement productName = driver.findElement(By.xpath(
				"//span[@class='a-truncate-cut'][normalize-space()='Apple iPhone 15 (128 GB) - Black']"));
		
		System.out.println(productName.getText());
	}
	
	/*public static void main(String[] args) throws InterruptedException {
		SearchPage sp = new SearchPage();
		sp.search();
	}*/
}
