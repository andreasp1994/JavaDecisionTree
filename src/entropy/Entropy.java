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
	 * Calculates the entropy of an attribute by constructing
	 * a frequency table given the values of the attribute.
	 * @param attr
	 * @param values
	 * @return double variable containing Entropy value
	 */
	public static <T> double calculate(String attr, T[] values){
		return  Entropy.calculate(new FrequencyTable<T>(attr, values));
	}
	
	public static <T> double calculate(String attr1, T[] values1, String attr2, T[] values2){
		return Entropy.calculate(new JointFrequencyTable<T>(attr1,attr2,values1,values2)); //Why the hell did i put the parameters in that order..? whatever...
	}
	
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
