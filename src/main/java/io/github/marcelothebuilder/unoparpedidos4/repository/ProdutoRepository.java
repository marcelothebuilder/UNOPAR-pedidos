package io.github.marcelothebuilder.unoparpedidos4.repository;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.marcelothebuilder.unoparpedidos4.model.Produto;

@Repository
@Transactional
//@RepositoryRestResource(path="produto")
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	Page<Produto> findByNomeContainingIgnoreCase(String nomePart, Pageable page);
}
