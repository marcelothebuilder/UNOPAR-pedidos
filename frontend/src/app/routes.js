angular
  .module('app')
  .config(routesConfig);

/** @ngInject */
function routesConfig($stateProvider, $urlRouterProvider, $locationProvider) {
  $locationProvider.html5Mode(true).hashPrefix('!');
  $urlRouterProvider.otherwise('/');

  $stateProvider
    .state('home', {
      url: '/',
      component: 'appHome'
    })
    .state('clientes', {
      url: '/clientes',
      component: 'appClientes'
    })
    .state('produtos', {
      url: '/produtos',
      component: 'appProdutos'
    })
    .state('pedidos', {
      url: '/pedidos',
      component: 'appPedidos'
    })
    .state('pedido', {
      url: '/pedido/:codigo',
      component: 'appPedido'
    })
    .state('novoPedido', {
      url: '/novo-pedido/:cliente',
      component: 'appNovoPedido'
    });
}
