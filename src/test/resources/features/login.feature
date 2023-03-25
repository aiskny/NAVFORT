@Wip
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




