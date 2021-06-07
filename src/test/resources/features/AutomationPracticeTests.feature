@test
Feature: This feature contains updating first name and placing an order scenarios

  Scenario: Update personal information in my account.
    Given user is on automation practice homepage
    When  i click on sign in link
    Then i should be in authentication page
    When i enter emailId reddyk@gmail.com and password Test@1234 and click on signin button
    Then i should be in my account page
    When i click on my personal information
    And change firstName to Kumar
    And click on save button
    When i click on sign out link
    Then i should be in authentication page

  Scenario: select t-shirt and place an order.
    Given user is on automation practice home page
    When i select t-shirts category
    Then i should be in t-shirts landing page
    When i select t-shirt
    Then i should be in product details page
    When i click on add to cart button
    And i click on proceed to checkout button
    And i click on proceed to checkout button in summary tab
    And i enter emailId reddyk@gmail.com and password Test@1234 and click on sign in button
    And i click on proceed to checkout button in address tab
    And i click on terms of service
    And i click on proceed to checkout button in terms of service tab
    And i click on pay by bank wire option
    When i click on i confirm my order button in order summary tab
    Then i should in order confirmation page
    When i click on back to order
    Then i should be in order history details page