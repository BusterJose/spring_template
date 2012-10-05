package pe.proyecto;

import java.util.List;

import org.apache.ibatis.annotations.*;

public interface EditorMapperAnnotation {

	@Select(value = "SELECT ID,FIRST_NAME,LAST_NAME,BIRTH_DATE FROM CONTACT")
	@Results(value = { @Result(javaType = Editor.class),
			@Result(property = "id", column = "EDIT_ID"),
			@Result(property = "firstName", column = "FIRST_NAME") })
	List<Editor> findAll();

}
