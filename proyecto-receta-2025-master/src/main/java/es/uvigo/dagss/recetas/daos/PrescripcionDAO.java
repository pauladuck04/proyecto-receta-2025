package es.uvigo.dagss.recetas.daos;

public interface PrescripcionDAO extends JpaRepository<Prescripcion, Long>{
	List<Prescripcion> findByPacienteIdAndFechaFinGreaterThanEqualOrderByFechaInicioAsc(Long pacienteId, LocalDate fechaActual);
	List<Prescripcion> findByActivoTrue();
}