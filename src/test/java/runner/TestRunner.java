package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import tests.TestBase;
@CucumberOptions(features = "src/test/java/features"
        ,glue = {"steps"}
        ,plugin = { "pretty", "html:target/cucumber-reports" },
        monochrome = true)

public class TestRunner extends TestBase {
/*    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    // Other TestNG lifecycle methods and test methods...

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        if (testNGCucumberRunner != null) {
            testNGCucumberRunner.finish();
        }
    }*/
    //This will run feature and steps
}
