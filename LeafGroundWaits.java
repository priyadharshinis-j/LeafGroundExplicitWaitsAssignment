package leafTapsWait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundWaits {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.leafground.com/waits.xhtml");
		
		driver.findElement(By.xpath("//span[@class='ui-button-text ui-c']")).click();
		
		WebElement button1 = driver.findElement(By.xpath("//span[text()='I am here']"));
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(button1));
		
		String text1 = button1.getText();
		System.out.println(text1);
		
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[3]")).click();
		WebElement button2 = driver.findElement(By.xpath("//span[text()='I am about to hide']"));
		wait.until(ExpectedConditions.invisibilityOf(button2));
		
		
		driver.findElement(By.xpath("//span[text()='Click First Button']")).click();
		
		WebElement button3 = driver.findElement(By.xpath("//span[text()='Click Second']"));
		wait.until(ExpectedConditions.visibilityOf(button3));
		String text2 = button3.getText();
		System.out.println(text2);
		
		
		WebElement button4 = driver.findElement(By.xpath("//span[text()='I am going to change!']"));
		String text3 = button4.getText();
		System.out.println("Before Text====> "+text3);
		
		driver.findElement(By.xpath("(//span[text()='Click'])[3]")).click();
		
		WebElement button5 = driver.findElement(By.xpath("//span[text()='Did you notice?']"));
		wait.until(ExpectedConditions.visibilityOf(button5));
		String text4 = button5.getText();
		System.out.println("After Text=====> "+text4);
		
		
		
		
	}

}
