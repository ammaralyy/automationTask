package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class NewTaskPage extends PageBase {

	public NewTaskPage(WebDriver driver) {
		super(driver);
		
		jse = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}

	@FindBy(id = "title")
	WebElement taskTitleField;

	@FindBy(xpath = "//*[@id=\"priority\"]/div/div/div[2]/input")
	WebElement priorityList;

	@FindBy(xpath = "//*[@id=\"mat-dialog-0\"]/app-create-task/mat-dialog-content/form/div/div[6]/app-date-time/form/div/div[1]/ng2-flatpickr/div/input[2]")
	WebElement startDateField;

	@FindBy(xpath = "//*[@id=\"mat-dialog-0\"]/app-create-task/mat-dialog-content/form/div/div[6]/app-date-time/form/div/div[2]/ng2-flatpickr/div/input[2]")
	WebElement endDateListField;

	@FindBy(xpath = "/html/body/div[5]/div[2]/div/div[2]/div/span[31]")
	WebElement endDateField;

	@FindBy(xpath = "//*[@id=\"assignees\"]/div/div/div[2]/input")
	WebElement assigneeListField;

//	@FindBy(xpath = "//*[@id=\"ae5be1aa4feb\"]")
//	WebElement assigneeField;


	@FindBy(xpath = "//*[@id=\"mat-dialog-0\"]/app-create-task/mat-dialog-actions/button[2]")
	WebElement createButton;

	public void setPriorityList(){
		select = new Select(priorityList);
		select.selectByIndex(2);
	}

	public void setAssignee(){
		select = new Select(assigneeListField);
		select.selectByIndex(2);
	}

	public void createNewTask(String taskName) {

		sendText(taskTitleField, taskName);

		sendText(endDateListField, "aa");
		endDateField.click();

		createButton.click();
	}

}
