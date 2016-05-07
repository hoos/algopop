package com.db.systrading.elliotwave;

import org.junit.Test;

import com.db.systrading.fx.ExRate;
import com.db.systrading.fx.FxFetcher;

public class FXTest {
	@Test
	public void testStock() { 	
		ExRate USDGBP = FxFetcher.getExRate("USDGBP=X");
		System.out.println(USDGBP.getSymbol() + " " + USDGBP.getFxRate()); 
	}
}
