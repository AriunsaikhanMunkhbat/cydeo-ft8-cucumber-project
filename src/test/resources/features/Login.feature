
Feature: Login to app

  Background:
    Given I am on the login page

  @librarian
  Scenario: Login as a librarian
   # Given I am on the login page
    When I login as a librarian
    Then dashboard should be displayed


  @student
  Scenario: Login as a student
  #  Given I am on the login page
    When I login as a student
    Then books should be displayed


  @librarianParam
  Scenario: Login as librarian 49
   # Given I am on the login page
    When I log in using "librarian13@library" and "libraryUser"
    And there should be 191 users
    Then dashboard should be displayed
      #number can be whatever you have there


  @all_accounts
  Scenario Outline: Verify user information <email>
  #  Given I am on the login page
    When I log in using "<email>" and "<password>"
    Then account holder name should be "<name>"

    @students
    Examples:
      | email             | password | name            |
      | student27@library | libraryUser | Test Student 27 |
      | student28@library | libraryUser | Test Student 28 |
      | student29@library | libraryUser | Test Student 29 |
      | student30@library | libraryUser | Test Student 30 |

    @librarians
    Examples:
      | email | password | name |
      | librarian13@library | libraryUser | Test Librarian 13 |
      | librarian14@library | libraryUser | Test Librarian 14 |
      | librarian15@library | libraryUser | Test Librarian 15 |
      | librarian16@library | libraryUser | Test Librarian 16 |
      | librarian17@library | libraryUser | Test Librarian 17 |