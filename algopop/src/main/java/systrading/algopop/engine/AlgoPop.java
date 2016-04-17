package systrading.algopop.engine;

import systrading.algopop.engine.CMDLineParser;

import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.FileHandler;
import java.io.IOException;

/**
 * 
 * @author Hussein Badakhchani
 *
 */
public class AlgoPop 
{
	
    /**
     * The log file handler.
     */
    private static FileHandler fileHandler; 
    
    private static ConsoleHandler consoleHandler = new ConsoleHandler();
    
    /**
     * The logger object used by AlgoPop.
     */
    private static final Logger LOGGER = Logger.getLogger("");
    
    static {
        final String appdir = System.getProperty("ALGOPOP_HOME");
        String logfile = "";
        if (appdir == null) {
            logfile = System.getProperty("java.io.tmpdir") + "/algopop.log";
            //System.out.println(logfile);
        } else {
            logfile = appdir + "/log/algopop.log";
        }
        try {
            AlgoPop.fileHandler = new FileHandler(logfile);
            LOGGER.addHandler(fileHandler);
            LOGGER.addHandler(consoleHandler);
            LOGGER.setUseParentHandlers(false);
        } catch (IOException e) {
            LOGGER.log(Level.INFO,
            "Failed to create log file handler: " + appdir + "/log/algopop.log");
        }
    }
    
 
    public static void main( String[] args )
    {
        LOGGER.log(Level.INFO, "Starting AlgoPop");
        final CMDLineParser cmdLineParser = new CMDLineParser(args);
    }
}