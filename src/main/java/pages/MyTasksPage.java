package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MyTasksPage extends PageBase {

	public MyTasksPage(WebDriver driver) {
		super(driver);
		
		jse = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}

	@FindBy(xpath = "/html/body/app-root/vertical-layout/div/content/div/app-my-tasks/div/core-sidebar/app-my-tasks-sidebar/div/div/div[1]/div[1]/button")
	WebElement newTask;

	@FindBy(xpath = "/html/body/app-root/vertical-layout/div/content/div/app-my-tasks/div/div/div/div/div[2]/app-all-tasks/div/div[1]/div[1]")
	WebElement Task;

	@FindBy(xpath = "/html/body/app-root/vertical-layout/div/content/div/app-task-details/div[1]/div[2]/div[2]/button")
	WebElement startTaskButton;


	public void openNewTask() {
		newTask.click();
	}

	public void openTask() {
		Task.click();
	}

	public void startTask() {
		startTaskButton.click();

	}

}
