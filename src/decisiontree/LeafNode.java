package decisiontree;

public class LeafNode<T> extends Node {
	
	private static int LEAFNODE_COUNT = 0;
	private T value;
	
	public LeafNode(){ this("UnnamedLeafNode" + LeafNode.LEAFNODE_COUNT);}
	
	public LeafNode(String attr){ this(attr,null); }
	
	public LeafNode(String attr, T value){
		super(attr);
		this.value = value;
		LeafNode.LEAFNODE_COUNT++;
	}
	
	public T getValue(){
		return this.value;
	}
	
	public void setValue(T value){
		this.value = value;
	}
}
