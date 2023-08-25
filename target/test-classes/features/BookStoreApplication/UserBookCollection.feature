@UserBookCollectionTests
Feature: User books collection

  Background: User is logged in
    Given User is on the login screen
    When User provides demoQaLeo1 and Getswift@123 as credentials and hit login button
    Then User is logged in to the system

  @Test-007
  Scenario:Verify user can add books to their collection
    When User add Git Pocket Guide book to collection
    Then User navigates to User Profile
    Then User can verify Git Pocket Guide book is present in collection
    Then User logs out of application

  @Test-008
   Scenario: Verify prompt is shown when adding the same book again.
    When User navigates to User Profile
    Then User can verify Git Pocket Guide book is present in collection
    When User navigates to Books Page
    Then User logs out of application

  @Test-009
  Scenario: Verify user can remove books from their collection
    When User navigates to User Profile
    Then User can verify Git Pocket Guide book is present in collection
    When User press delete button
    Then Git Pocket Guide is removed from collection
    Then User logs out of application


