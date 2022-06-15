package runner;

import utilities.Utils;
import environment.Setup;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.SignUp;

import java.io.IOException;

public class Run extends Setup {
    Utils utils;

    @Test(priority = 1)
    public void runValid() throws IOException, ParseException {
        utils = new Utils(driver);
        driver.get("https://miro.com/signup/");
        SignUp signUp = new SignUp(driver);
        String name = utils.readFromJSON(0, "name");
        String email = utils.readFromJSON(0, "email");
        String pass = utils.readFromJSON(0, "password");
        signUp.doSignUp(name, email, pass);
    }

    @Test(priority = 2)
    public void runInvalidEmail() throws IOException, ParseException {
        utils = new Utils(driver);
        driver.get("https://miro.com/signup/");
        SignUp signUp = new SignUp(driver);
        String name = utils.readFromJSON(0, "name");
        String email = utils.readFromJSON(0, "invalidEmail");
        String pass = utils.readFromJSON(0, "password");
        signUp.signUpInvalidEmail(name, email, pass);
    }

    @Test(priority = 3)
    public void runMissingEmail() throws IOException, ParseException {
        utils = new Utils(driver);
        driver.get("https://miro.com/signup/");
        SignUp signUp = new SignUp(driver);
        String name = utils.readFromJSON(0, "name");
        String pass = utils.readFromJSON(0, "password");
        signUp.signUpMissingEmail(name, pass);
    }

    @Test(priority = 4)
    public void runMissingName() throws IOException, ParseException {
        utils = new Utils(driver);
        driver.get("https://miro.com/signup/");
        SignUp signUp = new SignUp(driver);
        String email = utils.readFromJSON(0, "email");
        String pass = utils.readFromJSON(0, "password");
        signUp.signUpMissingEmail(email, pass);
    }

    @Test(priority = 5)
    public void runMissingPassword() throws IOException, ParseException {
        utils = new Utils(driver);
        driver.get("https://miro.com/signup/");
        SignUp signUp = new SignUp(driver);
        String email = utils.readFromJSON(0, "email");
        String name = utils.readFromJSON(0, "name");
        signUp.signUpMissingPassword(name, email);
    }

    @Test(priority = 6)
    public void runMissingTerm() throws IOException, ParseException, InterruptedException {
        utils = new Utils(driver);
        driver.get("https://miro.com/signup/");
        SignUp signUp = new SignUp(driver);
        String name = utils.readFromJSON(0, "name");
        String email = utils.readFromJSON(0, "email");
        String pass = utils.readFromJSON(0, "password");
        signUp.signUpMissingTerm(name, email, pass);
    }
}
