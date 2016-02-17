package test;

import decisiontree.DecisionTree;
import decisiontree.LeafNode;
import entropy.Entropy;
import ft.FrequencyTable;
import ft.JointFrequencyTable;

public class Test {

	public static void main(String args[]){
		//NOTE: Input arrays are sorted by index. ie : testInput[0] corresponds to testInput2[0]
		String[] testInput = {"Yes","Yes","Yes","Yes","Yes","Yes","Yes","Yes","Yes",
								"No","No","No","No","No"};
		String[] testInput2 = {"Sunny","Sunny","Sunny","Overcast","Overcast","Overcast","Overcast",
		                       "Rainy","Rainy","Sunny","Sunny","Rainy","Rainy","Rainy"};
		
		FrequencyTable<String> myFT = new FrequencyTable<String>("PlayGolf", testInput);
		System.out.println(myFT.toString());
		
		
		
		JointFrequencyTable<String> myDFT = new JointFrequencyTable<String>("PlayGolf","Weather",testInput,testInput2);
		//System.out.println(myDFT.getProbabilityByValue("Yes","Sunny"));
		
		System.out.println(Entropy.calculate(myDFT));
//		System.out.println(myDFT.toString());
//		try{
//			System.out.println(myFT.getProbabilityByValue("Yes"));
//		} catch (NoSuchValueException e){
//			System.out.println(e.getMessage());
//		}
		
		//LeafNodeTest
		LeafNode<String> a = new LeafNode<String>("Test");
		
		//DecisionTree test
		DecisionTree dt = new DecisionTree();
		dt.addAttribute("PlayGolf", testInput);
		
	}
	
}