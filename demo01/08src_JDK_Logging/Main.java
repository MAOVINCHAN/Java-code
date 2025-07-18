import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Logger log = Logger.getGlobal();

        log.info("start process...");
        log.warning("memory is running out...");
        log.fine("test fine");
        log.finer("test finer");
        log.finest("test finest");
    }
}