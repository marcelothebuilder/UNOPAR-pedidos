package io.github.marcelothebuilder.unoparpedidos4.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import io.github.marcelothebuilder.unoparpedidos4.model.Estado;

@Repository
@Transactional
//@RepositoryRestResource(path = "estado", collectionResourceRel = "estados", itemResourceRel = "estado")
public interface EstadoRepository extends JpaRepository<Estado, Long> {
	List<Estado> findByNomeIgnoreCaseContaining(@Param("nome") String nome);
}
