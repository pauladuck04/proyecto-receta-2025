package es.uvigo.dagss.recetas.services;

import java.util.List;
import es.uvigo.dagss.recetas.entidades.Receta;

@Service
public interface RecetaService{
	public void crearReceta(Receta receta);
	public void actualizarReceta(Receta receta);
	public void eliminarReceta(Receta receta);
	public Receta buscarPorId(Long id);
	public List<Receta> buscarTodas();
	public List<Receta> buscarPorPacienteId(Long pacienteId);
	public List<Receta> buscarPorMedicoId(Long medicoId);
}
