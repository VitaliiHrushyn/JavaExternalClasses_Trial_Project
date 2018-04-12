package ua.training.electriberies.model;

public class NotUniqueLoginException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotUniqueLoginException() {
		super();
	}

	public NotUniqueLoginException(String message) {
		super(message);
	}
	
}
