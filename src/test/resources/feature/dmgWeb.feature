@dmgWeb
Feature: Web Scenario
  @Web1
  Scenario: Verify the video player functionality
    Given User navigate to Daily mail Video Page
    Then  User accepts cookies
    And   User Click on Video in page to begin playback
    Then Click the video again to pause playback
    Then Click on the forward arrow to change to the next video
    And  Click on the back arrow to navigate to the previous video
    Then Click on the speaker icon to mute the video
    Then Click on the speaker icon again to unmute the video
     And When video is finished, next video should autoplay

 @web2
 Scenario Outline:Get the Position and Points for the given team from the Premier League table
    Given User navigate to Daily mail Video Page
    Then  User accepts cookies
    Then Click on Sport menu and scroll down to the Premier League table
    And Retrieve the Pos, PTS for the given team "<team>"
    Examples:
      | team |
      | Fulham |


