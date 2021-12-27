package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {
	
	public HomePage(WebDriver driver) {
		super(driver);
		
		jse = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}

	@FindBy(xpath = "/html/body/app-root/vertical-layout/div/content/div/app-dashboard/div/div[2]/div/div/div/div[1]/div")
	WebElement myTasks;

	public void openMyTasks() {

		myTasks.click();
	}

}
