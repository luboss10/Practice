package pages;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class UIAmazonHomePages {
    public Locator account;
    public Locator InputEmail;



    private Page page;
    public void navigateToAmazonHomePage(String url) {
        page.navigate(url);
    }
    public UIAmazonHomePages(Page page){
        this.page = page;

        account = page.locator("//*[@id=\"nav-link-accountList\"]/span");
        InputEmail = page.locator("//*[@id=\"ap_email\"]");

    }
}
