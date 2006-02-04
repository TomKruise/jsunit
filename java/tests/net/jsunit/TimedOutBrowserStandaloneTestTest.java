package net.jsunit;

import net.jsunit.configuration.ConfigurationConstants;
import net.jsunit.model.ResultType;

public class TimedOutBrowserStandaloneTestTest extends StandaloneTest{

	public TimedOutBrowserStandaloneTestTest(String name) {
		super(name);
	}
	
	  public void setUp() throws Exception {
		  JsUnitServer.MAX_SECONDS_TO_WAIT=1;
	      System.setProperty(ConfigurationConstants.BROWSER_FILE_NAMES, JsUnitServer.DEFAULT_SYSTEM_BROWSER);
	      System.setProperty(ConfigurationConstants.URL,
	         "http://localhost:8080/jsunit/testRunner.html?"
	         + "testPage=http://localhost:8080/jsunit/tests/jsUnitTestSuite.html&autoRun=true&submitresults=true&resultId=foobar");
	      super.setUp();
	  }
	  
	  public void testStandaloneRun() throws Exception {
		  super.testStandaloneRun();
		  assertEquals(ResultType.TIMED_OUT, runner.lastResult().getResultType());
	  }

	  public void tearDown() throws Exception {
	      super.tearDown();
	      JsUnitServer.MAX_SECONDS_TO_WAIT = 60;
	      System.getProperties().remove(ConfigurationConstants.BROWSER_FILE_NAMES);
	      System.getProperties().remove(ConfigurationConstants.URL);
	  }

}
