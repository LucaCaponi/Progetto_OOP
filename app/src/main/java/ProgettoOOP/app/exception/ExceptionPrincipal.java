package ProgettoOOP.app.exception;

import java.util.Calendar;

import org.springframework.http.HttpStatus;

/**
 * 
 * Classe che funziona da modello per gli errori dovuti ad eccezioni.
 * 
 * @author Federico Catalini
 * @author Luca Caponi
 * 
 */
public class ExceptionPrincipal {

	private Calendar date;
	private HttpStatus httpStatus;
	private String exception;
	private String message;

	/**
	 * Costruttore di ExceptionError con parametri
	 *
	 * @param date:       restituisce all'utente la data e l'orario della richiesta.
	 * @param httpStatus: status code che informa l'utente se una specifica
	 *                    richiesta HTTP è stata completata correttamente.
	 * @param exception:  informa l'utente su quale eccezione è stata generata.
	 * @param message:    messaggio dell'eccezione.
	 */
	public ExceptionPrincipal(Calendar date, HttpStatus httpStatus, String exception, String message) {
		super();
		this.date = date;
		this.httpStatus = httpStatus;
		this.exception = exception;
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Calendar getDate() {
		return date;
	}

	public void setC(Calendar date) {
		this.date = date;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

}