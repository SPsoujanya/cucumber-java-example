# new feature
# Tags: optional

Feature: Simple background feature

  Background: Execute before every scenario
    Given I filter some records

  Scenario: Verify delete functionality
    Given I click on the delete button of the first record
    Then I verify that record is removed from the table

  Scenario: Verify Update functionality
    Given I click on update button of the first record
    Then I verify that record opens in new window and we can modify it