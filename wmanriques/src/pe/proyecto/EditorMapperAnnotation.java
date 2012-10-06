package pe.proyecto;

import java.util.List;

import org.apache.ibatis.annotations.*;

public interface EditorMapperAnnotation {

	@Select(value = "SELECT EDIT_ID,EDIT_VALUE FROM EDITOR")
	@Results(value = { @Result(javaType = Editor.class),
			@Result(property = "edit_id", column = "EDIT_ID"),
			@Result(property = "edit_value", column = "EDIT_VALUE") })
	List<Editor> findAll();

}
