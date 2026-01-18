package es.uvigo.dagss.recetas.daos;

import es.uvigo.dagss.recetas.entidades.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Long>{
	Optional<Usuario> findByLoginContainingIgnoreCaseAndPasswordContainingIgnoreCase(String login, String password);
}