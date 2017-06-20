package org.anjeco.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "bandas")
public class Banda implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "nombre")
	private String nombre;

	@ManyToOne
	@JoinColumn(name = "genero")
	private Genero genero;

	@Column(name = "resena")
	private String resena;
	
	@ManyToMany
	@JoinTable(name = "bandas_integrantes", joinColumns = { @JoinColumn(name = "banda", referencedColumnName="id") }, inverseJoinColumns = {
			@JoinColumn(name = "integrante", referencedColumnName="id") })	
	private Set<Integrante> integrantes= new HashSet();

	@OneToMany(mappedBy = "banda", cascade = CascadeType.ALL)
	@JsonManagedReference(value="banda-trabajo")
	private Set<Trabajo> trabajos= new HashSet();

	public Banda() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getResena() {
		return resena;
	}

	public void setResena(String resena) {
		this.resena = resena;
	}

	public Set<Trabajo> getTrabajos() {
		return trabajos;
	}

	public void setTrabajos(Set<Trabajo> trabajos) {
		this.trabajos = trabajos;
	}

	public Set<Integrante> getIntegrantes() {
		return integrantes;
	}

	public void setIntegrantes(Set<Integrante> integrantes) {
		this.integrantes = integrantes;
	}
		
}
