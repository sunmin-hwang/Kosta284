package broker.twotier.exception;

public class DuplicateSSNException extends Exception{

	public DuplicateSSNException() {
		this("This is DuplicateSSN...");
	}

	public DuplicateSSNException(String message) {
		super(message);
	}

	
}
