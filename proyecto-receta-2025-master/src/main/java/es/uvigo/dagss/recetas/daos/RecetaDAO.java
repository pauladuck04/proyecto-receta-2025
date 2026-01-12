package es.uvigo.dagss.recetas.daos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RecetaDAO extends JpaRepository<Receta, Long> {
	List<Receta> findByPrescripcionId(Long prescripcionId);
	List<Receta> findByPrescripcionPacienteIdAndEstadorOrderByFechaValidezInicialAsc(Long pacienteId, EstadoReceta estado);
	List<Receta> findByPrescripcionPacienteNumTarjetaSanitariaAndEstado(String numTarjetaSanitaria, EstadoReceta estado);
}