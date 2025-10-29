package Pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class HomePage {
    WebDriver driver;

    By flightTab =  By.xpath("//a[contains(@href,'flights')]");    
    By fromCity = By.id("flight-origin");
    By toCity = By.id("flight-destination");
    By datePicker = By.cssSelector(".DayPicker-Day--selected");
    By searchButton = By.xpath("//button[contains(text(),'Search')]");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToFlightPage(){
        driver.findElement(flightTab).click();
    }

    public void enterCities(String from, String to){
        driver.findElement(fromCity).sendKeys(from);
        driver.findElement(toCity).sendKeys(to);
    }

    public void selectTomorrowDate(){
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        String formattedDate = tomorrow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        driver.findElement(By.xpath("//div[@data-date='" + formattedDate + "']")).click();
    }

     public void clickSearch(){
        driver.findElement(searchButton).click();
    }
}
