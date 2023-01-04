package com.gemini.generic.Runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/Features",glue = "com.gemini.generic",tags = "@test1"
//        features = "src/test/resources/Features",glue = "com.gemini.generic.StepDefinition",tags = "@test1"
)

public class CucumberRunner {

}