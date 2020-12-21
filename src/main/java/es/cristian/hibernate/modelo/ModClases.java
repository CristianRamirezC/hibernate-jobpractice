package es.cristian.hibernate.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "clases")
public class ModClases implements Serializable{
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenciaMaestros");


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
	
	public ModClases(int id, String nombre_Cusrso, String dia_Semana, ModMaestros maestro) {
		this.clase_ID = id;
		this.nombre_Cusrso = nombre_Cusrso;
		this.dia_Semana = dia_Semana;
		this.maestros = maestro;
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
		return "Clases [clase_ID= " + clase_ID + ", nombre_Curso= " + nombre_Cusrso + ", dia_Semana= " + dia_Semana + " maestro: "+ maestros+ "]";
	}
	

	//CRUD
	
	//CREATE A CLASS

	public void addClase(ModClases clase) {
		EntityManager manager = emf.createEntityManager();
		manager = emf.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(clase);
		manager.getTransaction().commit();
		manager.close();
		System.out.println("Clase de " + clase.getNombre_Cusrso() + " agregada");
	}
	
	
	//READ CLASES 
	
	public void getClases() {
		EntityManager manager = emf.createEntityManager();
		manager = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<ModClases> clases = (List<ModClases>) manager.createQuery("FROM ModClases").getResultList();
		System.out.println("Hay " + clases.size() + " clase(s) en el sistema");
		for(ModClases clase : clases) {
			System.out.println(clase.toString()); 
			}
		manager.close();
	}
	
	
	//UPDATE CLASS
	
	public void updateClase(ModClases clase, int id, String nombre, String dia, ModMaestros maestro) {
		EntityManager manager = emf.createEntityManager();
		manager = emf.createEntityManager();
		manager.getTransaction().begin();
		clase = manager.merge(clase);
		clase.setNombre_Cusrso(nombre);
		clase.setDia_Semana(dia);
		clase.setMaestros(maestro);
		manager.persist(clase);
		manager.getTransaction().commit();
		manager.close();
		System.out.println("Clase de " + clase.getNombre_Cusrso() + " actualizada");
	}
	
	//DELETE CLASS
	
	public void deleteClase(ModClases clase) {
		EntityManager manager = emf.createEntityManager();
		manager = emf.createEntityManager();
		manager.getTransaction().begin();
		clase = manager.merge(clase);
		manager.remove(clase);
		manager.getTransaction().commit();
		manager.close();
		System.out.println("Clase de " + clase.getNombre_Cusrso() + " eliminada");
	}
}
