package com.aggrey.booking.ui.cucumber;


import io.cucumber.core.options.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectDirectories;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectDirectories("src/main/java/com/aggrey/cucumber/features/Login.feature")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.aggrey.cu")
@ConfigurationParameter(key = Constants.PLUGIN_PUBLISH_QUIET_PROPERTY_NAME, value = "true")
//@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@negative")
public class RunCucumberTest {
    /**
     * This class is for running the Cucumber tests. I used Cucumber JVM 7.x version and Junit Jupiter’s @Suite annotations.
     * @SelectDirectories annotation is for the feature files, and @ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = “com.swtestacademy.springbootselenium.cucumber”)
     * is for gluing the steps files.
     */
}
