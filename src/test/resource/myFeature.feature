Feature: Failing test

  @Fail
   Scenario: My second test
     Given Navigate to "emag.ro" app
     When  I search the "lenovo T570"
     And i click on find button
     Then it should be dispalyed the "lenovo T570" and number of "27"