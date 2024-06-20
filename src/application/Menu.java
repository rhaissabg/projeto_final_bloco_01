package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.ProdutoController;
import model.Celular;
import model.Tablet;

public class Menu {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ProdutoController produtos = new ProdutoController();
		
		int opcao, codigo, tipoCapacidade, tipoProduto;
		String nome, camera, caneta;
		float valor;	
		
		do {
			
			System.out.println("\n*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                  LOJAS TECH BRASIL                  ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("          1 - Criar produto                          ");
			System.out.println("          2 - Listar todos os produtos               ");
			System.out.println("          3 - Buscar produto por código              ");
			System.out.println("          4 - Atualizar dados do produto             ");
			System.out.println("          5 - Apagar produto                         ");
			System.out.println("          0 - Sair                                   ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.print("Entre com a opção desejada: ");
						
			try {
				opcao = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				sc.nextLine();
				opcao = -1;
			}
			
			switch (opcao) {
			
			case 1:
				System.out.println("\nCriar produto: ");
				
				System.out.print("\nNome do produto: ");
				sc.skip("\\R?");
				nome = sc.nextLine();
				
				System.out.print("Valor do produto: ");
				valor = sc.nextFloat();
				
				System.out.print("Código do produto: ");
				codigo = sc.nextInt();
				
				do {
					System.out.print("Capacidade do produto ([1] 64GB | [2] 128GB | [3] 256GB): ");
					tipoCapacidade = sc.nextInt();
				} while(tipoCapacidade < 1 && tipoCapacidade > 3);
				
				System.out.print("Tipo do produto ([1] Celular | [2] Tablet): ");
				tipoProduto = sc.nextInt();
				
				switch (tipoProduto) {
				case 1: 
					System.out.print("Qualidade da câmera: ");
					camera = sc.next();
					produtos.criarProduto(new Celular(nome, valor, codigo, tipoCapacidade, camera));
					break;
				case 2:
					System.out.print("Suporte a caneta: ");
					caneta = sc.next();
					produtos.criarProduto(new Tablet(nome, valor, codigo, tipoCapacidade, caneta));
					break;
				}
				
				break;
				
			case 2:
				System.out.println("\nListar todos os produtos: \n");
				produtos.listarProdutos();
				break;
				
			case 3:
				System.out.println("\nBuscar produto por código: \n");
				
				System.out.print("Digite o código do produto: ");
				codigo = sc.nextInt();
				
				produtos.procurarProduto(codigo);
				
				break;
			
			case 4:
				System.out.println("\nAtualizar dados do produto: \n");
				
				System.out.print("Digite o código do produto: ");
				codigo = sc.nextInt();
				
				var buscaProduto = produtos.acharNaLista(codigo);
				
				if (buscaProduto != null) {
					tipoProduto = buscaProduto.getCodigoProduto();
					
					System.out.print("\nNome do produto: ");
					sc.skip("\\R?");
					nome = sc.nextLine();
					
					System.out.print("Valor do produto: ");
					valor = sc.nextFloat();
					
					do {
						System.out.print("Capacidade do produto ([1] 64GB | [2] 128GB | [3] 256GB): ");
						tipoCapacidade = sc.nextInt();
					} while(tipoCapacidade < 1 && tipoCapacidade > 3);
					
					System.out.print("Tipo do produto ([1] Celular | [2] Tablet): ");
					tipoProduto = sc.nextInt();
					
					switch (tipoProduto) {
					case 1: 
						System.out.print("Qualidade da câmera: ");
						camera = sc.next();
						produtos.atualizarProduto(new Celular(nome, valor, codigo, tipoCapacidade, camera));
						break;
					case 2: 
						System.out.print("Suporte a caneta: ");
						caneta = sc.next();
						produtos.atualizarProduto(new Tablet(nome, valor, codigo, tipoCapacidade, caneta));
					}
					
				}
				else {
					System.out.println("\nProduto não encontrado!");
				}
				
				break;
				
			case 5:
				System.out.println("\nApagar produto: \n");
				System.out.print("Digite o código do produto: ");
				codigo = sc.nextInt();
				
				produtos.deletarProduto(codigo);
				
				break;	
				
			default:
				if (opcao != 0 && opcao  > 5)
					System.out.println("Opção inválida!\n");
				break;
			
			}
			
		} while (opcao != 0);
		
		System.out.println("\nFim da execução");
		
		sc.close();

	}

}
