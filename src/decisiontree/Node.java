package decisiontree;

public abstract class Node<T> {
	
	private T element; //generic type element of the node
	
	/**
	 * Default constructor
	 */
	public Node(){ this(null); }
	
	/**
	 * Creates a node which contains the specified element.
	 * @param element
	 */
	public Node(T element){this.element = element;}
	
	/**
	 * Returns the element contained in the node.
	 * @return element
	 */
	public T getElement(){ return this.element;}
	
	/**
	 * Sets the element contained in the node.
	 * @param element
	 */
	public void setElement(T element) { this.element = element; }
}
