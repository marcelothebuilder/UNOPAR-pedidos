package io.github.marcelothebuilder.unoparpedidos4.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Formula;

import io.github.marcelothebuilder.unoparpedidos4.service.PedidoService;
import lombok.Data;

@Entity
@EntityListeners(PedidoService.class)
@Data
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long codigo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new Date();
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="pedido", cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<ItemPedido> itens;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@NotNull
	private Cliente cliente;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="pedido", cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<PassoEntrega> passosEntrega;
	
	//private EstadoEntrega estadoEntrega;
	
	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
		this.itens.forEach(item -> item.setPedido(this));
	}
	
	@Transient
	public Integer getQuantidadeItens() {
		return getItens().size();
	}
	
	public void adicionarPassoEntrega(PassoEntrega passo) {
		passo.setPedido(this);
		this.getPassosEntrega().add(passo);
	}
}
