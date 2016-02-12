package decisiontree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Decision Node Class:
 * 
 * The class extends a string type node since in this decision tree
 * implementation the decision node will always contain the name of
 * the attribute.
 * @author Antreas Pogiatzis
 *
 * @param <T> Type of decision node's attribute values 
 */
public class DecisionNode<T> extends Node<String> {

	//each branch has a value and leads to a node. 
	private Map<T, Node> branches = new HashMap<T, Node>();
	
	/**
	 * Default constructor
	 */
	public DecisionNode(){this(null);}	//explicit constructor invocation
	
	/**
	 * Creates a Decision node with the specified name.
	 * @param element
	 */
	public DecisionNode(String name){super(name);}
	
	/**
	 * Adds a new branch to the node.
	 * Each branch has a value and and a node which leads to.
	 * @param <E> Type of the node (String if DecisionNode)
	 * @param value Value of the branch
	 * @param next	Node which the branch is connected to.
	 * @throws BranchAlreadyExistsException
	 */
	public <E> void addBranch(T value, Node<E> next) throws BranchAlreadyExistsException{
		if (branches.containsKey(value)) throw new BranchAlreadyExistsException("This branch already exists!");
		branches.put(value, next);
	}
	
	/**
	 * Removes the branch with the specified value
	 * @param value Value of the branch to be removed.
	 * @throws BranchDoesNotExistException
	 */
	public void removeBranch(T value) throws BranchDoesNotExistException { 
		if (!branches.containsKey(value)) throw new BranchDoesNotExistException("The specified branch does not exist!");
		branches.remove(value);
	}
	
	/**
	 * Returns the number of branches in the DecisionNode.
	 * @return Number of branches
	 */
	public int getBranchesCount(){
		return branches.size();
	}
	
	/**
	 * Returns a Set containing all the branches attribute values.
	 * @return Set of values
	 */
	public Set<T> getBranchesValues(){
		return branches.keySet();
	}
	
	/**
	 * Sets the node of which a branch points to
	 * @param value Branch to change
	 * @param node	New children node
	 * @throws BranchDoesNotExistException
	 */
	public <E> void setBranchNode(T value, Node<E> node) throws BranchDoesNotExistException{
		if(!branches.containsKey(value)) throw new BranchDoesNotExistException("Can't change node of branch which does not exist.");
		branches.put(value, node);
	}
	
}