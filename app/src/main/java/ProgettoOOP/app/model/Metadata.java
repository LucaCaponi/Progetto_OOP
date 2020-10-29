package ProgettoOOP.app.model;

/**
 * 
 * @author Federico Catalini
 * @author Luca Caponi
 * 
 *         La classe Metadata serve per restituire i metadati di un oggetto di
 *         tipo 'Countries'.
 *
 */
public class Metadata {
	private String alias;
	private String sourcefield;
	private String type;

	public Metadata(String alias, String sourcefield, String type) {
		this.alias = alias;
		this.sourcefield = sourcefield;
		this.type = type;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getSourcefield() {
		return sourcefield;
	}

	public void setSourcefield(String sourcefield) {
		this.sourcefield = sourcefield;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
