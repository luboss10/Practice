package UtilsConstants;

import com.microsoft.playwright.*;

import java.awt.*;

public class BrowserManager {

private static Page page;
    static {
        page=getNewBrowserContext().newPage();
        }

    public static Page getPage(){
        return page;
        }

    public static BrowserContext getNewBrowserContext() {
        BrowserContext browserContext;
        //reading the choice of user from property files
        ConfigReader.readProperties(UIConstants.CONFIGURATION_FILEPATH);
        //launching the BrowserContext in normal mode not headless
        BrowserType.LaunchOptions browserType = new BrowserType.LaunchOptions().setHeadless(false);
        //taking screen size to maximize the browserContext
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Browser.NewContextOptions newContextOptions = new Browser.NewContextOptions().
                setViewportSize((int) screenSize.getWidth(), (int) screenSize.getHeight());
        Playwright playwright = Playwright.create();
        switch (ConfigReader.getPropertyValue("browser")) {
            case "Chrome" :
                browserContext = playwright.chromium().launch(browserType.setChannel("chrome")).newContext(newContextOptions);
                break;
            case "Firefox" :
                browserContext = playwright.firefox().launch(browserType).newContext(newContextOptions);
                break;
            case "Safari" :
                browserContext = playwright.webkit().launch(browserType).newContext(newContextOptions);
                break;
            default:
                throw new RuntimeException("Invalid browserContext name");
        }

        return browserContext;
    }
}
