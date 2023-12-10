Feature: User Registration

  Scenario: Successful registration
    Given I am on the registration page
    When I enter valid registration details
    And I click the submit button
    Then I should see a registration success message