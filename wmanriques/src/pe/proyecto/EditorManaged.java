package pe.proyecto;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.stereotype.Controller;

@Controller
public class EditorManaged {
	private String value = "williams";

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void save(ActionEvent actionEvent) {
		FacesContext context = FacesContext.getCurrentInstance();

		context.addMessage(null, new FacesMessage("Successful", "Hello "
				+ value));
		context.addMessage(null, new FacesMessage("Second Message",
				"Additional Info Here..."));
	}
}
