package es.uvigo.dagss.recetas.daos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import es.uvigo.dagss.recetas.entidades.Medicamento;

@Repository
public interface MedicamentoDAO extends JpaRepository<Medicamento, Long> {
	
    List<Medicamento> findByNombreComercialContainingIgnoreCase(String nombreComercial);
	List<Medicamento> findByPrincipioActivoContainingIgnoreCase(String principioActivo);
	List<Medicamento> findByFamiliaContainingIgnoreCase(String familia);
	List<Medicamento> findByFabricanteContainingIgnoreCase(String fabricante);
	List<Medicamento> findByActivoTrue();
}