package net.jsunit;

public class BrowserLaunchSpecification {

    private final String browserFileName;
    private final String overrideUrl;
    public static final String DEFAULT_SYSTEM_BROWSER = "default";

    public BrowserLaunchSpecification(String browserFileName) {
        this(browserFileName, null);
    }

    public BrowserLaunchSpecification(String browserFileName, String overrideUrl) {
        this.browserFileName = browserFileName;
        this.overrideUrl = overrideUrl;
    }

    public String getBrowserFileName() {
        return browserFileName;
    }

    public String getOverrideUrl() {
        return overrideUrl;
    }

    public boolean hasOverrideUrl() {
        return overrideUrl != null;
    }

    public boolean isForDefaultBrowser() {
        return browserFileName.equals(DEFAULT_SYSTEM_BROWSER);
    }

}
