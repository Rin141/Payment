package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class LinkedAggregate extends Login {
    private WebElement driver;


    @BeforeClass
    public void setUpAndLogin() {
        setup();  // Gọi setup từ lớp cha (nếu setup đã khởi tạo driver)
        login();  // Gọi login từ lớp cha để đăng nhập
    }

    @Test
    public void edit_button() {
        setup();  // Gọi setup từ lớp cha (nếu setup đã khởi tạo driver)
        login();  // Gọi login từ lớp cha để đăng nhập
        sleep(2000); // Chờ để đảm bảo đăng nhập xong
        // Kiểm tra xem nút edit có ẩn không
        WebElement element = driver.findElement(By.cssSelector(".v-btn.v-btn--elevated.v-btn--icon.v-theme--SCREEN_MODE_LIGHT.bg-red.v-btn--density-default.rounded-0.v-btn--size-default.v-btn--variant-elevated.mx-1.text-white"));
        Assert.assertFalse(element.isDisplayed(), "Phần tử vẫn hiển thị!");
        sleep(2000);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            try {
                driver.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
