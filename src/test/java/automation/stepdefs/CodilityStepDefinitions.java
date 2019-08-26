package automation.stepdefs;

import automation.pages.CodilitySteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CodilityStepDefinitions {
    private final CodilitySteps codilitySteps;

    public CodilityStepDefinitions(CodilitySteps codSteps) { codilitySteps = codSteps; }

    @Given("^I am on the Codility Login Page$")
    public void landOnCodilitySite() throws Throwable
    {
        codilitySteps.land();
    }

    @When("^login is attempted using the email (.*) and the password (.*)$")
    public void logIn(String email, String password) throws Throwable
    {
        codilitySteps.login(email, password);
    }

    @When("^login is attempted using the email (.*) and no password$")
    public void logInNoPassword(String email) throws Throwable
    {
        codilitySteps.login(email, null);
    }

    @When("^login is attempted using no email and the password (.*)$")
    public void logInNoEmail(String password) throws Throwable
    {
        codilitySteps.login(null, password);
    }

    @Then("^the login should be considered (.*) and the text (.*) should be displayed$")
    public void verifyText(String loginType, String text)
    {
        codilitySteps.textVerify(loginType, text);
    }

    @Then("^the email, password, and login button should be displayed$")
    public void verifyElementsAreDisplayed()
    {
        codilitySteps.verifyElementsDisplayed();
    }
}