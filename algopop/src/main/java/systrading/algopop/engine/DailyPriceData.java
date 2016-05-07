package com.db.systrading.stock;

import com.db.systrading.api.YahooAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * 
 * @author badahus
 *
 */
public class DailyPriceData {
	
	/**
	 * 
	 * @param symbol
	 * @return
	 */
	public static ArrayList<Stock> getDailyPriceData(String symbol) {
		ArrayList stockPrices = new ArrayList();
		String sym = symbol.toUpperCase();
		double price = 0.0;
		double daylow = 0.0;
		double dayhigh = 0.0;
		String name = "";
		double open = 0.0;
		double high = 0.0;
		double low = 0.0;
		double close = 0.0;
		double adjClose = 0.0;
		int volume = 0;
		String date = "";
		String exchange;
		// Handle Our Data
		StockHelper sh = new StockHelper();
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");

		try { 
			// Retrieve CSV File
			URL yahoo = new URL(YahooAPI.getHistoricalPricesCSV(symbol));
			URLConnection connection = yahoo.openConnection(); 
			InputStreamReader is = new InputStreamReader(connection.getInputStream());
			BufferedReader br = new BufferedReader(is); 
			String firstline = br.readLine();
			for (String line; (line = br.readLine()) != null;) {
				//Only split on commas that aren't in quotes
				String[] stockinfo = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
				//System.out.println(stockinfo[0]);
				date = stockinfo[0];
				open = sh.handleDouble(stockinfo[1]);
				high = sh.handleDouble(stockinfo[2]);
				low = sh.handleDouble(stockinfo[3]);
				close = sh.handleDouble(stockinfo[4]);
				volume = sh.handleInt(stockinfo[5]);
				adjClose = sh.handleDouble(stockinfo[6]);
				stockPrices.add(new Stock(symbol, date, open, high, low, close, volume, adjClose));
				//System.out.println(line);
			}  
			
		} catch (IOException e) {
				Logger log = Logger.getLogger(StockFetcher.class.getName()); 
				log.log(Level.SEVERE, e.toString(), e);
				return null;
		}
		return stockPrices;
	}

}
