package es.uvigo.dagss.recetas.daos;

public interface PrescripcionDAO extends JpaRepository<Prescripcion, Long>{
	List<Prescripcion> findByPacienteId(Long pacienteId);
	List<Prescripcion> findByFechaFinGreaterThanEqualOrderByFechaInicioAsc(LocalDate fechaActual);
	List<Prescripcion> findByActivoTrue();
}