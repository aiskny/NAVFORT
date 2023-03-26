@NAV10-437
Feature: Navfort login features

  Background:
    Given user is on the login page

  @NAV10-362
  Scenario: Login as a Driver
    When user login as "driver"
    Then user land on the "Quick Launchpad" page

  @NAV10-363
  Scenario: Login as a Sales Manager
    When user login as "salesmanager"
    Then user land on the "Dashboard" page

  @NAV10-364
  Scenario: Login as a StoreManager
    When user login as "storemanager"
    Then user land on the "Dashboard" page

  @NAV10-366
  Scenario: "Invalid username or password." message should be displayed for invalid credentials
    When user login with "invalidUserName" and "invalidPassword"
    Then "Invalid user name or password." message should be displayed for invalid credentials

  @NAV10-367
  Scenario:  "Please fill out this field." message should be displayed
    When user login with "UserName" and ""
    Then "Please fill out this field." message should be thrown from password field

  @NAV10-368
  Scenario: "Please fill out this field." message should be displayed
    When user login with "" and "Password"
    Then "Please fill out this field." message should be thrown from username field

  @NAV10-369
  Scenario: If username and password field both are empty, just the username field should throw the warning message
    When user click on login button
    Then "Please fill out this field." message should be thrown from username field

  @NAV10-370
  Scenario Outline: The user can see own username which is <username> after login
    When user login as "<user>"
    Then user can see "<username>"
    Examples:
      | user         | username        |
      | driver       | user1           |
      | storemanager | storemanager51  |
      | salesmanager | salesmanager101 |






