package automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

public class CodilitySteps {
    private final WebDriver driver;

    @FindBy(id = "email-input")
    private WebElement emailField;

    @FindBy(id = "password-input")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public CodilitySteps(WebDriver commonDriver) {
        driver = commonDriver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
    }

    public void land() throws Throwable
    {
        driver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");
        Thread.sleep(500);
    }

    public void login(String email, String password) throws Throwable
    {
        emailField.clear();
        if(email != null)
        {
            emailField.sendKeys(email);
        }
        passwordField.clear();
        if(password != null)
        {
            passwordField.sendKeys(password);
        }
        loginButton.click();
        Thread.sleep(500);
    }

    public void textVerify(String loginType, String text)
    {
        WebElement theMessage;
        switch(loginType)
        {
            case "successful":
                theMessage = driver.findElement(By.cssSelector(".message.success"));
                assertEquals("the messages don't match", theMessage.getText(), text);
                break;
            case "incorrect":
                theMessage = driver.findElement(By.cssSelector(".message.error"));
                assertEquals("the messages don't match", theMessage.getText(), text);
                break;
            case "invalid":
                theMessage = driver.findElement(By.cssSelector(".validation.error"));
                assertEquals("the messages don't match", theMessage.getText(), text);
                break;
        }
    }

    public void verifyElementsDisplayed()
    {
        assertTrue(emailField.isDisplayed());
        assertTrue(passwordField.isDisplayed());
        assertTrue(loginButton.isDisplayed());
        assertTrue(loginButton.isEnabled());
    }
}
