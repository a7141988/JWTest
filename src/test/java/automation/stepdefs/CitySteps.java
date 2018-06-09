package automation.stepdefs;

import automation.City.CityManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.Assert;

public class CitySteps {
    private final CityManager cityManager;

    public CitySteps(CityManager myManager) { cityManager = myManager; }

    @Given("^the city (.*) is connected to the city (.*)$")
    public void setConnection(String city1, String city2)
    {
        cityManager.addConnection(city1, city2);
    }

    @Then("^the connection between (.*) and (.*) should be (.*)$")
    public void testConnection(String city1, String city2, boolean expectedResult)
    {
        Assert.assertEquals(cityManager.connected(city1, city2), expectedResult);
    }

    @Then("^the route between (.*) and (.*) should be (.*)$")
    public void testRoute(String city1, String city2, String expectedRoute)
    {
        Assert.assertEquals(cityManager.getRoute(city1, city2).toString(), expectedRoute);
    }
}
