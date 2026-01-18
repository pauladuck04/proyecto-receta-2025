package es.uvigo.dagss.recetas.daos;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import es.uvigo.dagss.recetas.entidades.Prescripcion;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescripcionDAO extends JpaRepository<Prescripcion, Long>{
	List<Prescripcion> findByPacienteId(Long pacienteId);
	List<Prescripcion> findByFechaFinGreaterThanEqualOrderByFechaInicioAsc(LocalDate fechaActual);
	List<Prescripcion> findByActivoTrue();
}