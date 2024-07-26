package model;

public abstract class Produto {

	private String nomeProduto;
	private float valorProduto;
	private int codigoProduto;
	private int capacidade;
	
	public Produto() {
		
	}

	public Produto(String nomeProduto, float valorProduto, int codigoProduto, int capacidade) {
		this.nomeProduto = nomeProduto;
		this.valorProduto = valorProduto;
		this.codigoProduto = codigoProduto;
		this.capacidade = capacidade;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public float getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(float valorProduto) {
		this.valorProduto = valorProduto;
	}

	public int getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(int codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
	public String tipoCapacidade(int capacidade) {
		String qntdCapacidade = null;
		
		switch (capacidade) {
		
		case 1:
			qntdCapacidade = "64gb";
			break;
			
		case 2:
			qntdCapacidade = "128gb";
			break;
			
		case 3:
			qntdCapacidade = "256gb";
			break;
			
		}
		
		return qntdCapacidade;
			
	}
	
	public float valorReal(int capacidade) {
		return getValorProduto();
	}
	
	public float ValorComAdicao(float porcentagem) {
		float valorFinal = getValorProduto() + (getValorProduto() * porcentagem/100);
 		return valorFinal;
	}
	
	public void visualizar() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nNome do produto: " + getNomeProduto());
		sb.append("\nCódigo do produto: " + getCodigoProduto());
		sb.append("\nCapacidade do produto: " + tipoCapacidade(capacidade));
		System.out.println(sb.toString());
	}
	
}
