package test;

import decisiontree.DecisionTree;
import decisiontree.LeafNode;
import entropy.Entropy;
import ft.FrequencyTable;
import ft.JointFrequencyTable;
import informationgain.InformationGain;

public class Test {

	public static void main(String args[]){
		//NOTE: Input arrays are sorted by index. ie : testInput[0] corresponds to testInput2[0]
		String[] testInput = {"Yes","Yes","Yes","Yes","Yes","Yes","Yes","Yes","Yes",
								"No","No","No","No","No"};
		String[] testInput2 = {"Sunny","Sunny","Sunny","Overcast","Overcast","Overcast","Overcast",
		                       "Rainy","Rainy","Sunny","Sunny","Rainy","Rainy","Rainy"};
		
		FrequencyTable<String> myFT = new FrequencyTable<String>("PlayGolf", testInput);
		System.out.println(myFT.toString());
		
		
		
		JointFrequencyTable<String> myDFT = new JointFrequencyTable<String>("PlayGolf","Outlook",testInput,testInput2);
		//System.out.println(myDFT.getProbabilityByValue("Yes","Sunny"));
		
		System.out.println(Entropy.calculate(myDFT));
//		System.out.println(myDFT.toString());
//		try{
//			System.out.println(myFT.getProbabilityByValue("Yes"));
//		} catch (NoSuchValueException e){
//			System.out.println(e.getMessage());
//		}
		//Entropy Test
		System.out.println("Joint entropy:" + Entropy.calculate("PlayGolf",testInput,"Outlook",testInput2));
		
		//LeafNodeTest
		LeafNode<String> a = new LeafNode<String>("Test");
		
		//DecisionTree test
		DecisionTree dt = new DecisionTree();
		dt.addAttribute("PlayGolf", testInput);
		
		//Information Gain Test:
		System.out.println("Information Gain PlayGolf-Outlook:"+InformationGain.calculate("PlayGolf",myDFT ));
		
		//FrequencyTable Test:
		//Why generic type array cannot be casted to String???
		for ( Object s : myFT.generateValuesArray()){
			System.out.println("Generates values:" + s);
		}
		
	}
	
}