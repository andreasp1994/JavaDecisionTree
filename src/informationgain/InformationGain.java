package informationgain;

import entropy.Entropy;
import ft.JointFrequencyTable;

public final class InformationGain {
	
	private InformationGain(){};
	
	public static <T> double calculate(String classAttr, JointFrequencyTable<T> ft){
		return Entropy.calculate(ft.getFrequencyTable(classAttr)) - Entropy.calculate(ft);
	}
}
