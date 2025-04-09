package utils;

public class ConfigReader {
    public static String getUsername() {
        return System.getenv("HEROKU_USERNAME");
    }

    public static String getPassword() {
        return System.getenv("HEROKU_PASSWORD");
    }
}