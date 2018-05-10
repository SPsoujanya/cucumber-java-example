# new feature
# Tags: optional
    
Feature: Simple Datatable feature

  Scenario: Test web title
    Given I am on home page of xyz site
    And I submit the form with below details
      |name      | Pritesh Patel  |
      |id        | 77777  |
      |address   | Toronto |
    Then I see that form submission is successful