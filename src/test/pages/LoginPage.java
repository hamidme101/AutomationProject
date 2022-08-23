package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locator for username field
    // By uName = By.id("userName");

    By uName = By.xpath("//*[@id=\"loginForm\"]/div[1]/input");


    //Locator for password field
    By pswd = By.id("password");

    By loginBtn = By.id("intro-singup");


//    //Method to enter username
//    public void enterUsername(String user) {
//        //driver.findElement(uName).sendKeys(user);
//        driver.findElement(uName).sendKeys("revesqa2@yahoo.com");
//
//    }
//
//    //Method to enter password
//    public void enterPassword(String pass) {
//        // driver.findElement(pswd).sendKeys(pass);
//        driver.findElement(pswd).sendKeys("123456");
//    }

    //Method to click on Login button
    public void clickLoginWithValidCredentials() {
        driver.findElement(uName).sendKeys("revesqa3@yahoo.com");
        driver.findElement(pswd).sendKeys("654321");
        driver.findElement(loginBtn).click();
    }

    public void clickLoginWithValidUserInvalidPassword() {
        driver.findElement(uName).sendKeys("revesqa3@yahoo.com");
        driver.findElement(pswd).sendKeys("abcdefg");
        driver.findElement(loginBtn).click();
    }


    public void clickLoginWithInValidUserValidPassword() {
        driver.findElement(uName).sendKeys("invalidrevesqa3@yahoo.com");
        driver.findElement(pswd).sendKeys("654321");
        driver.findElement(loginBtn).click();
    }

    public void clickLoginWithInValidUserInvalidPassword() {
        driver.findElement(uName).sendKeys("invalidrevesqa3@yahoo.com");
        driver.findElement(pswd).sendKeys("abcdefg");
        driver.findElement(loginBtn).click();
    }

    public String getLoginErrorMessage() {
        String loginError = driver.findElement(By.id("invalid_error")).getText();
        return loginError;
    }

    public String checkPasswordValueIsMasked() {
        return driver.findElement(pswd).getAttribute("type");
    }
}