package es.cristian.hibernate.test;

import java.util.List;
import javax.persistence.*;

import es.cristian.hibernate.modelo.ModClases;
import es.cristian.hibernate.modelo.ModMaestros;

/*
 *  Ejecutar SET GLOBAL time_zone = '-3:00'; en MYSQL para corregir excepcion de timezome
 */

public class test {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenciaMaestros");

	public static void main(String[] args) {
		EntityManager manager = emf.createEntityManager();
		manager = emf.createEntityManager();
		
		ModMaestros maestro = new ModMaestros("Juan Calvo", 102, "3103254", "juan@calvo");
		manager.getTransaction().begin();
		manager.persist(maestro);
		manager.getTransaction().commit();
		manager.close();
		imprimirTodo();

		}
	@SuppressWarnings("unchecked")
	private static void imprimirTodo() {
		
		EntityManager manager = emf.createEntityManager();
		List<ModMaestros> maestros = (List<ModMaestros>) manager.createQuery("FROM ModMaestros").getResultList();
		System.out.println("Hay " + maestros.size() + " Maestro(s) en el sistema");
		for(ModMaestros maestro : maestros) {
			System.out.println(maestro.toString()); 
			}
		}
}
