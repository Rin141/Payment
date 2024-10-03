package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class linkedAggregate extends Login {
    private WebDriver driver;  // Khai báo driver

    @BeforeClass
    public void setUpAndLogin() {
        setup();
        login();
    }
//
//    @Test
//    public void click_add() {
//
//        WebElement button_add = driver.findElement(By.cssSelector(".v-btn.v-theme--SCREEN_MODE_LIGHT.bg-primary.v-btn--density-default.v-btn--size-default.v-btn--variant-flat"));
//        button_add.click();
//        sleep(5000);
//
//
//    }

    @Test
    public void click_edit() {
        /*WebElement  data18 = driver.findElement(By.cssSelector(".v-data-table__td.v-data-table-column--align-start"));*/
        List<WebElement> data = chromeDriver.findElements(By.cssSelector(".v-data-table__td.v-data-table-column--align-start"));
        WebElement data18 = data.get(11);
        data18.click();
        sleep(3000);

        List<WebElement>  edit = chromeDriver.findElements(By.cssSelector(".v-btn__overlay"));
        WebElement edit1 = edit.get(15);
//        WebElement button_edit = driver.findElement(By.cssSelector(".v-btn.v-btn--elevated.v-btn--icon.v-theme--SCREEN_MODE_LIGHT.bg-primary.v-btn--density-default.rounded-0.v-btn--size-default.v-btn--variant-elevated.mx-1.text-white"));
        edit1.click();
        sleep(3000);
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
