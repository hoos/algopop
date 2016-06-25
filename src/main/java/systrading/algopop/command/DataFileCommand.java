package systrading.algopop.command;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DataFileCommand implements Command {
	
	/**
	 * The logger object used by AlgoPop.
	 */
	private static final Logger LOGGER = Logger.getLogger("DataFileCommand");

	public void execute() {
		// TODO Auto-generated method stub
	}

	public void execute(String[] args) {
		LOGGER.log(Level.INFO, "Executing DataFileCommand");
        LOGGER.log(Level.INFO, args[0] + " " + args[1] + " " +  args[2]);
        String[] yahooArgs = new String[3];
        yahooArgs[0] = args[0].replaceFirst(".*=", "");
        yahooArgs[1] = args[1].replaceFirst(".*=", "");
        yahooArgs[2] = args[2].replaceFirst("commandstring=", "");
        switch (yahooArgs[0]) {
        case "yahoo": YahooDataFileCommand yahooDataFileCommand = new YahooDataFileCommand();
        yahooDataFileCommand.execute(yahooArgs);
        	break;
        default: LOGGER.log(Level.SEVERE, "Provider Not Found");
        }
	}		
}
