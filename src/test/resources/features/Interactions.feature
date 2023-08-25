@BrowserInteractionsTests
Feature:Test browser functionality

  Background: User is on Alerts, Frames & Windows Page
    Given User is on Alerts, Frames & Windows Page


  @Test-010
  Scenario: Verify user can open new tab
  Then User clicks on new tab button and verifies sample heading

  @Test-011
  Scenario: Verify user can open new windows
    Then User clicks on new window button and verifies sample heading