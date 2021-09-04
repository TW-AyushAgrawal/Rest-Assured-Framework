package constants;

public final class FilePaths {
    private static final String PATH_TO_RESOURCES = System.getProperty("user.dir") + "/src/test/resources/";
    private static final String Log_FILE_PATH = PATH_TO_RESOURCES.concat("log.txt");

    private FilePaths() {
    }

    public static String getLogFilePath() {
        return Log_FILE_PATH;
    }

}
