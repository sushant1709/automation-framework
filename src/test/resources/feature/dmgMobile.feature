@dmgMobile
Feature: Mobile Scenario

  Scenario Outline:Verify the Newspaper edition is downloadable.
    Given user navigate to main page
   # Then  user click on newspaper Tab
    Then  user scroll down to recent issues
    Then  user scroll right to see more
    And   user click on see more link
    Then  user click on "<date>" newspaper download button
    And   user verifies sign in page opened
   # Then  user click on sign in button
    And   user enter "<userName>" and "<password>" and click sign in
    Then  user wait for newspaper to download
    And   this is second Test

    Examples:
      | date    | userName                 | password     |
      | 30 July | twilightsp2708@gmail.com | National123! |

