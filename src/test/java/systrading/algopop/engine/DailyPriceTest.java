package systrading.algopop.engine;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

import systrading.algopop.engine.DailyPriceData;
import systrading.algopop.dto.Stock;

public class DailyPriceTest {
	
	@Test
	public void testDailyPriceData() {
		ArrayList<Stock> westernunion = DailyPriceData.getDailyPriceData("WU");
		Collections.reverse(westernunion);
		for (Stock stock : westernunion) {
			System.out.println(stock.getDate() + " Open: " + stock.getOpen());
		}
	} 

}
