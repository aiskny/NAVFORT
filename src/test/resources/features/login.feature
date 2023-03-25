@@LoginFunctinality
Feature: Fleet Management login feature
  User Story:
  As a user, I should be able to login with correct credentials to different
  accounts. And dashboard should be displayed.


  Scenario: Login as a Driver
    Given user is on the login page
    When user login as "driver"
    Then user should land on the "Quick Launchpad" page

  Scenario: Login as a Sales Manager
    Given user is on the login page
    When user login as "salesmanager"
    Then user should land on the "Dashboard" page

  Scenario: Login as a StoreManager
    Given user is on the login page
    When user login as "storemanager"
    Then user should land on the "Dashboard" page

  Scenario: "Invalid username or password." message should be displayed for invalid credentials
    When user login with "invalidUserName" and "invalidPassword"
    Then "Invalid username or password." message should be displayed for invalid credentials

  Scenario:  "Please fill out this field." message should be displayed
    When user login with "UserName" and ""
    Then "Please fill out this field." message should be thrown from password field

  Scenario: "Please fill out this field." message should be displayed
    When user login with "" and "Password"
    Then "Please fill out this field." message should be thrown from username field

  Scenario: If username and password field both are empty, just the username field should throw the warning message
    When user click on login button
    Then "Please fill out this field." message should be thrown from username field

  Scenario Outline: The user can see own username which is <username> after login
    When user login as "<user>"
    Then user can see "<username>"
    Examples:
      | user         | username        | password    |
      | driver       | John Doe        | UserUser123 |
      | storemanager | storemanager51  | UserUser123 |
      | salesmanager | salesmanager101 | UserUser123 |






