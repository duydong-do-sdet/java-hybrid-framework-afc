package commons;

import java.io.File;

public class GlobalConstants {

    public static final long LONG_TIMEOUT = 30;
    public static final long ONE_SECOND = 1;
    public static final long ZERO_TIME = 0;

    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String FILE_SEP = File.separator;
    public static final String PROJECT_BASE_PATH = PROJECT_PATH + FILE_SEP;

    public static final String UPLOAD_FILES_FOLDER = PROJECT_BASE_PATH + "uploadFiles" + FILE_SEP;
    public static final String EXTENTREPORTS_OUTPUT = PROJECT_BASE_PATH + "extentreports-output" + FILE_SEP + "extentreports.html";
    public static final String ALLURE_REPORT_OUTPUT = PROJECT_BASE_PATH + "allure-results" + FILE_SEP;

    public static final String OS_NAME = System.getProperty("os.name");
    public static final String JAVA_VERSION = System.getProperty("java.version");

}
