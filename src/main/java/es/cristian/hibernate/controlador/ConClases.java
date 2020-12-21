package es.cristian.hibernate.controlador;

import es.cristian.hibernate.modelo.*;

public class ConClases {
	
	//CRUD
	
	//CREATE CLASS
	
	public ModClases addClase(int id, String nombre, String dia, ModMaestros maestro) {
		ModClases clase = new ModClases(id, nombre, dia, maestro);
		clase.addClase(clase);
		return clase;
	}
	
	//READ CLASS
	
	public void getClases() {
		ModClases clases = new ModClases();
		clases.getClases();
	}
	
	//UPDATE CLASS
	
	public void updateClase(ModClases clase, int id, String nombre, String dia, ModMaestros maestro) {
		clase.updateClase(clase, id, nombre, dia, maestro);
	}
	
	//DELETE CLASS
	
	public void deleteClase(ModClases clase) {
		clase.deleteClase(clase);
	}

}
