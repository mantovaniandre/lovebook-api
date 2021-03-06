package br.com.lovebook.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lovebook.model.Comentarios;


public interface ComentariosRepository extends JpaRepository<Comentarios, Long> {

	Optional<Comentarios> findById(Long id);
	List<Comentarios> findByLivro_id(Long id);
	Optional<Comentarios> deleteByUsuario_id(Long id);
	List<Comentarios> findByUsuario_id(Long id);

	
}
