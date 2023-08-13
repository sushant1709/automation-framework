@dmgMobile
Feature: Mobile Scenario
  Scenario Outline: Verify the Newspaper edition is downloadable.
    Given Launch the app
    Then On Newspaper tab, scroll down to Recent issues and scroll right and tap on `See more` button
    And On Archive tab, tap to download "7 August 2023" edition
    And On the paywall carousel, sign with credential provided "<userName>" and "<password>"
    Then Wait for the edition to download completed
    Examples:
      | userName                 | password     |
      | twilightsp2708@gmail.com | National123! |


  Scenario:Verify the Images on Gallery section.
    Given User is On the downloaded "7 August 2023" edition
    Then Navigate to Page 3 on PDF view
    Then Tap on the Image Gallery is displayed on top of the ALB page
    And Tap on camera icon to open full screen
    And Traverse through all gallery images
    Then On last image close the image by clicking on Close button to return to ALB


