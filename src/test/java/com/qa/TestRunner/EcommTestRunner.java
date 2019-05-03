package com.qa.TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions (features="C:\\Users\\ghadeermoh\\eclipse-workspace\\EcommerceGuruSiteBDD\\src\\main\\java\\com\\qa\\features\\Ecomm.feature" 
, glue="com.qa.StepDefinitions" 
, dryRun=false
,monochrome=true
,tags= {"@Day4"}
)

public class EcommTestRunner {

}
