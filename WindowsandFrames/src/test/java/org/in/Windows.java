package org.in;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/windows");
		String id = driver.getWindowHandle();
		WebElement window = driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
		window.click();
		Set<String> handles = driver.getWindowHandles();
		List<String> handling = new ArrayList<String>(handles);
		driver.switchTo().window(handling.get(1));
		String windowhandle = driver.getTitle();
		String Expectedwindow = "New Window";
		if (windowhandle.equals(Expectedwindow)) {
			System.out.println("It will handle the new window");

		} else {
			System.out.println("It wil not handle the new window");

		}
		driver.close();

		driver.switchTo().window(id);
		String oldwindow = driver.getTitle();
		String Expectedoldwindow = "The Internet";
		if (oldwindow.equals(Expectedoldwindow)) {
			System.out.println("The original window is active");

		} else {
			System.out.println("The original windoe is not active");

		}
		driver.quit();
	}

}
