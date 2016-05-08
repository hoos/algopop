package systrading.algopop.engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.db.systrading.stock.StockFetcher;
import com.db.systrading.stock.StockHelper;

public class FxFetcher {

	public static ExRate getExRate(String symbol) {
		double exrate = 0.0;
		try { 
			// e	Exchange Rate
			URL yahoo = new URL("http://finance.yahoo.com/d/quotes.csv?e=.csv&f=sl1&s="+ symbol);
			URLConnection connection = yahoo.openConnection(); 
			InputStreamReader is = new InputStreamReader(connection.getInputStream());
			BufferedReader br = new BufferedReader(is);  
			
			// Parse CSV Into Array
			String line = br.readLine(); 
			System.out.println(line);
			//Only split on commas that aren't in quotes
			String[] fxinfo = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
			
			// Handle Our Data
			StockHelper sh = new StockHelper();
			exrate = sh.handleDouble(fxinfo[1]);
			//System.out.println(exrate);
			
		} catch (IOException e) {
			Logger log = Logger.getLogger(StockFetcher.class.getName()); 
			log.log(Level.SEVERE, e.toString(), e);
		}
		
		return new ExRate(symbol, exrate);
	}
}
