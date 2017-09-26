package automation.pages;

import gherkin.lexer.Th;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class JWSite {
    private final String url = "https://dashboard.jwplayer.com/";
    private final WebDriver driver;

    @FindBy(name = "email")
    private WebElement emailField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(css = "button[id='submit_login']")
    private WebElement loginButton;

    @FindBy(linkText = "Players")
    private WebElement playerButton;

    @FindBy(id = "player-title")
    private WebElement playerTitle;

    @FindBy(id = "res_ratio")
    private WebElement aspectRatio;

    @FindBy(css = "button[class='button button-default button-med ng-binding']")
    private WebElement saveChangesButton;

    @FindBy(css = "button[id='close_plyr_builder']")
    private WebElement closePlayerBuilderButton;

    public JWSite(WebDriver commonDriver) {
        driver = commonDriver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    public void load() {
        driver.get(url);
    }

    public void login(String email, String password) {
        emailField.clear();
        emailField.sendKeys(email);
        passwordField.clear();
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void clickPlayersLink() {
        playerButton.click();
    }

    public void clickPlayer(String playerName){
        driver.findElement(By.linkText(playerName)).click();
    }

    public void renamePlayerTo(String newPlayerName) throws Throwable{
        playerTitle.clear();
        Thread.sleep(2000);
        playerTitle.sendKeys(newPlayerName);
    }

    public void changeAspectRatioTo(String newAspectRatio) {
       Select select = new Select(aspectRatio);
       select.selectByVisibleText(newAspectRatio);
    }

    public void saveMyChanges() {
        saveChangesButton.click();
    }

    public void closePlayerBuilderPage() throws Throwable {
        Thread.sleep(5000);
        closePlayerBuilderButton.click();
    }

    public boolean checkPlayerNameExists(String playerName) throws Throwable {
        Thread.sleep(1000);
        return driver.findElement(By.linkText(playerName)).isDisplayed();
    }

    public String checkPlayerSize(String playerName) {
        WebElement table = driver.findElement(By.xpath("//div[@class='table-responsive']/table"));
        String path = "//tr[td[a[contains(text(), '" + playerName + "')]]]/td[@class='ng-binding']";
        return table.findElement(By.xpath(path)).getText();
    };
}
