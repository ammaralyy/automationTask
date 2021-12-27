package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SignIn extends PageBase {

	public SignIn(WebDriver driver) {
		super(driver);
		
		jse = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}

	@FindBy(xpath = "/html/body/app-root/vertical-layout/div/content/div/app-auth-login-v2/div/div/div[2]/div/form/div[1]/input")
	WebElement phoneNumberField;

	@FindBy(xpath = "/html/body/app-root/vertical-layout/div/content/div/app-auth-login-v2/div/div/div[2]/div/form/div[2]/div[1]/input")
	WebElement passwordField;

	@FindBy(xpath = "/html/body/app-root/vertical-layout/div/content/div/app-auth-login-v2/div/div/div[2]/div/form/button")
	WebElement signInButton;

	public void signIn(String phone, String password) {

		sendText(phoneNumberField, phone);
		sendText(passwordField, password);

		signInButton.click();
	}

}
