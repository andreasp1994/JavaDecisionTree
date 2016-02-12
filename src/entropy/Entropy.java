package entropy;

import ft.JointFrequencyTable;
import ft.FrequencyTable;

/**
 * Helper static class for calculating entropy, given a frequency table.
 * 
 * @author Antreas Pogiatzis
 *
 */
public final class Entropy {
	
	private  Entropy(){}
	
	/**
	 * Calculates entropy value given the frequency table of 1 attribute.
	 * @param ft1 Attribute's frequency table.
	 * @return double variable containing the entropy value.
	 */
	public static <T> double calculate(FrequencyTable<T> ft){
		return E(ft.getProbabilityArray());
	}
	
	/**
	 * Calculates entropy value given the a joint frequency table.
	 * Note: 1 of the attributes is the classification attribute.
	 * (first one passed to JointFrequencyTable constructor)
	 * @param ft Joint frequency table.
	 * @return double variable containing the entropy value.
	 */
	public static <T> double calculate(JointFrequencyTable<T> ft){
		double entropy = 0;
		double p = 0;
		for(T n : ft.getColumns()){
			p = ft.getProbabilityByValue(n);
			entropy += p*E(ft.getProbabilityColumnArray(n));
		}
		return entropy;
	}
	
	/**
	 * Calculates entropy, given some probability values.
	 * Let S array of double values
	 * E(S)=sum(-S[i]*log2(S[i]))
	 * where i is from 0 to S.size
	 * @param args probability values
	 * @return double variable containing entropy value.
	 */
	private static double E(double... args){
		double e = 0;
		for ( double arg : args ) {
			if (arg != 0) e -= arg*(Math.log(arg)/Math.log(2)); //log(0) returns NaN
			else e -= 0;										//return 0 instead
		}
		return e;
	}
}
