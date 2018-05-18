# new feature
# Tags: optional

@CCOrg @CCNet
Feature: Testing for login page

  Scenario Outline: Bad login

    Given I want to use the browser Firefox
    When I set the username to "<username>"
    When I set the password to "<password>"
    When I login to CosmicComix
    Then I see the error message "<message>"
    And I am on the login page

  @Regression
    Examples:
      | username  | password  | message                                                    |
      | testuser1 |           | Please provide a password.                                 |
      |           | testuser1 | Please provide a username.                                 |
      | testuser  | testuser  | That username does not match anything in our records.      |
      | testuser1 | testuser2 | The password provided does not match the username entered. |

  Scenario Outline: Successful login

    Given I want to use the browser "<browser>"
    When I set the username to testUserName
    And I set the password to testUserPassword
    When I login to CosmicComix
    Then I am on the launcher page

  @Regression
    Examples:
      | browser          |
      | Firefox          |
      | Chrome           |
      | InternetExplorer |
  @Smoke
    Examples:
      | browser |
      | Firefox |