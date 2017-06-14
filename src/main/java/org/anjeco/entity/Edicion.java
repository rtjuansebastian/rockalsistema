package org.anjeco.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "ediciones")
public class Edicion implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "fecha")
	@Temporal(TemporalType.DATE) 
	private Date fecha;

	@Column(name = "lugar")
	private String lugar;

	@Column(name = "objetivo")
	private String objetivo;

	@OneToMany(mappedBy = "edicion", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<Presentacion> presentaciones = new HashSet();

	public Edicion() {

	}

	public Edicion(int id, Date fecha, String lugar, String objetivo, Set<Presentacion> presentaciones) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.lugar = lugar;
		this.objetivo = objetivo;
		this.presentaciones = presentaciones;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public Set<Presentacion> getPresentaciones() {
		return presentaciones;
	}

	public void setPresentaciones(Set<Presentacion> presentaciones) {
		this.presentaciones = presentaciones;
	}

}
