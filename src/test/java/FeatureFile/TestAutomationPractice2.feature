Feature: Testing Test, Date, Popups and Table feature of testautomationpractice website

  Scenario: Testing Text feature using Data Table
    Given User launch browser
    When user opens URL of testautomationpractice website
    And User enter Name, Email and Phone
      | Name   | Email |  Phone |
      | testuser_1 | Test@153 | 12345 |
      | testuser_2 | Test@154 | 34567 |
    And quit the browser

  Scenario: Testing Date feature
    Given User launch browser
    When user opens URL of testautomationpractice website
    And Enter value to date field
    And quit the browser


  Scenario: Testing Dynamic table feature
    Given User launch browser
    When user opens URL of testautomationpractice website
    And display the value of the table with names and their CPU value
    And quit the browser


  Scenario: Testing Pagination Webtable feature
    Given User launch browser
    When user opens URL of testautomationpractice website
    And capture all the values in each page of the table and select the check boc.
    And quit the browser



  Scenario: Testing Single File Upload feature
    Given User launch browser
    When user opens URL of testautomationpractice website
    And Upload Single file
    Then Verify the File Name "samplefile.png"in browser
    And quit the browser


  Scenario: Testing Multiple File Upload feature
    Given User launch browser
    When user opens URL of testautomationpractice website
    And Upload Multiple file
    Then Verify the File Names "samplefile.png" and "bhuvan_project_computer.png" in browser
    And quit the browser


  Scenario: Testing Multiple data using excel file
    Given User launch browser
    When user opens URL of testautomationpractice website
    Then Verify the exceldata in specific fields.
    And quit the browser

  @High
  Scenario: Testing Multiple data using Database connection
    Given User launch browser
    When user opens URL of testautomationpractice website
    And provide data to fields from database
    And quit the browser and database connection
