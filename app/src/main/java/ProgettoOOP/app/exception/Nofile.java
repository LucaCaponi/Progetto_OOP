package ProgettoOOP.app.exception;

public class Nofile extends ExceptionPrincipal {
	
	@SuppressWarnings("unused")
	private static final long serialversionUID = 1L;
	
	@Override
	public String getMessage() {
		return "Nessun file trovato!";
	}

}
