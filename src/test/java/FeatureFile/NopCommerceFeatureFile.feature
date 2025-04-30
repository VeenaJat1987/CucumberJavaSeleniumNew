Feature: Login to Admin page of NopCommerce website

  Scenario Outline: Successful Login with data driven
    Given User launch chrome browser
    When user opens URL "http://admin-demo.nopcommerce.com/login"
    And User enter emailid as "<email>" and password as "<password>"
    And click on login
    Then Page title should be "Dashboard / nopCommerce administration"
    When User click on Logout link
    Then Page title should be "nopCommerce demo store. Login"
    And close browser

    Examples:
    | email | password |
    | admin@yourstore.com | admin |
    | admin1@yourstore.com | admin1 |