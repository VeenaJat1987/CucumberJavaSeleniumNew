package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features=".//src/test/java/FeatureFile/FlipkartTest.feature",
        glue={"stepDefination3"},
        dryRun = false,
        plugin={"pretty","html:target/cucumber-reports"},
        monochrome = true,
        tags = "@High"
)
public class TestRunner_Flipkart {
}
