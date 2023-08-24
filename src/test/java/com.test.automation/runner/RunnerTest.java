package com.test.automation.runner;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.intuit.karate.KarateOptions;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;

import cucumber.api.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

@KarateOptions(features="classpath:com/test/automation/features",tags="~@ignore")
@CucumberOptions()
public class RunnerTest {

    static final Logger Logger = LoggerFactory.getLogger(RunnerTest.class);


    //This executeTest will run karate test with thread count of 5
    //Stores the report in the target folder
      @Test
      public void executeTest(){
          Results results = Runner.parallel(getClass(),5,"target");
          assertTrue(results.getFailCount()==0, results.getErrorMessages());
          generateHtmlReport(results.getReportDir());
      }

      //This method will generate the HTML report based on the execution from executeTest method
      //Reports are stored inside target/cucumber-html-reports folder
      public static void generateHtmlReport(String htmlOutputFile){
        if(htmlOutputFile!="" || htmlOutputFile!= null){
          Collection<File> jsonFiles = FileUtils.listFiles(new File(htmlOutputFile), new String[]{"json"}, true);
          List<String> jsonPaths = new ArrayList<String>(jsonFiles.size());
          jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
          Configuration config = new Configuration(new File("target"), "KarateTesting");
          ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
          reportBuilder.generateReports();
        }
      }
}

