package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import java.util.Locale;

@RunWith(Cucumber.class)
@CucumberOptions(
        features=".//src/test/java/FeatureFile/NopCommerceFeatureFile.feature",
        glue={"stepdefination"},
        dryRun = false,
        plugin={"pretty","html:test-output"},
        monochrome = true
)
public class TestRunner {
}
