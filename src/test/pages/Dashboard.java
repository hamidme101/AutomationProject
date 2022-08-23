package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard {

    WebDriver driver;

    //Constructor that will be automatically called as soon as the object of the class is created
    public Dashboard(WebDriver driver) {
        this.driver=driver;
    }

    //Locators for the page title and the logout button
    // By heading = By.xpath("//div[@class=\"main-header\"]");

    By heading = By.xpath("//*[@id=\"navbarCollapse\"]/ul[2]/li[2]/a/span");


   // By logoutBtn = By.id("top_header_profile_image");

    //Method to capture the page heading
    public String getHeading() {
        String head = driver.findElement(heading).getText();
        return head;
    }

    //Method to click on Logout button
    public void clickLogout() throws InterruptedException {
        // Todo
        // driver.findElement(logoutBtn).click();
        driver.findElement(By.id("top_header_profile_image")).click();
        //*[@id="top_bar_profile_option"]/li[9]/a

        Thread.sleep(1000);
        // driver.findElement(By.xpath("//*[@id=\"top_bar_profile_option\"]/li[12]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"top_bar_profile_option\"]/li[11]/a")).click();



        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"delete\"]")).click();

        Thread.sleep(1000);
    }
}