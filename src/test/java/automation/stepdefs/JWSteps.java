package automation.stepdefs;

import automation.pages.JWSite;
import io.cucumber.java.en.*;

public class JWSteps {
    private final JWSite JWSite;

    public JWSteps(JWSite commonJWSite) {
        JWSite = commonJWSite;
    }

    @Given("^I am on the JW Player Dashboard Page$")
    public void landOnJWDashboard() throws Throwable  {
        JWSite.load();
    }

    @When("^I log in using the email (.*) and the password (.*)$")
    public void logIntoJWDashboard(String email, String password) {
        JWSite.login(email, password);
    }

    @When("^I use the email (.*) to log in and do not enter a password$")
    public void logIntoJWDashboard(String email) {
        JWSite.enterEmailClickPasswordField(email);
    }

    @When("^I click on the (.*) link$")
    public void gotoLink(String linkName){
        JWSite.clickLink(linkName);
    }

    @When("^I click on the player named (.*)$")
    public void clickonPlayer(String playerName) {
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

    @Then("^The correct login error text should appear$")
    public void verifyWarning() {
        JWSite.verifyWarningText();
    }

    @Then("^The correct invalid email text should appear$")
    public void verifyEmailWarning() {
        JWSite.verifyInvalidEmailText();
    }
}
