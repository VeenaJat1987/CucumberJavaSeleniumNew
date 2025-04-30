Feature: Login to Admin page of NopCommerce website

  Background: Common steps
    Given User launch chrome browser

  @sanity
  Scenario: Successful Login with config property file
    When user opens URL
    And User enter Username  and Password as
    And click on login btn
    Then Page title should be "Logged In Successfully"
    When User click on Logout link
    And close browser

  Scenario Outline: Successful Login with data driven
    When user opens URL "https://practicetestautomation.com/practice-test-login/"
    And User enter Username as "<username>" and Password as "<password>"
    And click on login btn
    Then Page title should be "Logged In Successfully"
    When User click on Logout link
    And close browser

    Examples:
    | username | password |
    | student | Password123 |

  @High
  Scenario Outline: Taking login credentials from excel file
    When user opens URL
    And The user enter sheet "<Sheetname>" and "<RowNumber>" to get username and password
    And click on login btn
    Then Page title should be "Logged In Successfully"
    When User click on Logout link
    And close browser

    Examples:
      | Sheetname | RowNumber |
      | Sheet1     | 0         |
      | Sheet1     | 1         |



