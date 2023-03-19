package util;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class Logger {
    public static void info(String text) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        System.out.println("[INFO][" + timeStamp + "]: " + text);
    }

    public static void warn(String text) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        System.out.println("[WARN][" + timeStamp + "]: " + text);
    }

    public static void error(String text) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        System.err.println("[ERROR][" + timeStamp + "]: " + text);
    }

    public static void fatal(String text) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        System.err.println("[FATAL][" + timeStamp + "]: " + text);
    }
}
