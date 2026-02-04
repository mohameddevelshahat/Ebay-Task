package Pages;


import Utilities.DataUtils;
import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;

public class Search_Results {

    private final WebDriver driver;

    private final By resultsLocator = By.cssSelector("h1.srp-controls__count-heading span.BOLD:nth-of-type(1)");
    private final By manualFilterLocator = By.xpath("//span[normalize-space()='Free International Shipping']");
    private final By filterResultsLocator = By.cssSelector("h1.srp-controls__count-heading > span.BOLD:first-of-type\n");

    public Search_Results(WebDriver driver) {
        this.driver = driver;
    }

    public int getResultsCount() {
        return Integer.parseInt(Utility.getText(driver, resultsLocator).replace(",", ""));
    }

    public Search_Results clickFilter() throws FileNotFoundException {
        Utility.scrolling(driver , manualFilterLocator);
        Utility.clickOnElement(driver, manualFilterLocator);
        return new Search_Results(driver);
    }

    public int getResultsCountForManualFilter() {
        Utility.scrolling(driver , filterResultsLocator);
        return Integer.parseInt(Utility.getText(driver, resultsLocator).replace(",", ""));
    }


}
