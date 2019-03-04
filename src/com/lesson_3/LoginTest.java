package com.lesson_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class LoginTest {
    WebDriver tutBy;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        tutBy = new ChromeDriver();
        tutBy.get("https://tut.by");
    }

    @AfterEach
    void tearDown() {
        tutBy.close();
    }

    @Test
    void login() {
        tutBy.findElement(By.cssSelector("a[data-target-popup='authorize-form']")).click();
        tutBy.findElement(By.name("login")).sendKeys("seleniumtests@tut.by");
        tutBy.findElement(By.name("password")).sendKeys("123456789zxcvbn");
        tutBy.findElement(By.className("auth__enter")).click();
        assertEquals(tutBy.findElement(By.className("uname")).getText(), "Selenium Test");
    }
}