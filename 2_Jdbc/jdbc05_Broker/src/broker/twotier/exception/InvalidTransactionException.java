package broker.twotier.exception;

public class InvalidTransactionException extends Exception{

	public InvalidTransactionException() {
		this("This is InvalidTransaction...");
	}

	public InvalidTransactionException(String message) {
		super(message);
	}
}
