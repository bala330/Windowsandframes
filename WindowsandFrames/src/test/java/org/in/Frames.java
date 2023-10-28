package org.in;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		WebElement parent = driver.findElement(By.xpath("//frame[@name='frame-top']"));
		driver.switchTo().frame(parent);
		List<WebElement> framescount = driver.findElements(By.tagName("frame"));
		if (framescount.size() == 3) {
			System.out.println("There are three frames in the page");

		} else {
			System.out.println("There are no three frames in the page");
		}

		WebElement left = driver.findElement(By.xpath("//frame[@name='frame-left']"));
		driver.switchTo().frame(left);
		WebElement leftframe = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
		String leftframetext = leftframe.getText();
		System.out.println("It will print the : " + leftframetext);

		String Exceptedleftframe = "LEFT";
		if (leftframetext.equals(Exceptedleftframe)) {
			System.out.println("It will print the left frame");

		} else {
			System.out.println("It will not print the left frame");

		}
		driver.switchTo().parentFrame();
		WebElement middle = driver.findElement(By.cssSelector("frame[name='frame-middle']"));
		driver.switchTo().frame(middle);
		WebElement middleframe = driver.findElement(By.xpath("//div[contains(text(),'MIDDLE')]"));
		String middleframetext = middleframe.getText();
		System.out.println("It will print the : " + middleframetext);

		String Exceptedmiddleframe = "MIDDLE";
		if (middleframetext.equals(Exceptedmiddleframe)) {
			System.out.println("It will print the middle frame");

		} else {
			System.out.println("It will not print the middle frame");

		}
		driver.switchTo().parentFrame();
		WebElement right = driver.findElement(By.cssSelector("frame[name='frame-right']"));
		driver.switchTo().frame(right);
		WebElement rightframe = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
		String rightframetext = rightframe.getText();
		System.out.println("It will print the : " + rightframetext);

		String Exceptedrightframe = "RIGHT";
		if (rightframetext.equals(Exceptedrightframe)) {
			System.out.println("It will print the right frame");

		} else {
			System.out.println("It will not print the right frame");

		}
		driver.switchTo().defaultContent();
		driver.switchTo().parentFrame();
		WebElement bottom = driver.findElement(By.xpath("//frame[@name='frame-bottom']"));
		driver.switchTo().frame(bottom);
		WebElement bottomframe = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
		String bottomframetext = bottomframe.getText();
		System.out.println("It will print the : " + bottomframetext);
		String Expectedbootomframe = "BOTTOM";
		if (bottomframetext.equals(Expectedbootomframe)) {
			System.out.println("It will print the bottom frame");
		} else {
			System.out.println("It will not print the bottom frame");
		}
		driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String title = driver.getTitle();
		System.out.println(title);
		if (title.equals("Frames")) {
			System.out.println("It will current title print");

		} else {
			System.out.println("It will not current title not print");

		}
		driver.quit();
	}

}
