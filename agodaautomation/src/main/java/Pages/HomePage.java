package Pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    By flightTab = By.xpath("//span[text()='Flights' or contains(text(),'Flight')]");
    By fromCity = By.xpath("//input[contains(@placeholder,'Origin')]");
    By toCity = By.xpath("//input[contains(@placeholder,'Destination')]");
    By dateInput = By.xpath("//div[contains(@data-selenium, 'departure-date-input')]");
    //By nextMonthBtn = By.xpath("//button[contains(@aria-label,'Next Month')]");
    By searchButton = By.xpath("//button[contains(.,'Search')]");


    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void goToFlightPage(){
        wait.until(ExpectedConditions.elementToBeClickable(flightTab)).click();
    }


    public void enterCities(String from, String to){
        wait.until(ExpectedConditions.elementToBeClickable(fromCity)).click();
        driver.findElement(fromCity).sendKeys(from);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(),'" + from + "')]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(toCity)).click();
        driver.findElement(toCity).sendKeys(to);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(),'" + to + "')]"))).click();
    }

    public void selectTomorrowDate(){
        wait.until(ExpectedConditions.elementToBeClickable(dateInput)).click();
        
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        String formattedDate = tomorrow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        
        // Click date cell
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//div[@data-date='" + formattedDate + "']")
        )).click();
    }

    public void clickSearch(){
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }
}
