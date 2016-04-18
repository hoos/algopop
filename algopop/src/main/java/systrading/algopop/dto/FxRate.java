package systrading.algopop.dto;

/**
 * 
 * @author Hussein Badakhchani
 *
 */
public class FxRate {
	private String symbol;
	private double fxrate;
	
	public FxRate(String symbol, double fxrate) {
		this.symbol = symbol;
		this.fxrate = fxrate;
	}

	public String getSymbol() {
		return this.symbol;
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public double getFxRate() {
		return this.fxrate;
	}
	
	public void setFxRate(double fxrate) {
		this.fxrate = fxrate;
	}
}
