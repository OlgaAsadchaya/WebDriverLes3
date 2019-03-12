package com.lesson_3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ByVariables {
    WebDriver tutBy;

    @Test
    void variables() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\SergeyA\\Downloads\\chromedriver.exe");
        WebDriver tutBy = new ChromeDriver();
        tutBy.get("https://tut.by");

        WebElement byCssSelector = tutBy.findElement(By.cssSelector("a[data-target-popup='authorize-form']"));
        assertNotNull(byCssSelector);
        WebElement byName = tutBy.findElement(By.name("login"));
        assertNotNull(byName);
        WebElement byClassName = tutBy.findElement(By.className("auth__enter"));
        assertNotNull(byClassName);
        WebElement byId = tutBy.findElement(By.id("geotarget_top_selector"));
        assertNotNull(byId);
        WebElement byLinkText = tutBy.findElement(By.linkText("Афиша"));
        assertNotNull(byLinkText);
        WebElement byPartialLinkText = tutBy.findElement(By.partialLinkText("Афиша"));
        assertNotNull(byPartialLinkText);
        WebElement byXpath = tutBy.findElement(By.xpath("//div[@data-id]"));
        assertNotNull(byXpath);
    }
}