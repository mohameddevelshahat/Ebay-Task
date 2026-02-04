package Tests;

import Pages.HomePage;
import Pages.Search_Results;
import Utilities.LogsUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;
import static Utilities.DataUtils.getPropertyValue;

public class Ebay_Search_Test {

    @BeforeMethod(alwaysRun = true)
    public void setup() throws IOException {

        setupDriver(getPropertyValue("environment", "browser"));
        LogsUtils.info("Chrome is Opened");
        getDriver().get(getPropertyValue("environment", "BASE_URL"));
        LogsUtils.info("Page is redirected Ebay");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test (description = "Search for Mazda MX-5 and apply Manual filter")
    @Epic("eBay Automation")
    @Feature("Search Results & Filters")
    @Story("Open eBay home page")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate search results count and filter by Manual transmission on eBay")
    @Owner("Mohamed Elshahat")
    @Attachment
    public void searchMazdaMx5() throws IOException {
       new HomePage(getDriver()).isHomePageLoaded();
       Assert.assertTrue(new HomePage(getDriver()).isHomePageLoaded());
       LogsUtils.info("Home page loaded");
       new HomePage(getDriver()).searchFor();
       LogsUtils.info("Searching for mazda mx-5");
       new Search_Results(getDriver()).getResultsCount();
       int count = new Search_Results(getDriver()).getResultsCount();
       Assert.assertTrue(count > 0);
       LogsUtils.info("Results Are Obtained");
       System.out.println("The Number of Search Results = " + count);
       new Search_Results(getDriver()).clickFilter().getResultsCountForManualFilter();
       int manualFilterCount = new Search_Results(getDriver()).getResultsCountForManualFilter();
       Assert.assertTrue(manualFilterCount > 0);
       LogsUtils.info("Results of Manual Filter Are Obtained");
       System.out.println("The Number of Search Results for Manual Filter = " + manualFilterCount);

    }

    @AfterMethod(alwaysRun = true)
    public void quit() {
        quitDriver();
    }

}
