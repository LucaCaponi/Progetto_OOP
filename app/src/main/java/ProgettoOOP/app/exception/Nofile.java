package ProgettoOOP.app.exception;

/**
 * Eccezione lanciata se il file JSON da richiamare non esiste
 */

public class Nofile extends ExceptionAbstract {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Ottiene il messaggio da stampare
	 *
	 * @return String
	 */
	
	@Override
	public String getMessage() {
		return "Nessun file trovato!";
	}

}
