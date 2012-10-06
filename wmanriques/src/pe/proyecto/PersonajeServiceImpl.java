package pe.proyecto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Repository
@Transactional
public class PersonajeServiceImpl implements PersonajeService {

	@Autowired
	private PersonajeMapper personajeMapper;

	@Transactional(readOnly = true)
	public List<Personaje> findAll() {
		List<Personaje> personajes = personajeMapper.findAll();
		return personajes;
	}
}
