package es.cristian.hibernate.controlador;

import es.cristian.hibernate.modelo.*;

public class ConMaestros {
	
	// CRUD
	
	//CREATE MAESTRO
	public ModMaestros addMaestro(int id, String nombre, int oficina, String telefono, String email) {
		ModMaestros maestro= new ModMaestros(id, nombre, oficina, telefono, email);
		maestro.addMaestro(maestro);
		return maestro;
	}
	
	//READ MAESTRO
	
	public void getMaestros() {
		ModMaestros maestro = new ModMaestros();
		maestro.getMaestros();
	}
	
	//UPDATE MAESTRO
	
	public void updateMaestro(ModMaestros maestro, int id, String nombre, int oficina, String telefono, String email) {
		maestro.updateMaestro(maestro, id, nombre, oficina, telefono, email);
	}
	
	//DELETE MAESTRO
	
	public void DeleteMaestro(ModMaestros maestro) {
		maestro.deleteMaestro(maestro);
	}
}
