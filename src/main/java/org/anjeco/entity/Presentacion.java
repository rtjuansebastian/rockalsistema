package org.anjeco.entity;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="presentaciones")
public class Presentacion implements Serializable {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="hora")
	@Temporal(TemporalType.TIME) 
	private Date hora;
	
	@ManyToOne
	@JoinColumn(name = "banda")
	private Banda banda;
	
	@ManyToOne
	@JoinColumn(name = "edicion")
	private Edicion edicion;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public Banda getBanda() {
		return banda;
	}

	public void setBanda(Banda banda) {
		this.banda = banda;
	}

}
