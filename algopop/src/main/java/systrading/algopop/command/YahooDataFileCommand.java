package systrading.algopop.command;

import systrading.algopop.api.YahooAPI;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class YahooDataFileCommand implements Command {
	
	/**
	 * The logger object used by AlgoPop.
	 */
	private static final Logger LOGGER = Logger.getLogger("YahooDataFileCommand");

	public void execute() {
		// TODO Auto-generated method stub
	}

	public void execute(String[] args) {
		LOGGER.log(Level.INFO, "Executing YahooDataFileCommand");
        LOGGER.log(Level.INFO, args[0] + " " + args[1] + " " +  args[2]);
        String symbol = args[1];
        String commandString = args[2];
        YahooAPI yahooAPI = new YahooAPI();
        try {
        	URL yahoo = new URL(yahooAPI.getCommand(symbol, commandString));
        	URLConnection connection = yahoo.openConnection();
        	InputStreamReader is = new InputStreamReader(connection.getInputStream());
        	BufferedReader br = new BufferedReader(is);
        	BufferedWriter bw = new BufferedWriter(new FileWriter(new File(System.getProperty("java.io.tmpdir") + "/data.csv")));
        	String line;
        	while ((line = br.readLine()) != null) {
        		bw.write(line);
        		bw.newLine();
        	}
            bw.flush();
            bw.close();
        	br.close();   	
        } catch (IOException e) {
        	LOGGER.log(Level.SEVERE, e.getMessage());
        }
    }		
}
