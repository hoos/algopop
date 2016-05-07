package com.db.systrading.stock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StockFetcher {  
	
	/**
	* Returns a Stock Object that contains info about a specified stock.
	* @param 	symbol the company's stock symbol
	* @return 	a stock object containing info about the company's stock
	* @see Stock
	*/
	public static Stock getStock(String symbol) {  
		String sym = symbol.toUpperCase();
		double price = 0.0;
		int volume = 0;
		double pe = 0.0;
		double eps = 0.0;
		double week52low = 0.0;
		double week52high = 0.0;
		double daylow = 0.0;
		double dayhigh = 0.0;
		double movingav50day = 0.0;
		double marketcap = 0.0;
		String name = "";
		String currency = "";
		double shortRatio = 0.0;
		double open = 0.0;
		double previousClose = 0.0;
		String exchange;
		double ask = 0.0;
		double bid = 0.0;
		try { 
			
			// Retrieve CSV File
			// l1	Last Trade (Price Only)
			// v	Volume
			// r2	P/E ratio (Realtime)
			// e 	Earnings per share
			// j	52 week low
			// k 	52 week high
			// g	Day's low
			// h	Day's high
			// m3	50 Day moving average
			// j3 	Market Cap (Realtime)
			// n 	name
			// c4	Currency
			// s7	Short Ratio
			// p	Previous Close
			// o 	Open
			// x 	Stock Exchange
			
			URL yahoo = new URL("http://finance.yahoo.com/d/quotes.csv?s="+ symbol + "&f=l1vr2ejkghm3j3nc4s7poxab");
			URLConnection connection = yahoo.openConnection(); 
			InputStreamReader is = new InputStreamReader(connection.getInputStream());
			BufferedReader br = new BufferedReader(is);  
			
			// Parse CSV Into Array
			String line = br.readLine(); 
			//Only split on commas that aren't in quotes
			String[] stockinfo = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
			
			// Handle Our Data
			StockHelper sh = new StockHelper();
			
			price = sh.handleDouble(stockinfo[0]);
			volume = sh.handleInt(stockinfo[1]);
			pe = sh.handleDouble(stockinfo[2]);
			eps = sh.handleDouble(stockinfo[3]);
			week52low = sh.handleDouble(stockinfo[4]);
			week52high = sh.handleDouble(stockinfo[5]);
			daylow = sh.handleDouble(stockinfo[6]);
			dayhigh = sh.handleDouble(stockinfo[7]);   
			movingav50day = sh.handleDouble(stockinfo[8]);
			marketcap = sh.handleDouble(stockinfo[9]);
			name = stockinfo[10].replace("\"", "");
			currency = stockinfo[11].replace("\"", "");
			shortRatio = sh.handleDouble(stockinfo[12]);
			previousClose = sh.handleDouble(stockinfo[13]);
			open = sh.handleDouble(stockinfo[14]);
			exchange = stockinfo[15].replace("\"", "");
			ask = sh.handleDouble(stockinfo[16]);
			bid = sh.handleDouble(stockinfo[17]);
			
		} catch (IOException e) {
			Logger log = Logger.getLogger(StockFetcher.class.getName()); 
			log.log(Level.SEVERE, e.toString(), e);
			return null;
		}
		
		return new Stock(sym, price, volume, pe, eps, week52low, week52high, daylow, dayhigh, movingav50day, marketcap, name,currency, shortRatio,previousClose,open,exchange, ask, bid);
		
	}
	
	public static double getRealtimeAsk(String symbol) {
		double realtimeAsk = 0.0;
		try { 
			
			URL yahoo = new URL("http://finance.yahoo.com/d/quotes.csv?s="+ symbol + "&f=nab");
			URLConnection connection = yahoo.openConnection(); 
			InputStreamReader is = new InputStreamReader(connection.getInputStream());
			BufferedReader br = new BufferedReader(is);  
			
			// Parse CSV Into Array
			String line = br.readLine(); 
			//Only split on commas that aren't in quotes
			String[] stockinfo = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
			
			// Handle Our Data
			StockHelper sh = new StockHelper();
			realtimeAsk = sh.handleDouble(stockinfo[0]);
			
		} catch (IOException e) {
			Logger log = Logger.getLogger(StockFetcher.class.getName()); 
			log.log(Level.SEVERE, e.toString(), e);
		}
		
		return realtimeAsk;
	}
}
