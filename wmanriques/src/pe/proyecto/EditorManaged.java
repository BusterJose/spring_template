package pe.proyecto;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EditorManaged {
	private String value = "williams";
	
	@Autowired
	private ServiceEditor serviceEditor;

	public ServiceEditor getServiceEditor() {
		return serviceEditor;
	}

	public void setServiceEditor(ServiceEditor serviceEditor) {
		this.serviceEditor = serviceEditor;
	}

	public String getValue() {
		List<Editor> editors = this.findAll();
		for (Editor editor : editors) {
			System.out.println(" "+editor.getEdit_value());
		}
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public void save(ActionEvent actionEvent) {  
        FacesContext context = FacesContext.getCurrentInstance();  
          
        context.addMessage(null, new FacesMessage("Successful", "Hello " + value));  
        context.addMessage(null, new FacesMessage("Second Message", "Additional Info Here..."));  
    } 
	
	public List<Editor> findAll(){
		List<Editor> editors = serviceEditor.findAll();
		return editors;
	}
}
