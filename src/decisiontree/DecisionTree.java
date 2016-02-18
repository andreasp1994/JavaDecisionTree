package decisiontree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ft.FrequencyTable;
import ft.JointFrequencyTable;
import informationgain.InformationGain;

public class DecisionTree {
	
	// Added data set map as a private field here
	// for convenience but it is quite space-expensive.
	private Map<String, String[]> datain = new HashMap<String, String[]>();
	
	private DecisionNode<String> root;
	private DecisionNode<String> activeDecisionNode;
	private String classAttribute = null;
	private Map<String,FrequencyTable<String>> fTableMap = new HashMap<String, FrequencyTable<String>>();
	private ArrayList<String> attributePool = new ArrayList<String>();
	
	public DecisionTree() {
		this.root = null; 
		this.activeDecisionNode = null;
	}
	
	public boolean isEmpty(){ return this.root == null; }
	
	private void addDecisionNode(DecisionNode<String> node, String branch){
		if (isEmpty()) { this.root = node; }
		else { this.activeDecisionNode.addBranch(branch, node); }
		this.activeDecisionNode = node;
	}
	
	public void addAttribute(String name, String[] values){
		this.fTableMap.put(name, new FrequencyTable<String>(name,values));
		this.datain.put(name, (String[]) values);
		this.attributePool.add(name);
	}
	
	public void setClassAttrbibute(String attr){
		this.classAttribute = attr;
	}
	
	public String getClassAttribute(){
		return this.classAttribute;
	}
	
	public String findMaxInformationGain(){
		String attrMax = "";
		double max = 0;
		for (String attribute : datain.keySet()) {
			double informationGain = InformationGain.calculate(this.classAttribute,
							new JointFrequencyTable<String>(this.classAttribute,attribute, datain.get(this.classAttribute), datain.get(attribute)));
			if (informationGain > max){
				max = informationGain;
				attrMax = attribute;
			}
		}
		return attrMax;
	}
	
	public void removeFromAttributePool(String attr){
		this.attributePool.remove(attr);
	}
	
	public void generateTree(){
		String maxInfoGainAttr = findMaxInformationGain();
		this.addDecisionNode(new DecisionNode<String>(maxInfoGainAttr), );
	}
	
	
}
