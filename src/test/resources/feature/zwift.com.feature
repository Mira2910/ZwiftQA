Feature: Zwift Validation Task

  Scenario: Home page validation
    Given user navigates to zwift home page
    Then user validates home page is fully loaded
    And user validates home page url "https://www.zwift.com/"
    And user validates home page title "The at Home Cycling & Running Virtual Training App - Zwift"
    And user validates all links working properly


  Scenario: Events page validation
    Given user navigates to zwift home page
    When user click on burger button
    Then user click on events
    And user validates events "events" page url
    And user click on filter events button
    Then user populates the Sports Running, Intensities B, and Start Times Morning  dropdown fields and press apply filters
    And user validates events have changed according to populate




