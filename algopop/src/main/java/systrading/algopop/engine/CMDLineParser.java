package systrading.algopop.engine;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.MissingArgumentException;
import org.apache.commons.cli.MissingOptionException;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.UnrecognizedOptionException;

import systrading.algopop.command.*;

/**
 * The CMDLineParser uses Apache Commons CLI to parse the command line
 * execute the relevant command class which implements the desired functionality. 
 * This class also uses a resource bundle for all messages.  
 * 
 * @author Hussein Badakhchani
 *
 */
public class CMDLineParser {
	

    /**
     * The logger used by this class.
     *
     */
    private static final Logger LOGGER = Logger.getLogger("CMDLineParser");

    /**
     * The CMDLineParser constructor uses the main methods arguments.
     * @param args A string arry of the command line arguments.
     */
    public CMDLineParser(final String[] args) {

        final String language = System.getProperty("user.language");
        final String region = System.getProperty("user.country");

        LOGGER.log(Level.FINEST, 
            "Creating Locale: language=" + language  + " region=" + region);

        final Locale locale = new Locale(language, region);

        final ResourceBundle messages = 
            ResourceBundle.getBundle("messages", locale);

        // Create Options collection
        final Options options = new Options();
        
        // Options placed in this group are mutually exclusive
        final OptionGroup commandGroup = new OptionGroup();

        // Setup the command line options
        commandGroup.addOption(Option.builder("h").required(false).longOpt("help").desc(messages.getString("help")).build());
        commandGroup.addOption(Option.builder("v").required(false).longOpt("version").desc(messages.getString("version")).build());
        commandGroup.addOption(Option.builder("q").required(false).longOpt("quiet").desc(messages.getString("quiet")).build());
        commandGroup.addOption(Option.builder("vv").required(false).longOpt("verbose").desc(messages.getString("verbose")).build());
        commandGroup.addOption(Option.builder("f").required(false).longOpt("file").desc(messages.getString("file"))
        		.numberOfArgs(3).argName("path> <parser> <algorithm").build());
        commandGroup.addOption(Option.builder("d").required(false).longOpt("data").desc(messages.getString("data"))
        		.numberOfArgs(3).argName("provider> <symbol> <commandstring").build());
        final Option listapis = new Option("listapis", messages.getString("list_apis"));
        commandGroup.addOption(listapis);
        final Option listalgos = new Option("listalgos", messages.getString("list_algos"));
        commandGroup.addOption(listalgos);
        options.addOptionGroup(commandGroup);

        // Create the command line parser
        final CommandLineParser parser = new DefaultParser();
        final HelpFormatter formatter = new HelpFormatter();
        try {
            // parse the command line arguments
            final CommandLine line = parser.parse(options, args);
            if (line.hasOption("help")) {
                LOGGER.log(Level.INFO, messages.getString("help"));
                // automatically generate the help statement
                formatter.printHelp(120, messages.getString("help_msg_usage"), messages.getString("help_msg_header"),
                		options, messages.getString("help_msg_footer"));
            } else if (line.hasOption("version")) {
                LOGGER.log(Level.INFO, "Version 1.0");
            } else if (line.hasOption("quiet")) {
            	LOGGER.setLevel(Level.INFO);
                LOGGER.log(Level.INFO,
                    messages.getString("quiet"));
            } else if (line.hasOption("verbose")) {
            	LOGGER.setLevel(Level.ALL);
                LOGGER.log(Level.ALL,
                    messages.getString("verbose"));
            }
            else if (line.hasOption("file")) {
            	   String[] fileArgs = line.getOptionValues("file");
            	   DataFileCommand dataFileCommand = new DataFileCommand();
            	   dataFileCommand.execute(fileArgs);
            } else {
                LOGGER.log(Level.FINEST,
                    messages.getString("no_arguments"));
                throw new MissingOptionException(
                    messages.getString("no_arguments"));
            }
        } catch (UnrecognizedOptionException ue) {
             LOGGER.log(Level.SEVERE, ue.getMessage());
        } catch (MissingOptionException me) {
             LOGGER.log(Level.INFO, me.getMessage());
             formatter.printHelp(120, messages.getString("help_msg_usage"), me.getMessage(),
             		options, messages.getString("help_msg_footer"));
        } catch (MissingArgumentException mae) {
             LOGGER.log(Level.SEVERE, mae.getMessage());
        } catch (ParseException pe) {
             LOGGER.log(Level.CONFIG, "Command line parsing failed: "
                 + pe.getMessage());
             formatter.printHelp("AlgoPop", options);
        }
    }
}