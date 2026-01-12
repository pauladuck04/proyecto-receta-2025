package es.uvigo.dagss.recetas.daos;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Long>{
	Optional<Usuario> findByLoginAndPassword(String login, String password);
}