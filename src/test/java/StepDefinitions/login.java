package StepDefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;



public class login { 
	
    private WebDriver driver;
    public login() {
        this.driver = DriverManager.getDriver(); 
    }
	
	@Given("navigate to saucedemo website")
	public void navigate_to_saucedemo_website() {
		driver.get("https://www.saucedemo.com/");
	}

	@When("Login with valid {string} and {string}")
	public void login_with_valid_and(String username, String password) {
		driver.findElement(By.name("user-name")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
	}

	@Given("click on Login button")
	public void click_on_login_button() {
		driver.findElement(By.name("login-button")).click();
	}

	@Then("redirect to product page")
	public void redirect_to_product_page() {
		String expectedUrl = "https://www.saucedemo.com/inventory.html";
        if (!driver.getCurrentUrl().equals(expectedUrl)) {
            throw new AssertionError("Expected " + expectedUrl + ", but got " + driver.getCurrentUrl());
        }

	}

}
