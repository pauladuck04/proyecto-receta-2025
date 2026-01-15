package es.uvigo.dagss.recetas.daos;

@Repository
public interface MedicamentoDAO extends JpaRepository<Medicamento, Long> {
	
    List<Medicamento> findByNombreComercialContainingIgnoreCase(String nombreComercial);
	List<Medicamento> findByPrincipioActivoContainingIgnoreCase(String principioActivo);
	List<Medicamento> findByFamiliaContainingIgnoreCase(String familia);
	List<Medicamento> findByFabricanteContainingIgnoreCase(String fabricante);
}