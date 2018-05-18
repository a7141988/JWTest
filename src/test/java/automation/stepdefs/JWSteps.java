package automation.stepdefs;

import automation.pages.JWSite;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JWSteps {
    private final JWSite JWSite;

    public JWSteps(JWSite commonJWSite) {
        JWSite = commonJWSite;
    }

    @Given("^I am on the JW Player Dashboard Page$")
    public void landOnJWDashboard() {
        JWSite.load();
    }

    @When("^I log in using the email (.*) and the password (.*)$")
    public void logIntoJWDashboard(String email, String password){
        JWSite.login(email, password);
    }

    @When("^I click on the (.*) link$")
    public void gotoLink(String linkName){
        JWSite.clickLink(linkName);
    }

    @When("^I click on the player named (.*)$")
    public void clickonPlayer(String playerName){
        JWSite.clickPlayer(playerName);
    }

    @When("^I rename the player to (.*)$")
    public void renamePlayer(String newPlayerName) throws Throwable{ JWSite.renamePlayerTo(newPlayerName); }

    @When("^I save my changes$")
    public void saveChanges() {
        JWSite.saveMyChanges();
    }

    @When("^I close the player builder page$")
    public void closePlayerBuilder() throws Throwable{ JWSite.closePlayerBuilderPage(); }

    @Then("^the name of the player should be (.*)$")
    public void verifyPlayerName(String expectedPlayerName) throws Throwable { JWSite.checkPlayerNameExists(expectedPlayerName); }
}
