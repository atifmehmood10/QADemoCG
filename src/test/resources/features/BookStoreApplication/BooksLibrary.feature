@BookStoreApplicationTests
Feature:Books Library Tests

  Background: User is logged in
    Given User is on the login screen
    When User provides demoQaLeo1 and Getswift@123 as credentials and hit login button
    Then User is logged in to the system

  @Test-004
  Scenario:Verify user can view books in library
    Then User can view different books
    Then User logs out of application

  @Test-005
  Scenario: Verify user can search for a book in library
    When User search for book with title Git Pocket Guide
    Then User verifies only given book is searched
    Then User logs out of application

  @Test-006
  Scenario: Verify correct details of the searched book are shown
    When User search for book with title Git Pocket Guide
    Then User opens the searched book
    Then User verifies book details from GitBookDetails file
    Then User logs out of application
