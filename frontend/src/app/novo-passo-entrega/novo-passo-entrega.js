angular
  .module('app')
  .component('appNovoPassoEntrega', {
    templateUrl: 'app/novo-passo-entrega/novo-passo-entrega.html',
    controller: 'NovoPassoEntregaController',
    bindings: {
      codigoPedido: '<',
      onCancel: '&',
      onSuccess: '&'
    }
  });
