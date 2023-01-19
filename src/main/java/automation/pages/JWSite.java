package automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

public class JWSite {
    private final WebDriver driver;

    //Xpath can be found in google chrome via right click -> Inspect.  Then click on element and right click -> Copy -> Copy XPath
    //Xpath needs to be surrounded by double quotes
    @FindBy(xpath = "//*[@id=\"jw-dash-root\"]/div/wui-theme-section/div/div[1]/form/wui-theme-section/div/div/wui-box/div/div[1]/wui-box/div/wui-input/div/input")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id=\"jw-dash-root\"]/div/wui-theme-section/div/div[1]/form/wui-theme-section/div/div/wui-box/div/div[2]/wui-box/div/wui-input/div/input")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"jw-dash-root\"]/div/wui-theme-section/div/div[1]/form/wui-theme-section/div/div/wui-box/div/wui-button/button/span")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"jw-dash-root\"]/div/div[2]/div[2]/wui-theme-section/div/div[1]/div/div/h1")
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

    public void load() throws Throwable {
        driver.get("https://dashboard.jwplayer.com/");
    }

    public void login(String email, String password)  {
        emailField.clear();
        emailField.sendKeys(email);
        passwordField.clear();
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void enterEmailClickPasswordField(String email) {
        emailField.clear();
        emailField.sendKeys(email);
        passwordField.clear();
        passwordField.sendKeys("");
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

    public void verifyWarningText() {
        assertEquals("The email or password you entered is incorrect. Please try again.", driver.findElement(By.xpath("//*[@id=\"jw-dash-root\"]/div/wui-theme-section/div/div[1]/form/wui-theme-section/div/div/wui-box/div/wui-alert/div")).getText());
    }

    public void verifyInvalidEmailText() {
        assertEquals("Please include an '@' in the email address. 'abc' is missing an '@'.", driver.findElement(By.xpath("//*[@id=\"jw-dash-root\"]/div/wui-theme-section/div/div[1]/form/wui-theme-section/div/div/wui-box/div/div[1]/wui-box/div/wui-input/div[2]")).getText());
    }
}
