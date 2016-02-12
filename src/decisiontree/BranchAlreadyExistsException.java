package decisiontree;

@SuppressWarnings("serial")
public class BranchAlreadyExistsException extends RuntimeException {
	public BranchAlreadyExistsException(){};
    public BranchAlreadyExistsException(String msg){super(msg);}
}
