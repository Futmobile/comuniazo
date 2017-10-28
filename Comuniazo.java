package Comunio;

import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class Comuniazo {

	private static Scanner input;

	public static void main(String[] args) {
	
		input = new Scanner(System.in);
		System.out.print("Introduce usuario: ");
		String jugador = input.next();
		
		
		//OPENING CHROME BROWSER
		System.setProperty("webdriver.chrome.driver","C://Program Files//Java//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.comuniazo.com");
		driver.manage().window().maximize();
			
		//ACCESING TO MEMBERS POINTS
		driver.findElement(By.className("icon-star")).click();
		driver.findElement(By.name("user")).sendKeys(jugador);
		driver.findElement(By.id("ajax-send")).click();
	
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//NUMBER OF POINTS
	
		WebElement puntos = driver.findElement(By.xpath(".//div[@id='field']/div[@class='info']/div[@class='box']/div[2]/span"));
		System.out.println("Puntos de " + jugador + " : " + puntos.getText());

		driver.close();
		driver.quit();
		
	}

}