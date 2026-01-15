package es.uvigo.dagss.recetas.daos;

ìmport es.uvigo.dagss.recetas.entidades.Farmacia;

@Repository
public interface FarmaciaDAO extends JpaRepository<Farmacia, Long>{
	List<Farmacia> findByNombreContainingIgnoreCase(String nombre);
	List<Farmacia> findByDireccionLocalidadContainingIgnoreCase(String localidad);
	List<Farmacia> findByProvinciaIgnoreCase(String provincia);
	Optional<Farmacia> findByLogin(String login);
}