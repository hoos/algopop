package systrading.algopop.dto;

/**
 * 
 * @author Hussein Badakhchani
 *
 */
public class Stock { 
	
	private String symbol; 
	private double price;
	private int volume;
	private double pe;
	private double eps;
	private double week52low;
	private double week52high;
	private double daylow;
	private double dayhigh;
	private double movingav50day;
	private double marketcap;
	private String name;
	private String currency;
	private double shortRatio;
	private double previousClose;
	private double open;
	private String exchange;
	private String date;
	private String time;
	private double close;
	private double ask;
	private double bid;
	
	/**
	 * 
	 * @param symbol
	 * @param date
	 * @param time
	 * @param price
	 * @param volume
	 */
	public Stock(String symbol, String date, String time, double price, int volume) {
		this.symbol = symbol;
		this.date = date;
		this.time = time;
		this.price = price;
		this.volume = volume;
	}
	
	/**
	 * 
	 * @param symbol
	 * @param date
	 * @param time
	 * @param price
	 * @param volume
	 */
	public Stock(String symbol, String date, String time, double price) {
		this.symbol = symbol;
		this.date = date;
		this.time = time;
		this.price = price;
	}
	
	/**
	 * 
	 * @param symbol
	 * @param date
	 * @param open
	 * @param high
	 * @param low
	 * @param close
	 * @param volume
	 * @param adjClose
	 */
	public Stock(String symbol, String date, double open, double high, double low, double close, int volume, double adjClose) {
		this.symbol = symbol;
		this.date = date;
		this.open = open;
		this.dayhigh = high;
		this.daylow = low;
		this.close = close;
		this.volume = volume;
		this.previousClose = adjClose;
	}

	/**
	 * 
	 * @param symbol
	 * @param price
	 * @param volume
	 * @param pe
	 * @param eps
	 * @param week52low
	 * @param week52high
	 * @param daylow
	 * @param dayhigh
	 * @param movingav50day
	 * @param marketcap
	 * @param name
	 * @param currency
	 * @param shortRatio
	 * @param previousClose
	 * @param open
	 * @param exchange
	 */
	public Stock(String symbol, double price, int volume, double pe, double eps, double week52low,      
					double week52high, double daylow, double dayhigh, double movingav50day, double marketcap, String name, String currency, double shortRatio, double previousClose, double open, String exchange, double ask, double bid) {	
		this.symbol = symbol; 
		this.price = price;	
		this.volume = volume; 
		this.pe = pe; 
		this.eps = eps; 
		this.week52low = week52low; 
		this.week52high = week52high; 
		this.daylow = daylow; 
		this.dayhigh = dayhigh; 
		this.movingav50day = movingav50day; 
		this.marketcap = marketcap;
		this.name = name;
		this.currency = currency;
		this.shortRatio = shortRatio;
		this.previousClose = previousClose;
		this.open = open;
		this.exchange = exchange;
		this.ask = ask;
		this.bid = bid;
	} 
	
	public String getExchange(){
		return this.exchange;
	}
	
	public double getPreviousClose(){
		return this.previousClose;
	}
	
	public double getOpen(){
		return this.open;
	}
	
	public double getShortRatio(){
		return this.shortRatio;
	}
	
	public String getCurrency(){
		return this.currency;
	}
	
	public String getSymbol() { 
		return this.symbol;		
	} 
	
	public double getPrice() { 		
		return this.price;		
	} 
	
	public int getVolume() {    
		return this.volume;     
	} 
 
	public double getPe() {    
		return this.pe;     
	} 
  
	public double getEps() { 
		return this.eps;     
	} 
  
	public double getWeek52low() {    
		return this.week52low;    
	} 
  
	public double getWeek52high() {  
		return this.week52high;    
	} 
  
	public double getDaylow() {    
		return this.daylow;    
	} 
  
	public double getDayhigh() {    
		return this.dayhigh;     
	} 
  
	public double getMovingav50day() {     
		return this.movingav50day;  
	} 
  
	public double getMarketcap() { 
		return this.marketcap;
	} 
	
	public String getName(){
		return this.name;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public String getTime() {
		return this.time;
	}
	
	public String getClose() {
		return this.getClose();
	}
	
	public String getInfo() {
	    return new String(this.getDate() + " Open: " + this.getOpen());	
	}
	
	public String getCSVInfo() {
	    return new String(this.getSymbol() + " " + this.getDate() + " " + this.getTime() + " "  + this.getPrice() + " " + this.getVolume());	
	}
	
	public double getAsk() { 
		return this.ask;
	} 
	
	public double getBid() { 
		return this.bid;
	} 
	
}
