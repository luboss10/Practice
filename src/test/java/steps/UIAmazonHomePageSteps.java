package steps;
import UtilsConstants.BrowserManager;
import UtilsConstants.UIConstants;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.UIAmazonHomePages;

public class UIAmazonHomePageSteps {

    public Page page = BrowserManager.getPage();
    UIAmazonHomePages UIAmazonHomePages;

    @Given("home page is loaded")
    public void homePageIsLoaded() {
        Page page = BrowserManager.getPage();
        UIAmazonHomePages homePage = new UIAmazonHomePages(page);
        homePage.navigateToAmazonHomePage(UIConstants.BaseURL);
        System.out.println(page.url());
        System.out.println(page.title());

    }

    @Then("user logs in to own profile")
    public void userLogsInToOwnProfile() {
        UIAmazonHomePages = new UIAmazonHomePages(BrowserManager.getPage());
        UIAmazonHomePages.InputEmail.click();
    }

    @Then("user verifies URL route for Amazon home page")
    public void userVerifiesURLRouteForAmazonHomePage() {
        String expectedURL = UIConstants.BaseURL;
        String currentURL = page.url();
        Assert.assertEquals(expectedURL,currentURL);
    }

    @Then("user verifies breadcrumb for Amazon home page")
    public void userVerifiesBreadcrumbForAmazonHomePage() {
    }
}
