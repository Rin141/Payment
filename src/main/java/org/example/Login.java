package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

import java.util.List;


public class Login {

    protected WebDriver chromeDriver;

    //    @BeforeMethod
    public void setup() {
        chromeDriver = new ChromeDriver();
    }

    public void login() {
        try {
//            chromeDriver.get("http://192.168.0.231:22003/migration-target");
            chromeDriver.get("http://192.168.0.231:25001/login");
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
            sleep(2000);

//            Use for app contract
            WebElement MenuButton = chromeDriver.findElement(By.cssSelector(".v-btn.v-theme--SCREEN_MODE_LIGHT.v-btn--density-default.v-btn--size-default.v-btn--variant-flat.px-5.d-flex.align-center.btn-draw.bg-transparent.pb-1"));
            MenuButton.click();
            sleep(1000);

            WebElement PaymentButton = chromeDriver.findElement(By.cssSelector(".v-list-item.v-list-item--link.v-theme--SCREEN_MODE_LIGHT.v-list-item--density-default.v-list-item--one-line.v-list-item--variant-text.page-function-4"));
         PaymentButton.click();
            sleep(4000);

            //linked aggregate tab
            List<WebElement> detailtab = chromeDriver.findElements(By.cssSelector(".v-btn.v-theme--SCREEN_MODE_LIGHT.v-btn--density-default.v-btn--size-default.v-btn--variant-flat.px-5.d-flex.align-center.text-capitalize.classification.bg-transparent"));
            WebElement Mtarget_detailtab = detailtab.get(3);
            Mtarget_detailtab.click();
            sleep(5000);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


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