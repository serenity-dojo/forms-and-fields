package serenitylabs.tutorials.vetclinic.webdriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class WhenLocatingElements {
    WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        URL testSiteUrl = getClass().getResource("/site/elements.html");
        driver.get(testSiteUrl.toString());
    }

    @Test
    public void find_an_element_by_id() {
        // TODO: Find the first name field by id
        WebElement firstName = null;

        assertThat(firstName.getAttribute("placeholder"), equalTo("Enter the first name here"));
    }

    @Test
    public void find_an_element_by_name() {
        // TODO: Find the last name field by name
        WebElement lastName = null;

        assertThat(lastName.getAttribute("placeholder"), equalTo("Enter the last name here"));
    }


    @Test
    public void finding_an_element_by_tag() {
        // TODO: Find the blockquote field by its HTML tag
        WebElement quote = null;

        assertThat(quote.getText(), containsString("locating and manipulating elements"));
    }

    @Test
    public void finding_an_element_by_slink_text() {
        // TODO: Find the 'Next Section' link by link text
        WebElement nextSection = null;

        assertThat(nextSection.getText(), equalTo("Next Section"));
    }

    @Test
    public void finding_the_new_todo_field_by_css() {
        // TODO: Find the Country of Origin dropdown using a CSS selector
        WebElement countryDropdown = null;

        new Select(countryDropdown).getOptions();
        assertThat(new Select(countryDropdown).getOptions(), hasSize(6));
    }

    @Test
    public void entering_values_into_text_fields() {
        // TODO: Enter Sarah-Jane Smith into the first and last names
        WebElement firstName = null;
        WebElement lastName = null;

        assertThat(firstName.getAttribute("value"), equalTo("Sarah-Jane"));
        assertThat(lastName.getAttribute("value"), equalTo("Smith"));
    }

    @Test
    public void setting_a_checkbox() {
        // TODO: Check the VIP checkbox
        WebElement vip = null;

        assertThat(vip.isSelected(), equalTo(true));
    }

    @Test
    public void setting_a_radio_button() {
        // TODO: Select the 'Courrier Pigeon' option in the notifications radio buttons
        WebElement notificationsByCourrierPigeon = null;

        assertThat(driver.findElement(By.id("notifications-preference")).getText(), equalTo("Pigeon"));
    }


    @After
    public void shutdown() {
        driver.quit();
    }
}
