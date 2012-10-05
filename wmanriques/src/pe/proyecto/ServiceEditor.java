package pe.proyecto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Repository
public class ServiceEditor {
	
	@Autowired
	private EditorMapper editorMapper;
	
	@Transactional(readOnly=true)
	public List<Editor> findAll(){
		List<Editor> editors = editorMapper.findAll();
		return editors;
	}
}
