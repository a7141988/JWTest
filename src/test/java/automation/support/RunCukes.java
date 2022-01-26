package automation.support;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(plugin={"pretty"}, features = "classpath:", glue = {"automation.stepdefs"}) //if you're on windows add `monochrome=true` for clean output
public class RunCukes { }
