package model;

public class Celular extends Produto {
	
	private String camera;
	
	public Celular(String nomeProduto, float valorProduto, int codigoProduto, int capacidade, String camera) {
		super(nomeProduto, valorProduto, codigoProduto, capacidade);
		this.camera = camera;
	}
	
	public String getCamera() {
		return camera;
	}

	public void setCamera(String camera) {
		this.camera = camera;
	}

	@Override
	public float valorReal(int capacidade) {
		
		switch (capacidade) {
		
		case 1:
			return ValorComAdicao(0);

			
		case 2:
			return ValorComAdicao(20);

			
		case 3:
			return ValorComAdicao(40);
			
		}
		
		return getValorProduto();
		
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Valor do produto: R$" + String.format("%.2f", valorReal(getCapacidade())));
		System.out.println("Qualidade da câmera: " + getCamera());
	}
	
}
