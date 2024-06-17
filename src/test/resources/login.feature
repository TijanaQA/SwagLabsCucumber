Feature: Login test

  Scenario: User can log in
    Given user is on login page
    When user inputs valid username into username field
    And user inputs valid password into password field
    And user clicks on Login button
    Then user is logged in
    And redirected to Home page

  Scenario Outline: User cannot log in with invalid password
    Given user is on login page
    When user inputs valid username into username field
    And user inputs invalid <password> into password field
    And user clicks on Login button
    Then user is not logged in
    And error message appears
    Examples:
      | password |
      |"password123"|
      |"pass124@"|
      |"1237654"|

  Scenario Outline: User cannot log in with invalid username and password
    Given user is on login page
    When user inputs invalid <username> into username field
    And user inputs invalid <password> into password field
    And user clicks on Login button
    Then user is not logged in
    And error message appears
    Examples:
      | username | password |
      | "user1" | "pass1" |
      | "user" | "123" |
      | "no_user" | "no_user" |
