import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Dashboard;
import pages.LoginPage;

import java.io.File;


public class Login {

    static WebDriver driver;
    static ExtentTest test;
    static ExtentReports report;
    static LoginPage login;
    static Dashboard dashboard;


    public static void main(String[] args) throws ClassNotFoundException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\New Installer Software\\seleniumDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        login = new LoginPage(driver);
        dashboard = new Dashboard(driver);
        startTest();
        checkLoginWithValidCredentials();
        checkLoginWithValidUserInvalidPassword();
        checkLoginWithInValidUserValidPassword();
        checkLoginWithInValidUserInvalidPassword();
        endTest();
    }

    public static void startTest() {
        String var10000 = System.getProperty("user.dir");
        String filePath = var10000 + File.separator + "ExtentReports" + File.separator + "AutomationTestReport.html";
        report = new ExtentReports(filePath);
        test = report.startTest("ReveChat-Automation-Test");
        driver.get("https://app.revechat.com/");
        driver.manage().window().maximize();
    }

    public static void checkLoginWithValidCredentials() throws InterruptedException {
        login.clickLoginWithValidCredentials();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (dashboard.getHeading().toString().equalsIgnoreCase("What's New"))
            test.log(LogStatus.PASS, "TC 1-Login with valid Email & valid Password: PASSED");
        else
            test.log(LogStatus.FAIL, "TC 1-Login with valid Email & valid Password: PASSED");

        dashboard.clickLogout();
    }

    public static void checkLoginWithValidUserInvalidPassword() throws InterruptedException {
        login.clickLoginWithValidUserInvalidPassword();
        Thread.sleep(1000);
        if (login.getLoginErrorMessage().toString().equalsIgnoreCase("Email address or password does not match"))
            test.log(LogStatus.PASS, "TC 2-Login with valid Email & Invalid Password: PASSED");
        else
            test.log(LogStatus.FAIL, "TC 2-Login with valid Email & Invalid Password: FAILED");
    }

    public static void checkLoginWithInValidUserValidPassword() throws InterruptedException {
        login.clickLoginWithInValidUserValidPassword();
        Thread.sleep(1000);
        if (login.getLoginErrorMessage().toString().equalsIgnoreCase("Email address or password does not match"))
            test.log(LogStatus.PASS, "TC 3-Login with Invalid Email & valid Password: PASSED");
        else
            test.log(LogStatus.FAIL, "TC 3-Login with Invalid Email & valid Password: FAILED");
    }

    public static void checkLoginWithInValidUserInvalidPassword() throws InterruptedException {
        login.clickLoginWithInValidUserInvalidPassword();
        Thread.sleep(1000);
        if (login.getLoginErrorMessage().toString().equalsIgnoreCase("Email address or password does not match"))
            test.log(LogStatus.PASS, "TC 4-Login with valid InEmail & Invalid Password: PASSED");
        else
            test.log(LogStatus.FAIL, "TC 4-Login with valid InEmail & Invalid Password: FAILED");
    }


    public static void endTest() {
        report.endTest(test);
        driver.close();
        driver.quit();
        report.flush();
    }
}
