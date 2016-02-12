package decisiontree;

public class LeafNode<T> extends Node<T> {
	
	private static int LEAFNODE_COUNT = 0;
	private String class_attribute;
	
	public LeafNode(){ this("UnnamedLeafNode" + LeafNode.LEAFNODE_COUNT);}
	
	public LeafNode(String class_atr){ this.class_attribute = class_atr; }
	
	
	
}
