package verduras;

import java.io.IOException;
import java.util.logging.*;

public class Log {
    private static final String FICHERO = "Log-Verduleria.txt";
    static Logger logger;


    private Log() {
        Logger rootLogger = Logger.getLogger("");
        Handler[] handlers = rootLogger.getHandlers();
        if (handlers.length > 0 && handlers[0] instanceof ConsoleHandler) {
            rootLogger.removeHandler(handlers[0]);
        }

        logger = Logger.getLogger(FICHERO   );
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        Handler fileTxt = null;
        try {
            fileTxt = new FileHandler(FICHERO, true);
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            fileTxt.setFormatter(simpleFormatter);
            fileTxt.setLevel(Level.WARNING);
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
        logger.addHandler(consoleHandler);
        logger.addHandler(fileTxt);
        logger.setLevel(Level.ALL);
    }

    private static Logger getLogger() {
        if(logger == null) {
            new Log();
        }
        return logger;
    }
    public static void log(Level level, String msg) {
        getLogger().log(level, msg);
    }
}
