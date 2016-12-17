import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * Created by user
 */
public class SimpleBrowserTest {
    public static final String USERNAME = "polinapasevina1";
    public static final String AUTOMATE_KEY = "N2KJ4qQJ4NfUanApxHPF";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    private WebDriver driver;
    private Map<Integer, List<String>> capabilities;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setPlatform(Platform.WINDOWS);
        capability.setCapability("build", "JUnit - Sample");
        driver = new RemoteWebDriver(
                new URL("https://polinapasevina1:N2KJ4qQJ4NfUanApxHPF@hub-cloud.browserstack.com/wd/hub"),
                capability
        );
        capabilities = CapabilitiesReader.readCapabilites();
    }

    @Test
    public void openTest()
    {
        DesiredCapabilities caps = setCapabilities(1);

        try {
            driver = new RemoteWebDriver(new URL(URL), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));

        element.sendKeys("BrowserStack");
        element.submit();

        System.out.println(driver.getTitle());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    public DesiredCapabilities setCapabilities(int key) {
        DesiredCapabilities caps = new DesiredCapabilities();
        int i = 0;

        for(String capability : capabilities.get(key)) {
            caps.setCapability(capabilities.get(0).get(i++), capability);
        }
        return caps;
    }
}
