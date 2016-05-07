package systrading.algopop.api;

/**
 * 
 * @author Hussein Badakhchani
 * This class provides static methods that return format strings for Yahoo Finance APIs.
 * Check out https://greenido.wordpress.com/2009/12/22/yahoo-finance-hidden-api/ for an explanation
 * of the API parameters
 */
public class YahooAPIStatic {
	
	/**
	 * The base URL for Yahoo Finance ichart site
	 */
	public static final String YAHOO_ICHART_URL = "http://ichart.finance.yahoo.com";
	
	/**
	 * The base URL for the Yahoo Finance site
	 */
	public static final String YAHOO_URL = "http://finance.yahoo.com/d/quotes.csv";
	
	/**
	 * Given a stock symbol this code will return the historical daily price data from 01/01/2010 to 12/04/2016
	 * @param symbol
	 * @return
	 */
	public static final String getHistoricalPricesCSV(String symbol) {
		return new String(YAHOO_ICHART_URL + "/table.csv?s=" + symbol + "&a=01&b=01&c=2010&d=04&e=12&f=2016&g=d&ignore=.csv");
	}
	
	/**
	 * This method doesn't seem to be well implemented by Yahoo
	 * @param symbol
	 * @return
	 */
	public static final String getRealtimeAsk(String symbol) {
		return new String(YAHOO_URL + "?s=" + symbol + "&f=b2");
	}

}
