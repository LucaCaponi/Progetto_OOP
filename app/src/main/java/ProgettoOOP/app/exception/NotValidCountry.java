package ProgettoOOP.app.exception;

public class NotValidCountry extends ExceptionAbstract {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Ottiene il messaggio da stampare
	 *
	 * @return String
	 */
	
	@Override
	public String getMessage() {
		return "Nessun paese trovato!";
	}

}
