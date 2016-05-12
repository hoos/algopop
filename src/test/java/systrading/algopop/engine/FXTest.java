package systrading.algopop.engine;
import org.junit.Test;

import systrading.algopop.dto.FxRate;
import systrading.algopop.engine.FxFetcher;

public class FXTest {
	@Test
	public void testStock() { 	
		FxRate USDGBP = FxFetcher.getExRate("USDGBP=X");
		System.out.println(USDGBP.getSymbol() + " " + USDGBP.getFxRate()); 
	}
}
