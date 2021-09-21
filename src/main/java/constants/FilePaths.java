package constants;

public final class FilePaths {
    private static final String PATH_TO_RESOURCES = System.getProperty("user.dir") + "/src/test/resources/";
    private static final String LOG_FILE_PATH = PATH_TO_RESOURCES.concat("log.txt");
    private static final String USERS_JSON_FILE_PATH = PATH_TO_RESOURCES.concat("UserDetails.json");

    private FilePaths() {
    }

    public static String getLogFilePath() {
        return LOG_FILE_PATH;
    }

    public static String getUsersJsonFilePath() { return USERS_JSON_FILE_PATH; }

}
