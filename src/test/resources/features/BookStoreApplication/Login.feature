@LoginPage
Feature:Book Store login Tests

  @Test-001
  Scenario Outline: Verify user can login with correct credentials
    Given User is on the login screen
    When User provides <Username> and <Password> as credentials and hit login button
    Then User is logged in to the system
  Examples:
    | Username   | Password     |
    | demoQaLeo1 | Getswift@123 |

  @Test-002
  Scenario Outline: Verify user cannot login with incorrect credentials
    Given User is on the login screen
    When User provides <Username> and <Password> as credentials and hit login button
    Then Login error is shown to user due to incorrect credentials
    Examples:
      | Username | Password |
      | ab       | 1a        |

  @Test-003
  Scenario: Verify system prompts error on empty credentials
    Given User is on the login screen
    When User provides no credentials
    Then Required fields are marked red
