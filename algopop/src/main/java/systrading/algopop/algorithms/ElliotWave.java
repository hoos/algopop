package systrading.algopop.algorithms;

/**
 * 
 * @author Hussein Badakhchani
 * 
 * ElliotWave provides methods for identifying Elliot Waves at different levels of precision.
 *
 */
public class ElliotWave {
	
	/**
	 * Wave 2 is typically a 50% or 62% retrenchment from the end high of the Wave 1
	 * This method starts by verifying the direction of the Wave and then simply compares
	 * the lengths of the Waves. If the length of Wave 1 is roughly twice that of Wave 2 we have
	 * identified and Elliot Wave i.e. the 50% definition of an Elliot Wave 2 
	 * @param startWave1
	 * @param endWave1
	 * @param endWave2
	 * @return
	 */
	static boolean isWave2pc50(double startWave1, double endWave1, double endWave2, float offset) { 
		if (endWave1 > startWave1 && endWave2 < endWave1) {
			double waveRatio = (endWave1 - endWave2)/(endWave1 - startWave1);
			if( waveRatio >= (0.5 - offset) && waveRatio <= (0.5 + offset)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Wave 2 is typically a 50% or 62% retrenchment from the end high of the Wave 1
	 * This method starts by verifying the direction of the Wave and then simply compares
	 * the lengths of the Waves. If the length of Wave 1 is roughly 1.61 that of Wave 2 we have
	 * identified and Elliot Wave i.e. the 62% definition of an Elliot Wave 2 
	 * @param startWave1
	 * @param endWave1
	 * @param endWave2
	 * @param offset
	 * @return
	 */
	static boolean isWave2pc62(double startWave1, double endWave1, double endWave2, float offset) { 
		if (endWave1 > startWave1 && endWave2 < endWave1) {
			double waveRatio = (endWave1 - endWave2)/(endWave1 - startWave1);
			//System.out.println(waveRatio);
			if( waveRatio >= (0.62 - offset) && waveRatio <= (0.62 + offset)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Wave 3 is typically 1.62, 2.62 or 4.25 times the size of Wave 1
	 * This method starts by verifying the direction of the Wave and then simply compares
	 * the lengths of the Waves. This method identifies Wave 3 that fits with the 162% 
	 * gain over Wave 1 definition.
	 * @param startWave1
	 * @param endWave1
	 * @param endWave2
	 * @param endWave3
	 * @param offset
	 * @return
	 */
	static boolean isWave3pc162(double startWave1, double endWave1, double endWave2, double endWave3, float offset) { 
		if (endWave1 > startWave1 && endWave2 < endWave1 && endWave2 < endWave3) {
			double waveRatio = (endWave3 - endWave2)/(endWave1 - startWave1);
			if( waveRatio >= (1.62 - offset) && waveRatio <= (1.62 + offset))  {
				return true;
			} 
		}
		return false;
	}

	/**
	 * Wave 3 is typically 1.62, 2.62 or 4.25 times the size of Wave 1
	 * This method starts by verifying the direction of the Wave and then simply compares
	 * the lengths of the Waves. This method identifies Wave 3 that fits with the 262% 
	 * gain over Wave 1 definition.
	 * @param startWave1
	 * @param endWave1
	 * @param endWave2
	 * @param endWave3
	 * @param offset
	 * @return
	 */
	static boolean isWave3pc262(double startWave1, double endWave1, double endWave2, double endWave3, float offset) { 
		if (endWave1 > startWave1 && endWave2 < endWave1 && endWave2 < endWave3) {
			double waveRatio = (endWave3 - endWave2)/(endWave1 - startWave1);
			if( waveRatio >= (2.62 - offset) && waveRatio <= (2.62 + offset))  {
				return true;
			} 
		}
		return false;
	}

	/**
	 * Wave 3 is typically 1.62, 2.62 or 4.25 times the size of Wave 1
	 * This method starts by verifying the direction of the Wave and then simply compares
	 * the lengths of the Waves. This method identifies Wave 3 that fits with the 425% 
	 * gain over Wave 1 definition.
	 * @param startWave1
	 * @param endWave1
	 * @param endWave2
	 * @param endWave3
	 * @param offset
	 * @return
	 */
	static boolean isWave3pc425(double startWave1, double endWave1, double endWave2, double endWave3, float offset) { 
		if (endWave1 > startWave1 && endWave2 < endWave1 && endWave2 < endWave3) {
			double waveRatio = (endWave3 - endWave2)/(endWave1 - startWave1);
			if( waveRatio >= (4.25 - offset) && waveRatio <= (4.25 + offset))  {
				return true;
			} 
		}
		return false;
	}
	
	/**
	 * Wave 4 is typically 0.24, 0.38 or 0.5 times the size of Wave 3
	 * This method starts by verifying the direction of the Wave and then simply compares
	 * the lengths of the Waves. This method identifies Wave 4 that fits with the 24% 
	 * gain over Wave 3 definition.
	 * @param endWave2
	 * @param endWave3
	 * @param endWave4
	 * @param offset
	 * @return
	 */
	static boolean isWave4pc24(double endWave2, double endWave3, double endWave4, float offset) { 
		if (endWave2 < endWave3 && endWave3 > endWave4) {
			double waveRatio = (endWave3 - endWave4)/(endWave3 - endWave2);
			if( waveRatio > (0.24 - offset) && waveRatio < (0.24 + offset))  {
				return true;
			} 
		}
		return false;
	}
	
	/**
	 * Wave 4 is typically 0.24, 0.38 or 0.5 times the size of Wave 3
	 * This method starts by verifying the direction of the Wave and then simply compares
	 * the lengths of the Waves. This method identifies Wave 4 that fits with the 38% 
	 * gain over Wave 3 definition.
	 * @param endWave2
	 * @param endWave3
	 * @param endWave4
	 * @param offset
	 * @return
	 */
	static boolean isWave4pc38(double endWave2, double endWave3, double endWave4, float offset) { 
		if (endWave2 < endWave3 && endWave3 > endWave4) {
			double waveRatio = (endWave3 - endWave4)/(endWave3 - endWave2);
			if( waveRatio > (0.38 - offset) && waveRatio < (0.38 + offset))  {
				return true;
			} 
		}
		return false;
	}
	
	/**
	 * Wave 4 is typically 0.24, 0.38 or 0.5 times the size of Wave 3
	 * This method starts by verifying the direction of the Wave and then simply compares
	 * the lengths of the Waves. This method identifies Wave 4 that fits with the 50% 
	 * gain over Wave 3 definition. 
	 * @param endWave2
	 * @param endWave3
	 * @param endWave4
	 * @param offset
	 * @return
	 */
	static boolean isWave4pc50(double endWave2, double endWave3, double endWave4, float offset) { 
		if (endWave2 < endWave3 && endWave3 > endWave4) {
			double waveRatio = (endWave3 - endWave4)/(endWave3 - endWave2);
			if( waveRatio > (0.50 - offset) && waveRatio < (0.50 + offset))  {
				return true;
			} 
		}
		return false;
	}
	
	/**
	 * If Wave 3 is greater than 1.62 or extended then Wave 5 ratios are 1, 1.62 and 2.62 of Wave 1
	 * This method starts by verifying the direction of the Wave and then simply compares
	 * the lengths of the Waves. This method identifies Wave 5 that fits with the 100% 
	 * gain over Wave 1 definition. 
	 * @param startWave1
	 * @param endWave1
	 * @param endWave2
	 * @param endWave3
	 * @param endWave4
	 * @param endWave5
	 * @param offset
	 * @return
	 */
	static boolean isWave5pc100(double startWave1, double endWave1, double endWave2, double endWave3, 
			double endWave4, double endWave5, float offset) {
		if(endWave1 > startWave1 && endWave5 > endWave4) {
			if (isWave3pc162(startWave1, endWave1, endWave2, endWave3, 0.05f)) {
				double waveRatio = (endWave5 - endWave4)/(endWave1 - endWave2);
				if( waveRatio > (1 - offset) || waveRatio < (1 + offset)) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * If Wave 3 is greater than 1.62 or extended then Wave 5 ratios are 1, 1.62 and 2.62 of Wave 1
	 * This method starts by verifying the direction of the Wave and then simply compares
	 * the lengths of the Waves. This method identifies Wave 5 that fits with the 162% 
	 * gain over Wave 1 definition.
	 * @param startWave1
	 * @param endWave1
	 * @param endWave2
	 * @param endWave3
	 * @param endWave4
	 * @param endWave5
	 * @param offset
	 * @return
	 */
	static boolean isWave5pc162(double startWave1, double endWave1, double endWave2, double endWave3, 
			double endWave4, double endWave5, float offset) {
		if(endWave1 > startWave1 && endWave5 > endWave4) {
			if (isWave3pc162(startWave1, endWave1, endWave2, endWave3, 0.05f)) {
				double waveRatio = (endWave5 - endWave4)/(endWave1 - endWave2);
				if( waveRatio > (1.62 - offset) || waveRatio < (1.62 + offset)) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * If Wave 3 is greater than 1.62 or extended then Wave 5 ratios are 1, 1.62 and 2.62 of Wave 1
	 * This method starts by verifying the direction of the Wave and then simply compares
	 * the lengths of the Waves. This method identifies Wave 5 that fits with the 262% 
	 * gain over Wave 1 definition.
	 * @param startWave1
	 * @param endWave1
	 * @param endWave2
	 * @param endWave3
	 * @param endWave4
	 * @param endWave5
	 * @param offset
	 * @return
	 */
	static boolean isWave5pc262(double startWave1, double endWave1, double endWave2, double endWave3, 
			double endWave4, double endWave5, float offset) {
		if(endWave1 > startWave1 && endWave5 > endWave4) {
			if (isWave3pc162(startWave1, endWave1, endWave2, endWave3, 0.05f)) {
				double waveRatio = (endWave5 - endWave4)/(endWave1 - endWave2);
				if( waveRatio > (2.62 - offset) || waveRatio < (2.62 + offset)) {
					return true;
				}
			}
		}
		return false;
	}
}
