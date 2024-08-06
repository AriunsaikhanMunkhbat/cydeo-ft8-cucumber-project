
Feature: Login to app

  @librarian
  Scenario: Login as a librarian
    Given I am on the login page
    When I login as a librarian
    Then dashboard should be displayed


  @student
  Scenario: Login as a student
    Given I am on the login page
    When I login as a student
    Then books should be displayed


  @librarianParam
  Scenario: Login as librarian 49
    Given I am on the login page
    When I log in using "librarian13@library" and "libraryUser"
    And there should be 191 users
    Then dashboard should be displayed
      #number can be whatever you have there