package commons;

import java.io.File;

public class GlobalConstants {

    public static final long LONG_TIMEOUT = 30;
    public static final long ONE_SECOND = 1;

    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String FILE_SEP = File.separator;
    public static final String UPLOAD_FILES_FOLDER = PROJECT_PATH + FILE_SEP + "uploadFiles" + FILE_SEP;
    public static final String EXTENTREPORTS_OUTPUT = PROJECT_PATH + FILE_SEP + "extentreports-output" + FILE_SEP + "extentreports.html";

    public static final String OS_NAME = System.getProperty("os.name");

}
