# new feature
# Tags: optional
Feature: Outline feature

Scenario Outline: Create ABC

  Given I open the application

  When I enter username as "<username>"

  And I enter password as "<password>"

  Then I enter title as "<title>"

  And press submit


Examples:

| username | password | title |

| Rob      | xyz1      | title1 |

| Bob      | xyz1      | title2 |
