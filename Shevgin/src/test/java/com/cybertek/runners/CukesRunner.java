package com.cybertek.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        plugin = "html:target/cucumber-report.html",
        features = "src/test/resources/features/Search.feature", //will help us
        glue = "com/cybertek/step_definitions"
)
public class CukesRunner {

@Before
    public void ss(){

}



}
