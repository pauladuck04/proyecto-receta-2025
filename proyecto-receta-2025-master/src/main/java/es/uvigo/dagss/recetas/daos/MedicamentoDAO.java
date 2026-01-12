package es.uvigo.dagss.recetas.daos;

@Repository
public interface MedicamentoDAO extends JpaRepository<Medicamento, Long> {
	
    List<Medicamento> findByNombreComercialContainingIgnoreCase(String nombreComercial);
	List<Medicamento> findByPrincipioActivoContainingIgnoreCase(String principioActivo);

	@Query("SELECT m FROM Medicamento m WHERE " +
           "LOWER(m.nombreComercial) LIKE LOWER(CONCAT('%', :t, '%')) OR " +
           "LOWER(m.principioActivo) LIKE LOWER(CONCAT('%', :t, '%')) OR " +
           "LOWER(m.fabricante) LIKE LOWER(CONCAT('%', :t, '%')) OR " +
           "LOWER(m.familia) LIKE LOWER(CONCAT('%', :t, '%'))")
    List<Medicamento> buscarPorCriteriosAproximados(@Param("t") String termino);
}