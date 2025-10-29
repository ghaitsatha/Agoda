package stepdefinitions;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import Pages.ContactDetailsPage;
import Pages.FlightResultPage;
import Pages.HomePage;

public class StepsBookingFlight {
    WebDriver driver;
    HomePage homePage;
    FlightResultPage resultPage;
    String selectedAirline;
    ContactDetailsPage contactPage;
    

    @Given("user open agoda")
    public void open_agoda() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.agoda.com/");
    }
    
    @When("user search flight from {string} to {string} for tomorrow")
    public void search_flight(String from, String to) {
        homePage = new HomePage(driver);
        homePage.goToFlightPage();
        homePage.enterCities(from, to);
        homePage.selectTomorrowDate();
        homePage.clickSearch();
    }

    @When("user search airline {string}")
    public void search_airline(String airline){
        resultPage = new FlightResultPage(driver);
        selectedAirline = airline;
        resultPage.selectAirAsiaCheapest();
    }

    @When("user chooses the cheapest available flight")
    public void choose_cheapest() {
        // Already chosen in previous step
    }

    @Then("user should see correct airline and price on contact details page")
    public void verify_details() {
        contactPage = new ContactDetailsPage(driver);
        assertTrue(contactPage.getAirlineName().contains(selectedAirline));
        assertNotNull(contactPage.getTotalPrice());
        driver.quit();
    }
}
