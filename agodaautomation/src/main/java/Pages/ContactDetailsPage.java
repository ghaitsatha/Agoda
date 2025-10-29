package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactDetailsPage {
    WebDriver driver;

    By airlineLabel = By.xpath("//div[contains(@class,'airline-name')]");
    By totalPrice = By.xpath("//span[contains(@class,'total-price')]");

    public ContactDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAirlineName() {
        return driver.findElement(airlineLabel).getText();
    }

    public String getTotalPrice() {
        return driver.findElement(totalPrice).getText();
    }
}
