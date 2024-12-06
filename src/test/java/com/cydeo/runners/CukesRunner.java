package com.cydeo.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // plugin = {
        //         "html:target/cucumber-reports.html",
        //         "rerun:target/rerun.txt",
        //         "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        // },
        features = "src/test/resources/features", // business layer
        glue = "com/cydeo/step_definitions", // implementation layer
        dryRun = false, // true: it will run only feature file
                        // false: it will run both stepdef and feature file
        tags = "@myself", //@envData
        publish = false //generating a report with public link
)
public class CukesRunner {

}
