package es.uvigo.dagss.recetas.services;

import java.util.List;

import es.uvigo.dagss.recetas.entidades.Prescripcion;
import es.uvigo.dagss.recetas.entidades.Receta;

public interface RecetaService{
	public void eliminarReceta(Receta receta);
	public Receta buscarPorId(Long id);
    public List<Receta> listarRecetas();
	public List<Receta> buscarPorPaciente(String nss);
	public List<Receta> buscarPorMedico(Long medicoId);
    public List<Receta> buscarRecetasPlanificadas();
    public List<Receta> generarPlanRecetas(Prescripcion prescripcion);
    public Receta anotarRecetaServida(Long recetaId, Long farmaciaId);
}