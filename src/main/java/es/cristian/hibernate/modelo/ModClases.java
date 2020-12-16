package es.cristian.hibernate.modelo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "clases")
public class ModClases implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "Clase_ID")
	private int clase_ID;
	
	@Column(name = "Nombre_Curso")
	private String nombre_Cusrso;
	
	@Column(name = "Dia_Semana")
	private String dia_Semana;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Maestro_ID")
	private ModMaestros maestros;
	
	public ModClases() {
		
	}

	public ModClases(int clase_ID, String nombre_Cusrso, String dia_Semana) {
		this.clase_ID = clase_ID;
		this.nombre_Cusrso = nombre_Cusrso;
		this.dia_Semana = dia_Semana;
	}

	public int getClase_ID() {
		return clase_ID;
	}

	public void setClase_ID(int clase_ID) {
		this.clase_ID = clase_ID;
	}

	public String getNombre_Cusrso() {
		return nombre_Cusrso;
	}

	public void setNombre_Cusrso(String nombre_Cusrso) {
		this.nombre_Cusrso = nombre_Cusrso;
	}

	public String getDia_Semana() {
		return dia_Semana;
	}

	public void setDia_Semana(String dia_Semana) {
		this.dia_Semana = dia_Semana;
	}
	
	

	public ModMaestros getMaestros() {
		return maestros;
	}

	public void setMaestros(ModMaestros maestros) {
		this.maestros = maestros;
	}

	@Override
	public String toString() {
		return "Clases [clase_ID=" + clase_ID + ", nombre_Cusrso=" + nombre_Cusrso + ", dia_Semana=" + dia_Semana + "]";
	}
	
}
