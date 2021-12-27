package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SignUp extends PageBase {

	public SignUp(WebDriver driver) {
		super(driver);
		
		jse = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}

	@FindBy(xpath = "/html/body/app-root/vertical-layout/div/content/div/app-auth-register-v2/div/div/div[2]/div/form/div[1]/input")
	WebElement fullNameField;

	@FindBy(xpath = "/html/body/app-root/vertical-layout/div/content/div/app-auth-register-v2/div/div/div[2]/div/form/div[2]/input")
	WebElement phoneNumberField;

	@FindBy(xpath = "/html/body/app-root/vertical-layout/div/content/div/app-auth-register-v2/div/div/div[2]/div/form/div[3]/input")
	WebElement emailField;

	@FindBy(xpath = "/html/body/app-root/vertical-layout/div/content/div/app-auth-register-v2/div/div/div[2]/div/form/div[4]/div/input")
	WebElement passwordField;

	@FindBy(xpath = "/html/body/app-root/vertical-layout/div/content/div/app-auth-register-v2/div/div/div[2]/div/form/button")
	WebElement registerButton;

	public void register(String fullName, String phone, String email, String password) {

		sendText(fullNameField, fullName);
		sendText(phoneNumberField, phone);
		sendText(emailField, email);
		sendText(passwordField, password);

		registerButton.click();
	}

}
