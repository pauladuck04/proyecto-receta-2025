package es.uvigo.dagss.recetas.daos;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Long>{
	Optional<Usuario> findByLoginContainingIgnoreCaseAndPasswordContainingIgnoreCase(String login, String password);
}