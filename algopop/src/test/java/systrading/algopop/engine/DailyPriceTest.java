package com.db.systrading.elliotwave;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

import com.db.systrading.stock.DailyPriceData;
import com.db.systrading.stock.Stock;


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
