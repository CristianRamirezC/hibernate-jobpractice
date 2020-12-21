package es.cristian.hibernate.test;

import java.util.List;
import javax.persistence.*;

import es.cristian.hibernate.modelo.*;
import es.cristian.hibernate.controlador.*;

/*
 *  Ejecutar SET GLOBAL time_zone = '-3:00'; en MYSQL para corregir excepcion de timezome
 */

public class test {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenciaMaestros");

	public static void main(String[] args) {
		/*ConMaestros ConMaestro = new ConMaestros();
		ModMaestros ModMaestro = ConMaestro.addMaestro(19, "Santiago Ramirez", 106, "123456", "santi@correo");
		ConMaestro.getMaestros();
		ConMaestro.updateMaestro(ModMaestro, 19, "Camila Ramirez", 106, "123456", "santi@correo");*/
		ModMaestros maestro = new ModMaestros(19, "Camila Ramirez", 106, "123456", "santi@correo");
		ConClases ConClase = new ConClases();
		//ModClases ModClase = ConClase.addClase(2, "ciencias naturales", "Miercoles", maestro);
		ModClases ModClase = new ModClases(2, "ciencias naturales", "Miercoles", maestro);
		ConClase.deleteClase(ModClase);
		ConClase.getClases();
		


		}
/*	@SuppressWarnings("unchecked")
	private static void imprimirMaestros() {
		
		EntityManager manager = emf.createEntityManager();
		List<ModMaestros> maestros = (List<ModMaestros>) manager.createQuery("FROM ModMaestros").getResultList();
		System.out.println("Hay " + maestros.size() + " Maestro(s) en el sistema");
		for(ModMaestros maestro : maestros) {
			System.out.println(maestro.toString()); 
			}
		}
	
	@SuppressWarnings("unchecked")
	private static void imprimirClases() {
		
		EntityManager manager = emf.createEntityManager();
		List<ModClases> clases = (List<ModClases>) manager.createQuery("FROM ModClases").getResultList();
		System.out.println("Hay " + clases.size() + " clase(s) en el sistema");
		for(ModClases clase : clases) {
			System.out.println(clase.toString()); 
			}
		}*/
}
