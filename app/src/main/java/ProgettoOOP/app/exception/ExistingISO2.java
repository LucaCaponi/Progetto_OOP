package ProgettoOOP.app.exception;

/**
 * 
 * Eccezione lanciata se il il paese che si vuole inserire è 
 * già presente nella lista definita dall'utente
 * 
 * @author Federico Catalini
 * @author Luca Caponi
 */

public class ExistingISO2  extends ExceptionAbstract {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Ottiene il messaggio da stampare
	 *
	 * @return String
	 */
	
	@Override
	public String getMessage() {
		return "Existing ISO2!";
	}
	

}
