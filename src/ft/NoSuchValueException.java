package ft;

@SuppressWarnings("serial")
public class NoSuchValueException extends RuntimeException{
	public NoSuchValueException(){};
    public NoSuchValueException(String msg){super(msg);}
}
