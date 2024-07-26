package model;

public class Tablet extends Produto {

	private String caneta;
	
	public Tablet(String nomeProduto, float valorProduto, int codigoProduto, int capacidade, String caneta) {
		super(nomeProduto, valorProduto, codigoProduto, capacidade);
		this.caneta = caneta;
	}
	
	public String getCaneta() {
		return caneta;
	}

	public void setCaneta(String caneta) {
		this.caneta = caneta;
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
		System.out.println("Suporte à caneta interativa: " + getCaneta());
	}
	
}
