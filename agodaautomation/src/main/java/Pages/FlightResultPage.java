package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlightResultPage {
   WebDriver driver;

   public FlightResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectAirAsiaCheapest() {
        List<WebElement> flights = driver.findElements(By.xpath("//div[contains(@class,'FlightItem')]"));
        WebElement cheapest = null;
        double minPrice = Double.MAX_VALUE;

        for (WebElement flight : flights) {
            if (flight.getText().contains("AirAsia")) {
                String priceText = flight.findElement(By.xpath(".//span[contains(@class,'Price')]")).getText()
                        .replaceAll("[^0-9]", "");
                double price = Double.parseDouble(priceText);
                if (price < minPrice) {
                    minPrice = price;
                    cheapest = flight;
                }
            }
        }

        if (cheapest != null) {
            cheapest.click();
        }
    }
}
