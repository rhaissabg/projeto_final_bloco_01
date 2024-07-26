package model;

public class Tablet extends Produto {

	public Tablet(String nomeProduto, float valorProduto, int codigoProduto, int capacidade) {
		super(nomeProduto, valorProduto, codigoProduto, capacidade);
	}
	
	@Override
	public float valorReal(int capacidade) {
		
		switch (capacidade) {
		
		case 1:
			return ValorComAdicao(0);

			
		case 2:
			return ValorComAdicao(30);

			
		case 3:
			return ValorComAdicao(50);
			
		}
		
		return getValorProduto();
		
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Valor do produto: R$" + String.format("%.2f", valorReal(getCapacidade())));
	}
	
}
