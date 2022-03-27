Feature: This feature will test Trello API

  Scenario: Add new list to the test board after changing title
    Given The test board exists and contains the correct information
    When I change the board title to "Test Title"
    And I check the board name was updated to "Test Title"
    Then I add a list with title "Example List" to the board