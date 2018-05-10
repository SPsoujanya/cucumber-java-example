# new feature
# Tags: optional
    
@selenium
Feature: Simple feature

  Scenario: Test web title
    Given I am on "www.yahoo.com" page
    Then I verify that the title is "yahoo"

  Scenario: Test web title
    Given I am on "www.softpost.org" page
    Then I verify that the title is "tutorials"