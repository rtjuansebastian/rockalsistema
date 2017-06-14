package org.anjeco.dao;

import java.util.Date;
import java.util.List;

import org.anjeco.entity.Edicion;

public interface EdicionDao {
	
	Edicion find(int id);
	
	void create(Edicion edicion);
	
	List<Edicion> read();
	
	Edicion update(Edicion edicion);

	void delete(int id);
	
	boolean exist(Date fecha);
	
}
