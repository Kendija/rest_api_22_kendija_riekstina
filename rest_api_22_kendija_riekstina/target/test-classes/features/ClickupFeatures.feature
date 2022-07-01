Feature: This Feature will test ClickUp API

  Scenario: Create new folder in space and work with it
    Given We have a space to use
    When Create folder "NewFolder", save folders data and check that the name is correct
    Then Create list with name "NewList" in the folder
    And Check that list name is "NewList" and check that it is inside "NewFolder"
    Then Create task "NewTask" in the list
    And Check that tasks name is "NewTask"
    When Remove "NewTask" from the list
    Then Check that task is removed from the list