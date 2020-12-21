package es.cristian.hibernate.modelo;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;


@Entity
@Table(name = "maestros")
public class ModMaestros implements Serializable{
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenciaMaestros");

	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Maestro_ID")
	private int maestro_ID;
	
	@Column(name = "Nombre")
	private String nombre;
	
	@Column(name = "Oficina")
	private int oficina;
	
	
	@Column(name = "Telefono")
	private String telefono;
	
	@Column(name = "Email")
	private String email;
	
	@OneToMany(mappedBy = "maestros", cascade = CascadeType.ALL)
	private List<ModClases> clases = new ArrayList<>();
	
	public ModMaestros() {
		
	}
	public ModMaestros(int id) {
		this.maestro_ID = id;
	}

	public ModMaestros(int id, String nombre, int oficina, String telefono, String email) {
		this.maestro_ID = id;
		this.nombre = nombre;
		this.oficina = oficina;
		this.telefono = telefono;
		this.email = email;
	}

	public int getMaestro_ID() {
		return maestro_ID;
	}

	public void setMaestro_ID(int maestro_ID) {
		this.maestro_ID = maestro_ID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getOficina() {
		return oficina;
	}

	public void setOficina(int oficina) {
		this.oficina = oficina;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<ModClases> getClases() {
		return clases;
	}

	public void setClases(List<ModClases> clases) {
		this.clases = clases;
	}

	@Override
	public String toString() {
		return "Maestros [maestro_ID=" + maestro_ID + ", nombre=" + nombre + ", oficina=" + oficina + ", telefono="
				+ telefono + ", email=" + email + "]";
	}
	
	
	//CRUD
	


	//CREATE MAESTRO
	
	public void addMaestro(ModMaestros maestro) {
		EntityManager manager = emf.createEntityManager();
		manager = emf.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(maestro);
		manager.getTransaction().commit();
		manager.close();
	    System.out.println("Maestro "+ maestro.getNombre() + " agregado exitosamente");
		
	}
	
	//READ MAESTROS
	@SuppressWarnings("unchecked")
	public void getMaestros() {
		EntityManager manager = emf.createEntityManager();
		manager = emf.createEntityManager();
		List<ModMaestros> maestros = (List<ModMaestros>) manager.createQuery("FROM ModMaestros").getResultList();
		System.out.println("Hay " + maestros.size() + " Maestro(s) en el sistema");
		for(ModMaestros maestro : maestros) {
			System.out.println(maestro.toString()); 
			}
		manager.close();
	}
	
	//UPDATE MAESTRO
	
	public void updateMaestro(ModMaestros maestro, int id, String nombre, int oficina, String telefono, String email){
		EntityManager manager = emf.createEntityManager();
		manager = emf.createEntityManager();
		manager.getTransaction().begin();
		maestro = manager.merge(maestro);  //Al usar el metodo merge, convierte la entidad e en managed, y asi poder ser editada
		maestro.setNombre(nombre);
		maestro.setOficina(oficina);
		maestro.setTelefono(telefono);
		maestro.setEmail(email);
		manager.getTransaction().commit();
		manager.close();
		System.out.println("El maestro de ID: "+ maestro.getMaestro_ID() + " ha sido actualizado satisfactoriamente");
	}
	
	//DELETE MAESTRO
	
	public void deleteMaestro(ModMaestros maes) {
		EntityManager manager = emf.createEntityManager();
		manager = emf.createEntityManager();
		manager.getTransaction().begin();
		maes = manager.merge(maes);
		manager.remove(maes);
		manager.getTransaction().commit();
		manager.close();
		System.out.println("Maestro con ID: " + maes.getMaestro_ID() + " eliminado de la base de datos");
	}
	
}
