# new feature
# Tags: optional

Feature: Sum of two Number using inbuild Android calculator feature

  Scenario Outline: Sum of Two Numbers
    Given I Open Calculator on Device
    When I enter Number One as "<number1>"
    And I enter Operator +
    And I enter Number Two as "<number2>"
    Then I press Equal Keys on Device
    And I verified the result "<result>"


    Examples:

      | number1 | number2 | result |

      | 2       | 5       | 7      |
      | 9       | 3       | 16     |
      | 5       | 5       | 10     |
      | 4       | 3       | 12     |