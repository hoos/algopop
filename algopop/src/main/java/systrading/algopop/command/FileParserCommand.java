package systrading.algopop.command;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FileParserCommand  implements Command {
	
	/**
	 * The logger object used by AlgoPop.
	 */
	private static final Logger LOGGER = Logger.getLogger("FileParserCommand");


	public void execute() {
		// TODO Auto-generated method stub
		
	}

	public void execute(String[] args) {
		// TODO Auto-generated method stub
		LOGGER.log(Level.INFO, args[0] + " " + args[1] + " " +  args[2]);
	}

}
