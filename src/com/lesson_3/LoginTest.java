package com.lesson_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


class LoginTest {
    WebDriver tutBy;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        tutBy = new ChromeDriver();
        tutBy.get("https://tut.by");
        tutBy.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterEach
    void tearDown() {
        tutBy.close();
    }

    @Test
    void login() {
        // unconditional synchronization
        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException ie){
        }
        tutBy.findElement(By.cssSelector("a[data-target-popup='authorize-form']")).click();
        tutBy.findElement(By.name("login")).sendKeys("seleniumtests@tut.by");
        tutBy.findElement(By.name("password")).sendKeys("123456789zxcvbn");
        tutBy.findElement(By.className("auth__enter")).click();

        WebElement content = tutBy.findElement(By.className("uname"));

        // Explicit Wait
        WebDriverWait explicitWait = new WebDriverWait(tutBy, 10);
        explicitWait.pollingEvery(Duration.ofSeconds(2));
        explicitWait.until(ExpectedConditions.visibilityOf(content));
        assertEquals(content.getText(), "Selenium Test");
    }
}