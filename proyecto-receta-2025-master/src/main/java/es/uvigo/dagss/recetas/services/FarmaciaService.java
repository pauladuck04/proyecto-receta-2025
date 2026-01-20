package es.uvigo.dagss.recetas.services;

import java.util.List;
import es.uvigo.dagss.recetas.entidades.Farmacia;

public interface FarmaciaService{
	public void crearFarmacia(Farmacia farmacia);
	public void actualizarFarmacia(Farmacia farmacia);
	public void eliminarFarmacia(Farmacia farmacia);
	public List<Farmacia> buscarTodos();
	public Farmacia buscarPorId(Long id);
	public List<Farmacia> buscarActivos();
	public List<Farmacia> buscarPorNombre(String nombre);
	public List<Farmacia> buscarPorLocalidad(String localidad);
    public String getFarmaciaHome(Long farmaciaId);
}