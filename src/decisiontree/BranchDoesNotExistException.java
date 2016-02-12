package decisiontree;

@SuppressWarnings("serial")
public class BranchDoesNotExistException extends RuntimeException{
	public BranchDoesNotExistException(){};
    public BranchDoesNotExistException(String msg){super(msg);}
}
