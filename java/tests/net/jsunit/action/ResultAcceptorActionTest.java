package net.jsunit.action;

import java.util.List;

import junit.framework.TestCase;
import net.jsunit.BrowserTestRunner;
import net.jsunit.DummyBrowserResult;
import net.jsunit.model.BrowserResult;

import org.jdom.Element;

public class ResultAcceptorActionTest extends TestCase {

    public void testSimple() throws Exception {
        ResultAcceptorAction action = new ResultAcceptorAction();
        DummyBrowserResult dummyResult = new DummyBrowserResult(false, 1, 2);
        action.setBrowserResult(dummyResult);
        MockBrowserTestRunner mockRunner = new MockBrowserTestRunner();
        action.setBrowserTestRunner(mockRunner);
        assertEquals(ResultAcceptorAction.SUCCESS, action.execute());
        assertSame(dummyResult, mockRunner.acceptedResult);
    }

    static class MockBrowserTestRunner implements BrowserTestRunner {

        public BrowserResult acceptedResult;

        public List<String> getBrowserFileNames() {
            return null;
        }

        public long launchTestRunForBrowserWithFileName(String browserFileName) {
        	return 0;
        }

        public boolean hasReceivedResultSince(long launchTime) {
            return false;
        }

        public BrowserResult lastResult() {
            return null;
        }

        public void accept(BrowserResult result) {
            this.acceptedResult = result;
        }

        public void dispose() {
        }

        public BrowserResult findResultWithId(String id) {
            return null;
        }

        public Element asXml() {
            return null;
        }

		public void startTestRun() {
		}

		public void finishTestRun() {
		}

		public void logStatus(String message) {
		}
    }

}
