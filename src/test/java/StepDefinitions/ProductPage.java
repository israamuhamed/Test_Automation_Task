package StepDefinitions;
import static org.junit.Assert.assertTrue;
import java.time.Duration;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.*;

public class ProductPage {
	WebDriver driver;
	public ProductPage() {
        this.driver = DriverManager.getDriver(); 
    }
	
	@When("Login with valid credentials")
	public void login_with_valid_credentials() {
		driver.findElement(By.name("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
	}
	
	@Given("Add the lowest price product to cart")
	public void Add_the_lowest_price__product_to_cart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_item")));
        List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));
        
        double lowestPrice = Double.MAX_VALUE;
        WebElement lowestPriceElement = null;
        
        for (WebElement priceElement : priceElements) {
            
            double price = Double.parseDouble(priceElement.getText().replace("$", "").trim());
            
            if (price < lowestPrice) {
                lowestPrice = price;
                lowestPriceElement = priceElement;
            }
            }
        WebElement productElement = lowestPriceElement.findElement(By.xpath("./ancestor::div[contains(@class, 'inventory_item')]/div/button"));
        productElement.click();
    } 
	
	@Given("access to Cart")
	public void access_to_cart() {
		
		driver.findElement(By.className("shopping_cart_link")).click();
	}

	@Given("Click on checkout")
	public void click_on_checkout() { 
		
		driver.findElement(By.id("checkout")).click();
	}

	@Given("fill information data")
	public void fill_information_data() {
		
		driver.findElement(By.id("first-name")).sendKeys("israa");;
        driver.findElement(By.id("last-name")).sendKeys("Muhamed");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        driver.findElement(By.id("continue")).click();
	}

	@Given("Complete checkout process")
	public void complete_checkout_process() {
		
        driver.findElement(By.id("finish")).click();
	}

	@Then("assert on completion of order")
	public void assert_on_completion_of_order() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	        WebElement completionMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("complete-header")));
	        assertTrue(completionMessage.isDisplayed());
//	        assertTrue(completionMessage.getText().contains("THANK YOU FOR YOUR ORDER"));
	        driver.quit();

	}
}
