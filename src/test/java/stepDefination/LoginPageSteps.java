package stepDefination;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LoginPage;

public class LoginPageSteps {
	LoginPage login = new LoginPage();
	@When("user enter user name and password")
	public void user_enter_user_name_and_password() {
	    login.enterUserNameandPassword();
	}
	@When("user click on login button")
	public void user_click_on_login_button() {
	login.clickOnLoginButton();
	}
	@Then("valid successfull login")
	public void valid_successfull_login() {
	   login.validateSucessfulLogin();
	}
}
    
    




