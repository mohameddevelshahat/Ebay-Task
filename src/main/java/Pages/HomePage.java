package Pages;

import Utilities.DataUtils;
import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class HomePage {

    private final WebDriver driver;

    private final By SearchFieldLocator = By.cssSelector("#gh-ac");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isHomePageLoaded() {
        return driver.getTitle().contains("eBay");
    }

    public void searchFor() throws IOException {
        Utility.sendData(driver , SearchFieldLocator ,
                DataUtils.getJsonData("searchData", "searchKeyword"));
        Utility.clickEnter(driver);
    }
}
