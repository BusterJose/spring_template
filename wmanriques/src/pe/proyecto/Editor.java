package pe.proyecto;

import java.io.Serializable;

public class Editor implements Serializable {

	private Integer edit_id;
	private String edit_value;

	public Integer getEdit_id() {
		return edit_id;
	}

	public void setEdit_id(Integer edit_id) {
		this.edit_id = edit_id;
	}

	public String getEdit_value() {
		return edit_value;
	}

	public void setEdit_value(String edit_value) {
		this.edit_value = edit_value;
	}
}
