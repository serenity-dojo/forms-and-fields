package serenitylabs.tutorials.vetclinic.webdriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class WhenInteractingWithElementsAndForms {
    WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://search.maven.org/classic/");
    }

    @Test
    public void enter_a_value_into_a_text_field() {
        // TODO: Enter 'serenity-core' into the search box

        WebElement searchBox = driver.findElement(By.id("query"));

        searchBox.sendKeys("serenity-core");

        assertThat(searchBox.getAttribute("value"),is("serenity-core"));
    }

    @Test
    public void click_a_button() {

        // TODO: Enter 'serenity-core' into the search box, then click the 'Search' button

        WebElement searchBox = driver.findElement(By.id("query"));
        WebElement searchButton = driver.findElement(By.id("queryButton"));
        searchBox.sendKeys("serenity-core");
        searchButton.click();

        WebElement searchResultsTitle = driver.findElement(By.id("pageTitle"));
        assertThat(searchResultsTitle.isDisplayed(), equalTo(true));
    }


    @Test
    public void click_on_a_button() {
        // TODO: Click on the 'Train times' tab, then enter 'London Bridge' into the 'Where from?' field
        // and `Glasgow Central' into the `Where to?' field, and then click on the Go button

        WebElement trainTimesTab = driver.findElement(By.partialLinkText("Train times"));
        trainTimesTab.click();

        WebElement originStation = driver.findElement(By.cssSelector("form[id^='TrainTimes'] input[name='origin_station']"));
        originStation.sendKeys("London Bridge");

        WebElement destinationStation = driver.findElement(By.cssSelector("form[id^='TrainTimes'] input[name='destination_station']"));
        destinationStation.sendKeys("Glasgow Central");

        WebElement findTimesAndTicketsButton = driver.findElement(By.cssSelector("button[title='Find times & tickets']"));

        findTimesAndTicketsButton.click();

        String title = driver.findElement(By.tagName("h1")).getText();
        assertThat(title, containsString("Train times from London Bridge to Glasgow Central"));
    }

    @Test
    public void click_on_a_checkbox() {
        // TODO: Click on the Remember Me checkbox
        WebElement rememberMe = driver.findElement(By.id("chkRemember"));

        rememberMe.click();

        boolean rememberMeChoice = rememberMe.isSelected();
        assertThat(rememberMeChoice, is(true));
    }

    @Test
    public void click_on_a_radio_button() {

        WebElement leaveAfter = driver.findElement(By.cssSelector("[value='arr']"));

        // TODO: Choose the 'Leave After' option and make sure it is the one selected
        leaveAfter.click();

        assertThat(leaveAfter.isSelected(), is(true));

        String leaveOrArrivePreference = leaveAfter.getAttribute("value");

        assertThat(leaveOrArrivePreference, is("arr"));
    }


    @Test
    public void choose_a_dropdown_value() {
        // TODO: Click on 12pm

        Select dateList = new Select(driver.findElement(By.id("itdTimeHour")));

        dateList.selectByVisibleText("12");

        String selectedHour = dateList.getFirstSelectedOption().getText();

        assertThat(selectedHour, is("12"));
    }

    @After
    public void shutdown() {
        driver.quit();
    }
}
