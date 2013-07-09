package test.java.composerwindow.test;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(format = {"html:target/cucumber-htmlreport","json-pretty:target/cucumber-report.json"})

public class RunCukeTest {

}
