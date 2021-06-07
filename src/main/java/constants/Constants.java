package constants;

public final class Constants {

    private static final String DIRECTORY_PATH = System.getProperty("user.dir");
    private static final String CONFIG_FILE_PATH = DIRECTORY_PATH + "/src/test/resources/config/config.properties";

    private Constants() {
    }

    public static String getConfigFilePath() {
        return CONFIG_FILE_PATH;
    }
}
