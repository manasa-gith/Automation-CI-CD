
@tag
Feature: Purchase the order from Ecommerce website
  I want to use this template for my feature file

Background: 
Given I landed on Ecommerce page 

  @Regression
  Scenario Outline: Positive test of submitting the order
    Given Logged in with username <username> and password <password>
    When I add the product <productName> to the cart
    And  Checkout product <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmation page.

    Examples: 
      | username  							| password 	 | productName  	 |
      | manasatest123@gmail.com | Durga@123	 | ADIDAS ORIGINAL |
