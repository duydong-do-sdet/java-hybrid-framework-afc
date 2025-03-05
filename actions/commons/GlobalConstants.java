package commons;

import java.io.File;

public class GlobalConstants {

    public static final long LONG_TIMEOUT = 30;
    public static final long ONE_SECOND = 1;

    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String UPLOAD_FILES_FOLDER = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;

}
