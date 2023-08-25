package demoQA.utils;

import static demoQA.constants.DemoQAConstants.DEMO_QA_BASE_URL;
import static demoQA.utils.PropertiesUtils.properties;

public class StringUtils {

    public static String getDemoQABaseURL() {

        String url = properties.getProperty(DEMO_QA_BASE_URL);

        if (!url.startsWith("https://")) {
            url = "https://" + url;
        }

        return url;
    }
}
