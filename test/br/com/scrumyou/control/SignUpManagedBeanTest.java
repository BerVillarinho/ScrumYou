/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.scrumyou.control;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 *
 * @author Disguise
 */
public class SignUpManagedBeanTest {

    private WebDriver webdriver;

    public SignUpManagedBeanTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        webdriver = new HtmlUnitDriver();
        webdriver.get("http://localhost:8080/ScrumYou/faces/signUp.xhtmls");
    }

    @After
    public void tearDown() {
        if (webdriver != null) {
            webdriver.close();

        }
    }

    @Test
    public void testSignUpSFail() {
        WebElement name = webdriver.findElement(By.id("name"));
        WebElement email = webdriver.findElement(By.id("email"));
        WebElement password = webdriver.findElement(By.id("password"));
        WebElement submitBt = webdriver.findElement(By.id("submit"));

        name.sendKeys("Macaco");
        email.sendKeys("macaco@selva.com");
        password.sendKeys("ape");

        submitBt.click();

        String expected = "Error";
        assertTrue(webdriver.getPageSource().contains(expected));
    }

}
