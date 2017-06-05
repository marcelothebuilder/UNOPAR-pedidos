class ProdutosController {
  constructor(ProdutoService) {
    angular.extend(this, {
      ProdutoService
    });

    this.resetarProduto();
  }

  $onInit() {
    this.buscarProdutos();
  }

  resetarProduto() {
    this.novoProduto = {};
  }

  buscarProdutos() {
    this.ProdutoService.todos()
      .then(produtos => this.produtos = produtos);
  }

  salvar() {
    this.ProdutoService.adicionar(
        this.novoProduto
      )
      .then(() => this.resetarProduto())
      .then(() => this.buscarProdutos());
  }
}

angular.module('app').controller('ProdutosController', ProdutosController);
