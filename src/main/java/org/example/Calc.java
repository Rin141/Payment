package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static javax.swing.UIManager.get;

public class Calc extends Login {

    private WebDriver driver;


    private String getErrorMessage(WebElement field) {
        try {
            WebElement errorMessage = field.findElement(By.xpath("following-sibling::div[contains(@class, 'v-messages__message')]"));
            return errorMessage.isDisplayed() ? errorMessage.getText() : "";
        } catch (Exception e) {
            return "";  // No error message found
        }
    }

//    @DataProvider(name = "targetYearMonth")
//    public Object[][] targetYearMonthData() {
//        return new Object[][]{
//                {"1234567890", true},
//                {"0987654321", true},
//                {"123456789", false},
//                {"12345678901", false},
//                {"123456789a", false},
//                {"abcdefghij", false},
//                {"0000000000", true},
//                {"12345 7890", false},
//                {"12345678 0", false},
//                {"", false}
//        };
//    }
//
//    @Test(dataProvider = "targetYearMonth")
//    public void targetYearMonth(String input, boolean expectedResult) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement datePicker = wait.until(ExpectedConditions.elementToBeClickable(
//                By.cssSelector(".v-input.v-input--horizontal.v-input--center-affix.v-input--density-default.v-locale--is-ltr.v-input--error.v-text-field.iplat-text-field-default.iplat-date-picker.text-field-align-start")));
//
//        // 1.1 Check required field by pressing the Tab key
//        datePicker.clear();  // Clear data (if available)
//        datePicker.click(); // Click on the text box
//        datePicker.sendKeys(""); // Enter test data
//        datePicker.sendKeys(Keys.TAB);  // Press Tab to focus out
//
//        // Check and print out the Required error message
//        WebElement requiredMess = driver.findElement(By.xpath("//div[contains(@class, 'v-messages__message') and contains(text(), 'required')]"));
//        Assert.assertEquals(requiredMess.getText(), "対象年月は必須です", "Required error message mismatch.");
//
//        // 1.2 Check required field by pressing the Submit button
//        datePicker.clear(); // Clear data (if available)
//        datePicker.click();  // Click on the text box
//        datePicker.sendKeys(""); // Enter test data
//        datePicker.sendKeys(Keys.TAB); // Press Tab to focus out
//        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(
//                By.cssSelector(".v-btn.v-theme--SCREEN_MODE_LIGHT.bg-success.v-btn--density-default.v-btn--size-default.v-btn--variant-flat")));
//        submitButton.click();
//
//        // Check the result after pressing Submit
//        WebElement resultElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.cssSelector(".result-class"))); // Replace with the exact selector for the result display element
//
//        // Example: Verify message or status after Submit
//        String resultText = resultElement.getText();
//        boolean isValid = false /* logic to validate the output from resultText */;
//        Assert.assertEquals(isValid, expectedResult, "The result after pressing Submit is incorrect.");
//
//        // 2. Check format yyyyMM
//        datePicker.clear();  // Clear the input field
//        datePicker.sendKeys(input);  // Enter invalid format (YYYYMM requires 6 characters)
//        datePicker.sendKeys(Keys.TAB); // Press Tab to focus out
//
//        // Check and print out the Format error message
//        WebElement formatError = driver.findElement(By.xpath("//div[contains(@class, 'v-messages__message') and contains(text(), 'format')]"));
//        if (formatError.isDisplayed()) {
//            System.out.println("Format Error: " + formatError.getText());
//        } else {
//            System.out.println("No format error message displayed.");
//        }
//
//        // 3. Check that the date must be after 1/1/1900
//        datePicker.clear();  // Clear the input field
//        datePicker.sendKeys("189912");  // Enter a date before 1/1/1900
//        datePicker.sendKeys(Keys.TAB); // Press Tab to focus out
//
//        // Check and print out the date error message
//        WebElement dateError = driver.findElement(By.xpath("//div[contains(@class, 'v-messages__message') and contains(text(), 'after 1/1/1900')]"));
//        if (dateError.isDisplayed()) {
//            System.out.println("Date Error: " + dateError.getText());
//        } else {
//            System.out.println("No date error message displayed.");
//        }
//    }

    @Test
    public void information1() {
        setup();
            login();
        List<WebElement> detailtab = driver.findElements(By.cssSelector(".v-btn.v-theme--SCREEN_MODE_LIGHT.v-btn--density-default.v-btn--size-default.v-btn--variant-flat.px-5.d-flex.align-center.text-capitalize.classification.bg-transparent"));get(4);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        detailtabMigrationTarget.click();


        WebElement information1 = driver.findElement(By.xpath("//button[contains(@class, 'v-btn--icon') and contains(@class, 'bg-primary')]/span[@class='v-btn__content']/i[contains(@class, 'mdi-pencil')]"));
        information1.clear();

        String maxLengthData = "あいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあ"; // Chuỗi dài
        information1.sendKeys(maxLengthData);
        sleep(2000);
        information1.sendKeys(Keys.TAB);

        String enteredText = information1.getAttribute("value");
        Assert.assertEquals(enteredText.length(), 910, "Data nhập vào dài hơn giá trị maxlength 901!");

        information1.clear();
        // Nhập chuỗi half-width
        String halfWidthText = "ABCD1234";
        information1.sendKeys(halfWidthText);
        sleep(2000);
        information1.sendKeys(Keys.TAB);

        // Lấy giá trị sau khi focus out
        String enteredTextAfterFocusOut = information1.getAttribute("value");

        // Giả định chuỗi full-width mong đợi
        String expectedFullWidthText = "ＡＢＣＤ１２３４"; // Chuỗi full-width

        // Kiểm tra xem chuỗi đã chuyển thành full-width chưa
        Assert.assertEquals(enteredTextAfterFocusOut, expectedFullWidthText, "Chuỗi không được chuyển thành full-width!");

        // Test full-width
        information1.clear();
        // Nhập data full-width
        String fullWidthText = "ＡＢＣＤ１２３４"; // Chuỗi full-width
        information1.sendKeys(fullWidthText);
        sleep(2000);
        information1.sendKeys(Keys.TAB);

        // Lấy giá trị thực tế của trường nhập liệu sau khi nhập chuỗi full-width
        String enteredFullWidthText = information1.getAttribute("value");

        // So sánh với giá trị mong đợi
        Assert.assertEquals(enteredFullWidthText, fullWidthText, "Đã dúng là full width");
    }
    @AfterClass
    public void cleanup() {
        super.cleanup();
    }
}
