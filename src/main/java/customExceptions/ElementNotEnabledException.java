package customExceptions;

public class ElementNotEnabledException extends RuntimeException {
	
	private String message;
	
	public ElementNotEnabledException(String message) {
		this.message= message;
	}

	public String toString() {
		return message;
	}
}
