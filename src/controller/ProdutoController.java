package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.Produto;
import repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository {
	
	private List<Produto> listaProdutos = new ArrayList<>();

	@Override
	public void criarProduto(Produto produto) {
		listaProdutos.add(produto);
		System.out.println("\nO produto " + produto.getNomeProduto() + " foi criado com sucesso!\n");
	}

	@Override
	public void deletarProduto(int numero) {
		var produtoLista = acharNaLista(numero);
		Optional<Produto> produtoNull = Optional.ofNullable(produtoLista);
		
		if (produtoNull.isPresent()) {
			listaProdutos.remove(produtoLista);
			System.out.println("\nO produto " + produtoLista.getNomeProduto() + " foi deletado com sucesso!\n");
		}
		else {
			System.out.println("\nO produto " + produtoLista.getNomeProduto() + " não foi encontrado!\n");
		}
	}

	@Override
	public void procurarProduto(int numero) {
		var produtoLista = acharNaLista(numero);
		Optional<Produto> produtoNull = Optional.ofNullable(produtoLista);
		
		if (produtoNull.isPresent()) {
			produtoLista.visualizar();
		}
		else {
			System.out.println("\nO produto " + produtoLista.getNomeProduto() + " não foi encontrado!\n");
		}
		
	}

	@Override
	public void atualizarProduto(Produto produto) {
		var produtoLista = acharNaLista(produto.getCodigoProduto());
		Optional<Produto> produtoNull = Optional.ofNullable(produtoLista);
		
		if (produtoNull.isPresent()) {
			for (Produto p : listaProdutos) {
				for (int i = 0; i < listaProdutos.size(); i++) {
					if (produtoLista == p) {
						listaProdutos.set(i, produto);
					}
				}
			}

			System.out.println("\nO produto " + produtoLista.getNomeProduto() + " foi atualizado com sucesso!\n");
		}
		else {
			System.out.println("\nO produto " + produtoLista.getNomeProduto() + " não foi encontrado!\n");
		}
		
	}

	@Override
	public void listarProdutos() {
		if (listaProdutos.isEmpty()) {
			System.out.println("\nA lista está vazia!");
		}
		else {
			for (var p : listaProdutos) {
				p.visualizar();
			}
		}
	}
	
	public Produto acharNaLista(int numero) {
		for (var p : listaProdutos) {
			if (p.getCodigoProduto() == numero) {
				return p;
			}
		}
		return null;
	}
	
}
