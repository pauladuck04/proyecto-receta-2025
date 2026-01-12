package es.uvigo.dagss.recetas.daos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RecetaDAO extends JpaRepository<Receta, Long> {

}