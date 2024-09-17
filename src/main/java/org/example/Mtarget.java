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

public class Mtarget extends Login {

    private WebDriver driver;


    private String getErrorMessage(WebElement field) {
        try {
            WebElement errorMessage = field.findElement(By.xpath("following-sibling::div[contains(@class, 'v-messages__message')]"));
            return errorMessage.isDisplayed() ? errorMessage.getText() : "";
        } catch (Exception e) {
            return "";  // No error message found
        }
    }

    @Test
    public void information1() {
        setup();
        login();
        List<WebElement> detailtab = driver.findElements(By.cssSelector(".v-btn.v-theme--SCREEN_MODE_LIGHT.v-btn--density-default.v-btn--size-default.v-btn--variant-flat.px-5.d-flex.align-center.text-capitalize.classification.bg-transparent"));get(4);

        WebElement  Mtarget_detailtab = detailtab.get(4);
        Mtarget_detailtab.click();



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
