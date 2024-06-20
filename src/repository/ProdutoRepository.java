package repository;

import model.Produto;

public interface ProdutoRepository {

	public void criarProduto(Produto produto);
	public void deletarProduto(int numero);
	public void procurarProduto(int numero);
	public void atualizarProduto(Produto produto);
	public void listarProdutos();
	
}
