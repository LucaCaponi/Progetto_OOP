package ProgettoOOP.app.model;

/**
 * 
 * La classe Metadata serve per restituire i metadati di un oggetto di tipo
 * 'Countries'.
 *
 * @author Federico Catalini
 * @author Luca Caponi
 * 
 */
public class Metadata {
	private String alias;
	private String sourcefield;
	private String type;

	/**
	 * 
	 * @param alias
	 * @param sourcefield
	 * @param type
	 */
	public Metadata(String alias, String sourcefield, String type) {
		this.alias = alias;
		this.sourcefield = sourcefield;
		this.type = type;
	}

	/**
	 * 
	 * @return
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * 
	 * @param alias
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * 
	 * @return
	 */
	public String getSourcefield() {
		return sourcefield;
	}

	/**
	 * 
	 * @param sourcefield
	 */
	public void setSourcefield(String sourcefield) {
		this.sourcefield = sourcefield;
	}

	/**
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

}
