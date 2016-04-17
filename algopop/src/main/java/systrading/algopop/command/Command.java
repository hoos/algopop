package systrading.algopop.command;

/**
 * Commands match AlgoPop's command line options and encapsulate the actions to be performed.
 * The Command interface provides the necessary contract that all command implementations 
 * must adhere to. 
 * @author Hussein
 *
 */
public interface Command {
	
	/**
	 * Typically used by commands that print messages or perform simple functions.
	 */
	public abstract void execute();
	
	/**
	 * The args parameter relates to arguments provided to command line options.
	 * @param args
	 */
	public abstract void execute(String[] args);

}
