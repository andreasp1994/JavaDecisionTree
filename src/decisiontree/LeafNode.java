package decisiontree;

/**
 * LeafNode Class
 * 
 * Description:
 * 
 * @author Andreas Pogiatzis
 *
 * @param <T> Type of node's values
 */
public class LeafNode<T> extends Node {
	
	/**
	 * private fields of the class
	 * 
	 * LEAFNODE_COUNT: 	used to create names for unnamed nodes.
	 * value: 			value contained in the node.
	 */
	private static int LEAFNODE_COUNT = 0;
	private T value;
	
	/**
	 * Default constructor
	 * Creates a leaf node with an automatic generated attribute name and a null value.
	 */
	public LeafNode(){ this("UnnamedLeafNode" + LeafNode.LEAFNODE_COUNT);}
	
	/**
	 * Creates a leaf node with the specified attribute name
	 * and null value.
	 * @param attr
	 */
	public LeafNode(String attr){ this(attr,null); }
	
	/**
	 * Creates a leaf node with the specified attribute name and the
	 * specified value.
	 * @param attr Attribute Name
	 * @param value	Value of the node
	 */
	public LeafNode(String attr, T value){
		super(attr);
		this.value = value;
		LeafNode.LEAFNODE_COUNT++;
	}
	
	/**
	 * Returns the value of the node
	 * @return Value of the node
	 */
	public T getValue(){
		return this.value;
	}
	
	/**
	 * Sets the value of the node.
	 * @param value New value
	 */
	public void setValue(T value){
		this.value = value;
	}
}
