package com.db.systrading.elliotwave;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.LinkedHashSet;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.db.systrading.stock.DailyPriceData;
import com.db.systrading.stock.Stock;

/**
 * 
 * @author badahus
 *
 */
public class ElliotWaveTest {
	
	static double[] WAVE5PC262 = {0.0, 1.0, 0.5, 2.12, 1,7312, 2.7312}; 
	static Set<Stock> elliotWaves = new LinkedHashSet<>();
	static final float OFFSET = 0.02f;
	
	@AfterClass
	public static void onTimeTearDown() {
		System.out.println();
		System.out.println("ElliotWave Price Points:" + elliotWaves.size());
		for (Stock stock : elliotWaves)
			System.out.println(stock.getDate() + " " + stock.getOpen());
	}
	
	@Test
	public void testIsWave2() {
		ArrayList<Stock> prices = DailyPriceData.getDailyPriceData("FB");
		Collections.reverse(prices);
		int index = 0;
		while (index <= (prices.size() - 3)) {
			Stock pricePointA = prices.get(index);
			Stock pricePointB = prices.get(index + 1);
			Stock pricePointC = prices.get(index + 2);
			
			double startWave1 = prices.get(index).getOpen();
			double endWave1 = pricePointB.getOpen();
			double endWave2 = pricePointC.getOpen();
			if(ElliotWave.isWave2pc50(startWave1, endWave1, endWave2, OFFSET)) {
				System.out.println("Found Elliot Wave 1 and Wave2! at 50% retrenchment");
				System.out.println(pricePointA.getInfo());
				System.out.println(pricePointB.getInfo());
				System.out.println(pricePointC.getInfo());
				elliotWaves.add(pricePointA);
				elliotWaves.add(pricePointB);
				elliotWaves.add(pricePointC);
			}
			if(ElliotWave.isWave2pc62(startWave1, endWave1, endWave2, OFFSET)) {
				System.out.println("Found Elliot Wave 1 and Wave2! at 62% retrenchment");
				System.out.println(pricePointA.getInfo());
				System.out.println(pricePointB.getInfo());
				System.out.println(pricePointC.getInfo());
				elliotWaves.add(pricePointA);
				elliotWaves.add(pricePointB);
				elliotWaves.add(pricePointC);
			}
			index++;
		}
	} 

	@Test
	public void testIsWave3() {
		ArrayList<Stock> prices = DailyPriceData.getDailyPriceData("FB");
		Collections.reverse(prices);
		int index = 0;
		while (index <= (prices.size() - 4)) {
			Stock pricePointA = prices.get(index);
			Stock pricePointB = prices.get(index + 1);
			Stock pricePointC = prices.get(index + 2);
			Stock pricePointD = prices.get(index + 3);
			
			double startWave1 = pricePointA.getOpen();
			double endWave1 = pricePointB.getOpen();
			double endWave2 = pricePointC.getOpen();
			double endWave3 = pricePointD.getOpen();
			if(ElliotWave.isWave3pc162(startWave1, endWave1, endWave2, endWave3, OFFSET)) {
				System.out.println("Found Elliot Wave 1 and Wave 3 at 162% gain ");
				System.out.println(pricePointA.getInfo());
				System.out.println(pricePointB.getInfo());
				System.out.println(pricePointC.getInfo());
				System.out.println(pricePointD.getInfo());
				elliotWaves.add(pricePointA);
				elliotWaves.add(pricePointB);
				elliotWaves.add(pricePointC);
				elliotWaves.add(pricePointD);
			}
			if(ElliotWave.isWave3pc262(startWave1, endWave1, endWave2, endWave3, OFFSET)) {
				System.out.println("Found Elliot Wave 1 and Wave 3 at 262% gain");
				System.out.println(pricePointA.getInfo());
				System.out.println(pricePointB.getInfo());
				System.out.println(pricePointC.getInfo());
				System.out.println(pricePointD.getInfo());
				elliotWaves.add(pricePointA);
				elliotWaves.add(pricePointB);
				elliotWaves.add(pricePointC);
				elliotWaves.add(pricePointD);
			}
			if(ElliotWave.isWave3pc425(startWave1, endWave1, endWave2, endWave3, OFFSET)) {
				System.out.println("Found Elliot Wave 1 and Wave 3 at 425% gain");
				System.out.println(pricePointA.getInfo());
				System.out.println(pricePointB.getInfo());
				System.out.println(pricePointC.getInfo());
				System.out.println(pricePointD.getInfo());
				elliotWaves.add(pricePointA);
				elliotWaves.add(pricePointB);
				elliotWaves.add(pricePointC);
				elliotWaves.add(pricePointD);
			}
			index++;
		}
	} 
	
	@Test
	public void testIsWave4() {
		ArrayList<Stock> prices = DailyPriceData.getDailyPriceData("FB");
		Collections.reverse(prices);
		int index = 0;
		while (index <= (prices.size() - 3)) {
			Stock pricePointA = prices.get(index);
			Stock pricePointB = prices.get(index + 1);
			Stock pricePointC = prices.get(index + 2);

			double endWave2 = pricePointA.getOpen();
			double endWave3 = pricePointB.getOpen();
			double endWave4 = pricePointC.getOpen();
			if(ElliotWave.isWave4pc24(endWave2, endWave3, endWave4, OFFSET)) {
				System.out.println("Found Elliot Wave 3 and Wave 4 at 0.24% retrenchment");
				System.out.println(pricePointA.getInfo());
				System.out.println(pricePointB.getInfo());
				System.out.println(pricePointC.getInfo());
				elliotWaves.add(pricePointA);
				elliotWaves.add(pricePointB);
				elliotWaves.add(pricePointC);
			}
			if(ElliotWave.isWave4pc38(endWave2, endWave3, endWave4, OFFSET)) {
				System.out.println("Found Elliot Wave 3 and Wave 4 at 0.38% retrenchment");
				System.out.println(pricePointA.getInfo());
				System.out.println(pricePointB.getInfo());
				System.out.println(pricePointC.getInfo());
				elliotWaves.add(pricePointA);
				elliotWaves.add(pricePointB);
				elliotWaves.add(pricePointC);
			}
			if(ElliotWave.isWave4pc50(endWave2, endWave3, endWave4, OFFSET)) {
				System.out.println("Found Elliot Wave 3 and Wave 4 at 0.50% retrenchment");
				System.out.println(pricePointA.getInfo());
				System.out.println(pricePointB.getInfo());
				System.out.println(pricePointC.getInfo());
				elliotWaves.add(pricePointA);
				elliotWaves.add(pricePointB);
				elliotWaves.add(pricePointC);
			}

			index++;
		}
	} 
	
	@Test
	public void testIsWave5() {
		ArrayList<Stock> prices = DailyPriceData.getDailyPriceData("FB");
		Collections.reverse(prices);
		int index = 0;
		while (index <= (prices.size() - 6)) {
			Stock pricePointA = prices.get(index);
			Stock pricePointB = prices.get(index + 1);
			Stock pricePointC = prices.get(index + 2);
			Stock pricePointD = prices.get(index + 3);
			Stock pricePointE = prices.get(index + 4);
			Stock pricePointF = prices.get(index + 5);

			double startWave1 = pricePointA.getOpen();
			double endWave1 = pricePointB.getOpen();
			double endWave2 = pricePointC.getOpen();
			double endWave3 = pricePointD.getOpen();
			double endWave4 = pricePointE.getOpen();
			double endWave5 = pricePointF.getOpen();
			
			if(ElliotWave.isWave5pc100(startWave1, endWave1, endWave2, endWave3, endWave4, endWave5, OFFSET)) {
				System.out.println("Found Elliot Wave 5 at 100% of Wave 1");
				System.out.println(pricePointA.getInfo());
				System.out.println(pricePointB.getInfo());
				System.out.println(pricePointC.getInfo());
				System.out.println(pricePointD.getInfo());
				System.out.println(pricePointE.getInfo());
				System.out.println(pricePointF.getInfo());
				elliotWaves.add(pricePointA);
				elliotWaves.add(pricePointB);
				elliotWaves.add(pricePointC);
				elliotWaves.add(pricePointD);
				elliotWaves.add(pricePointE);
				elliotWaves.add(pricePointF);
			}
			if(ElliotWave.isWave5pc162(startWave1, endWave1, endWave2, endWave3, endWave4, endWave5, OFFSET)) {
				System.out.println("Found Elliot Wave 5 at 162% of Wave 1");
				System.out.println(pricePointA.getInfo());
				System.out.println(pricePointB.getInfo());
				System.out.println(pricePointC.getInfo());
				System.out.println(pricePointD.getInfo());
				System.out.println(pricePointE.getInfo());
				System.out.println(pricePointF.getInfo());
				elliotWaves.add(pricePointA);
				elliotWaves.add(pricePointB);
				elliotWaves.add(pricePointC);
				elliotWaves.add(pricePointD);
				elliotWaves.add(pricePointE);
				elliotWaves.add(pricePointF);
			}
			if(ElliotWave.isWave5pc262(startWave1, endWave1, endWave2, endWave3, endWave4, endWave5, OFFSET)) {
				System.out.println("Found Elliot Wave 5 at 262% of Wave 1");
				System.out.println(pricePointA.getInfo());
				System.out.println(pricePointB.getInfo());
				System.out.println(pricePointC.getInfo());
				System.out.println(pricePointD.getInfo());
				System.out.println(pricePointE.getInfo());
				System.out.println(pricePointF.getInfo());
				elliotWaves.add(pricePointA);
				elliotWaves.add(pricePointB);
				elliotWaves.add(pricePointC);
				elliotWaves.add(pricePointD);
				elliotWaves.add(pricePointE);
				elliotWaves.add(pricePointF);
			}

			index++;
		}
	} 
	
	@Test
	public void testIsWave5pc262() {
	   Assert.assertTrue(ElliotWave.isWave5pc262(WAVE5PC262[0], WAVE5PC262[1], WAVE5PC262[2], WAVE5PC262[3], WAVE5PC262[4], WAVE5PC262[5], 0.01f));	
	}
}
