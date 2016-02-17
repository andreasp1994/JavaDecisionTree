package decisiontree;

import java.util.HashMap;
import java.util.Map;

import ft.FrequencyTable;

public class DecisionTree {
	
	private Node root;
	private Node active;
	private Map<String,FrequencyTable> fTableMap = new HashMap<String, FrequencyTable>();
	
	public DecisionTree() {this(null); }
	
	public DecisionTree(Node root){ this.root = root; }
	
	public boolean isEmpty(){ return this.root == null; }
	
//	private <T> void addDecisionNode(DecisionNode<T> node, String branch){
//		if (root == null) { 
//			this.root = node;
//			this.active = node;
//		} else {
//			if (this.active instanceof DecisionNode){
//				((DecisionNode) this.active).setBranchNode(branch, node);
//			}
//		}
//	}
	
	public <T> void addAttribute(String name, T[] values){
		this.fTableMap.put(name, new FrequencyTable<T>(name,values));
		
	}
	
	
}
