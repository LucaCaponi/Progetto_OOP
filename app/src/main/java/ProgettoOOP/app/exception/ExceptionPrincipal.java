package ProgettoOOP.app.exception;

public class ExceptionPrincipal {
	private String message;
	
	public ExceptionPrincipal() {
		message = "---";
	}
	
	public ExceptionPrincipal(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
