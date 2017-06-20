package org.anjeco.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "bandas_integrantes")
public class BandaIntegrante {

	@Id
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "banda")
	@JsonBackReference
	private Banda banda;

	@ManyToOne
	@JoinColumn(name = "integrante")
	@JsonBackReference
	private Integrante integrante;

	public BandaIntegrante() {

	}

	public BandaIntegrante(int id, Banda banda, Integrante integrante) {
		this.id = id;
		this.banda = banda;
		this.integrante = integrante;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Banda getBanda() {
		return banda;
	}

	public void setBanda(Banda banda) {
		this.banda = banda;
	}

	public Integrante getIntegrante() {
		return integrante;
	}

	public void setIntegrante(Integrante integrante) {
		this.integrante = integrante;
	}

}
