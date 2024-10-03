package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class PaymentHistory extends Login {

    @BeforeClass
    public void setUpAndLogin() {
        setup();
        login();
        WebElement HistoryPayment_DetailTab = chromeDriver.findElement(By.id("detail-76"));
        HistoryPayment_DetailTab.click();
        sleep(1000);


    }
    @Test
    //first input yyyyMMdd
    public void FirstDateInput()  {
        List<WebElement> Inputs = chromeDriver.findElements(By.className("v-field__input"));
        WebElement dateInput = Inputs.get(12);
        dateInput.sendKeys("20241f03");
        sleep(2000);

        WebElement submitButton = chromeDriver.findElement(By.cssSelector(".v-btn.v-theme--SCREEN_MODE_LIGHT.bg-success.v-btn--density-default.v-btn--size-default.v-btn--variant-flat.ml-2"));
        submitButton.click();
        sleep(2000);

        List<WebElement> errorMessages = chromeDriver.findElements(By.className("v-input__details"));
        WebElement errorMessages1 = errorMessages.get(12);

        Assert.assertEquals(errorMessages1.getText(), "取引年月日はyyyyMMdd形式の日付パターンで入力してください");
    }

    @Test
    //first input yyyyMMdd
    public void SecondDateInput()  {
        List<WebElement> Inputs = chromeDriver.findElements(By.className("v-field__input"));
        WebElement dateInput = Inputs.get(13);
        dateInput.sendKeys("20241f03");
        dateInput.sendKeys(Keys.TAB);
        sleep(1000);


//        WebElement submitButton = chromeDriver.findElement(By.cssSelector(".v-btn.v-theme--SCREEN_MODE_LIGHT.bg-success.v-btn--density-default.v-btn--size-default.v-btn--variant-flat.ml-2"));
//        submitButton.click();
//        sleep(2000);

        List<WebElement> errorMessages = chromeDriver.findElements(By.className("v-input__details"));
        WebElement errorMessages1 = errorMessages.get(13);

        Assert.assertEquals(errorMessages1.getText(), "取引年月日はyyyyMMdd形式の日付パターンで入力してください"); // No error message expected for valid date
    }

//    @Test
//    public void testValidDateRange() {
//        WebElement startDateInput = chromeDriver.findElement(By.id("startDateInput"));
//        WebElement endDateInput = chromeDriver.findElement(By.id("endDateInput"));
//
//        startDateInput.clear();
//        startDateInput.sendKeys("20241001");
//        endDateInput.clear();
//        endDateInput.sendKeys("20241010");
//        WebElement submitButton = chromeDriver.findElement(By.id("submit"));
//        submitButton.click();
//
//        sleep(2000);
//
//        WebElement errorMessage = chromeDriver.findElement(By.id("errorMessage"));
//        Assert.assertEquals(errorMessage.getText(), ""); // No error message expected for valid date range
//    }
//
//    @Test
//    public void testInvalidDateRange(){
//        WebElement startDateInput = chromeDriver.findElement(By.id("startDateInput"));
//        WebElement endDateInput = chromeDriver.findElement(By.id("endDateInput"));
//
//        startDateInput.clear();
//        startDateInput.sendKeys("20241010"); // Start date is later than end date
//        endDateInput.clear();
//        endDateInput.sendKeys("20241001");   // End date is earlier
//
//        WebElement submitButton = chromeDriver.findElement(By.id("submit"));
//        submitButton.click();
//
//        sleep(2000);
//
//        WebElement errorMessage = chromeDriver.findElement(By.id("errorMessage"));
//        Assert.assertEquals(errorMessage.getText(), "対象期間（開始年月日）は対象期間（終了年月日）で入力された値以下で入力してください"); // Expected error message
//    }
//
//    @Test
//    public void testInvalidDate() {
//        WebElement dateInput = chromeDriver.findElement(By.id("dateInput"));
//        dateInput.clear();
//        dateInput.sendKeys("20241301");
//
//        WebElement submitButton = chromeDriver.findElement(By.id("submit"));
//        submitButton.click();
//
//        sleep(2000);
//
//        WebElement errorMessage = chromeDriver.findElement(By.id("errorMessage"));
//        Assert.assertEquals(errorMessage.getText(), "Invalid date format");
//    }

    @AfterClass
    public void tearDown() {
        if (chromeDriver != null) {
            chromeDriver.quit(); // Close the browser and end the session
        }
    }
}
