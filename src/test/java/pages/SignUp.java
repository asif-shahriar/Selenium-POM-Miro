package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class SignUp {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public SignUp(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "name")
    WebElement nameField;
    @FindBy(id = "email")
    WebElement emailField;
    @FindBy(id = "password")
    WebElement passField;
    @FindBy(id = "onetrust-accept-btn-handler")
    WebElement acceptCookie;
    @FindBy(className = "mr-checkbox-1__check")
    List<WebElement> acceptCheckBox;
    @FindBy(id = "nameError")
    WebElement nameError;
    @FindBy(id = "termsError")
    WebElement termError;
    @FindBy(id = "emailError")
    WebElement emailError;
    @FindBy(css = "div[data-testid='please-enter-your-password-1']")
    WebElement passError;
    @FindBy(className = "signup__submit")
    WebElement btnSubmit;
    @FindBy(xpath = "//h1[contains(text(),'Check your email')]")
    WebElement assertTitle;

    public void doSignUp(String name, String email, String pass) {
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(nameField)).sendKeys(name);
        emailField.sendKeys(email);
        passField.sendKeys(pass);
        wait.until(ExpectedConditions.visibilityOf(acceptCookie));
        actions.moveToElement(acceptCookie).click().build().perform();
        acceptCheckBox.get(0).click();
        wait.until(ExpectedConditions.elementToBeClickable(btnSubmit)).click();
        String message = assertTitle.getText();
        Assert.assertTrue(message.contains("Check your email"));
    }

    public void signUpInvalidEmail(String name, String email, String pass) {
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(nameField)).sendKeys(name);
        emailField.sendKeys(email);
        passField.sendKeys(pass);
        acceptCheckBox.get(0).click();
        wait.until(ExpectedConditions.elementToBeClickable(btnSubmit)).click();
        String message = emailError.getText();
        Assert.assertTrue(message.contains("Enter a valid email address."));
    }

    public void signUpMissingEmail(String name, String pass) {
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(nameField)).sendKeys(name);
        passField.sendKeys(pass);
        acceptCheckBox.get(0).click();
        wait.until(ExpectedConditions.elementToBeClickable(btnSubmit)).click();
        String message = emailError.getText();
        Assert.assertTrue(message.contains("Enter your email address."));
    }

    public void signUpMissingName(String email, String pass) {
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(emailField));
        emailField.sendKeys(email);
        passField.sendKeys(pass);
        acceptCheckBox.get(0).click();
        wait.until(ExpectedConditions.elementToBeClickable(btnSubmit)).click();
        String message = nameError.getText();
        Assert.assertTrue(message.contains("Please enter your name."));
    }

    public void signUpMissingPassword(String name, String email) {
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(nameField)).sendKeys(name);
        emailField.sendKeys(email);
        acceptCheckBox.get(0).click();
        wait.until(ExpectedConditions.elementToBeClickable(btnSubmit)).click();
        String message = passError.getText();
        Assert.assertTrue(message.contains("Enter your password."));
    }

    public void signUpMissingTerm(String name, String email, String pass) throws InterruptedException {
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(nameField)).sendKeys(name);
        emailField.sendKeys(email);
        passField.sendKeys(pass);
        wait.until(ExpectedConditions.elementToBeClickable(btnSubmit)).click();
        String message = termError.getText();
        Assert.assertTrue(message.contains("Please agree with the Terms to sign up."));
    }

}
