package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helper.base;

public class LoginPage extends base {

	public void enterUserNameandPassword() {
		WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
		userName.sendKeys("standard_user");

		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("secret_sauce");
	}

	public void clickOnLoginButton() {
		WebElement loginBtn = driver.findElement(By.xpath("//input[@id='login-button']"));
		loginBtn.click();
	}
	public boolean validateSucessfulLogin() {
	return	driver.findElement(By.xpath("//span[@class='title']")).isDisplayed();
		
		
}

}