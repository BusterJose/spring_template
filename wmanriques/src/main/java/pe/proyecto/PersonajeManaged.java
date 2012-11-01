package pe.proyecto;




import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;





@Controller
public class PersonajeManaged {

	@Autowired
	@Qualifier("personajeServiceImpl")
	private PersonajeService personajeService;

	private String value;

	public String getValue() {
		List<Personaje> personajes = personajeService.findAll();
		for (Personaje personaje : personajes) {
			System.out.println(personaje.getValue());
		}
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public void save(ActionEvent actionEvent) {  
        FacesContext context = FacesContext.getCurrentInstance();  
          
        context.addMessage(null, new FacesMessage("Successful", "williams"));  
        context.addMessage(null, new FacesMessage("Second Message", "Additional Info Here..."));  
    }  
}
