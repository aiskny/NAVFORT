@NAV10-438
Feature: Navfort Logout Functionality

  @NAV10-418
  Scenario Outline: <user> can log out successfully
    Given user login as "<user>"
    Then user land on the "<pagename>" page
    When user logs out by clicking the Logout button
    Then user is on the login page

    Examples:
      | user         | pagename        |
      | driver       | Quick Launchpad |
      | storemanager | Dashboard       |
      | salesmanager | Dashboard       |

  @NAV10-419
  Scenario Outline: <user> can not navigate back to the home page after logging out
    Given user login as "<user>"
    Then user land on the "<pagename>" page
    When user logs out by clicking the Logout button
    When user navigates back
    Then user is on the login page

    Examples:
      | user         | pagename        |
      | driver       | Quick Launchpad |
      | storemanager | Dashboard       |
      | salesmanager | Dashboard       |