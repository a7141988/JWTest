package automation.stepdefs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import automation.pages.JWSite;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class JWSteps {
    private final JWSite JWSite;

    private final Logger logger = LoggerFactory.getLogger(JWSteps.class);

    private String finalPlayerName, finalAspectRatio;

    public JWSteps(JWSite commonJWSite) {
        JWSite = commonJWSite;
    }

    @Given("^I am on the JW Player Dashboard Page$")
    public void landOnJWDashboard() {
        JWSite.load();
    }

    @Given("^I log in using the email (.*) and the password (.*)$")
    public void logIntoJWDashboard(String email, String password){
        JWSite.login(email, password);
    }

    @Given("^I click on the Players link$")
    public void gotoPlayers(){
        JWSite.clickPlayersLink();
    }

    @Given("^I click on the player named (.*)$")
    public void clickonPlayer(String playerName){
        JWSite.clickPlayer(playerName);
    }

    @When("^I rename the player to (.*)$")
    public void renamePlayer(String newPlayerName) throws Throwable{
        JWSite.renamePlayerTo(newPlayerName);
        finalPlayerName = newPlayerName;
    }

    @When("^I change the aspect ratio to (.*)$")
    public void changeAspectRatio(String newAspectRatio) {
        JWSite.changeAspectRatioTo(newAspectRatio);
        finalAspectRatio = newAspectRatio;
    }

    @When("^I save my changes$")
    public void saveChanges() {
        JWSite.saveMyChanges();
    }

    @When("^I close the player builder page$")
    public void closePlayerBuilder() throws Throwable{
        JWSite.closePlayerBuilderPage();
    }

    @Then("^the name and size of the player should be correct$")
    public void verifyPlayerNameandSize() throws Throwable {
        assertTrue(JWSite.checkPlayerNameExists(finalPlayerName));
        assertEquals(finalAspectRatio, JWSite.checkPlayerSize(finalPlayerName));
    }
}
