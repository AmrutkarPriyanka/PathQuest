@endtoend
Feature: PathQuest Application Login Functionality Check

  Background: Navigation to the URL with login functionality
    Given navigation to the url
    And login to the application using username "uattestuser@mailinator.com" and password "P@ssw0rd@111"

  @ManageCopmany
  Scenario: User is able to login and navigated to Manage Company Page
    Then After Login verify Manage Company page will open

  @dashboard
  Scenario: User is able to check All the widgets with chart
    When go to Dashboard
    Then All the widgets with chart should display

  @gearOptions
  Scenario: user click on gear icon and check number of options
    When Click on gear icon at top right side
    Then Check and verify how many options are there to select
