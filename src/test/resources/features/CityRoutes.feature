@city-routes

Feature: City Connection Test

Description: Testing that the CityManager's implementation of RouteManager is correct

  Scenario: Test city connections and routes
    Given the city Washington is connected to the city Philadelphia
    And the city Philadelphia is connected to the city Newark
    And the city Newark is connected to the city New York
    And the city Tokyo is connected to the city Hong Kong
    Then the connection between New York and Washington should be true
    And the connection between Washington and New York should be true
    And the connection between New York and Tokyo should be false
    And the connection between Tokyo and New York should be false
    And the route between New York and Washington should be [New York, Newark, Philadelphia, Washington]
    And the route between Washington and New York should be [Washington, Philadelphia, Newark, New York]
    And the route between New York and Tokyo should be []
    And the route between Tokyo and New York should be []