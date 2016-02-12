package decisiontree;

public abstract class Node {
	
	private String attribute; 
	
	/**
	 * Default constructor
	 */
	public Node(){ this(null); }
	
	/**
	 * Creates a node which represents the specified attribute.
	 * @param attribute
	 */
	public Node(String attr){this.attribute = attr;}
	
	/**
	 * Returns the attribute associated with the node.
	 * @return attribute string
	 */
	public String getAttribute(){ return this.attribute;}
	
	/**
	 * Sets the attribute associated with the node.
	 * @param attribute
	 */
	public void setAttribute(String attr) { this.attribute = attr; }
}
