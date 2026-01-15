package es.uvigo.dagss.recetas.services;

import java.util.List;
import es.uvigo.dagss.recetas.entidades.Farmacia;

public interface FarmaciaService{
	public Farmacia crearFarmacia(Farmacia farmacia);
	public Farmacia actualizarFarmacia(Farmacia farmacia);
	public void eliminarFarmacia(Farmacia farmacia);
	public List<Farmacia> buscarTodos();
	public Farmacia buscarPorId(Long id);
	public List<Farmacia> buscarActivos();
	public List<Farmacia> buscarPorNombre(String nombre);
	public List<Farmacia> buscarPorLocalidad(String localidad);
}