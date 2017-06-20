package org.anjeco.dao;

import java.util.Date;
import java.util.List;

import org.anjeco.entity.Edicion;
import org.anjeco.entity.Presentacion;

public interface PresentacionDao {
	
	Presentacion find(int id);
	
	void create(Presentacion presentacion);
	
	List<Presentacion> read();
	
	Presentacion update(Presentacion presentacion);
	
	void delete(int id);
	
	boolean exist(Date hora, Edicion edicion);

}
