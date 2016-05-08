package systrading.algopop.engine;

import org.junit.Assert;
import org.junit.Test;
import systrading.algopop.algorithms.ElliotWave;

/**
 * 
 * @author Hussein Badakhchani
 *
 */
public class ElliotWaveStaticDataTest {
	
	/*
	 * Unit Wave 1
	 * W1 = 1
	 */
	static double[] WAVE1 = {0.0, 1.0}; 
	
	/*
	 * A perfect Elliot Wave Pattern, wave length ratios are:
	 * W1 = 1
	 * W2 = 0.5
	 */
	static double[] WAVE2PC50 = {0.0, 1.0, 0.5}; 
	static double[] NOTWAVE2PC50 = {0.0, 1.0, 0.4};
	
	/*
	 * A perfect Elliot Wave Pattern, wave length ratios are:
	 * W1 = 1
	 * W2 = 0.5
	 * W3 = 1.62(W1)
	 */
	static double[] WAVE2PC50WAVE3PC162 = {0.0, 1.0, 0.5, 2.12}; 
	static double[] NOTWAVE2PC50WAVE3PC162 = {0.0, 0.8, 0.5, 2.12}; 
	
	/*
	 * A perfect Elliot Wave Pattern, wave length ratios are:
	 * W1 = 1
	 * W2 = 0.5
	 * W3 = 2.62(W1)
	 */
	static double[] WAVE2PC50WAVE3PC262 = {0.0, 1.0, 0.5, 3.12}; 
	static double[] NOTWAVE2PC50WAVE3PC262 = {0.0, 0.8, 0.5, 3.12}; 	
	
	/*
	 * A perfect Elliot Wave Pattern, wave length ratios are:
	 * W1 = 1
	 * W2 = 0.5
	 * W3 = 4.25(W1)
	 */
	static double[] WAVE2PC50WAVE3PC425 = {0.0, 1.0, 0.5, 4.75}; 
	static double[] NOTWAVE2PC50WAVE3PC425 = {0.0, 0.8, 0.5, 4.75}; 
	
	/*
	 * An almost perfect Elliot Wave Pattern, wave length ratios are:
	 * W1 = 1
	 * W2 = 0.62
	 */
	static double[] WAVE2PC62 = {0.0, 1.0, 0.38}; 
	static double[] NOTWAVE2PC62 = {0.0, 1.0, 0.28};
	
	/*
	 * A perfect Elliot Wave Pattern, wave length ratios are:
	 * W1 = 1
	 * W2 = 0.62
	 * W3 = 1.62(W1)
	 */
	static double[] WAVE2PC62WAVE3PC162 = {0.0, 1.0, 0.38, 2}; 
	static double[] NOTWAVE2PC62WAVE3PC162 = {0.0, 0.8, 0.38, 2}; 
	
	/*
	 * A perfect Elliot Wave Pattern, wave length ratios are:
	 * W1 = 1
	 * W2 = 0.62
	 * W3 = 2.62(W1)
	 */
	static double[] WAVE2PC62WAVE3PC262 = {0.0, 1.0, 0.38, 3.0}; 
	static double[] NOTWAVE2P62CWAVE3PC262 = {0.0, 0.8, 0.38, 3.0};
	
	/*
	 * A perfect Elliot Wave Pattern, wave length ratios are:
	 * W1 = 1
	 * W2 = 0.62
	 * W3 = 4.25(W1)
	 */
	static double[] WAVE2PC62WAVE3PC425 = {0.0, 1.0, 0.38, 4.63}; 
	static double[] NOTWAVE2PC62WAVE3PC425 = {0.0, 0.8, 0.38, 4.63};
	
	/*
	 * An almost perfect Elliot Wave Pattern, wave length ratios are:
	 * W1 = 1
	 * W2 = 0.5(W2)
	 * W3 = 1.62(W1)
	 * W4 = 0.24(W3)
	 * W5 = W1
	 */
	static double[] WAVE5PC262 = {0.0, 1.0, 0.5, 2.12, 1,7312, 2.7312}; 
	
	@Test
	public void testIsWave2pc50() {
		Assert.assertTrue(ElliotWave.isWave2pc50(WAVE2PC50[0], WAVE2PC50[1], WAVE2PC50[2], 0.0f));
	}
	
	@Test
	public void testIsNotWave2pc50() {
		Assert.assertFalse(ElliotWave.isWave2pc50(NOTWAVE2PC50[0], NOTWAVE2PC50[1], NOTWAVE2PC50[2], 0.0f));
	}
	
	@Test
	public void testIsWave2pc62() {
		Assert.assertTrue(ElliotWave.isWave2pc62(WAVE2PC62[0], WAVE2PC62[1], WAVE2PC62[2], 0.0f));
	}
	
	@Test
	public void testIsNotWave2pc62() {
		Assert.assertFalse(ElliotWave.isWave2pc62(NOTWAVE2PC62[0], NOTWAVE2PC62[1], NOTWAVE2PC62[2], 0.0f));
	}
	
	@Test
	public void testIsWave3pc162() {
		Assert.assertTrue(ElliotWave.isWave3pc162(WAVE2PC50WAVE3PC162[0], WAVE2PC50WAVE3PC162[1], WAVE2PC50WAVE3PC162[2], WAVE2PC50WAVE3PC162[3], 0.0f));
		Assert.assertTrue(ElliotWave.isWave3pc162(WAVE2PC62WAVE3PC162[0], WAVE2PC62WAVE3PC162[1], WAVE2PC62WAVE3PC162[2], WAVE2PC62WAVE3PC162[3], 0.0f));
	}
	
	@Test
	public void testIsNotWave3pc162() {
		Assert.assertFalse(ElliotWave.isWave3pc162(NOTWAVE2PC50WAVE3PC162[0], NOTWAVE2PC50WAVE3PC162[1], NOTWAVE2PC50WAVE3PC162[2], NOTWAVE2PC50WAVE3PC162[3], 0.0f));
		Assert.assertFalse(ElliotWave.isWave3pc162(NOTWAVE2PC62WAVE3PC162[0], NOTWAVE2PC62WAVE3PC162[1], NOTWAVE2PC62WAVE3PC162[2], NOTWAVE2PC62WAVE3PC162[3], 0.0f));
	}
	
	@Test
	public void testIsWave3pc262() {
	   Assert.assertTrue(ElliotWave.isWave3pc262(WAVE2PC62WAVE3PC262[0], WAVE2PC62WAVE3PC262[1], WAVE2PC62WAVE3PC262[2], WAVE2PC62WAVE3PC262[3], 0.0f));
	   Assert.assertTrue(ElliotWave.isWave3pc262(WAVE2PC62WAVE3PC262[0], WAVE2PC62WAVE3PC262[1], WAVE2PC62WAVE3PC262[2], WAVE2PC62WAVE3PC262[3], 0.0f));
	}
	
	@Test
	public void testIsNotWave3pc262() {
		Assert.assertFalse(ElliotWave.isWave3pc262(NOTWAVE2PC50WAVE3PC262[0], NOTWAVE2PC50WAVE3PC262[1], NOTWAVE2PC50WAVE3PC262[2], NOTWAVE2PC50WAVE3PC262[3], 0.0f));
		Assert.assertFalse(ElliotWave.isWave3pc262(NOTWAVE2P62CWAVE3PC262[0], NOTWAVE2P62CWAVE3PC262[1], NOTWAVE2P62CWAVE3PC262[2], NOTWAVE2P62CWAVE3PC262[3], 0.0f));
	}
	
	@Test
	public void testIsWave3pc425() {
		Assert.assertTrue(ElliotWave.isWave3pc425(WAVE2PC50WAVE3PC425[0], WAVE2PC50WAVE3PC425[1], WAVE2PC50WAVE3PC425[2], WAVE2PC50WAVE3PC425[3], 0.0f));
		Assert.assertTrue(ElliotWave.isWave3pc425(WAVE2PC62WAVE3PC425[0], WAVE2PC62WAVE3PC425[1], WAVE2PC62WAVE3PC425[2], WAVE2PC62WAVE3PC425[3], 0.0f));
	}
	
	@Test
	public void testIsNotWave3pc425() {
		Assert.assertFalse(ElliotWave.isWave3pc425(NOTWAVE2PC50WAVE3PC425[0], NOTWAVE2PC50WAVE3PC425[1], NOTWAVE2PC50WAVE3PC425[2], NOTWAVE2PC50WAVE3PC425[3], 0.0f));
		Assert.assertFalse(ElliotWave.isWave3pc425(NOTWAVE2PC62WAVE3PC425[0], NOTWAVE2PC62WAVE3PC425[1], NOTWAVE2PC62WAVE3PC425[2], NOTWAVE2PC62WAVE3PC425[3], 0.0f));
	}
	
	@Test
	public void testIsWave5pc262() {
		Assert.assertTrue(ElliotWave.isWave5pc262(WAVE5PC262[0], WAVE5PC262[1], WAVE5PC262[2], WAVE5PC262[3], WAVE5PC262[4], WAVE5PC262[5], 0.01f));	
	}
}
