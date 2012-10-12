package pe.proyecto;

import java.io.Serializable;

public class Personaje implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String value;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
