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
        LOGGER.log(Level.INFO, args[0] + " " + args[1] + " " +  args[2]);		
	}		
}
