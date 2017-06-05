package io.github.marcelothebuilder.unoparpedidos4.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import io.github.marcelothebuilder.unoparpedidos4.model.Cidade;

@Repository
@Transactional
//@RepositoryRestResource(path="cidade")
public interface CidadeRepository extends CrudRepository<Cidade, Long>, PagingAndSortingRepository<Cidade, Long> {

}
