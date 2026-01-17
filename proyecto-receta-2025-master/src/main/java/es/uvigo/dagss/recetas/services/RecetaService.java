package es.uvigo.dagss.recetas.services;

import java.util.List;
import es.uvigo.dagss.recetas.entidades.Receta;

@Service
public interface RecetaService{
	Receta crearReceta(Receta receta);
	Receta actualizarReceta(Receta receta);
	void eliminarReceta(Receta receta);
	Receta buscarPorId(Long id);
	List<Receta> buscarTodas();
	List<Receta> buscarPorPacienteId(Long pacienteId);
	List<Receta> buscarPorMedicoId(Long medicoId);
}
