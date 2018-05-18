package automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class JWSite {
    private final WebDriver driver;

    @FindBy(name = "email")
    private WebElement emailField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(css = "button[id='submit_login']")
    private WebElement loginButton;

    @FindBy(id = "player-title")
    private WebElement playerTitle;

    @FindBy(css = "button[class='button button-default button-med ng-binding']")
    private WebElement saveChangesButton;

    @FindBy(css = "button[id='close_plyr_builder']")
    private WebElement closePlayerBuilderButton;

    public JWSite(WebDriver commonDriver) {
        driver = commonDriver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
    }

    public void load() {
        driver.get("https://dashboard.jwplayer.com/");
    }

    public void login(String email, String password) {
        emailField.clear();
        emailField.sendKeys(email);
        passwordField.clear();
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void clickLink(String linkName) {
        driver.findElement(By.linkText(linkName)).click();
    }

    public void clickPlayer(String playerName){
        driver.findElement(By.linkText(playerName)).click();
    }

    public void renamePlayerTo(String newPlayerName) throws Throwable{
        playerTitle.clear();
        Thread.sleep(2000);
        playerTitle.sendKeys(newPlayerName);
    }

    public void saveMyChanges() {
        saveChangesButton.click();
    }

    public void closePlayerBuilderPage() throws Throwable {
        Thread.sleep(5000);
        closePlayerBuilderButton.click();
    }

    public void checkPlayerNameExists(String playerName) throws Throwable {
        Thread.sleep(1000);
        assertThat(driver.findElement(By.linkText(playerName)).isDisplayed(), is(true));
    }
}
