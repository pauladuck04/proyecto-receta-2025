package es.uvigo.dagss.recetas.daos;

public interface MedicamentoDAO extends JpaRepository<Medicamento, Long> {
	List<Medicamento> findByNombreComercialContaining(String nombreComercial);
	List<Medicamento> findByPrincipioActivoContaining(String principioActivo);
	List<Medicamento> findByFabricanteContaining(String fabricante);
	List<Medicamento> findByFamiliaContaining(String familia);
	List<Medicamento> findByActivoTrue();
}