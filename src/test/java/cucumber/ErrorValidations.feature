
@tag
Feature: Error validation
  I want to use this template for my feature file


  @ErrorValidation
  Scenario Outline: Negative test on logging into application
    Given I landed on Ecommerce page 
    When Logged in with username <username> and password <password>
    Then "Incorrect email or password." message is displayed

    Examples: 
      | username  					| password 	|
      | durgatest@gmail.com | Durga12 	|
      
