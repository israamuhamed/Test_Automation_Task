Feature: Select the lowest price product and complete checkout process

Background: select lowest price to cart
 Given navigate to saucedemo website
 When  Login with valid credentials
 And   click on Login button
 And   redirect to product page
 Then  Add the lowest price product to cart
 
Scenario: checkout and validate the order completed successfully
 Given  access to Cart 
 And    Click on checkout
 And    fill information data
 And    Complete checkout process 
 Then   assert on completion of order