package ProgettoOOP.app.exception;

/**
 * 
 * Eccezione lanciata se il il paese che si vuole inserire non è presente
 * nell'API "Get Countries" o non esiste
 * 
 * @author Federico Catalini
 * @author Luca Caponi
 */

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
