/***********************************************************
 * Joint Frqequency Table Java Implementation ( 2 Attributes )
 * Author: Antreas Pogiatzis
 * 
 * Description:
 * This frequency table stores the frequency
 * of various outcomes in a data sample. Specifically,
 * it was developed for the purpose of implementing the
 * ID3 algorithm for decision tree construction with JAVA
 * as described in this link:
 * 
 * http://www.saedsayad.com/decision_tree.htm
 * 
 ***********************************************************/
package ft;

import java.util.HashMap;
import java.util.Map;

public class FrequencyTable<T> {
	
	private Map<T,Integer> valueDomain = new HashMap<T,Integer>();
	private Map<T,Integer> mapper = new HashMap<T,Integer>();
	private int totalElements = 0;
	private int valueCounter = 0;
	private String title;
	
	/**
	 * Constructor of the class. 
	 * i) Counts how many times each value is present and completes the table
	 * ii) Counts how many different values there are
	 * iii) Assigns an index to each value and creates a mapper (Used for in JointFrequencyTable).
	 * @param title Title of the data sample. Only used for visualising purposes.
	 * @param in 	Array with sample data. 
	 */
	public FrequencyTable(String title, T[] in){
		this.title = title;
		for (T item : in){
			Integer counter = valueDomain.get(item);
			valueDomain.put(item,(counter == null) ? 1 : counter + 1);
			if (!mapper.containsKey(item)){
				mapper.put(item, valueCounter);
				valueCounter++;
			}
			
			totalElements++;
		}
	}
	
	/**
	 * This method returns a HashMap which is used as a mapper
	 * to assign a unique identifier to each value of the sample
	 * set.
	 * @return mapper HashMap.
	 */
	public Map<T,Integer> getMapper(){
		return mapper;
	}
	
	/**
	 * Calculates the probability (0.0 - 1.0) of a value to occur 
	 * according to the frequency table.
	 * 
	 * Probability(Value) = TimesValueOccured/TotalValueEntries
	 * 
	 * @param value The value of which the probability is needed
	 * @return The probability of a value to occur
	 * @throws NoSuchValueException
	 */
	public double getProbabilityByValue(T value) throws NoSuchValueException{
		if (!valueDomain.containsKey(value)) throw new NoSuchValueException("No such value in value domain!");
		return (double) valueDomain.get(value)/this.totalElements;
	}

	/**
	 * Creates an array with probability values.
	 * Each value corresponds to one value of the attribute
	 * @return Array with probabilities
	 */
	public double[] getProbabilityArray() throws NoSuchValueException{
		double[] array = new double[this.getValueDomainSize()];
		int i = 0;
		for (T n : this.getValueDomain()){
			array[i] = this.getProbabilityByValue(n);
			i++;
		}
		return array;
	}
	
	/**
	 * Returns how many times a value occurred in the data set
	 * @param value
	 * @return integer with number of value occurrences
	 * @throws NoSuchValueException if the value is not present in the table.
	 */
	public int getValueCount(T value) throws NoSuchValueException{
		if (!valueDomain.containsKey(value)) throw new NoSuchValueException("No such value in value domain!");
		return valueDomain.get(value);
	}
	
	/**
	 * Creates and returns an array which contains the possible values of an
	 * attribute.
	 * @return Array with values
	 */
	@SuppressWarnings("unchecked")
	public T[] getValueDomain(){
		return valueDomain.keySet().toArray((T[])new Object[valueDomain.keySet().size()]);
	}
	
	/**
	 * Returns true if the value is contained in the table, false otherwise.
	 * @param value
	 * @return boolean value of the presence of value 
	 */
	public boolean valueInDomain(T value){
		return valueDomain.containsKey(value);
	}
	
	/**
	 * Returns the size of the domain size.
	 * In other words how many possible values the attribute
	 * can take.
	 * @return
	 */
	public int getValueDomainSize(){ return valueCounter; }
	
	/**
	 * Creates and returns a string representation of the frequency
	 * table.
	 */
	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();
		out.append(this.title + "\n");
		for(Map.Entry<T, Integer> entry : this.valueDomain.entrySet()){
			out.append(entry.getKey() + "\t" + entry.getValue() + "\n");
		}
		out.append("------------------\n");
		out.append("Total\t" + this.totalElements);
		return out.toString();
	}
	
	
}
