Feature: Verify login functionaity

Scenario Outline: test login functionality with valid credentials
 Given navigate to saucedemo website
 When  Login with valid "<username>" and "<password>"
 And   click on Login button
 Then  redirect to product page
Examples:
|username     ||password    |
|standard_user||secret_sauce|
|problem_user ||secret_sauce|

 