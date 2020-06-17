package tests;

import org.junit.jupiter.api.*;
import utils.Browser;
import utils.TestContext;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class AbstractTest
{
    public TestContext context = new TestContext();
    public Browser browser = context.doCreateBrowser();

    @BeforeAll
    public void setUpClass()
    {
        browser.get("https://www.migros.com.tr");
    }

    @AfterAll
    public void tearDownClass()
    {
        if (null != browser)
            browser.close();
    }
}
