package io.github.marcelothebuilder.unoparpedidos4.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.github.marcelothebuilder.unoparpedidos4.model.Cliente;

@Repository
@Transactional
//@RepositoryRestResource(path = "cliente")
public interface ClienteRepository extends JpaRepository<Cliente, Long>, PagingAndSortingRepository<Cliente, Long> {

}
