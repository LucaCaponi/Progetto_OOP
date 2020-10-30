package ProgettoOOP.app.exception;

/**
 * Eccezione lanciata se il JSONObject da richiamare è vuoto.
 * 
 * @author Federico Catalini
 * @author Luca Caponi
 * 
 */
public class NoJSONObject extends ExceptionAbstract {

	private static final long serialVersionUID = 1L;

	/**
	 * Ottiene il messaggio da stampare.
	 *
	 * @return String.
	 */

	@Override
	public String getMessage() {
		return "Nessun JSONObject trovato!";
	}

}
