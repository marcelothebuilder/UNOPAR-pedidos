package io.github.marcelothebuilder.unoparpedidos4.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.marcelothebuilder.unoparpedidos4.model.Pedido;

@Repository
@Transactional
//@RepositoryRestResource(path="pedido")
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
