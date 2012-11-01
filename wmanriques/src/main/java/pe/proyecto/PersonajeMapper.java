package pe.proyecto;




import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;



public interface PersonajeMapper {
	
	@Select(value = "SELECT PER_ID,PER_VALUE FROM PERSONAJE")
	@Results(value = { @Result(javaType = Personaje.class),
			@Result(property = "id", column = "PER_ID"),
			@Result(property = "value", column = "PER_VALUE") })
	List<Personaje> findAll();

}
