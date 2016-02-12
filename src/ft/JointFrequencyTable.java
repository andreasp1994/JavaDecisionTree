/***********************************************************
 * Joint Frqequency Table Java Implementation ( 2 Attributes )
 * Author: Antreas Pogiatzis
 * 
 * Description:
 * This 
 * 
 * 
 ***********************************************************/
package ft;

import java.util.Map;

public class JointFrequencyTable<T> {
	
	private int[][] frequencies;
	private Map<T, Integer> mapper1;
	private Map<T, Integer> mapper2;
	private FrequencyTable<T> classft1;
	private FrequencyTable<T> ft2;
	private StringBuilder out = new StringBuilder();
	
	/**
	 * Contructor of the class
	 * @param title1
	 * @param title2
	 * @param in1
	 * @param in2
	 * @throws DatasetsDifferentSizeException
	 */
	public JointFrequencyTable(String title1, String title2, T[] in1, T[] in2) throws DatasetsDifferentSizeException{
		if (in1.length != in2.length) throw new DatasetsDifferentSizeException("Inputs have different length!");
		
		classft1 = new FrequencyTable<T>(title1,in1);
		ft2 = new FrequencyTable<T>(title2,in2);
		mapper1 = classft1.getMapper();
		mapper2 = ft2.getMapper();
		frequencies =  new int[classft1.getValueDomainSize()][ft2.getValueDomainSize()];
		
		//Complete frequency table by utilizing the mapper
		int index1;
		int index2;
		for (int i = 0;i<in1.length;i++) {
			index1 = mapper1.get(in1[i]);
			index2 = mapper2.get(in2[i]);
			frequencies[index1][index2]++;
		}
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public String toString() {
		for(int i = 0;i<frequencies.length;i++){
			for(int j = 0;j<frequencies[i].length;j++){
				out.append(frequencies[i][j] + "\t");
			}
			out.append("\n");
		}
		return out.toString();
	}
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	public double getProbabilityByValue(T value) throws NoSuchValueException{
		if (classft1.valueInDomain(value)) return classft1.getProbabilityByValue(value);
		return ft2.getProbabilityByValue(value);
	}
	
	/**
	 * 
	 * @param value
	 * @param value2
	 * @return
	 * @throws NoSuchValueException
	 */
	public double getProbabilityByValue(T value,T value2) throws NoSuchValueException{
		Integer index1 = mapper1.get(value);
		Integer index2 = mapper2.get(value2);
		if (index1 == null) throw new NoSuchValueException("No such value : " + value.toString());
		if (index2 == null) throw new NoSuchValueException("No such calue : " + value2.toString());
		return (double) frequencies[index1][index2]/ft2.getValueCount(value2);
	}
	
	/**
	 * 
	 * @param value
	 * @return
	 * @throws NoSuchValueException
	 */
	public double[] getProbabilityColumnArray(T value) throws NoSuchValueException {
		double[] array = new double[classft1.getValueDomainSize()];
		int i = 0;
		for(T class_value : classft1.getValueDomain()){
			//System.out.println(this.getProbabilityByValue(class_value,value));
			array[i] = this.getProbabilityByValue(class_value,value);
			i++;
		}
		return array;
	}
	
	public T[] getColumns(){
		return ft2.getValueDomain();
	}
	
	
}
