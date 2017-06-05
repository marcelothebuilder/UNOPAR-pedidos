class ClientesController {
  constructor(ClienteService, CidadeService, EstadoService, $log, $state) {
    angular.extend(this, {
      ClienteService,
      CidadeService,
      EstadoService,
      $log,
      $state
    });

    this.resetarCliente();
  }

  $onInit() {
    this.EstadoService.todos()
      .then(estados => this.estados = estados);
    this.buscarClientes();
  }

  novoPedido(cliente) {
    this.$state.go('novoPedido', {
      cliente: cliente.codigo
    });
  }

  buscarClientes() {
    return this.ClienteService.todos()
      .then(clientes => this.clientes = clientes);
  }

  estadoAlterado(novoEstado) {
    this.novoCliente.endereco.cidade = null;
    this.cidades = [];
    this.CidadeService.porEstado(novoEstado)
      .then(cidades => {
        this.cidades = cidades;
      });
  }

  resetarCliente() {
    this.novoCliente = {};
    this.novoCliente.endereco = {};
    this.cidades = [];
    this.estadoSelecionado = null;
  }

  salvar() {
    this.ClienteService.adicionar(
        this.novoCliente
      )
      .then(() => this.resetarCliente())
      .then(() => this.buscarClientes());
  }
}

angular.module('app').controller('ClientesController', ClientesController);
