package es.uvigo.dagss.recetas.daos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RecetaDAO extends JpaRepository<Receta, Long> {
	List<Receta> findByPrescripcionId(Long prescripcionId);
	List<Receta> findByPrescripcionPacienteId(Long pacienteId);
	List<Receta> findByEstado(EstadoReceta estado);
	List<Receta> findByPrescripcionPacienteNumTarjetaSanitaria(String numTarjetaSanitaria);
}