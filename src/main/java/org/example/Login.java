package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;


public class Login {

    protected WebDriver chromeDriver;

    //    @BeforeMethod
    public void setup() {
        chromeDriver = new ChromeDriver();
    }

    public void login() {
        try {
            chromeDriver.get("http://192.168.0.231:22003/invoice-calculation");
//            chromeDriver.manage().window().maximize();
            sleep(1000);

            WebElement button1 = chromeDriver.findElement(By.className("classification"));
            button1.click();
            sleep(500);

            WebElement inputacc = chromeDriver.findElement(By.xpath("//input[@placeholder='アカウントID']"));
            inputacc.sendKeys("00005445");
            sleep(1000);
            WebElement inputpwd = chromeDriver.findElement(By.xpath("//input[@placeholder='パスワード']"));
            inputpwd.click();
            inputpwd.sendKeys("itec@544");
            sleep(1000);
            WebElement loginButton = chromeDriver.findElement(By.cssSelector(".v-btn.v-btn--flat.v-theme--SCREEN_MODE_LIGHT.bg-primary.v-btn--density-default.v-btn--size-default.v-btn--variant-elevated.width-100.rounded-3.font-weight-bold"));
            loginButton.click();
            sleep(500);
            

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
//    protected WebDriver chromeDriver;
//    WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
//    //    @BeforeMethod
//    public void setup() {
//        chromeDriver = new ChromeDriver();
//    }
//
//    public void login() {
//        try {
//            chromeDriver.get("http://192.168.0.231:25002/invoice-calculation");
//
//            WebElement button1 = wait.until(ExpectedConditions.elementToBeClickable(By.className("classification")));
//            button1.click();
//
//            WebElement inputacc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='アカウントID']")));
//            inputacc.sendKeys("00005445");
//
//            WebElement inputpwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='パスワード']")));
//            inputpwd.click();
//            inputpwd.sendKeys("itec@544");
//
//            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".v-btn.v-btn--flat.v-theme--SCREEN_MODE_LIGHT.bg-primary.v-btn--density-default.v-btn--size-default.v-btn--variant-elevated.width-100.rounded-3.font-weight-bold")));
//            loginButton.click();
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

    @AfterClass
    public void cleanup() {
        if (chromeDriver != null) {
            chromeDriver.quit();
        }
    }

    protected void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
            Thread.currentThread().interrupt();
        }
    }

}