package pe.proyecto.service.mybatis;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.proyecto.domain.Personaje;
import pe.proyecto.persistence.PersonajeMapperXML;
import pe.proyecto.service.PersonajeService;

@Service
@Repository
@Transactional
public class PersonajeServiceImpl implements PersonajeService {

	private Log log = LogFactory.getLog(PersonajeServiceImpl.class);
	
	@Autowired
	private PersonajeMapperXML personajeMapperXML;

	@Transactional(readOnly = true)
	public List<Personaje> findAll() {
		log.info("fillAll() ok");
		List<Personaje> personajes = personajeMapperXML.findAll();
		return personajes;
	}
}
