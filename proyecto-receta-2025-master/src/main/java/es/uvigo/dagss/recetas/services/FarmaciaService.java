package es.uvigo.dagss.recetas.services;

import java.util.List;
import es.uvigo.dagss.recetas.entidades.Farmacia;

public interface FarmaciaService{
	void crearFarmacia(Farmacia farmacia);
	void actualizarFarmacia(Farmacia farmacia);
	void eliminarFarmacia(Farmacia farmacia);
	Farmacia buscarPorId(Long id);
	List<Farmacia> buscarActivos();
	List<Farmacia> buscarPorNombre(String nombre);
	List<Farmacia> buscarPorLocalidad(String localidad);
}