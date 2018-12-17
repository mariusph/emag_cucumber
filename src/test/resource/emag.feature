Feature: Does it works

  @Sanity
  Scenario Outline: My first test
    Given Navigate to "url" app
    And we might be redirected to special offer page
    When  I search the "<term>"
    And i click on find button
    Then it should be dispalyed the "<term>" and number of "<results>"

    Examples: 
      | term        | results |
      | lenovo T570 | 27  |
     | nvidia shield | 5  |